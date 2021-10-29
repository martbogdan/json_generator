package io.github.martbogdan.generator.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.collections.HashMap

@Service
class GenerateService(@Autowired val replaceService: ReplaceService) {

    companion object {
        const val COUNT_KEY = "@count"
    }

    fun generateJson(jsonTemplate: String, count: Int?): Iterator<HashMap<*,*>> {

        val countTimes = getCount(jsonTemplate, count)

        return sequence {
            while (true) {
                yield(replaceService.processReplace(jsonTemplate))
            }
        }.take(countTimes).iterator()
    }

    fun getCount(json: String, count: Int?): Int {
        val jsonMap = replaceService.parseJsonToMap(json)
        return if (count != null && count > 0) {
            count
        } else if (jsonMap.containsKey(COUNT_KEY)) {
            jsonMap[COUNT_KEY] as Int
        } else 1
    }
}
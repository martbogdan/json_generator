package com.supper.generator.replacer

abstract class Replacer() {
    abstract val replaceValue: String
    open var nextReplacer: Replacer? = null

    companion object {
        fun getReplacer(): Replacer {
            return FirstNameReplacer()
                .addNextReplacer(
                    LastNameReplacer()
                        .addNextReplacer(AddressReplacer())
                )
        }
    }

    fun addNextReplacer(replacer: Replacer): Replacer {
        this.nextReplacer = replacer
        return this
    }

    fun replace(string: String): String {
        if (string == replaceValue) {
            return generate()
        }
        if (nextReplacer != null) {
            return nextReplacer?.replace(string)!!
        }
        return string
    }

    abstract fun generate(): String

}
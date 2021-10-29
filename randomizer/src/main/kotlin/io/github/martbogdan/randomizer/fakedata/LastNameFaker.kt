package io.github.martbogdan.randomizer.fakedata

import org.springframework.stereotype.Component

@Component
class LastNameFaker {
    val listLastNames: List<String>
        get() = listOf<String>(
            "Swan",
            "Bawles", "Yakobovicz", "Freeth", "Gopsell", "Glenfield", "Craigmile", "Duigenan", "Heavens", "Manktelow",
            "Doul", "Haggerty", "Montier", "Piscopo", "Bagshaw", "Cogley", "Harfoot", "Bridson", "Balser", "Burberye",
            "Tommis", "Kenneway", "Goghin", "Mattevi", "Bullocke", "Rosewall", "Slevin", "Yerrall", "Janata", "Ellerby",
            "Grundle", "Epsly", "Ledbetter", "Mines", "Conkling", "Conley", "Heinritz", "Tooher",
            "Heiner", "Crasford", "Winspurr", "Pyott", "Jarritt", "Pates", "McGinnell", "Sesser", "Baudasso"
        )

    fun getLastName() = listLastNames.random()
}
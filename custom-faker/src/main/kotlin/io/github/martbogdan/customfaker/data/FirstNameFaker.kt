package io.github.martbogdan.customfaker.data

class FirstNameFaker {
    val listNames: List<String>
        get() = listOf<String>(
            "Tom", "Bob", "Tomasine", "Keane", "Hilliard", "Wyn", "Baily", "Harcourt", "Cherie", "North", "Gillie",
            "Vaughan", "Kile", "Merrill", "Fania", "Ruthie", "Rooney", "Ferdie", "Angelita", "Diane", "Jordana", "Moina",
            "Hatty", "Umeko", "Gaby", "Augustus", "Martguerita", "Kaylil", "Phylis", "Sarah", "Svend", "Dulcia", "Blake",
            "Ashlin", "Tani", "Hubie", "Jolyn", "Tamara", "Prue", "Lexie", "Rubie", "Thomas", "Amalita", "Kip", "Quill",
            "Emilia", "Darrel", "Orelie", "Beth", "Loydie", "Victor", "Clevey", "Ambur", "Malcolm", "Harris", "Noach",
            "Kort", "Sarena", "Freida", "Gnni", "Elyse", "Dede", "Edvard", "Doy", "Rollins", "Danna", "Marita", "Dane",
            "Colby", "Annelise", "Carole", "Chastity", "Delano", "Gregor", "Henrietta", "Dione", "Coralyn", "Roland",
            "Shannan", "Augy", "Sallyann", "Drew", "Laurianne", "Ashbey", "Onfroi", "Barde", "Irving", "Claudius", "Maris",
            "Pauli", "Casi", "Jammie", "Ansley", "Ellie", "Kirbee", "Nikola", "Aundrea", "Melitta", "Iris", "Brigitta",
            "Stewart", "Obed")

    fun getFirstName() = listNames.random()
}
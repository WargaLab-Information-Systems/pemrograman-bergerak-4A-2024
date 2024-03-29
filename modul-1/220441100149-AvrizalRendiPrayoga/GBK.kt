fun main() {
    print("Silahkan masukkan nama anda: ")
    val nama = readLine()
    val game = gbk()
    var cont: Boolean = true
    while (cont) {
        println("\n\nSelamat datang di game GBK, ${nama}")
        println("Silahkan pilih salah satu: \n1. Gunting\n2. Batu\n3. Kertas")

        val pilihanPemain = game.getPilihanPemain()
        val pilihanKomputer = game.getPilihanKomputer()

        game.tentukanHasil(pilihanPemain, pilihanKomputer)

        print("Lanjut main lagi ? [y/n] : ")
        val pilihan = readLine()
        if (pilihan.isNullOrBlank()) {
            cont = true
        } else {
            val input = pilihan.lowercase()
            if (input == "y") {
                cont = true
            } else if (input != "y") {
                cont = false
            }
        }
    }
}

class gbk() {
    fun getPilihanKomputer(): String {
        val opsi = arrayOf("Gunting", "Batu", "Kertas")
        val pilihanRandom = opsi.random()
        return pilihanRandom
    }

    fun getPilihanPemain(): String {
        var pilihan: String = ""
        print("\nPilih [1/2/3] : ")
        val numb = readLine()
        if (numb == "1") {
            pilihan = "Gunting"
        } else if (numb == "2") {
            pilihan = "Batu"
        } else if (numb == "3") {
            pilihan = "Kertas"
        }

        return pilihan
    }

    fun tentukanHasil(user: String, komputer: String) {
        println("\nKamu\t : ${user}")
        println("Komputer : ${komputer}")
        if (user == komputer) {
            println("\nSeri!")
        } else if ((user == "Gunting" && komputer == "Kertas") ||
                        (user == "Batu" && komputer == "Gunting") ||
                        (user == "Kertas" && komputer == "Batu")
        ) {
            println("\nKamu Menang!")
        } else {
            println("\nKamu Kalah!")
        }
    }
}

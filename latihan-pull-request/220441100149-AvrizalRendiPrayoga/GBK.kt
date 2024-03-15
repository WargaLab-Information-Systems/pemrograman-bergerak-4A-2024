fun main() {
    print("Silahkan masukkan nama anda: ")
    val nama = readLine()
    var con: Int = 1
    while (con == 1 ) {
        println("\n\nSelamat datang di game GBK, ${nama}")
        println("Silahkan pilih salah satu: \n1. Gunting\n2. Batu\n3. Kertas")

        val pilihanPemain: String = getPilihanPemain()
        val pilihanKomputer: String = getPilihanKomputer()

        tentukanHasil(pilihanPemain, pilihanKomputer)

        print("Lanjut main lagi ? [y/n] : ")
        val pilihan = readLine()
        if (pilihan.isNullOrBlank()) {
            con = 1
        } else {
            val input = pilihan.lowercase()
            if (input == "y") {
                con = 1
            } else if (input != "y") {
                con = 0
            }
        }
    }
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

fun getPilihanKomputer(): String {
    val opsi = arrayOf("Gunting", "Batu", "Kertas")
    val pilihanRandom = opsi.random()
    return pilihanRandom
}

fun tentukanHasil(user: String, komputer: String) {
    println("\nKamu\t : ${user}")
    println("Komputer : ${komputer}")
    if (user == komputer) {
        println("\nSeri!")
    } else if (
        (user == "Gunting" && komputer == "Kertas") ||
        (user == "Batu" && komputer == "Gunting") ||
        (user == "Kertas" && komputer == "Batu")
    ) {
        println("\nKamu Menang!")
    } else {
        println("\nKamu Kalah!")
    }
}
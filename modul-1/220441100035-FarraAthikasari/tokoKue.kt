fun main() {
    var x = true    //dpt diubah
    while (x) {     //looping
        println("==============Toko Kue==============")
        println("===================================")
        println("Apa yang ingin Anda lakukan?")
        println("1. Lihat Daftar Kue \n2. Pesan Kue \nPilih nomor berapa? 1/2")
        println("===================================\n")
        println("-----------------------------------")

        val bakery = Bakery()       //tdk dapat diubah
        val input = readLine()?.toIntOrNull()

        when (input) {      //penyeleksian kondisi
            1 -> {
                println("[1] Daftar Kue")
                bakery.daftar()
            }
            2 -> {
                println("[2] Pesan Kue")
                bakery.daftar()
                print("Pilih kue yang ingin dipesan: ")
                val pilihanKue = readLine()?.toIntOrNull() ?: 0
                print("Jumlah pesanan: ")
                val jumlahPesan = readLine()?.toIntOrNull() ?: 0
                val totalHarga = bakery.pesan(pilihanKue, jumlahPesan)
                println("Total Harga: Rp$totalHarga")
            }
            3 -> {
                println("Terima kasih telah menggunakan layanan kami.")
                x = false
            }
            else -> println("Pilihan tidak valid")
        }

        println("-----------------------------------")
        println("Apakah Anda ingin melanjutkan? (ya/tidak)")
        val kondisi = readLine()
        if (kondisi != "ya") {      //looping
            println("Terima kasih telah menggunakan layanan kami.")
            x = false
        }
    }
}

class Bakery {
    val menuKue = mutableListOf(        //properti (koleksi yg dpt diubah)
        MenuKue("Kue Coklat", 45000),
        MenuKue("Kue Keju", 50000),
        MenuKue("Kue Strawberry", 65000)
    )

    fun daftar() {
        println("=========================")
        println("Menu Kue:")
        menuKue.forEachIndexed { index, item ->     //melakukan iterasi pada setiap elemen
            println("${index + 1}. ${item.nama} - Rp${item.harga}")
        }       //untuk mencetak detail dari setiap kue dalam menuKue
        println("=========================\n")
    }

    fun pesan(pilihan: Int, jumlah: Int): Int {
        if (pilihan in 1..menuKue.size) {           //penyeleksian kondisi
            val totalHarga = menuKue[pilihan - 1].harga * jumlah
            println("Anda memesan ${menuKue[pilihan - 1].nama} sebanyak $jumlah, total harga: Rp$totalHarga")
            return totalHarga       //menghitung total harga sesuai pilihan kue dan jumlah pesanan
        } else {
            println("Pilihan tidak valid.")
            return 0
        }
    }
}

class MenuKue(val nama: String, val harga: Int)     //merepresentasikan data menu kue.

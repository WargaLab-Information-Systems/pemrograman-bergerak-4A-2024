fun main() {
    var x = true
    while (x) {
        println("==============KYLIE COSMETIC==============")
        println("===================================")
        println("Apa yang ingin Anda lakukan?")
        println("1. Lihat Daftar Cosmetic \n2. Pesan Cosmetic \nPilih nomor berapa? 1/2")
        println("===================================\n")
        println("-----------------------------------")

        val cosmetic = Cosmetic()
        val input = readLine()?.toIntOrNull()

        when (input) {
            1 -> {
                println("[1] Daftar Cosmetic")
                cosmetic.daftar()
            }
            2 -> {
                println("[2] Pesan Cosmetic")
                cosmetic.daftar()
                print("Pilih Cosmetic yang ingin dipesan: ")
                val pilihanCosmetic = readLine()?.toIntOrNull() ?: 0
                print("Jumlah pesanan: ")
                val jumlahPesan = readLine()?.toIntOrNull() ?: 0
                val totalHarga = cosmetic.pesan(pilihanCosmetic, jumlahPesan)
                println("Total Harga: Rp$totalHarga")

                print("Masukkan uang pembayaran: Rp")
                val uangPembayaran = readLine()?.toIntOrNull() ?: 0

                if (uangPembayaran < totalHarga) {
                    println("Uang yang dimasukkan kurang. Mohon masukkan uang yang mencukupi.")
                } else {
                    val kembalian = uangPembayaran - totalHarga
                    println("Uang yang dimasukkan mencukupi. Kembalian Anda: Rp$kembalian")
                }
            }
            3 -> {
                println("Terima kasih telah menggunakan layanan kami.")
                x = false
            }
            else -> println("Pilihan tidak valid")
        }

        println("-----------------------------------")
        println("Apakah Anda ingin melanjutkan pemesanan? (ya/tidak)")
        val kondisi = readLine()
        if (kondisi != "ya") {
            println("Terima kasih telah menggunakan layanan kami.")
            x = false
        }
    }
}

class Cosmetic {
    val menuCosmetic = mutableListOf(
        MenuCosmetic("Eyeliner", 45000),
        MenuCosmetic("Mascara", 50000),
        MenuCosmetic("Lip Serum", 65000)
    )

    fun daftar() {
        println("=========================")
        println("Menu Cosmetic:")
        menuCosmetic.forEachIndexed { index, item ->
            println("${index + 1}. ${item.nama} - Rp${item.harga}")
        }
        println("=========================\n")
    }

    fun pesan(pilihan: Int, jumlah: Int): Int {
        if (pilihan in 1..menuCosmetic.size) {
            val totalHarga = menuCosmetic[pilihan - 1].harga * jumlah
            println("Anda memesan ${menuCosmetic[pilihan - 1].nama} sebanyak $jumlah, total harga: Rp$totalHarga")
            return totalHarga
        } else {
            println("Pilihan tidak valid.")
            return 0
        }
    }
}

class MenuCosmetic(val nama: String, val harga: Int)

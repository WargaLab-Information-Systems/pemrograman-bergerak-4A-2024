import java.util.Scanner

class TopUpGame {

    private val scanner = Scanner(System.`in`)
    private var userID = ""
    private var saldo = 0

    fun main() {
        println("Selamat datang di layanan top up game!")
        println("Silakan masukkan User ID anda: ")
        userID = scanner.nextLine()

        println("Silakan masukkan saldo anda: ")
        saldo = scanner.nextInt()

        while (true) {
            println("\nMenu:")
            println("1. Beli 10 Diamond (Harga: Rp. 10.000)")
            println("2. Beli 50 Diamond (Harga: Rp. 50.000)")
            println("3. Beli 120 Diamond (Harga: Rp. 100.000)")
            println("4. Keluar")

            print("Pilih menu: ")
            val pilihan = scanner.nextInt()

            when (pilihan) {
                1 -> beliDiamond(10, 10000)
                2 -> beliDiamond(50, 50000)
                3 -> beliDiamond(120, 100000)
                4 -> {
                    println("Terima kasih telah menggunakan layanan top up game.")
                    return
                }
                else -> println("Pilihan tidak valid, silakan coba lagi.")
            }
        }
    }

    private fun beliDiamond(jumlah: Int, harga: Int) {
        if (saldo >= harga) {
            println("Anda telah memilih untuk membeli $jumlah Diamond untuk user ID: $userID.")
            println("Harga yang harus anda bayar adalah Rp. $harga")
            println("Apakah anda yakin ingin melanjutkan pembelian? (y/n)")
            val konfirmasi = scanner.next()

            if (konfirmasi.equals("y", ignoreCase = true)) {
                saldo -= harga
                println("Pembelian berhasil! Anda telah membeli $jumlah Diamond untuk user ID: $userID.")
                println("Saldo Anda sekarang: Rp. $saldo")
            } else {
                println("Pembelian dibatalkan.")
            }
        } else {
            println("Saldo Anda tidak mencukupi untuk membeli $jumlah Diamond untuk user ID: $userID.")
            println("Silakan top up saldo Anda terlebih dahulu.")
        }
    }
}

fun main(args: Array<String>) {
    // Menjalankan program
    val topUpGame = TopUpGame()
    topUpGame.main()
}
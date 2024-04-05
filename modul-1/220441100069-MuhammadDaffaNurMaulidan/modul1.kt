import kotlin.system.exitProcess

fun main (){
    var bayar: Int
    var jumlahpesan: Int
    var ulang = "Y"

    while (ulang.equals("Y") || ulang.equals("y")) {
        println("===============")
        println("Menu Kasir")
        println("===============")
        println("1. Pecel Lele")
        println("2. Ayam Penyet")
        println("3. Ayam Geprek")
        println("4. Nasi Goreng")
        println("5. Sop Buntut")
        println("6. Keluar")
        println("================")
        print("Pilih Menu: ")
        val choice = readLine()!!.toInt()
        if (choice == 1){
            val hargaPecelLele = hargamenu ()
            println("harga menu Pecel Lele ${hargaPecelLele.hrgPecelLele}")
            println("Jumlah menu yang dipesan: ")
            jumlahpesan = readLine()?.toIntOrNull() ?: 0
            var total = hargaPecelLele.hrgPecelLele * jumlahpesan
            println("\n\nTotal harga yang dibayarkan: Rp. $total")

            print("Dibayar Rp. ")
            bayar = readLine()?.toIntOrNull() ?: 0
            var kembalian: Int

            if (bayar > total){
                println("pembayaran lebih")
                kembalian = bayar - total
                println("Kembali Rp. $kembalian")
            }else if (bayar == total){
                println("uang pas")
            } else{
                println("uang kurang")
            }

            hargaPecelLele.tambahMinuman(total)

            println("Terima kasih telah berkunjung!")
        } else if (choice == 2) {
            val hargaAyamPenyet = hargamenu ()
            println("harga menu Ayam Penyet ${hargaAyamPenyet.hrgAyamPenyet}")
            println("Jumlah menu yang dipesan: ")
            jumlahpesan = readLine()?.toIntOrNull() ?: 0
            var total  = hargaAyamPenyet.hrgAyamPenyet * jumlahpesan
            println("\n\nTotal harga yang dibayarkan: Rp. $total")

            print("Dibayar Rp. ")
            bayar = readLine()?.toIntOrNull() ?: 0
            var kembalian: Int

            if (bayar > total){
                println("pembayaran lebih")
                kembalian = bayar - total
                println("Kembali Rp. $kembalian")
            }else if (bayar == total){
                println("uang pas")
            } else{
                println("uang kurang")
            }
            hargaAyamPenyet.tambahMinuman(total)

            println("Terima kasih telah berkunjung!")
        }else if (choice == 3) {
            val hargaAyamgeprek = hargamenu ()
            println("harga menu Ayam Geprek ${hargaAyamgeprek.hrgAyamGeprek}")
            println("Jumlah menu yang dipesan: ")
            jumlahpesan = readLine()?.toIntOrNull() ?: 0
            var total  = hargaAyamgeprek.hrgAyamGeprek * jumlahpesan
            println("\n\nTotal harga yang dibayarkan: Rp. $total")

            print("Dibayar Rp. ")
            bayar = readLine()?.toIntOrNull() ?: 0
            var kembalian: Int

            if (bayar > total){
                println("pembayaran lebih")
                kembalian = bayar - total
                println("Kembali Rp. $kembalian")
            }else if (bayar == total){
                println("uang pas")
            } else{
                println("uang kurang")
            }

            hargaAyamgeprek.tambahMinuman(total)

            println("Terima kasih telah berkunjung!")
        }else if (choice == 4) {
            val hargaNasiGoreng = hargamenu ()
            println("harga menu Nasi Goreng ${hargaNasiGoreng.hrgNasigoreng}")
            println("Jumlah menu yang dipesan: ")
            jumlahpesan = readLine()?.toIntOrNull() ?: 0
            var total  = hargaNasiGoreng.hrgNasigoreng * jumlahpesan
            println("\n\nTotal harga yang dibayarkan: Rp. $total")

            print("Dibayar Rp. ")
            bayar = readLine()?.toIntOrNull() ?: 0
            var kembalian: Int

            if (bayar > total){
                println("pembayaran lebih")
                kembalian = bayar - total
                println("Kembali Rp. $kembalian")
            }else if (bayar == total){
                println("uang pas")
            } else{
                println("uang kurang")
            }

            hargaNasiGoreng.tambahMinuman(total)

            println("Terima kasih telah berkunjung!")
        }else if (choice == 5) {
            val hargaMieGoreng = hargamenu ()
            println("harga menu Mie Goreng ${hargaMieGoreng.hrgMiegoreng}")
            println("Jumlah menu yang dipesan: ")
            jumlahpesan = readLine()?.toIntOrNull() ?: 0
            var total  = hargaMieGoreng.hrgMiegoreng * jumlahpesan
            println("\n\nTotal harga yang dibayarkan: Rp. $total")

            print("Dibayar Rp. ")
            bayar = readLine()?.toIntOrNull() ?: 0
            var kembalian: Int

            if (bayar > total){
                println("pembayaran lebih")
                kembalian = bayar - total
                println("Kembali Rp. $kembalian")
            }else if (bayar == total){
                println("uang pas")
            } else{
                println("uang kurang")
            }

            hargaMieGoreng.tambahMinuman(total)

            println("Terima kasih telah berkunjung!")
        }else if (choice == 6){
            println("See ya")
            exitProcess(0)
        } else {
            println("Pilihan salah")
        }
        print("Transaksi selanjutnya? (Y/T)")
        ulang = readLine()!!.toString()
    }
}
class hargamenu (){
    val hrgPecelLele: Int = 15000
    val hrgAyamPenyet: Int = 17000
    val hrgAyamGeprek: Int = 10000
    val hrgNasigoreng: Int = 11000
    val hrgMiegoreng: Int = 9000

    fun tambahMinuman(total: Int){
        println("\nApakah Anda ingin menambahkan minuman? (ya/tidak)")
        val tambahMinuman = readLine()?.toLowerCase()

        if (tambahMinuman == "ya") {
            val hargaMinuman = 3000
            println("Harga menu Minuman: $hargaMinuman")
            print("Jumlah minuman yang dipesan: ")
            val jumlahMinuman = readLine()?.toIntOrNull() ?: 0
            val totalMinuman = hargaMinuman * jumlahMinuman
            val totalHargaSetelahMinuman = total + totalMinuman
            println("\nTotal harga termasuk minuman: Rp. $totalHargaSetelahMinuman")
        }
    }
}


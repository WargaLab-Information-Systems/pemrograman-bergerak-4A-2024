class Konvers(val nilaiTukar: Double) {
    fun konversiIdrKeUsd(jumlahIdr: Double): Double {
        return jumlahIdr / nilaiTukar
    }

    fun konversiUsdKeIdr(jumlahUsd: Double): Double {
        return jumlahUsd * nilaiTukar
    }
}

fun main() {
    val tukar = 15000.0
    val konverter = Konvers(tukar)

    var ulang = true

    while (ulang) {
        println("------------------------------------------------")
        println("| SELAMAT DATANG di PROGRAM KONVERSI MATA UANG |")
        println("------------------------------------------------")
        println("|            Menu Konversi Mata Uang           |")
        println("------------------------------------------------")
        println("| 1. Rupiah -> Dollar                          |")
        println("| 2. Dollar -> Rupiah                          |")
        println("------------------------------------------------")

        var inputValid = false

        while (!inputValid) {
            print("Masukkan Pilihan : ")
            val pilihan = readLine()?.toIntOrNull()

            when (pilihan) {
                1 -> {
                    println("------------------------------------------------")
                    print("| Masukkan Jumlah Rupiah : ")
                    val jumlahIdr = readLine()?.toDoubleOrNull()
                    println("------------------------------------------------")
                    if (jumlahIdr != null) {
                        val hasil = konverter.konversiIdrKeUsd(jumlahIdr)
                        println("| Rp $jumlahIdr = \$ $hasil ")
                        println("------------------------------------------------")
                    } else {
                        println("Angka tidak Valid")
                    }
                    inputValid = true
                }
                2 -> {
                    println("------------------------------------------------")
                    print("Masukkan Jumlah Dollar USD : ")
                    val jumlahUsd = readLine()?.toDoubleOrNull()
                    println("------------------------------------------------")
                    if (jumlahUsd != null) {
                        val hasil = konverter.konversiUsdKeIdr(jumlahUsd)
                        println("| $ $jumlahUsd = Rp $hasil ")
                        println("------------------------------------------------")
                    } else {
                        println("Angka tidak Valid")
                    }
                    inputValid = true
                }
                else -> println("Pilihan tidak valid. Harap masukkan angka 1 atau 2.")
            }
        }
        print("Apakah Ingin Menggunakan Program ini lagi ? (Y/X): ")
        val lagi = readLine()
        if (lagi.equals("Y", ignoreCase = true)) {
            ulang = true
        } else {
            ulang = false
        }
    }
    println("Terimakasi Telah Menggunakan Program ini")
}

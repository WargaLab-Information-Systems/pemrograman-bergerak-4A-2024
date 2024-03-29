fun main() {
    val bentuk = kalkulatorKeliling()
    while (true) {
        println("Input bangun datar (persegi / lingkaran / segitiga) 'keluar' untuk keluar : ")
        val input = readLine()?.toLowerCase() ?: "keluar"

        when (input) {
            "persegi" -> {
                println("Masukkan panjang sisi : ")
                val panjangSisi = readLine()?.toDoubleOrNull() ?: 0.0
                if (panjangSisi > 0) {
                    val keliling = bentuk.KelilingPersegi(panjangSisi)
                    println("Keliling persegi = $keliling")
                } else {
                    println("Panjang sisi harus lebih besar dari 0.")
                }
            }
            "lingkaran" -> {
                println("Masukkan jari-jari : ")
                val radius = readLine()?.toDoubleOrNull() ?: 0.0
                if (radius > 0) {
                    val keliling = bentuk.kelilingLingkaran(radius)
                    println("Keliling lingkaran = $keliling")
                } else {
                    println("Jari-jari harus lebih besar dari 0.")
                }
            }
            "segitiga" -> {
                println("Masukkan panjang sisi ke-1 :")
                val sisi1 = readLine()?.toDoubleOrNull() ?: 0.0
                println("Masukkan panjang sisi ke-2: ")
                val sisi2 = readLine()?.toDoubleOrNull() ?: 0.0
                println("Masukkan panjang sisi ke-3: ")
                val sisi3 = readLine()?.toDoubleOrNull() ?: 0.0

                if (sisi1 > 0 && sisi2 > 0 && sisi3 > 0) {
                    val keliling = bentuk.kelilingSegitiga(sisi1, sisi2, sisi3)
                    println("Keliling segitiga: $keliling")
                } else {
                    println("Panjang sisi harus lebih besar dari 0.")
                }
            }
            "keluar" -> {
                println("Terima kasih telah menggunakan kalkulator ini.")
                break
            }
            else -> println("Input tidak valid.")
        }
    }
}

class kalkulatorKeliling {
    fun KelilingPersegi(panjangSisi: Double): Double {
        return 4 * panjangSisi
    }

    fun kelilingLingkaran(radius: Double): Double {
        return 2 * Math.PI * radius
    }

    fun kelilingSegitiga(sisi1: Double, sisi2: Double, sisi3: Double): Double {
        return sisi1 + sisi2 + sisi3
    }
}
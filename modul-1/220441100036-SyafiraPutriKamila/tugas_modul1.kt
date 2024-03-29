import kotlin.math.PI

fun main() {
    val kalkulator = bentuk_kalkulator()
    var lanjutkan = true

    while (lanjutkan) {
        print("Masukkan bentuk (persegi, lingkaran, segitiga): ")
        val jenis_bentuk = readLine()?.toString() ?: ""
        kalkulator.menghitung_keliling(jenis_bentuk)
        print("Apakah ingin menghitung keliling lagi? (tentu saja!/cukup!): ")
        val input = readLine()?.toString()?.toLowerCase() ?: ""
        lanjutkan = input == "tentu saja!"
    }
}

class bentuk_kalkulator {
    fun menghitung_keliling(jenis_bentuk: String): Double {
        println("Masukkan nilai-nilai yang diperlukan:")
        return when (jenis_bentuk.toLowerCase()) {
            "persegi" -> keliling_persegi()
            "lingkaran" -> keliling_lingkaran()
            "segitiga" -> keliling_segitiga()
            else -> {
                println("Bentuk tidak dikenali")
                0.0
            }
        }
    }

    private fun keliling_persegi(): Double {
        print("Masukkan panjang sisi: ")
        val sisi = readLine()?.toDoubleOrNull() ?: 0.0
        val keliling = 4 * sisi
        println("Keliling persegi dengan sisi $sisi adalah $keliling")
        return keliling
    }

    private fun keliling_lingkaran(): Double {
        print("Masukkan jari-jari lingkaran: ")
        val jari = readLine()?.toDoubleOrNull() ?: 0.0
        val keliling = 2 * PI * jari
        println("Keliling lingkaran dengan jari-jari $jari adalah $keliling")
        return keliling
    }

    private fun keliling_segitiga(): Double {
        print("Masukkan panjang sisi pertama: ")
        val sisi1 = readLine()?.toDoubleOrNull() ?: 0.0
        print("Masukkan panjang sisi kedua: ")
        val sisi2 = readLine()?.toDoubleOrNull() ?: 0.0
        print("Masukkan panjang sisi ketiga: ")
        val sisi3 = readLine()?.toDoubleOrNull() ?: 0.0
        val keliling = sisi1 + sisi2 + sisi3
        println("Keliling segitiga dengan sisi $sisi1, $sisi2, dan $sisi3 adalah $keliling")
        return keliling
    }
}
import java.util.Scanner

class DeteksiAngka {
    fun deteksiAngka(angka: Int) {
        if (angka % 2 == 0) {
            println("$angka adalah angka genap")
        } else {
            println("$angka adalah angka ganjil")
        }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)

    var ulangi = true
    while (ulangi) {

        print("Masukkan angka : ")
        val angka = scanner.nextInt()

        val deteksiAngkaObjek = DeteksiAngka()

        deteksiAngkaObjek.deteksiAngka(angka)

        print("Ingin masukkan angka lagi? (ya/tidak) : ")
        val pilihan = scanner.next()

        ulangi = pilihan.equals("ya", ignoreCase = true)

    }

    scanner.close()

}
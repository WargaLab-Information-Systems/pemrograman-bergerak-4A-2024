import java.util.Scanner

class Laundry(val nama: String, val berat: Double, val hargaPerKg: Double) {
    fun harga(): Double {
        return berat * hargaPerKg
    }
}

class DaftarBarang {
    private val barangLaundry = ArrayList<Laundry>()

    fun tambahBarang(item: Laundry) {
        barangLaundry.add(item)
    }

    fun hargaTotal(): Double {
        return barangLaundry.sumByDouble { it.harga() }
    }

    fun struk() {
        println("Struk Laundry:")
        barangLaundry.forEach {
            println("${it.nama} - ${it.berat} kg - Rp ${it.harga()}")
        }
        println("Total harga: Rp ${hargaTotal()}")
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val daftarBarang = DaftarBarang()

    while (true) {
        println("Menu:")
        println("1. Tambah Barang")
        println("2. Lihat Struk")
        println("3. Keluar")
        print("Pilih menu: ")
        val pilihanMenu = scanner.nextInt()
        scanner.nextLine()

        if (pilihanMenu == 1) {
            print("Masukkan nama barang: ")
            val namaBarang = scanner.nextLine()

            print("Total berat(kg) dari $namaBarang: ")
            val beratBarang = scanner.nextDouble()
            scanner.nextLine()

            val hargaPerKg = 4000.0
            val item = Laundry(namaBarang, beratBarang, hargaPerKg)
            daftarBarang.tambahBarang(item)
        } else if (pilihanMenu == 2) {
            daftarBarang.struk()
        } else if (pilihanMenu == 3) {
            println("Terima kasih!")
            return
        } else {
            println("Pilihan menu tidak valid.")
        }
    }
}

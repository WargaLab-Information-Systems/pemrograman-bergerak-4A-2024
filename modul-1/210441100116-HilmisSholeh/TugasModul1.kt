open class Mobil(val nama: String, val biayaSewa: Int)

fun main() {
    // Daftar mobil yang tersedia
    val mobilTersedia = listOf(
        Mobil("Avanza", 200000),
        Mobil("Xenia", 200000),
        Mobil("Mobilio", 250000),
        Mobil("Innova", 350000),
        Mobil("Brio", 195000),
        Mobil("Fortuner", 450000),
        Mobil("Pajero", 450000),
        Mobil("Alphard", 550000),
        Mobil("Hiace", 650000)
    )

    var pilihanMobil: Mobil?

    var lamaSewa: Int?

    var totalBiaya = 0

    // Menampilkan daftar mobil yang tersedia
    println("Daftar mobil yang tersedia:")
    for (mobil in mobilTersedia) {
        println("- ${mobil.nama}")
    }

    // Meminta pilihan mobil dari user
    println("Pilih mobil yang ingin Anda sewa (masukkan nama mobil):")
    val inputMobil = readLine()!!.trim()

    // Mencari mobil yang dipilih user
    pilihanMobil = mobilTersedia.find { it.nama == inputMobil }

    // Menampilkan pesan jika mobil tidak ditemukan
    if (pilihanMobil == null) {
        println("Mobil tidak ditemukan!")
        return
    }

    // Meminta lama sewa dari user
    println("Masukkan lama sewa (hari):")
    val inputLamaSewa = readLine()!!.toInt()

    // Memastikan lama sewa tidak kurang dari 1
    if (inputLamaSewa < 1) {
        println("Lama sewa minimal 1 hari!")
        return
    }

    lamaSewa = inputLamaSewa

    // Menghitung total biaya
    for (i in 1..lamaSewa) {
        totalBiaya += pilihanMobil.biayaSewa
    }

    // Fungsi untuk mencetak detail mobil
    fun printDetailMobil(mobil: Mobil, lamaSewa: Int, totalBiaya: Int) {
        println("Nama mobil: ${mobil.nama}")
        println("Biaya sewa per hari: Rp${mobil.biayaSewa}")
        println("Lama sewa: $lamaSewa hari")
        println("Total biaya: Rp$totalBiaya")
    }

    // Memproses pilihan user
    if (pilihanMobil != null && lamaSewa != null) {
        printDetailMobil(pilihanMobil, lamaSewa, totalBiaya)
    }
}
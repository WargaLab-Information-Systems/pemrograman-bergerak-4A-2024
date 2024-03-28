// Kelas untuk merepresentasikan data siswa
class Siswa(val nama: String, var usia: Int, var nilai: Int) {
    // Fungsi untuk menampilkan informasi siswa
    fun tampilkanInfo() {
        println("Nama: $nama")
        println("Usia: $usia")
        println("Nilai: $nilai")
    }
}

// Fungsi untuk mengecek kelulusan siswa
fun cekKelulusan(nilai: Int): Boolean {
    return nilai >= 70
}

fun main() {
    var siswa = mutableListOf<Siswa>()

    repeat(3) {
        print("Masukkan nama siswa: ")
        val nama = readLine() ?: ""
        print("Masukkan usia siswa: ")
        val usia = readLine()?.toIntOrNull() ?: 0
        print("Masukkan nilai siswa: ")
        val nilai = readLine()?.toIntOrNull() ?: 0

        val siswaBaru = Siswa(nama, usia, nilai)
        siswa.add(siswaBaru)
    }

    for (siswa in siswa) {
        siswa.tampilkanInfo()

        if (cekKelulusan(siswa.nilai)) {
            println("${siswa.nama} telah lulus.")
        } else {
            println("${siswa.nama} belum lulus.")
        }
        println()
    }
}
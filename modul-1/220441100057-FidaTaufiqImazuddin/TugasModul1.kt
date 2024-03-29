class Mahasiswa(val nim: String, val nama: String, val jurusan: String, val alamat: String){
    fun inpo(): String {
        return "Data Mahasiswa -> NIM: $nim, Nama: $nama, Jurusan: $jurusan, Alamat: $alamat"
    }
}

fun tambahDataMahasiswa(daftar: List<Mahasiswa>): Mahasiswa? {
    print("Masukkan NIM: ")
    val nim = readLine()!!

    if(daftar.any{ it.nim == nim }) {
        println("NIM sudah terdaftar. Data gagal ditambahkan!!!")
        return null
    }
    print("Masukkan Nama: ")
    val nama = readLine()!!
    print("Masukkan Jurusan: ")
    val jurusan = readLine()!!
    print("Masukkan Alamat: ")
    val alamat = readLine()!!
    return Mahasiswa(nim, nama, jurusan, alamat)
}

fun tampilkanDaftarMahasiswa(daftar: List<Mahasiswa>) {
    println("Daftar Mahasiswa: ")
    for (mahasiswa in daftar) {
        println(mahasiswa.inpo())
    }
}

fun main() {
    val daftarMahasiswa = mutableListOf<Mahasiswa>()

    while (true) {
        println("\nMenu")
        println("1. Tambah Data Mahasiswa")
        println("2. Tampilkan Daftar Mahasiswa")
        println("3. Keluar")
        print("Pilih Menu: ")
        val pilihan = readLine()!!

        when (pilihan) {
            "1" -> {
                val mahasiswaBaru = tambahDataMahasiswa(daftarMahasiswa)
                if (mahasiswaBaru != null) {
                    daftarMahasiswa.add(mahasiswaBaru)
                    println("data berhasil ditambahkan")
                }
            }

            "2" -> {
                if (daftarMahasiswa.isNotEmpty()) {
                    tampilkanDaftarMahasiswa(daftarMahasiswa)
                } else {
                    println("Belum ada data mahasiswa yang terdaftar")
                }
            }

            "3" -> {
                print("Selesai.")
                break
            }

            else -> println("Pilihan tidak tersedia. Silahkan coba lagi.")
        }
    }
}
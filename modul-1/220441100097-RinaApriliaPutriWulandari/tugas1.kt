class AlatMusik(val nama: String, var jumlah: Int, val hargaSewa: Int)
class Peminjam(val nama: String)

fun main() {
    val daftarAlatMusik = listOf(
        AlatMusik("Suling", 3, 25000),
        AlatMusik("Gitar", 3, 50000),
        AlatMusik("Biola", 3, 75000),
        AlatMusik("Keyboard", 3, 100000)
    )

    val daftarPeminjam = mutableListOf<Peminjam>()
    var pilihan = true

    while (pilihan) {
        println("==== Program Peminjaman Alat Musik ====")
        println("Pilih menu:")
        println("1. Lihat daftar alat musik")
        println("2. Pinjam alat musik")
        println("3. Keluar")
        print("Pilihan Anda: ")
        val pilihanMenu = readLine()?.toIntOrNull()

        when (pilihanMenu) {
            1 -> {
                println("Daftar Alat Musik:")
                daftarAlatMusik.forEachIndexed { index, alat ->
                    println("${index + 1}. ${alat.nama} (Tersedia: ${alat.jumlah}, Harga Sewa: Rp${alat.hargaSewa})")
                }

                print("Apakah ingin memilih lagi? (ya/tidak): ")
                var jawaban = readLine()?.toLowerCase()
                if (jawaban == "tidak") {
                    pilihan = false
                }
            }
            2 -> {
                val notaPeminjaman = mutableMapOf<String, MutableList<String>>()
                var totalHarga = 0

                do {
                    println("Daftar Alat Musik:")
                    daftarAlatMusik.forEachIndexed { index, alat ->
                        println("${index + 1}. ${alat.nama} (Tersedia: ${alat.jumlah}, Harga Sewa: Rp${alat.hargaSewa})")
                    }

                    print("Masukkan nama peminjam: ")
                    val namaPeminjam = readLine()
                    val peminjam = Peminjam(namaPeminjam ?: "Anonymous")
                    daftarPeminjam.add(peminjam)

                    print("Masukkan nomor alat musik yang ingin dipinjam:")
                    val nomorAlat = readLine()?.toIntOrNull()?.minus(1)

                    if (nomorAlat == null || nomorAlat < 0 || nomorAlat >= daftarAlatMusik.size) {
                        println("Pilihan yang dipilih tidak sesuai")
                        pilihan = false
                        break
                    }

                    val alatYangDipinjam = daftarAlatMusik[nomorAlat]

                    print("Masukkan jumlah yang ingin dipinjam dari ${alatYangDipinjam.nama}: ")
                    val jumlahDipinjam = readLine()?.toIntOrNull()

                    if (jumlahDipinjam == null || jumlahDipinjam <= 0 || jumlahDipinjam > alatYangDipinjam.jumlah) {
                        println("Pilihan yang dipilih tidak sesuai")
                        pilihan = false
                        break
                    }

                    alatYangDipinjam.jumlah -= jumlahDipinjam
                    notaPeminjaman.getOrPut(namaPeminjam ?: "Anonymous") { mutableListOf() }.add(alatYangDipinjam.nama)
                    totalHarga += jumlahDipinjam * alatYangDipinjam.hargaSewa

                    println("Anda telah meminjam $jumlahDipinjam ${alatYangDipinjam.nama}")

                    print("Apakah ingin meminjam lagi? (ya/tidak): ")
                    var jawaban = readLine()?.toLowerCase()
                    while (jawaban != "ya" && jawaban != "tidak") {
                        println("Inputan yang dimasukkan salah")
                        print("Apakah ingin meminjam lagi? (ya/tidak): ")
                        jawaban = readLine()?.toLowerCase()
                    }
                    if (jawaban == "tidak") {
                        break
                    }
                } while (true)

                if (!pilihan) {
                    break
                }

                println("====================")
                println("       Nota")
                println("====================")
                notaPeminjaman.forEach { (namaPeminjam, alatDipinjam) ->
                    println("Nama Peminjam: $namaPeminjam")
                    println("--------------------")
                    println("Nama Alat\tJumlah\tHarga")
                    println("--------------------")
                    alatDipinjam.forEach { namaAlat ->
                        val alat = daftarAlatMusik.find { it.nama == namaAlat }
                        val hargaTotal = alat?.hargaSewa ?: 0
                        println("$namaAlat\t\t1\tRp$hargaTotal")
                    }
                    println("--------------------")
                }
                println("Total Harga:\tRp$totalHarga")
                println("====================")

                print("Apakah ingin memilih lagi? (ya/tidak): ")
                var jawaban = readLine()?.toLowerCase()
                while (jawaban != "ya" && jawaban != "tidak") {
                    println("Inputan yang dimasukkan salah")
                    print("Apakah ingin memilih lagi? (ya/tidak): ")
                    jawaban = readLine()?.toLowerCase()
                }
                if (jawaban == "tidak") {
                    pilihan = false
                }
            }
            3 -> {
                pilihan = false
            }
            else -> {
                println("Pilihan yang dipilih tidak sesuai")
                pilihan = false
            }
        }
    }

    println("Terima kasih telah menggunakan program peminjaman alat musik")
}
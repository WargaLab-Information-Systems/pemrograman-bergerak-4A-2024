package com.example.tgsnilai
import kotlin.system.exitProcess
//val nilai tetap
class PeriksaNilai(private val nilai: Int) {
    fun periksa() {
        if (nilai < 0) {
            println("Maaf, nilai tidak boleh negatif atau kurang dari 0.")
        } else if (nilai > 100) {
            println("Maaf, nilai tidak boleh lebih dari 100.")
        } else if (nilai >= 80) {
            println("Nilai Anda: $nilai")
            println("Selamat! Anda mendapatkan nilai A")
        } else if (nilai >= 65) {
            println("Nilai Anda: $nilai")
            println("Anda mendapatkan nilai B")
        } else if (nilai >= 50) {
            println("Nilai Anda: $nilai")
            println("Anda mendapatkan nilai C")
        } else if (nilai >= 35) {
            println("Nilai Anda: $nilai")
            println("Anda mendapatkan nilai D")
        } else {
            println("Nilai Anda: $nilai")
            println("Maaf, Anda mendapatkan nilai E. Anda perlu belajar lebih giat lagi.")
        }
    }
}

fun main() {
    println("===== Selamat Datang Di Program Pengelompokan Nilai =====")
    var lanjut = true

    while (lanjut) {
        println("\nMenu:")
        println("1. Periksa Nilai")
        println("2. Informasi Program & Bantuan")
        println("3. Keluar")
        print("Pilih menu: ")

        when (readlnOrNull()?.toIntOrNull()) {
            1 -> {
                do {
                    print("\n Masukkan nilai Anda: ")
                    val input = readlnOrNull()
                    if (input.isNullOrEmpty()) {
                        println("Input tidak boleh kosong. Silakan masukkan nilai yang valid.")
                        continue
                    }
                    val nilai = input.toIntOrNull()
                    if (nilai == null) {
                        println("Maaf, input tidak valid. Mohon masukkan nilai angka.")
                        continue
                    }
                    val periksaNilai = PeriksaNilai(nilai)
                    periksaNilai.periksa()
                    var ulangi: String?
                    do {
                        print("\n Ingin memasukkan nilai lagi? (y/n): ")
                        ulangi = readlnOrNull()?.lowercase()
                        if (ulangi != "y" && ulangi != "n") {
                            println("Input y/n saja.")
                        }
                    } while (ulangi != "y" && ulangi != "n")
                    if (ulangi == "n") {
                        break
                    }
                } while (true)
            }
            2 -> {
                println("\n ===== Informasi Program: =====")
                println("Program ini adalah program sederhana untuk pengelompokan nilai.")
                println("Dibuat oleh Fera Defi (22-045).")
                println("\n ===== Bantuan: =====")
                println("Silakan masukkan nilai Anda untuk mengetahui kategori nilai.")
                println("Program ini hanya menerima input berupa bilangan bulat.")
                println("Nilai yang diterima berkisar dari 0 hingga 100.")
            }
            3 -> {
                lanjut = false
            }
            else -> {
                println("Menu tidak valid. Silakan pilih menu yang tersedia.")
            }
        }
        if (!lanjut) {
             break
        }

        var ulangiMenu: String?
        do {
            print("\n Ingin memilih menu lagi? (y/n): ")
            ulangiMenu = readlnOrNull()?.lowercase()
            if (ulangiMenu != "y" && ulangiMenu != "n") {
                println("Input y/n saja.")
            }
        } while (ulangiMenu != "y" && ulangiMenu != "n")

        if (ulangiMenu == "n") {
            lanjut = false
        }
    }

    println("Program Selesai.")
    exitProcess(0)
}

//readlnOrNull() membaca input pengguna dan mengembalikan nilainya,atau null jika terjadi kesalahan.
//variabel, = lanjut, input, nilai, dan jawab.
// function = main, readlnOrNull, dan fungsi di dalam kelas PeriksaNilai.

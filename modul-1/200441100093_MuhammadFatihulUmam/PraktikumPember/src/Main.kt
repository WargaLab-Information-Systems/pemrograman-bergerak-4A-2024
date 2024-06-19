class Kategori {
    var usia = ""
    var kelas = ""

    fun seleksi() {
        println("===== SELAMAT DATANG PESERTA TRUNOJOYO CUP 2024 =====")
        print("Silahkan Masukkan Nama Lengkap Anda: ")
        val nama = readLine()
        print("Silahkan Masukkan Jenis Kelamin Anda: ")
        val jk = readLine()
        print("Silahkan Masukkan Usia Anda: ")
        val umurInput = readLine()
        print("Silahkan Masukkan Bobot Anda: ")
        val bobotInput = readLine()

        val umur = umurInput?.toInt()
        val bobot = bobotInput?.toInt()

        if (umur != null) {

            if (umur >= 17) {
                usia = "Dewasa"
                if (bobot != null) {
                    if (bobot > 70) kelas = "lebih"
                    else if (bobot >= 65) kelas = "E"
                    else if (bobot >= 60) kelas = "D"
                    else if (bobot >= 55) kelas = "C"
                    else if (bobot >= 50) kelas = "B"
                    else if (bobot >= 45) kelas = "A"
                    else kelas = "kurang"
                }
            } else if (umur >= 14) {
                usia = "Remaja"
                if (bobot != null) {
                    if (bobot > 63) kelas = "lebih"
                    else if (bobot >= 59) kelas = "F"
                    else if (bobot >= 55) kelas = "E"
                    else if (bobot >= 51) kelas = "D"
                    else if (bobot >= 47) kelas = "C"
                    else if (bobot >= 43) kelas = "B"
                    else if (bobot >= 39) kelas = "A"
                    else kelas = "kurang"
                }
            } else if (umur >= 11) {
                usia = "Pra Remaja"
                if (bobot != null) {
                    if (bobot > 60) kelas = "lebih"
                    else if (bobot >= 57) kelas = "J"
                    else if (bobot >= 54) kelas = "I"
                    else if (bobot >= 51) kelas = "H"
                    else if (bobot >= 48) kelas = "G"
                    else if (bobot >= 45) kelas = "F"
                    else if (bobot >= 42) kelas = "E"
                    else if (bobot >= 39) kelas = "D"
                    else if (bobot >= 36) kelas = "C"
                    else if (bobot >= 33) kelas = "B"
                    else if (bobot >= 30) kelas = "A"
                    else kelas = "kurang"
                }
            } else if (umur >= 8) {
                usia = "Usia Dini"
                if (bobot != null) {
                    if (bobot > 46) kelas = "lebih"
                    else if (bobot >= 44) kelas = "J"
                    else if (bobot >= 42) kelas = "I"
                    else if (bobot >= 40) kelas = "H"
                    else if (bobot >= 38) kelas = "G"
                    else if (bobot >= 36) kelas = "F"
                    else if (bobot >= 34) kelas = "E"
                    else if (bobot >= 32) kelas = "D"
                    else if (bobot >= 30) kelas = "C"
                    else if (bobot >= 28) kelas = "B"
                    else if (bobot >= 26) kelas = "A"
                    else {kelas = "kurang"
                        println("")
                    }
                }
            }
        }

        val template = """
            ===========================================
            Nama          = $nama
            Jenis Kelamin = $jk
            Umur          = $umurInput 
            Bobot         = $bobotInput 
            ===========================================
            ============ Kategori Tanding =============
            Usia   = $usia
            Kelas  = $kelas
            """
        if (kelas == "lebih"){
            println("==== Bobot Anda Lebih Dari Batas Ketentuan ====")
            return main()
        }else if (kelas == "kurang") {
            println("==== Bobot Anda Kurang Dari Batas Ketentuan ====")
        }else if (umur!! > 30) {
            println("==== Umur Anda Lebih Dari Batas Ketentuan ====")
        }else if (umur < 8) {
            println("==== Umur Anda Kurang Dari Batas Ketentuan ====")
        }else if (umurInput.isNullOrBlank() || bobotInput.isNullOrBlank()) {
            println("============ DATA HARUS DIISI SEMUA =============")
            println("==== UMUR DAN BOBOT HARUS DIISI DENGAN ANGKA ====")
        }
        else println(template)
    }
}

fun main() {

    do {
        val atlet = Kategori()
        atlet.seleksi()
        print("Apakah anda ingin masukkan data lagi? (y/t) ")
        val a = readLine()
    } while (a == "y")

    print("===== TERIMAKASIH ====")

}

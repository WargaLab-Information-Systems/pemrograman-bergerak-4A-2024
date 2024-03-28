class WeatherForecast(var suhu: String, var jenis: String, var tahun: Int)

fun main() {
    // Menggunakan 'var' karena variabel akan diubah ketika pengguna memilih menu 1
    var weatherForecast = WeatherForecast("Dingin", "Badai", 2024)

    // Perulangan menu
    while (true) {
        println("=== Menu ===")
        println("1. Isi Informasi Cuaca Hari Ini")
        println("2. Tampilkan Cuaca Hari Ini")
        println("3. Keluar")

        print("Pilih menu (1/2/3): ")
        when (val choice = readLine()?.toIntOrNull()) {
            1 -> {
                // Isi informasi cuaca sesuai input pengguna
                print("Masukkan suhu: ")
                val suhuInput = readLine() ?: ""
                print("Masukkan jenis cuaca: ")
                val jenisInput = readLine() ?: ""
                print("Masukkan tahun: ")
                val tahunInput = readLine()?.toIntOrNull() ?: 0

                // Mengganti nilai properti WeatherForecast dengan input pengguna
                weatherForecast = WeatherForecast(suhuInput, jenisInput, tahunInput)
                println("Informasi cuaca berhasil diisi.")
            }
            2 -> {
                // Menampilkan informasi cuaca
                println("Cuaca hari ini: Suhu ${weatherForecast.suhu}, Jenis ${weatherForecast.jenis}, Tahun ${weatherForecast.tahun}")
            }
            3 -> {
                // Keluar dari program
                println("Terima kasih! Sampai jumpa.")
                return
            }
            else -> {
                // Pilihan tidak valid
                println("Pilihan '$choice' tidak valid. Silakan pilih lagi.")
            }
        }
    }
}




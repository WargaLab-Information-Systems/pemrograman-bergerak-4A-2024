fun main() {
    val tokeElektronik = toko()
    tokeElektronik.garis()
   	println("")
    println("        SELAMAT DATANG\n      DI TOKO ELECTROMALL")
    tokeElektronik.garis()
    println("")
    println("        Daftar Produk         ")
    tokeElektronik.garis()
    println("")
    println("1. Laptop = Rp 5.000.000\n2. Handphone = Rp 2.500.000\n3. Komputer = Rp 15.000.000")
    println("")
    println("Pilih Produk Yang Ingin Dibeli (1/2/3)")
    val produk = 3
    val harga: Int
    println("")
    if (produk == 1){
        println("Pilihan Anda 1")
        tokeElektronik.garis()
        println("")
        println("        Keranjang belanja         ")
        tokeElektronik.garis()
        println("")
        println("1. Laptop = Rp 5.000.000")
        harga = 5000000
    }else if(produk == 2){
        println("Pilihan Anda 2")
        tokeElektronik.garis()
        println("")
        println("        Keranjang belanja         ")
        tokeElektronik.garis()
        println("")
        println("Handphone = Rp 2.500.000")
        harga = 2500000
    }else if(produk == 3){
        println("Pilihan Anda 3")
        tokeElektronik.garis()
        println("")
        println("        Keranjang belanja         ")
        tokeElektronik.garis()
        println("")
        println("Komputer = Rp 15.000.000")
        harga = 15000000
    }else {
        println{"pilihan anda Tidak Valid"}
        return
    }
    println("")
    tokeElektronik.garis()
    println("")
    println("        Checkout         ")
    tokeElektronik.garis()
    println("")
    println("Masukkan Nominal Pembayaran")
    println("Rp. 25.000.000")
    var bayar = 20000000
    var kembalian = bayar - harga
    if (bayar == harga){
        println("Uang Anda Pas")
    }else if (bayar > harga){
        println("Kembalian = $kembalian")
    }else {
        println("Uang Kurang = $kembalian")
        
    }
    println("Terima kasih telah menggunakan TOKO ELECTROMALL. Sampai jumpa lagi")

}

class toko(){
    fun garis() {
        for (i in 1 .. 30){
            val baris = "="
            print(baris)
        }
    }
}
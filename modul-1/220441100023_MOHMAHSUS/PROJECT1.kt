fun main() {
    val tokoOnline = toko()
    tokoOnline.garis()
   	println("")
    println("         WELLCOME TO\n      EVERNEXT OFFICIAL")
    tokoOnline.garis()
    println("")
    println("        Daftar Barang         ")
    tokoOnline.garis()
    println("")
    println(" 1. Tas Ransel Backpack = Rp 355.000\n 2. Pouch Hand Bag = Rp 105.000\n 3. Dompet Lipat Wallet = Rp 165.000")
    println("")
    println("Pilih Produk Yang Ingin Dibeli (1/2/3)")
    val produk = 1
    val harga: Int
    println("")
    if (produk == 1){
        println("Pilihan Anda 1")
        tokoOnline.garis()
        println("")
        println("        Keranjang belanja         ")
        tokoOnline.garis()
        println("")
        println("1. Tas Ransel Backpack = Rp 355.000")
        harga = 355000
    }else if(produk == 2){
        println("Pilihan Anda 2")
        tokoOnline.garis()
        println("")
        println("       Keranjang belanja         ")
        tokoOnline.garis()
        println("")
        println("Pouch Hand Bag = Rp 105.000")
        harga = 105000
    }else if(produk == 3){
        println("Pilihan Anda 3")
        tokoOnline.garis()
        println("")
        println("       Keranjang belanja         ")
        tokoOnline.garis()
        println("")
        println(" Dompet Lipat Wallet = Rp 165.000")
        harga = 165000
    }else {
        println{"pilihan anda Tidak Valid"}
        return
    }
    println("")
    tokoOnline.garis()
    println("")
    println("         Checkout         ")
    tokoOnline.garis()
    println("")
    println("Masukkan Nominal Pembayaran")
    println("Rp. 400.000")
    var bayar = 400000
    var kembalian = bayar - harga
    if (bayar == harga){
        println("Uang Anda Pas")
    }else if (bayar > harga){
        println("Kembalian = $kembalian")
    }else {
        println("Uang Kurang = $kembalian")
        
    }
    println("THANK YOU")

}
class toko(){
    fun garis() {
        for (i in 1 .. 30){
            val baris = "="
            print(baris)
        }
    }
}
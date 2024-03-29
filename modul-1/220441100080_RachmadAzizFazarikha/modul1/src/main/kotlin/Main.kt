import java.util.Scanner

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val orang = user()

    var pilih: Int

    do {
        orang.welcome()

        print("Masukkan Pilihan : ")
        pilih = input.nextInt()

        when(pilih){
            1 ->{
                orang.item()
                print("Masukkan No Item Ke Keranjang : ")
                var masuk_itm : Int = input.nextInt()
                if (masuk_itm == 1){
                    orang.masukkan("Kemeja", 75000)
                }else if (masuk_itm == 2){
                    orang.masukkan("Kaos", 50000)
                }else if (masuk_itm == 3){
                    orang.masukkan("Celana Panjang", 100000)
                }else if (masuk_itm == 4){
                    orang.masukkan("Celana Pendek", 60000)
                }
            }
            2 ->{
                orang.keranjang_itm()
            }
            3 ->{
                println("Pembayaran Berhasil")
            }
        }
    }while (pilih != 0)
}

class user(){
    var keranjang: ArrayList<String> = ArrayList()
    var total: Int = 0

    fun welcome(){
        println("==========================================================================")
        println("Selamat Datang di Toko Clothing")
        println("1. Tampilkan Item \n2. Lihat Keranjang \n3. Bayar \n0. Keluar")
        println("")
    }

    fun item(){
        println("==========================================================================")
        println("Daftar Item")
        println("1. Kemeja \n2. Kaos \n3. Celana Panjang \n4. Celana Pendek")
        println("Ketik exit untuk kembali ke Menu Awal")
    }

    fun masukkan(barang : String, harga : Int){
        keranjang.add(barang)
        total = total + harga
        println("Berhasil Ditambahkan Ke Keranjang")
    }

    fun keranjang_itm(){
        println("=====================")
        println("Keranjang : ")
        var ind : Int = 0
        for (p in keranjang){
            println("$ind -> $p")
            ind = ind + 1
        }
        println("Total Harga Item : $total")
        println("=====================")
    }
}

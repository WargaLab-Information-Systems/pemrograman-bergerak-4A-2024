fun main() {
    println("||==================================||")
    println("||----------SELAMAT DATANG----------||")
    println("||==================================||")
    println("")
    pembeli()
    println("")
    daftar()
    println("")
    tanda()
    beli()
    tanda()
    println("")
    println("-----------TERIMA KASIH-----------")
}

// function

fun pembeli(){
    val orang = Orang()
    println(orang.identitas())
}
class Orang() {      
    fun identitas() = "nama pembeli = faril"
} 
fun daftar(){
    println("DAFTAR HP:")
    println("")
    println("1. SAMSUNG = RP.5.000.000")
    println("2. VIVO    = RP.3.000.000")
    println("3. OPPO    = RP.4.500.000")
    println("4. REDMI   = RP.3.500.000")
    println("5. INFINIX = RP.2.000.000")
}
fun tanda (){
    var tanda1 = 3
    while (tanda1 < 5){
        tanda1++
        println("==================================")
    }
}

fun beli (){
    var jumlah = 13
    if (jumlah == 10){
        println("anda membeli HP : ")
        println("1. SAMSUNG = RP.5.000.000")
        println("2. VIVO    = RP.3.000.000")
    	println("3. OPPO    = RP.4.500.000")
    } else if (jumlah > 12 || jumlah < 15){
        println("anda membeli HP : ")
        println("INFINIX DENGAN HARGA RP 2.000.000")
    }
}
@file:JvmName("Main")

fun main(){

    ExchangeApp(7000).init()

    /*println("Teste")
    val response = khttp.get(url = "https://api.exchangeratesapi.io/latest?base=USD")

    println(response)

    println(response.text)

    val obj : JSONObject = response.jsonObject
    print(obj["rates"])


    val student = Gson().fromJson(response.text, RatesDTO::class.java)

    println(student)*/
}
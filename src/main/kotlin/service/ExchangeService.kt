package service

import com.google.gson.Gson
import dto.RatesDTO
import model.Entrada
import org.json.JSONObject

interface ExchangeService {
    fun register(entrada : Entrada)
}


class ExchangeServiceImpl(): ExchangeService {

    override fun register(entrada : Entrada) {

        println(entrada.moedaOrigem)

        val response = khttp.get(url = "https://api.exchangeratesapi.io/latest?base=$(entrada.moedaOrigem)")

        val obj : JSONObject = response.jsonObject

        val student = Gson().fromJson(response.text, RatesDTO::class.java)

        println(student)

    }
}
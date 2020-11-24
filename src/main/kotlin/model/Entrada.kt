package model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.util.*

/**
 * Entity definition
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class Entrada (
    val id: Int?,
    val moedaOrigem: String,
    val valorOrigem: Double,
    val moedaDestino: String) {
}
package controller

import io.javalin.Context
import model.Entrada
import service.ExchangeService

interface ExchangeController {
    fun registerEvent(ctx: Context)

}

class ExchangeApiController(private val service : ExchangeService): ExchangeController {
    override fun registerEvent(ctx: Context) {
        val entradaEvent = ctx.validatedBody<Entrada>().getOrThrow()
        val id = service.register(entradaEvent);
        ctx.status(201);
        ctx.json(object {val id = id})
    }

}
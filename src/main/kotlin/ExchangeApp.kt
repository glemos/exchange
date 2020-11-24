import io.javalin.Javalin

class ExchangeApp (private val port: Int = 7000) {

    var app = Javalin.create()

    fun init(): Javalin {

        app = app.apply {
            port(port)
            //enableStaticFiles("/public")
            enableCorsForAllOrigins()
            exception(Exception::class.java) { e, _ -> e.printStackTrace() }
            error(404) { ctx -> ctx.json("not found") }
        }

        app.start();

        Koin.initKoin()

        Api.initApi(app)

        return app
    }
}
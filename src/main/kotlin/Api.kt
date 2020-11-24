import controller.ExchangeController
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder
import org.koin.standalone.KoinComponent
import org.koin.standalone.get

class Api : KoinComponent {
    companion object : KoinComponent {

        val exchangeEventController : ExchangeController =  get()
        fun initApi(app: Javalin) {

            app.routes {
                ApiBuilder.path("/") {
                    ApiBuilder.get() { ctx ->
                        val url = ctx.url()
                        ctx.redirect("/quote")
                    }
                }
                ApiBuilder.path("/quote") {
                    ApiBuilder.post(exchangeEventController::registerEvent)
                }
            }


            fun stop(){
                Koin.stopKoin()
                app.stop();
            }
        }
    }
}
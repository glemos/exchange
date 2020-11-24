import controller.ExchangeApiController
import controller.ExchangeController
import org.koin.dsl.module.module
import org.koin.standalone.KoinComponent
import org.koin.standalone.StandAloneContext
import service.ExchangeService
import service.ExchangeServiceImpl

class Koin {

    companion object: KoinComponent{
        fun initKoin(){
            StandAloneContext.startKoin(listOf(exchangeEventsModule))
        }

        fun stopKoin(){
            StandAloneContext.stopKoin()
        }

        val exchangeEventsModule = module {

            single { ExchangeServiceImpl() as ExchangeService }

            module ("gitHub"){
                factory { ExchangeApiController( get()) as ExchangeController }
            }
        }
    }
}
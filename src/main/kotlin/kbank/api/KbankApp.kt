package kbank.api

import com.fasterxml.jackson.databind.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.jackson.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*


fun Application.main() {
    install(DefaultHeaders)
    install(CallLogging)
    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT) // Pretty Prints the JSON
        }
    }
    install(Routing) {
        get("/") {
            call.respondText("KBank is Starting", ContentType.Text.Html)
        }
        post("/command"){
            val command = call.receive<Command>()
            log.info(command.toString())
            call.respond(mapOf("OK" to true))
        }
    }
}

package br.com.webmarmo

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.routing.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
fun Application.module() {
    // configureRouting()
    install(CallLogging)
    routing {
        static(remotePath = "assets") {
            resources("static")
        }
        get("/") {
            call.respondText { "Hello, World!" }
        }
    }
}

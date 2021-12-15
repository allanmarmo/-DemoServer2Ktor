package br.com.webmarmo

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.html.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlinx.html.*

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
        get("/welcome") {
            val name = call.request.queryParameters["name"]
            call.respondHtml {
                head {
                    title { +"Custom Title" }
                }
                body {
                    if (name.isNullOrEmpty()) {
                        h3 { +"Welcome!" }
                    } else {
                        h3 { +"Welcome, $name!" }
                    }
                    p { +"Current directory is: ${System.getProperty("user.dir")}" }
                    img(src = "assets/logo.jpg")
                }
            }
        }
    }
}

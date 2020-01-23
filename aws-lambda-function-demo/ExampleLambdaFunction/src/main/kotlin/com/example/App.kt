package com.example

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import kotlin.collections.HashMap
import java.io.IOException
import java.net.URL


/**
 * Handler for requests to Lambda function.
 */
class App : RequestHandler<Any?, Any> {

    override fun handleRequest(input: Any?, context: Context?): Any {
        val headers = HashMap<String, String>().apply {
            this["Content-Type"] = "application/json"
            this["X-Custom-Header"] = "application/json"
        }
        return try {
            val callerIp = getPageContents("https://checkip.amazonaws.com")
            val output = """{ "message": "hello :)", "location": "${callerIp}" }""".trim()
            GatewayResponse(output, headers, 200);
        } catch (e: IOException) {
            GatewayResponse("{}", headers, 500);
        }
    }

    private fun getPageContents(address: String): String {
        return URL(address).openStream().run { bufferedReader().readText().trim() }
    }
//    private val getPageContents = {
//        address: String -> URL(address).openStream().run { bufferedReader().readText() }
//    }
}

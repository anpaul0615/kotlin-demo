package com.example

import kotlin.collections.HashMap


data class GatewayResponse(
        val body: String,
        val headers: HashMap<String, String>,
        val statusCode: Int
)

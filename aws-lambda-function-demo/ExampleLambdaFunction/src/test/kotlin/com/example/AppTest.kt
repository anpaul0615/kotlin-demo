package com.example

import org.junit.Assert
import org.junit.Test

class KAppTest {
    @Test
    fun successfulResponse() {
        val app = App()
        val result = app.handleRequest(null, null) as GatewayResponse
        Assert.assertEquals(result.statusCode.toLong(), 200)
        Assert.assertEquals(result.headers["Content-Type"], "application/json")
        val content:String = result.body
        Assert.assertNotNull(content)
        Assert.assertTrue(content.contains("\"message\""))
        Assert.assertTrue(content.contains("\"hello world\""))
        Assert.assertTrue(content.contains("\"location\""))
    }
}
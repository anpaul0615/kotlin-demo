/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package helloworld

import kotlin.test.Test
import kotlin.test.assertNotNull

class AppTest {
    @Test fun testAppHasAGreeting() {
        val classUnderTest = App("abcd-123")
        assertNotNull(classUnderTest.greeting, "app should have a greeting")
    }
}

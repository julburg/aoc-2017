package de.aoc

import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

/**
 * @author Julia Burgard - burgard@synyx.de
 */
class Day7KtTest {

    @Test
    fun day7() {
        val input = File("inputDay7").inputStream().bufferedReader().use { it.readText() }

        val day7 = day7(input)
        println(day7)
        assertTrue(day7 == "tknk")
    }

    @Test
    fun day7b() {
        val input = File("inputDay7").inputStream().bufferedReader().use { it.readText() }

        val day7 = day7b(input)
        println(day7)
        assertTrue(day7 == "tknk")
    }

}
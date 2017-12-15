package de.aoc

import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

/**
 * @author Julia Burgard - burgard@synyx.de
 */
class Day8KtTest {

    @Test
    fun day8() {
        val input = File("inputDay8").inputStream().bufferedReader().use { it.readText() }

        val day8 = day8(input)
        println(day8)
        assertTrue(day8.first == 1)
        assertTrue(day8.second == 10)
    }



}
package de.aoc

import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

/**
 * @author Julia Burgard - burgard@synyx.de
 */
class Day2KtTest {

    @Test
    fun day2Examples() {
        val input="5 1 9 5\n" +
                "7 5 3\n" +
                "2 4 6 8";
        assertTrue(day2a(input)==18)
    }

     @Test
    fun day2() {
        val input = File("inputDay2").inputStream().bufferedReader().use { it.readText() }
        val result = day2a(input)

         assertTrue(result == 50376)
    }

    @Test
    fun day2bExamples() {
        val input = "5 9 2 8\n" +
                "9 4 7 3\n" +
                "3 8 6 5";
        assertTrue(day2b(input) == 9)
    }

}
package de.aoc

import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

/**
 * @author Julia Burgard - burgard@synyx.de
 */
class Day1KtTest {

    @Test
    fun day1aExamples() {

        var input = "1122";
        var result = day1a(input)
        assertTrue(result == 3)

        input = "1111";
        result = day1a(input)
        assertTrue(result == 4)

        input = "1234";
        result = day1a(input)
        assertTrue(result == 0)

        input = "91212129";
        result = day1a(input)
        assertTrue(result == 9)
    }

    @Test
    fun day1a() {
        val input = File("inputday1").inputStream().bufferedReader().use { it.readText() }
        val result = day1a(input)

        assertTrue(result == 1216)
    }

    @Test
    fun day1bExamples() {

        var input = "1212";
        var result = day1b(input)
        assertTrue(result == 6)

        input = "1221";
        result = day1b(input)
        assertTrue(result == 0)

        input = "123425";
        result = day1b(input)
        assertTrue(result == 4)

        input = "123123";
        result = day1b(input)
        assertTrue(result == 12)

        input = "12131415";
        result = day1b(input)
        assertTrue(result == 4)
    }

    @Test
    fun day1b() {
        val input = File("inputday1").inputStream().bufferedReader().use { it.readText() }
        val result = day1b(input)

        assertTrue(result == 1072)
    }
}
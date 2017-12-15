package de.aoc

import kotl.de.aoc.findAll
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

/**
 * @author Julia Burgard - burgard@synyx.de
 */
class Day9KtTest {

    @Test
    fun day9() {
        val input = File("inputDay9").inputStream().bufferedReader().use { it.readText() }

        val day9 = day9a(input)
        println(day9)
        assertTrue(day9 == 1)
    }

    @Test
    fun day9b() {
        val input = File("inputDay9").inputStream().bufferedReader().use { it.readText() }

        val day9 = day9b(input)
        println(day9)
        assertTrue(day9 == 1)
    }

    @Test
    fun day9Example1() {
        val input = "{}"
        assertTrue(day9a(input) == 1)
    }

    @Test
    fun day9Example2() {
        val input = "{{{}}}"
        val message = day9a(input)
        println(message)
        assertTrue(message == 6)
    }

    @Test
    fun day9Example3() {
        val input = "{{{},{}}}"
        val message = day9a(input)
        println(message)
        assertTrue(message == 9)
    }

    @Test
    fun day9Example4() {
        val input = "{{{},{},{{}}}}"
        val day9 = day9a(input)
        println(day9)
        assertTrue(day9 == 16)
    }

    @Test
    fun day9Exampled4() {
        val input = "{{},{},{{}}}"
        println(input.findAll("""([{|}])""").toList().size%2)

        val evenNumberOfBracketd = input.split(",").filter{it.findAll("""([{|}])""").toList().size % 2 != 0 }.size ==0


        print(evenNumberOfBracketd)
    }

    @Test
    fun day9Example5() {
        val input = "{<a>,<a>,<a>,<a>}"
        assertTrue(day9a(input) == 1)
    }

    @Test
    fun day9Example6() {
        val input = "{{<ab>},{<ab>},{<ab>},{<ab>}}"
        assertTrue(day9a(input) == 9)
    }

    @Test
    fun day9Example7() {
        val input = "{{<!!>},{<!!>},{<!!>},{<!!>}}"
        assertTrue(day9a(input) == 9)
    }

    @Test
    fun day9Example8() {
        val input = "{{<a!>},{<a!>},{<a!>},{<ab>}}"
        assertTrue(day9a(input) == 3)
    }


}
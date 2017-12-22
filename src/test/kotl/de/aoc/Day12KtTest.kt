package de.aoc

import org.junit.Test
import java.io.File

/**
 * @author Julia Burgard - burgard@synyx.de
 */
class Day12KtTest {

    @Test
    fun day12Example() {
        val input = "0 <-> 2\n" +
                "1 <-> 1\n" +
                "2 <-> 0, 3, 4\n" +
                "3 <-> 2, 4\n" +
                "4 <-> 2, 3, 6\n" +
                "5 <-> 6\n" +
                "6 <-> 4, 5\n"

        val day12 = day12(input)
        assert(day12 == 6)
    }

    @Test
    fun day12() {
        val input = File("inputDay12").inputStream().bufferedReader().use { it.readText() }

        val day12 = day12(input)
        println(day12)
        assert(day12 == 378)
    }

    @Test
    fun day12bExample() {
        val input = "0 <-> 2\n" +
                "1 <-> 1\n" +
                "2 <-> 0, 3, 4\n" +
                "3 <-> 2, 4\n" +
                "4 <-> 2, 3, 6\n" +
                "5 <-> 6\n" +
                "6 <-> 4, 5\n"

        val day12 = day12b(input)
        assert(day12 == 2)
    }

    @Test
    fun day12b() {
        val input = File("inputDay12").inputStream().bufferedReader().use { it.readText() }

        val day12 = day12b(input)
        println(day12)
        assert(day12 == 204)
    }


}

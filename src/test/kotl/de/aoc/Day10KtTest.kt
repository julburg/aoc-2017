package de.aoc

import org.junit.Assert.assertTrue
import org.junit.Test
import java.util.*

/**
 * @author Julia Burgard - burgard@synyx.de
 */
class Day10KtTest {

    @Test
    fun day10() {
        val input = "70,66,255,2,48,0,54,48,80,141,244,254,160,108,1,41"

        val day10 = day10(input, 256)
        println(day10)
        assertTrue(day10 == 1)
    }

    @Test
    fun day10Example() {
        val input = "3,4,1,5"

        val day10 = day10(input, 5)
        println(day10)
        assertTrue(day10 == 12)
    }

    @Test
    fun getSubListCircular() {
        val input = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)

        val res = getSubList(input, 5, 5)
        println(res.indizes.joinToString(","))
        println(res.values.joinToString(","))

        assertTrue(res.indizes == Arrays.asList(5, 6, 7, 0, 1))
        assertTrue(res.values == Arrays.asList(6, 7, 8, 1, 2))
    }

    @Test
    fun getSubList() {
        val input = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)

        val res = getSubList(input, 2, 3)
        assertTrue(res.indizes == Arrays.asList(2, 3, 4))
        assertTrue(res.values == Arrays.asList(3, 4, 5))
    }

    @Test
    fun getSubListOneElement() {
        val input = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)

        val res = getSubList(input, 7, 1)
        println(res.values.joinToString(","))
        assertTrue(res.indizes == Arrays.asList(7))
        assertTrue(res.values == Arrays.asList(8))
    }


}

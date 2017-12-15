package de.aoc

import org.junit.Assert.assertTrue
import org.junit.Test

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
        val input = "3, 4, 1, 5"

        val day10 = day10(input, 5)
        println(day10)
        assertTrue(day10 == 1)
    }


}
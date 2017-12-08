package de.aoc

import kotl.de.aoc.findAll

/**
 * @author  Julia Burgard - burgard@synyx.de
 */
fun day2a(input: String): Int {

    val rows = input.split("\n")
    val result: Iterable<Int> = rows.map {
        val numbersInTheRow = it.findAll("""(\d+)""").map {
            val (number: kotlin.String) = it.destructured
            number.toInt()
        }
        var max = numbersInTheRow.map { it.toInt() }.max();
        var min = numbersInTheRow.map { it.toInt() }.min();
        if (max != null && min != null) {
            max - min
        } else {
            0
        }
    }
    return result.sum()
}

fun day2b(input: String): Int {
    val rows = input.split("\n")
    val result: Iterable<Int> = rows.map {
        val numbersInTheRow = it.findAll("""(\d+)""").map {
            val (number: kotlin.String) = it.destructured
            number.toInt()
        }
        
        0
    }
    return result.sum()

}
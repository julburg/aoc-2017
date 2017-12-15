package de.aoc

import kotl.de.aoc.findAll


/**
 * @author  Julia Burgard - burgard@synyx.de
 */
fun day1a(input: String): Int {

    val lastDigit = input.findAll("""^(\d)""").map {
        val (result: String) = it.destructured
        result.toInt()
    }

    val inputWithLastSign = input + lastDigit.sum()
    val dublicatedNumbers = inputWithLastSign.findAll("""(\d)(?=\1)""").map {
        val (result: String) = it.destructured
        result.toInt()
    }

    return dublicatedNumbers.sum()
}

fun day1b(input: String): Int {

    val halfLength = (input.length / 2);
    val longerInput = input + input.substring(0, halfLength)

    val value = Regex("(?=((\\d)\\d{" + (halfLength.toInt() - 1) + "}(?=\\2)))").toString()
    val duplicatedNumbers = longerInput.findAll(value).map {
        val (first: String, second: String) = it.destructured
        second.toInt()
    }

    return duplicatedNumbers.sum()
}


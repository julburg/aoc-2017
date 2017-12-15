package de.aoc

import kotl.de.aoc.findAll

/**
 * @author  Julia Burgard - burgard@synyx.de
 */
fun day9a(input: String): Int {

    val inputFiltered = input.replace(Regex("!."), "")
    val inputFilteredGarbage = inputFiltered.replace(Regex("<[^>]*>"), "")
    val inputFilteredCommas = inputFilteredGarbage.replace(",", "");
    println(inputFilteredCommas)

    val reduceString = reduceString(inputFilteredCommas)
    println(reduceString)
    return reduceString
}

fun reduceString(value: String): Int {

    val splitted = value.split("");
    var sum: Int = 0;
    var lvl: Int = 1;
    splitted.forEach {
        if (it == "{") {
            sum = sum + lvl + 1
            lvl++
        } else {
            lvl--
        }

    }
    return sum;
}

fun day9b(input: String): Int {

    val inputFiltered = input.replace(Regex("!."), "")
    println(inputFiltered)
    return inputFiltered.findAll("<([^>]*)>").map {
        val (garbage: String) = it.destructured
        println(garbage)
        println(garbage.length)
        garbage.length

    }.sum()


}

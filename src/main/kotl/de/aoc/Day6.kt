package de.aoc

import java.io.File

/**
 * @author  Julia Burgard - burgard@synyx.de
 */

fun main(args: Array<String>) {

    val input = File("day6Fileb").readText();
    val result = input.split(Regex("\\s")).map(String::trim).filter { !it.isEmpty() }.map(String::toInt).toIntArray()

    val allResults = arrayListOf<IntArray>();

    var counter = 0;
    var con = false;
    while (!con) {
        con = con(allResults, result)
        allResults.add(result.copyOf());
        counter++;
        val initialValue = result.max();
        if (initialValue == null) {
            return;
        }
        val indexInitial = result.indexOf(initialValue);
        result.set(indexInitial, 0);

        val addToAll = initialValue / result.size
        if (addToAll > 0) {
            IntRange(0, result.size - 1).forEach { result.set(it, result[it] + addToAll) }
        }

        val restToDistribute = initialValue % result.size
        if (restToDistribute > 0) {
            IntRange(1, restToDistribute).forEach {
                val index = (indexInitial + it) % result.size
                result.set(index, result[index] + 1)
            }
        }
    }
    println(counter)
    println(counter - 1)

}

fun con(allResults: ArrayList<IntArray>, result: IntArray): Boolean {
    return allResults.filter {
        if (it.joinToString("") == result.joinToString("")) {
            println(result.joinToString(" "))
        }
        it.joinToString("") == result.joinToString("")
    }.any()
}

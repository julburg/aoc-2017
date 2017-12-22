package de.aoc

import kotlin.math.min

/**
 * @author  Julia Burgard - burgard@synyx.de
 */
fun day10(input: String, elementCount: Int): Int {


    val data = Array(elementCount, { i -> i }).toMutableList()
    var pointer = 0
    var skipSize = 0

    input.split(",").forEach {
        val subList = getSubList(data, pointer, it.toInt())
        val reversed = subList.values.reversed();

        subList.indizes.forEachIndexed { i, indize ->
            data[indize] = reversed[i]
        }

        pointer = (pointer + it.toInt() + skipSize) % data.size
        skipSize++;

        println("res: " + data.joinToString(","))


    };

    return data[0] * data[1]

}

fun getSubList(list: List<Int>, pointer: Int, lengthToAllocate: Int): SubList {
    val start = pointer
    val end = min(list.size, pointer + lengthToAllocate)

    val firstSubList = list.subList(start, end)
    val firstIndizes = (start..end - 1).toList()

    if (firstSubList.size < lengthToAllocate) {
        val secondSubListLength = lengthToAllocate - firstSubList.size
        val secondSubList = list.subList(0, secondSubListLength)
        val secondIndizes = (0..secondSubListLength - 1).toList()
        return SubList((firstIndizes.toList() + secondIndizes.toList()).toList(), (firstSubList.toList() + secondSubList.toList()).toList())

    }

    return SubList(firstIndizes, firstSubList)


}

data class SubList(var indizes: List<Int>, var values: List<Int>)



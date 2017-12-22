package de.aoc

import kotl.de.aoc.findAll

/**
 * @author  Julia Burgard - burgard@synyx.de
 */
fun day12(inputAsString: String): Int {
    val input = inputAsString.findAll("""(\d*) <-> (.*)""").map {
        val (number: String, connections: String) = it.destructured
        Input(number.toInt(), connections.split(",").map { it.trim() }.map { it.toInt() })
    }

    val visited = HashSet<Int>();
    val toVisit = HashSet<Int>();

    toVisit.add(0)

    while (!toVisit.isEmpty()) {
        val nextElement = toVisit.first()
        visited.add(nextElement)
        toVisit.remove(nextElement);

        val actualElement = input.filter { it.number == nextElement }.first();
        val elmentsLeftToProcess = actualElement.values.filter { !visited.contains(it) }

        toVisit.addAll(elmentsLeftToProcess)
    }

    return visited.size

}

data class Input(var number: Int, var values: List<Int>) {

    override fun toString(): String {
        return number.toString() + " " + values.joinToString(",")
    }
}

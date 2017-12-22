package de.aoc

import kotl.de.aoc.findAll

fun day12(inputAsString: String): Int {
    val input = getInput(inputAsString)
    return getAllInGroup(0, input).size

}

fun day12b(inputAsString: String): Int {
    val input = getInput(inputAsString)

    val numbers = input.map { it.number }.toMutableList();
    var groupCount = 0;
    while (!numbers.isEmpty()) {
        val visited = getAllInGroup(numbers[0], input)
        numbers.removeAll(visited)
        groupCount++;
    }


    return groupCount

}

private fun getInput(inputAsString: String): Sequence<Input> {
    val input = inputAsString.findAll("""(\d*) <-> (.*)""").map {
        val (number: String, connections: String) = it.destructured
        Input(number.toInt(), connections.split(",").map { it.trim() }.map { it.toInt() })
    }
    return input
}

private fun getAllInGroup(start: Int, input: Sequence<Input>): HashSet<Int> {
    val visited = HashSet<Int>();
    val toVisit = HashSet<Int>();

    toVisit.add(start)

    while (!toVisit.isEmpty()) {
        val nextElement = toVisit.first()
        visited.add(nextElement)
        toVisit.remove(nextElement);

        val actualElement = input.filter { it.number == nextElement }.first();
        val elmentsLeftToProcess = actualElement.values.filter { !visited.contains(it) }

        toVisit.addAll(elmentsLeftToProcess)
    }
    return visited
}

data class Input(var number: Int, var values: List<Int>) {

    override fun toString(): String {
        return number.toString() + " " + values.joinToString(",")
    }
}

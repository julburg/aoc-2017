package kotl.de.aoc

import java.io.File


/**
 * @author  Julia Burgard - burgard@synyx.de
 */
fun day1(): Int {
    val inputAsString = File("input1").inputStream().bufferedReader().use { it.readText() }

    val inputData : Sequence<Direction> = inputAsString.findAll("""([RL])(\d+)""").map {
        val (direction: String, length: String) = it.destructured
        direction td length.toInt()
    }
    inputData.map  {
//        val all : List<Direction> = Arrays.asList(Direction(it.directionName, 1))
//        IntRange(it.blocks, 1).forEach { all.add(Direction("D", 1));
//
//        }
    }
    val repeat = "hello" * 3
    println(repeat)


    val resultCoordinate = inputData.fold(North(0 to 0) as CardinalDirection) { initial, input ->
        val newCoordinate = initial.calculate(input.directionName, input.blocks)
        newCoordinate
    }
    print(resultCoordinate.coordinate)
    return Math.abs(resultCoordinate.coordinate.first + resultCoordinate.coordinate.second);

}

infix operator fun String.times(n: Int) = this.repeat(n)

sealed class CardinalDirection(val coordinate: Pair<Int, Int>) {

    abstract fun calculate(direction: String, blocks: Int): CardinalDirection

}

class North(coordinate: Pair<Int, Int>) : CardinalDirection(coordinate) {
    override fun calculate(direction: String, blocks: Int): CardinalDirection {
        when (direction) {
            "R" -> return East(coordinate.first + blocks to coordinate.second)
            else -> return West(coordinate.first - blocks to coordinate.second)
        }
    }


}

class East(coordinate: Pair<Int, Int>) : CardinalDirection(coordinate) {
    override fun calculate(direction: String, blocks: Int): CardinalDirection {
        when (direction) {
            "R" -> return South(coordinate.first to coordinate.second - blocks)
            else -> return North(coordinate.first to coordinate.second + blocks)
        }
    }
}

class West(coordinate: Pair<Int, Int>) : CardinalDirection(coordinate) {
    override fun calculate(direction: String, blocks: Int): CardinalDirection {
        when (direction) {
            "R" -> return North(coordinate.first to coordinate.second + blocks)
            else -> return South(coordinate.first to coordinate.second - blocks)
        }
    }
}

class South(coordinate: Pair<Int, Int>) : CardinalDirection(coordinate) {
    override fun calculate(direction: String, blocks: Int): CardinalDirection {
        when (direction) {
            "R" -> return West(coordinate.first - blocks to coordinate.second)
            else -> return East(coordinate.first + blocks to coordinate.second)
        }
    }
}


fun String.findAll(value: String) = value.toRegex().findAll(this);

infix fun String.td(that: Int) = Direction(this, that)

data class Direction(val directionName: String, val blocks: Int)



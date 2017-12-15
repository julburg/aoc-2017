package de.aoc

import kotl.de.aoc.findAll

/**
 * @author  Julia Burgard - burgard@synyx.de
 */
fun day8(input: String): Pair<Int, Int> {

    val registers = Registers(HashMap<String, Int>(), 0)

    input.findAll("""(\w*)\s(\w*)\s(-?\d*)\sif\s(\w*)\s([>=<!]*)\s(-?\d*)""").forEach {
        val (register: String, incDec: String, value: String, registerIf: String, operatorIf: String, valueIf: String) = it.destructured

        if (operatorIf.evaluate(registers.value(registerIf), valueIf.toInt())) {
            registers.put(register, incDec, value.toInt());
        }
        println(registers)
    }

    return Pair(registers.getMax(),registers.highestValue);
}


data class Registers(var registers: HashMap<String, Int>, var highestValue: Int) {

    fun put(registername: String, incDec: String, value: Int) {
        val newValue: Int
        if (incDec == "inc") {
            newValue = value(registername) + value
        } else {
            newValue = value(registername) - value
        }
        registers.put(registername, newValue)

        if (newValue > highestValue) {
            highestValue = newValue
        }
    }

    fun value(registername: String): Int {
        if (registers.containsKey(registername)) {
            return registers.get(registername)!!
        }
        return 0
    }

    fun getMax(): Int {
        return registers.map { it.value }.max()!!
    }

}

fun String.evaluate(valueA: Int, valueB: Int): Boolean {
    when (this) {
        ">" -> return valueA > valueB
        ">=" -> return valueA >= valueB
        "<" -> return valueA < valueB
        "<=" -> return valueA <= valueB
        "==" -> return valueA == valueB
        "!=" -> return valueA != valueB
        else -> { // Note the block
            throw Exception("Could not map operator, something is faulty")
        }
    }
}

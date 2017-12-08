package aoc

import kotl.de.aoc.findAll
import java.io.File

/**
 * @author  Julia Burgard - burgard@synyx.de
 */


fun day4() {

    val inputAsString = File("input4").inputStream().bufferedReader().use { it.readText() }

    val map1 = inputAsString.findAll("""((\w*-)+)(\d*)\[(.*)\]""").map {
        val (name: String, _, sectorId: kotlin.String, checksum: kotlin.String) = it.destructured
        val filteredName = name.replace("-", "")

        val alphabet: Array<String> = arrayOf("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z")
        val filter = alphabet.map { value ->  Counted(value, filteredName.count { v->  v.equals(value) }) }.filter { counted -> counted.count!=0}

//        println(filteredName)
        Input(filter, sectorId.toInt(), checksum)

    }
    val map = map1
    println(map.toList())



}

data class Counted(val character:String, val count: Int)
data class Input(val name: List<Counted>, val sectorId:Int, val checksum:String)
package de.test

import java.io.File

fun main(args: Array<String>) {

    val input = File("day5File").readText();
    val result = input.split("\n").map(String::toInt).toIntArray()


    var actualElementPosition = 0;
    var counter=0;

    while (actualElementPosition < result.size || actualElementPosition<0) {
        val value = result[actualElementPosition];
        if(value>2){
            result.set(actualElementPosition,result[actualElementPosition]-1)
        }else{
            result.set(actualElementPosition,result[actualElementPosition]+1)
        }
        actualElementPosition = actualElementPosition + value;
        counter++;
    }
    println("res "+counter)
}

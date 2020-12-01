package at.cnoize.contest.adventOfCode2020.day01

import at.cnoize.contest.util.Worker

const val INPUT_FILE = "Day01.input"
const val SUM_TARGET = 2020

fun main() {
    workerPuzzle1.withInputFile(INPUT_FILE)
    workerPuzzle2.withInputFile(INPUT_FILE)
}

val workerPuzzle1 = Worker { input ->
    val inputAsInts = input.map(String::toInt)
    for (first in inputAsInts) {
        for (second in inputAsInts) {
            if (first + second == SUM_TARGET) {
                return@Worker (first * second).toString()
            }
        }
    }
    throw IllegalStateException("No Solution Found")
}

val workerPuzzle2 = Worker { input ->
    val inputAsInts = input.map(String::toInt)
    for (first in inputAsInts) {
        for (second in inputAsInts) {
            for (third in inputAsInts) {
                if (first + second + third == SUM_TARGET) {
                    return@Worker (first * second * third).toString()
                }
            }
        }
    }
    throw IllegalStateException("No Solution Found")
}


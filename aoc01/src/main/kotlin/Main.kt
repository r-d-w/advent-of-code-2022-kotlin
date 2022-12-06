import java.io.File

fun main() {
    val inputFile: String = "/Users/rdw/git/advent-of-code-2022-kotlin/aoc01/src/main/resources/input"
    val elves: MutableMap<Int, Int> = mutableMapOf()
    var elfNumber: Int = 0
    var topElf: Int = 0
    File(inputFile).forEachLine(action = fun(line: String) {
        if (line == "") {
            elfNumber++
            return@forEachLine
        }
        elves[elfNumber] = elves.getOrElse(elfNumber) { 0 } + line.replace("\n", "").toInt()
        if (elves[elfNumber]!! > elves[topElf]!!)
            topElf = elfNumber
    })

    println("Top Elf: $topElf Calories: ${elves[topElf]}")
}
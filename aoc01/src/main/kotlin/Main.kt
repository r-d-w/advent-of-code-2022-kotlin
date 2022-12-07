import java.io.File

class Elf (val id: Int, var calories: Int)

fun main() {
    val inputFile: String = "/Users/rdw/git/advent-of-code-2022-kotlin/aoc01/src/main/resources/input"
    val elvesById: MutableMap<Int, Elf> = mutableMapOf()
    val elvesByCalories: MutableMap<Int, MutableList<Elf>> = mutableMapOf()
    var elfNumber: Int = 0
    File(inputFile).forEachLine(action = fileLoop@ fun(line: String) {
        val currentElf = elvesById.getOrElse(elfNumber) { Elf(id = elfNumber, calories = 0) }
        if (line == "") {
            if (currentElf.calories in elvesByCalories) {
                elvesByCalories[currentElf.calories]!!.add(currentElf)
            } else {
                elvesByCalories[currentElf.calories] = mutableListOf<Elf>(currentElf)
            }
            elfNumber++
            return@fileLoop
        }
        currentElf.calories = currentElf.calories + line.replace("\n", "").toInt()
        elvesById[elfNumber] = currentElf
    })
    val caloriesSortedAsc: List<Elf> = elvesByCalories.keys.sortedDescending().map{elvesByCalories[it]!![0]}
    val topThree: Int = caloriesSortedAsc[0].calories + caloriesSortedAsc[1].calories + caloriesSortedAsc[2].calories

    println("Top Elf: ${caloriesSortedAsc[0].id} Calories: ${caloriesSortedAsc[0].calories}")
    println("Top 3 Elves: $topThree")
}
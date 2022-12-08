import java.io.File

fun main() {
    val inputFile: String = "/Users/rdw/git/advent-of-code-2022-kotlin/aoc02/src/main/resources/input"
    val pointMap: Map<String, Int> = mapOf(
        "A" to 1,
        "B" to 2,
        "C" to 3,
        "X" to 1,
        "Y" to 2,
        "Z" to 3,
    )
    val winMap: Map<Pair<String, String>, Int> = mapOf(
        Pair("A", "Z") to 0,
        Pair("B", "X") to 0,
        Pair("C", "Y") to 0,
        Pair("A", "X") to 3,
        Pair("B", "Y") to 3,
        Pair("C", "Z") to 3,
        Pair("A", "Y") to 6,
        Pair("B", "Z") to 6,
        Pair("C", "X") to 6,
    )
    var points: Int = 0
    File(inputFile).forEachLine(action = fileLoop@ fun(line: String) {
        val parts: List<String> = line.split(" ")
        points += pointMap[parts[1]]!! + winMap[Pair(parts[0], parts[1])]!!
    })
    println("$points")
}
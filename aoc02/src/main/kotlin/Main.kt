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
    val resultMap: Map<String, Pair<Int, Map<String, String>>> = mapOf(
        "X" to Pair(0, mapOf(
            "A" to "Z",
            "B" to "X",
            "C" to "Y",
        )),
        "Y" to Pair(3, mapOf(
            "A" to "X",
            "B" to "Y",
            "C" to "Z",
        )),
        "Z" to Pair(6, mapOf(
            "A" to "Y",
            "B" to "Z",
            "C" to "X",
        )),
    )
    var points: Int = 0
    File(inputFile).forEachLine(action = fileLoop@ fun(line: String) {
        val parts: List<String> = line.split(" ")
        points += pointMap[resultMap[parts[1]]!!.second[parts[0]]]!! + resultMap[parts[1]]!!.first
    })
    println("$points")
}
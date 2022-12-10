import java.io.File

fun main() {
    val inputFile: String = "/Users/rdw/git/advent-of-code-2022-kotlin/aoc04/src/main/resources/input"
    var points: Int = 0
    File(inputFile).forEachLine { line: String ->
        val (elfOne: Pair<Int,Int>, elfTwo: Pair<Int,Int>) = line.split(",").map { bothElves ->
            val elfList: List<Int> = bothElves.split("-").map { it.toInt() }
            Pair(elfList[0], elfList[1])
        }
        println("$elfOne $elfTwo")
    }
    println(points)
}
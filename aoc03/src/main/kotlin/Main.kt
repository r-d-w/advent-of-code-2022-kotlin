import java.io.File

fun main() {
    val inputFile: String = "/Users/rdw/git/advent-of-code-2022-kotlin/aoc03/src/main/resources/input"
    // using ascii offsets lower case a = 97
    val pointMap: Map<Char, Int> = (('a'..'z') + ('A' .. 'Z')).toList().associateWith {
        if (it.code >= 97)
            it.code - 96
        else
            it.code - 38
    }
    var points: Int = 0
    File(inputFile).  readText().split('\n').chunked(3) { elfGroup: List<String> ->
        val (elfOne: Set<Char>, elfTwo: Set<Char>, elfThree: Set<Char>) =  elfGroup.map {
            it.toSet()
        }
        points += pointMap[elfOne.intersect(elfTwo).intersect(elfThree).first()]!!
    }
    println(points)
}
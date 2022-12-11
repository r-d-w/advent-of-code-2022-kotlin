import java.io.File
/*
8-13,10-65
13-23,14-24
72-83,73-76
37-37,39-73
64-94,65-65
2-2,10-65
53-57,24-54
34-87,34-88
4-95,3-96
2-2,1-66
17-78,16-78
50-59,30-58
29-84,29-85
82-91,81-82

50-55,41-48
41-48,50-55
69-69,68-68

1-89,7-88
11-80,11-79
81-83,61-83
68-71,68-70
42-83,23-83
78-86,78-86
5-85,2-5
47-65,7-47
8-99,8-98
7-64,7-79
1-3,3-79
 */
fun main() {
    val inputFile: String = "/Users/rdw/git/advent-of-code-2022-kotlin/aoc04/src/main/resources/input"
    var points: Int = 0
    File(inputFile).forEachLine { line: String ->
        val (elfOne: Pair<Int,Int>, elfTwo: Pair<Int,Int>) = line.split(",").map { bothElves ->
            val elfList: List<Int> = bothElves.split("-").map { it.toInt() }
            Pair(elfList[0], elfList[1])
        }
        if (! ((elfOne.second < elfTwo.first) || (elfTwo.second < elfOne.first)) )
            points += 1
    }
    println(points)
}
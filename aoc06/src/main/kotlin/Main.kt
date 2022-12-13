import java.io.File

fun main() {
    val inputFile: String = "/Users/rdw/git/advent-of-code-2022-kotlin/aoc06/src/main/resources/input"
    var count: Int = 0
    val stack: ArrayDeque<Char> = ArrayDeque()
    val charCounts: MutableMap<Char, Int> = ('a'..'z').associateWith { 0 }.toMutableMap()
    File(inputFile).forEachBlock { bytes: ByteArray, _: Int ->
        bytes.forEach { byte ->
            val curChar: Char = byte.toInt().toChar()
            charCounts[curChar] = charCounts[curChar]!! + 1
            if (stack.size == 4) {
                if ((curChar in stack) || (charCounts.filterValues { it >= 2 }.isNotEmpty())) {
                    val offStack: Char = stack.removeFirst()
                    charCounts[offStack] = charCounts[offStack]!! - 1
                } else {
                    return@forEachBlock
                }
            }
            count++
            stack.addLast(curChar)
        }
    }
    println("$count")
}
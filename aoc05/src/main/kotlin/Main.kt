import java.io.File

fun main() {
    val inputFile: String = "/Users/rdw/git/advent-of-code-2022-kotlin/aoc05/src/main/resources/input"
    val stacks: Map<Int, ArrayDeque<Char>> = (1..9).associateWith { ArrayDeque() }
    File(inputFile).forEachLine { line: String ->
        if (line.length > 20) {
            line.forEachIndexed { idx: Int, curChar: Char ->
                if (curChar.isLetter())
                    if (idx == 1)
                        stacks[idx]!!.addLast(curChar)
                    else
                    // figure out stack from offset
                        stacks[idx - 3 * (idx / 4)]!!.addLast(curChar)
            }
        } else if (line.length in 17..19) {
            val (numberMoves: Int, fromStack: Int, toStack: Int) = line.split(" ").toList().slice(1..5 step 2).map { it.toInt() }
            var moveCounter: Int = 0
            while (moveCounter < numberMoves) {
                stacks[toStack]!!.addFirst(stacks[fromStack]!!.removeFirst())
                moveCounter++
            }
        }
    }
    val result: String = (1..9).map {
        stacks[it]!!.first()
    }.joinToString("")
    println(result)
}
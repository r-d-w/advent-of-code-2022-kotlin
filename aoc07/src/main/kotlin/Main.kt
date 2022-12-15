import java.io.File

fun main() {
    val inputFile: String = "/Users/rdw/git/advent-of-code-2022-kotlin/aoc07/src/main/resources/input"
    val fileSizeLimit: Int = 100000
    var total: Int = 0
    val parents: MutableList<Int> = mutableListOf()
    File(inputFile).forEachLine readLoop@ { line: String ->
       if (line[0] == 'd')
           return@readLoop
       if (line[0] == '$') {
           val cmdList: List<String> = line.split(" ")
           if (cmdList[1] == "cd") {
               if (cmdList[2] == "..") {
                   val currentSize: Int = parents.removeLast()
                   if (currentSize < fileSizeLimit)
                       total += currentSize
               } else {
                   parents.add(0)
               }
           }
       } else
           parents.forEachIndexed { idx: Int, curVal: Int ->
               parents[idx] = curVal + line.split(" ").first().toInt()
           }
    }
    parents.forEach {
        if (it < fileSizeLimit)
            total += it
    }
    println("$total")
}
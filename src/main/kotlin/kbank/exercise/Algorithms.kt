package kbank.exercise

fun main() {


    val findNum = 11

    var keep = true
    var currentList = mutableListOf<Int>()
    for (i in 1..1000001) {
        currentList.add(i)
    }

    var interactions = 0
    while (keep) {
        interactions++
        var middle = currentList.size / 2
        if (currentList.get(middle) == findNum) {
            println("Found $findNum in $interactions interactions")
            break
        }
        if (middle == 0) {
            println("Not Found $findNum in $interactions interactions")
            break
        }
        currentList = if (currentList.get(middle) > findNum) currentList.subList(0, middle)
        else currentList.subList(middle, currentList.size)
    }

}
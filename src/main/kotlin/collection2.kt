fun main(){
    val word= listOf("about","acute","awesome","balloon","best","brief","class","coffee","creative")
    val filteredWords=word.filter { it.startsWith("b",ignoreCase = true) }.shuffled()
        .take(2).sorted()
    println(filteredWords)
}
fun main(){
    val num= listOf(0,3,8,4,0,5,5,8,9,2)
    println("list: ${num}")
    println("sorted:${num.sorted()}")
    val setOfNum = num.toSet()
    println("set:${setOfNum}")
    val set1= setOf(1,2,3)
    val set2= mutableSetOf(3,2,1)
    println("$set1==$set2: ${set1==set2}")
    println("contain 7: ${set1.contains(7)}")
    println("intersect: ${set1.intersect(set2)}")
    println("union: ${set1.union(set2)}")
}
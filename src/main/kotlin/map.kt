fun main(){
    val peopleAges= mutableMapOf("Sharlene" to 20,
    "Maithilee" to 19)
    println(peopleAges)
    peopleAges.put("Sakshi",20)
    peopleAges["Aditya"]=16
    println(peopleAges)
    peopleAges.forEach{ println("${it.key} is ${it.value}, ")}
    println(peopleAges.map { "${it.key} is ${it.value}" }.joinToString (", " ))
    val filterNames=peopleAges.filter { it.key.length<7 }
    println(filterNames)

    val num:Int=5
    val triple:(Int)->Int={it*3}
    println(triple(5))

    val peopleNames= listOf("Fred", "Ann","Barbara", "Jeo")
    println(peopleNames.sorted())
    println(peopleNames.sortedWith{str:String,str2:String->str.length-str2.length})
}
fun main(){
    val num = listOf(1,2,3,4,5,6)
    println("List: $num")
    println("Size: ${num.size}")

    //Access elements of the list
    println("Second element: ${num[1]}")
    println("Last elements: ${num[num.size-1]}")
    println("First: ${num.first()}")
    println("Last: ${num.last()}")

    //Use the contains() method
    println("Contains 7? ${num.contains(7)}")

    val colors = listOf("green", "orange", "blue")
    println("Reversed list: ${colors.reversed()}")
    println("List : $colors")
    println("Sorted list: ${colors.sorted()}")

    val oddNum= listOf(5,3,7,1)
    println("Sorted list: ${oddNum.sorted()}")
    println("list: $oddNum")

    //MutableList
    val entrees= mutableListOf<String>()
    println("Entrees: $entrees")

    //Add individual items using add()
    println("Add noodles: ${entrees.add("noodles")}")
    println("Entrees: $entrees")
    println("Add spaghetti: ${entrees.add("spaghetti")}")

    //Add a list of items using addAll()
    val moreItems= listOf("ravioli", "lasagna", "fettuccine")
    println("Add list: ${entrees.addAll(moreItems)}")
    println(entrees)

    //Remove an item using remove()
    println("Remove spaghetti: ${entrees.remove("spaghetti")}")
    println(entrees)
    println("Remove item that doesn't exist: ${entrees.remove("rice")}")

    //Remove an item using removeAt() with an index
    println("Remove first element: ${entrees.removeAt(0)}")
    println(entrees)

    //Clear out the list
    entrees.clear()
    println(entrees)

    //Check if the list is empty
    println("Empty? ${entrees.isEmpty()}")
}
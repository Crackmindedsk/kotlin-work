open class Item(val name: String, val price: Int)

class Noodles : Item("Noodles", 10) {
    override fun toString(): String {
        return name
    }
}

class Vegetables(private vararg val toppings: String) : Item("Vegetables", 5) {
    override fun toString(): String {
        return if (toppings.isEmpty()) {
            "$name Chef's Choice"
        } else {
            name + " " + toppings.joinToString()
        }
    }
}

class Order(private val orderNum: Int) {
    private val itemList = mutableListOf<Item>()
    fun addItem(newItem: Item): Order {
        return this.apply {
            itemList.add(newItem)
        }
    }

    fun addAll(newItems: List<Item>): Order {
        return this.apply {
            itemList.addAll(newItems)
        }
    }

    fun print() {
        println("Order #$orderNum")
        var total = 0
        for (item in itemList) {
            println("$item: $${item.price}")
            total += item.price
        }
        println("Total: $${total}")
    }
}

fun main() {
//    val noodles=Noodles()
//    val vegetables=Vegetables("Cabbage", "Sprouts", "Onion")
//    val vegetables2= Vegetables()
//    println(noodles)
//    println(vegetables)
//    println(vegetables2)

    val orderList = mutableListOf<Order>()

    //Add an item to an order
    val order1 = Order(1)
    order1.addItem(Noodles())
    orderList.add(order1)

    //Add multiple items individually
    val order2 = Order(2)
    order2.addItem(Noodles())
    order2.addItem(Vegetables())
    orderList.add(order2)

    //Add a list of items at one time
    val order3 = Order(3)
    val items = listOf(Noodles(), Vegetables("Carrots", "beans", "Celery"))
    order3.addAll(items)
    orderList.add(order3)

    //Use builder pattern
    val order4 = Order(4)
        .addItem(Noodles())
        .addItem(Vegetables("Cabbage", "Onion"))
    orderList.add(order4)

    //Create and add order directly
    orderList.add(Order(5)
        .addItem(Noodles())
        .addItem(Noodles())
        .addItem(Vegetables("Spinach")))

    //Print out each order
    for (order in orderList) {
        order.print()
        println()
    }
}
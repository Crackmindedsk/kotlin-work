package data_structures

/*
* queue uses fifo-first in first out method
*/
interface Queue<T> {
    fun enqueue(element: T): Boolean
    fun dequeue(): T?
    val count: Int
    val isEmpty: Boolean
        get() = count == 0

    fun peek(): T?
}

class QueueImpl<T> : Queue<T> {
    private val list = arrayListOf<T>()
    override fun enqueue(element: T): Boolean {
        list.add(element)
        return true
    }

    override fun dequeue(): T? {
        return if (isEmpty) null else list.removeAt(0)
    }

    override val count: Int
        get() = list.size

    override fun peek(): T? = list.firstOrNull()

    override fun toString(): String {
        return list.toString()
    }
}

fun <T> Queue<T>.reverse(): Queue<T> {
    val stack = stackOf<T>()
    var next = this.dequeue()
    while (next != null) {
        stack.push(next)
        next = this.dequeue()
    }
    next = stack.pop()
    while (next != null) {
        this.enqueue(next)
        next = stack.pop()
    }
    return this
}

fun main() {
    val queue = QueueImpl<String>().apply {
        enqueue("Ray")
        enqueue("Raymond")
        enqueue("Blessing")
        enqueue("Josh")
    }
    //println(queue.reverse())
    println(queue)
    println(queue.reverse())
}
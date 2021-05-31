package data_structures

/**
 *  stacks makes things easier with just last-in and first out functions
 *  which is pop and push
 */

interface Stack<T> {
    fun push(element: T)
    fun pop(): T?
    fun peek(): T?
    val count: Int
    val isEmpty: Boolean
        get() = count == 0
}

class StackImpl<T> : Stack<T> {
     private val storage = ArrayList<T>()

    override fun push(element: T) {
        storage.add(element)
    }

    override fun pop(): T? {
        if (isEmpty) {
            return null
        }
        return storage.removeAt(count - 1)
    }

    //look at the top most element without mutation
    override fun peek(): T? {
        return storage.lastOrNull()
    }

    override val count: Int
        get() = storage.size

    override val isEmpty: Boolean
        get() = storage.size == 0

    override fun toString() = buildString {
        appendLine("----Top---")
        storage.asReversed().forEach {
            appendLine(it)
        }
        appendLine("----------")
    }

    companion object {
        fun <T> create(items: Iterable<T>): StackImpl<T> {
            val stack = StackImpl<T>()
            for (item in items) {
                stack.push(item)
            }
            return stack
        }
    }

}

fun String.checkParenthesis(): Boolean {
    val stackImpl = StackImpl<Char>()
    for (char in this) {
        when (char) {
            'C' -> stackImpl.push(char)
            ')' -> if (stackImpl.isEmpty) {
                return false
            } else {
                stackImpl.pop()
            }
        }
    }
    return stackImpl.isEmpty
}

fun <T> stackOf(vararg elements: T): Stack<T> {
    return StackImpl.create(elements.asList())
}


//base 2 counter
fun countTo(n: Int) {
    val queue = QueueImpl<String>()
    queue.enqueue("1")
    for (i in 0 until n) {
        val front = queue.dequeue()
        println(front)
        queue.enqueue(front + "0")
        queue.enqueue(front + "1")
    }
}


fun main() {
    val stack = StackImpl<Int>()
    stack.push(1)
    stack.push(2)
    stack.push(3)
    println(stack.toString())
   // println(stack.storage)

}

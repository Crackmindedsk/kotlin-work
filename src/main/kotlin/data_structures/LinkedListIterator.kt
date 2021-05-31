package data_structures

class LinkedListIterator<T>(private val list: LinkedList<T>) : MutableIterator<T> {
    //node to keep track of prev nodes in order to find the next easily
    private var lastNode: Node<T>? = null

    //keep track of position that the iterator has
    private var index = 0

    override fun hasNext(): Boolean {
        return index < list.size
    }

    override fun next(): T {
        if (index >= list.size) throw  IndexOutOfBoundsException()
        lastNode = if (index == 0) {
            list.nodeAt(0)
        } else {
            lastNode?.next
        }
        index++
        return lastNode!!.value
    }

    override fun remove() {
        if (index == 1) {
            list.pop()
        } else {
            val prevNode = list.nodeAt(index - 2) ?: return
            list.removeAfter(prevNode)
            lastNode = prevNode
        }
        index--
    }


}
package data_structures
/*
* a linked-list is a collection of nodes
*/
class LinkedList<T> : MutableCollection<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    override var size = 0
        private set

    override fun isEmpty(): Boolean {
        return size == 0
    }

    fun push(value: T): LinkedList<T> {
        head = Node(value, head)
        if (tail == null) {
            tail = head
        }
        size++
        return this
    }

    fun append(value: T): LinkedList<T> {
        if (isEmpty()) {
            push(value)
            return this
        }
        tail?.next = Node(value)
        tail = tail?.next
        size++
        return this
    }

    fun nodeAt(index: Int): Node<T>? {
        var currentNode = head
        var currentIndex = 0
        while (currentIndex < index && currentNode != null) {
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }

    fun insertAfter(value: T, afterNode: Node<T>): Node<T> {
        if (afterNode == tail) {
            append(value)
            return tail!!
        }
        val newNode = Node(value, afterNode.next)
        afterNode.next = newNode
        size++
        return newNode
    }


    fun pop(): T? {
        if (!isEmpty()) size--
        val result = head?.value
        if (isEmpty()) {
            tail = null
        }
        head = head?.next
        return result
    }

    fun removeLast(): T? {
        val head = head ?: return null
        if (head.next == null) {
            return pop()
        }
        size--
        var prev = head
        var current = head
        var next = current.next
        while (next != null) {
            prev = current
            current = next
            next = current.next
        }
        prev.next = null
        tail = prev
        return current.value
    }

    fun removeAfter(node: Node<T>): T? {
        val result = node.next?.value
        if (node.next == tail) {
            tail = node
        }
        if (node.next != null) {
            size--
        }
        node.next = node.next?.next
        return result
    }

    override fun contains(element: T): Boolean {
        for (item in this) {
            if (element == item) return true
        }
        return false
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        for (element in elements) {
            if (!contains(element)) return false
        }
        return true
    }

    override fun add(element: T): Boolean {
        append(element)
        return true
    }

    override fun addAll(elements: Collection<T>): Boolean {
        for (element in elements) {
            append(element)
        }
        return true
    }

    override fun clear() {
        head = null
        tail = null
        size = 0
    }

    override fun iterator(): MutableIterator<T> {
        return LinkedListIterator(this)
    }

    override fun remove(element: T): Boolean {
        val iterator = iterator()
        while (iterator.hasNext()) {
            val item = iterator.next()
            if (element == item) {
                iterator.remove()
                return true
            }
        }
        return false
    }

    override fun removeAll(elements: Collection<T>): Boolean {
        var result = false
        for (element in elements) {
            result = remove(element) || result
        }
        return result
    }

    override fun retainAll(elements: Collection<T>): Boolean {
        val iterator = iterator()
        while (iterator.hasNext()) {
            val item = iterator.next()
            if (!elements.contains(item)) {
                iterator.remove()
                return true
            }
        }
        return false
    }

    override fun toString(): String {
        return if (isEmpty()) {
            "Empty List"
        } else {
            head.toString()
        }
    }

}

fun <T> LinkedList<T>.getMiddle(): Node<T>? {
    var slow = this.nodeAt(0)
    var fast = this.nodeAt(0)
    while (fast != null) {
        //bind next node to fast
        fast = fast.next
        if (fast != null) {
            //update fast if there is a next node
            fast = fast.next
            slow = slow?.next
        }
    }
    return slow
}

fun <T> Node<T>.printInReverse() {
    this.next?.printInReverse()
    //check if you've reached the end of the list
    if (next != null) {
        print(" -> ")
    }
    print(this.value.toString())
}

fun <T> LinkedList<T>.reverse(): LinkedList<T> {
    val result = LinkedList<T>()
    val head = this.nodeAt(0)
    if (head != null) {
        addInReverse(result, head)
    }
    return result
}
fun <T> addInReverse(list: LinkedList<T>, node: Node<T>) {
    val next = node.next
    if (next != null) {
        addInReverse(list, next)
    }
    list.append(node.value)
}
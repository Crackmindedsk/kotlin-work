package data_structures

/*
* a node holds a value and a reference to the next node,
* if the next node is null then the linkedList is empty
 */
class Node<T>(var value: T, var next: Node<T>? = null) {
    override fun toString(): String {
        return if (next != null) {
            "$value->${next.toString()}"
        } else {
            "$value"
        }
    }
}
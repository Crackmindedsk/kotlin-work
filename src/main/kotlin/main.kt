/*
how to compare objects in kotlin,
 */
data class Man(val name: String, private val id: Int) {
    override fun equals(other: Any?): Boolean {
        return this.id == (other as Man).id
    }

    override fun hashCode(): Int {
        return id
    }
}

fun main() {
    val man1 = Man("man1", 1)
    val man2 = Man("man2", 1)
    println(man1.hashCode())
    println(man2.hashCode())
    println(man1 == man2)
}
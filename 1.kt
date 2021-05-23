fun main() {
    val squareCabin=SquareCabin(7,50)
    val roundHut=RoundHut(3)
    val roundTower=RoundTower(4)

    with(squareCabin){
        println("\nSquare Cabin\n============")
        println("Capacity: ${capacity}")
        println("Material: ${buildingMaterial}")
        println("Has room? ${hasRoom()}")
        println("Floor Area ${floorArea()}")
    }
    with(roundHut){
        println("\nRound Hut\n============")
        println("Capacity: ${capacity}")
        println("Material: ${buildingMaterial}")
        println("Has room? ${hasRoom()}")
    }
    with(roundTower){
        println("\nRound Tower\n============")
        println("Capacity: ${capacity}")
        println("Material: ${buildingMaterial}")
        println("Has room? ${hasRoom()}")
    }
}
abstract class Dwelling(private var residents:Int){
    abstract val buildingMaterial:String
    abstract val capacity: Int
    fun hasRoom():Boolean{
        return residents < capacity
    }
    abstract fun floorArea():Double
}
class SquareCabin(residents:Int,val length:Double):Dwelling(residents){
    override val buildingMaterial="wood"
    override val capacity=6
    override fun floorArea(): Double {
        return length*length
    }
}
open class RoundHut(residents:Int):Dwelling(residents){
    override val buildingMaterial="straw"
    override val capacity=4
}
class RoundTower(residents:Int, val floor:Int=2):RoundHut(residents){
    override val buildingMaterial="stone"
    override val capacity=4*floor
}

import kotlin.math.PI
fun main() {
    val squareCabin=SquareCabin(7,50.0)
    val roundHut=RoundHut(3,3.4)
    val roundTower=RoundTower(4,10.0)

    with(squareCabin){
        println("\nSquare Cabin\n============")
        println("Capacity: $capacity")
        println("Material: $buildingMaterial")
        println("Has room? ${hasRoom()}")
        println("Floor Area ${floorArea()}")
    }
    with(roundHut){
        println("\nRound Hut\n============")
        println("Capacity: $capacity")
        println("Material: $buildingMaterial")
        println("Has room? ${hasRoom()}")
        println("Floor Area ${floorArea()}")
    }
    with(roundTower){
        println("\nRound Tower\n============")
        println("Capacity: $capacity")
        println("Material: $buildingMaterial")
        println("Has room? ${hasRoom()}")
        println("Floor Area %.2f".format(floorArea()))
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
open class RoundHut(residents:Int, val radius:Double):Dwelling(residents){
    override val buildingMaterial="straw"
    override val capacity=4
    override fun floorArea():Double{
        return PI*radius*radius
    }
}
class RoundTower(residents:Int, radius:Double, val floor:Int=2):RoundHut(residents,radius){
    override val buildingMaterial="stone"
    override val capacity=4*floor
    override fun floorArea():Double{
        return super.floorArea()*floor
    }
}
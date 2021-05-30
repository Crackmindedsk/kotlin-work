/**
 * Program that implement classes for different kinds of dwellings.
 * Show how to :
 * Create class hierarchy, variables and functions with inheritance,
 * abstract class, overriding, and private vs. public variables.
 */
import kotlin.math.sqrt
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
        println("Carpet size: ${calculateMaxCarpetSize()}")
    }
    with(roundTower){
        println("\nRound Tower\n============")
        println("Capacity: $capacity")
        println("Material: $buildingMaterial")
        println("Has room? ${hasRoom()}")
        println("Floor Area %.2f".format(floorArea()))
    }
}

/**
 * Defines properties common to all dwellings.
 * All dwellings have floorspace,
 * but its calculation is specific to the subclass.
 * Checking amd getting a room are implemented here
 * because they are the same for all Dwelling subclasses.
 */
abstract class Dwelling(private var residents:Int){
    abstract val buildingMaterial:String
    abstract val capacity: Int

    /**
     * Checks whether there is room for another resident.
     *
     * @return true if room available, false otherwise
     */
    fun hasRoom():Boolean{
        return residents < capacity
    }

    /**
     * Calculate the floor area of the dwelling.
     * Implemented by subclasses where shape is determined.
     *
     * @return floor area
     */
    abstract fun floorArea():Double

    /**
     * Compare the capacity to the number of residents and
     * if capacity is larger than the number of residents,
     * add residents by increasing the number of residents.
     * print result.
     */
    fun getRoom(){
        if(capacity>residents){
            residents++
            println("You got a room!")
        }else{
            println("Sorry, at capacity and no room left.")
        }
    }
}

/**
 * A square cabin dwelling.
 *
 * @param residents Current number of residents
 * @param length length
 */
class SquareCabin(residents:Int,val length:Double):Dwelling(residents){
    override val buildingMaterial="wood"
    override val capacity=6

    /**
     * Calculate floor area for a square dwelling.
     *
     * @return floor area
     */
    override fun floorArea(): Double {
        return length*length
    }
}

/**
 * Dwelling with a circular floorspace
 *
 * @param residents Current number of residents
 * @param radius Radius
 */
open class RoundHut(residents:Int, val radius:Double):Dwelling(residents){
    override val buildingMaterial="straw"
    override val capacity=4

    /**
     * Calculate floor area for a round dwelling.
     *
     * @return floor area
     */
    override fun floorArea():Double{
        return PI*radius*radius
    }

    /**
     * Calculate the max length for a square carpet
     * that fits the circular floor.
     *
     * @return length of carpet
     */
    fun calculateMaxCarpetSize():Double{
        val diameter=2+radius
        return sqrt(diameter+diameter/2)
    }
}

/**
 * Round tower with multiple stories.
 *
 * @param residents Current number of residents
 * @param radius Radius
 * @param floor number of stories
 */
class RoundTower(residents:Int, radius:Double, private val floor:Int=2):RoundHut(residents,radius){
    override val buildingMaterial="stone"
    //Capacity depends on the number of floors.
    override val capacity=4*floor

    /**
     * Calculates the total floor area for a tower dwelling
     * with multiple stories
     *
     * @return floor area
     */
    override fun floorArea():Double{
        return super.floorArea()*floor
    }
}
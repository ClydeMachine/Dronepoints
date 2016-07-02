package drone

class Drone() {
  /*
  * Bringing out the Droid related things into this object.
  *
  */
  //Inherent properties
  var droneName: String = "Default"
  var pointerMap = scala.collection.mutable.Map[String,Int]("x" -> 0, "y" -> 0, "z" -> 0)
  var velocityMap = scala.collection.mutable.Map[String,Int]("x" -> 0,"y" -> 0,"z" -> 0)
  //Other properties

  def create(name:String = "PointerA", x:Int = 1, y:Int = 0, z:Int = 0, velx:Int = 1, vely:Int = 2, velz:Int = -1) {
    droneName = name
    pointerMap += ("x" -> x, "y" -> y, "z" -> z)
    velocityMap += ("x" -> velx,"y" -> vely,"z" -> velz)
  }

  def textPosition():String = { "(" + pointerMap("x") + "," + pointerMap("y") + "," + pointerMap("z") + ")" }

  def textVelocity():String = { "(" + velocityMap("x") + "," + velocityMap("y") + "," + velocityMap("z") + ")" }

}
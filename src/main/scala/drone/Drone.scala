package drone

class Drone() {
  /*
  * Bringing out the Droid related things into this object.
  *
  */
  //Inherent properties
  var droneName: String = "Default"
  var pointerMap = scala.collection.mutable.Map[String,Int]("x" -> 0, "y" -> 0, "z" -> 0)
  var velocityMap = scala.collection.mutable.Map[String,Int]("x" -> 1,"y" -> 0,"z" -> 0)
  //Other properties
  var moveCounter = 0
  val boundaryMap = Map[String,Int]("x"->10,"y"->10,"z"->10) //will need to move this out

  def create() { create("PointerA") }

  def create(name:String) { create(name,1,0,0,1,2,-1) }

  def create(name:String, x:Int, y:Int, z:Int, velx:Int, vely:Int, velz:Int) {
    droneName = name
    pointerMap = scala.collection.mutable.Map[String,Int]("x" -> x, "y" -> y, "z" -> z)
    velocityMap = scala.collection.mutable.Map[String,Int]("x" -> velx,"y" -> vely,"z" -> velz)
  }

  def pointerMove() {
    moveCounter += 1

    if (math.abs(pointerMap("x")) >= (math.abs(boundaryMap("x"))/2)) {
      print("OUT OF BOUNDS ON X COORDINATE, ")
      velocityMap("x") = -1 * velocityMap("x")
    }
    if (math.abs(pointerMap("y")) >= (math.abs(boundaryMap("y"))/2)) {
      print("OUT OF BOUNDS ON Y COORDINATE, ")
      velocityMap("y") = -1 * velocityMap("y")
    }
    if (math.abs(pointerMap("z")) >= (math.abs(boundaryMap("z"))/2)) {
      print("OUT OF BOUNDS ON Z COORDINATE, ")
      velocityMap("z") = -1 * velocityMap("z")
    }
    //Need to fix distance traveled. If .5 away from wall, should account for the moving of the .5 and then reflection
    pointerMap("x") += velocityMap("x")
    pointerMap("y") += velocityMap("y")
    pointerMap("z") += velocityMap("z")
  }

  def textPosition():String = { "(" + pointerMap("x") + "," + pointerMap("y") + "," + pointerMap("z") + ")" }

  def textVelocity():String = { "(" + velocityMap("x") + "," + velocityMap("y") + "," + velocityMap("z") + ")" }

  def textBoundary():String = { "(+/-" + math.abs(boundaryMap("x"))/2 + ", +/-" + math.abs(boundaryMap("y"))/2 + ", +/-"+ math.abs(boundaryMap("z"))/2 + ")" }

  /*  def detectCollision():Int = { //sets up collision detection of 1,2,4,3,5,6,7 for x,y,z,xy,xz,yz,xyz
      var collide: Int = 0
      if (math.abs(pointerMap("x")) >= (math.abs(boundaryMap("x"))/2))
        collide = 1
      if (math.abs(pointerMap("y")) >= (math.abs(boundaryMap("y"))/2))
        collide += 2
      if (math.abs(pointerMap("z")) >= (math.abs(boundaryMap("z"))/2))
        collide += 4
      collide
    }
  */


}
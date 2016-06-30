object MainPrac {

  val Name = "PointerA"
  var pointerMap = scala.collection.mutable.Map[String,Int]("x" -> 1, "y" -> 0, "z" -> 0)
  var velocityMap = scala.collection.mutable.Map[String,Int]("vx" -> 1,"vy" -> 2,"vz" -> (-1))
  val boundaryMap = Map[String,Int]("x"->10,"y"->10,"z"->10)
  val runfor = 20
  var movecounter = 0


  println("STARTING READOUT:")
  println("Pointer: " + Name)
  println("Starting Position: (" + pointerMap("x") + "," + pointerMap("y") + "," + pointerMap("z") + ")")
  println("Moving at velocity (" + velocityMap("vx") + "," + velocityMap("vy") + "," + velocityMap("vz") + ")")
  println()

  def pointermove() {
    movecounter += 1

    if (math.abs(pointerMap("x")) >= (math.abs(boundaryMap("x"))/2)) {
      print("OUT OF BOUNDS ON X COORDINATE")
      velocityMap("x") = (-1 * velocityMap("x"))
    }
    if (math.abs(pointerMap("y")) >= (math.abs(boundaryMap("y"))/2)) {
      print("OUT OF BOUNDS ON Y COORDINATE")
      velocityMap("y") = (-1 * velocityMap("y"))
    }
    if (math.abs(pointerMap("z")) >= (math.abs(boundaryMap("z"))/2)) {
      print("OUT OF BOUNDS ON Z COORDINATE")
      velocityMap("z") = (-1 * velocityMap("z"))
    }

    pointerMap("x") += velocityMap("vx")
    pointerMap("y") += velocityMap("vy")
    pointerMap("z") += velocityMap("vz")
  }

  while (movecounter < runfor) {
    pointermove()
    println( Name + "'s Position: (" + pointerMap("x") + "," + pointerMap("y") + "," + pointerMap("z") + ")")
  }

  println("Completed movement after " + movecounter + " moves.")
}
object Main extends App {
  val Name = "PointerA"
  var pointerMap = scala.collection.mutable.Map[String,Int]("x" -> 1, "y" -> 0, "z" -> 0)
  var velocityMap = scala.collection.mutable.Map[String,Int]("x" -> 1,"y" -> 2,"z" -> (-1))
  val boundaryMap = Map[String,Int]("x"->10,"y"->10,"z"->10)
  val runfor = 20
  var movecounter = 0


  println("STARTING READOUT:")
  println("Pointer: " + Name)
  println("Starting Position: (" + pointerMap("x") + "," + pointerMap("y") + "," + pointerMap("z") + ")")
  println("Moving at velocity (" + velocityMap("x") + "," + velocityMap("y") + "," + velocityMap("z") + ")")
  println("Bounds are: (+/-" + math.abs(boundaryMap("x"))/2 + ", +/-" + math.abs(boundaryMap("y"))/2 + ", +/-"+ math.abs(boundaryMap("z"))/2 + ")")
  println()

  def pointermove() {
    movecounter += 1

    if (math.abs(pointerMap("x")) >= (math.abs(boundaryMap("x"))/2)) {
      print("OUT OF BOUNDS ON X COORDINATE, ")
      velocityMap("x") = (-1 * velocityMap("x"))
    }
    if (math.abs(pointerMap("y")) >= (math.abs(boundaryMap("y"))/2)) {
      print("OUT OF BOUNDS ON Y COORDINATE, ")
      velocityMap("y") = (-1 * velocityMap("y"))
    }
    if (math.abs(pointerMap("z")) >= (math.abs(boundaryMap("z"))/2)) {
      print("OUT OF BOUNDS ON Z COORDINATE, ")
      velocityMap("z") = (-1 * velocityMap("z"))
    }

    pointerMap("x") += velocityMap("x")
    pointerMap("y") += velocityMap("y")
    pointerMap("z") += velocityMap("z")
  }

  while (movecounter < runfor) {
    pointermove()
    println( Name + "'s Position: (" + pointerMap("x") + "," + pointerMap("y") + "," + pointerMap("z") + ")")
  }

  println("Completed movement after " + movecounter + " moves.")
}
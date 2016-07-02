import common.boundary
import drone.Drone

object Main extends App {
  /*
  * First, we start by hardcoding everything - modularity will come later as I figure out how to do that.
  *
  * For now, we have one drone named "PointerA", a fixed box-shaped boundary, and a hardcoded velocity.
  * When a boundary is encountered, the drone bounces off that boundary with same speed, but in the opposite
  * direction.
  * */
  val runFor = 20
  var moveCounter = 0
  var container = new boundary()
  var droneA = new Drone()
  var droneB = new Drone()
  var drones = scala.collection.mutable.ArrayBuffer[Drone]()

  drones += droneA
  drones += droneB

  drones(0).create("Drone A")
  drones(1).create("Drone B", x = 2, y = -5, z = 1)

  container.create(radius = 10)

  println("STARTING READOUT:")
  for(i <- drones.indices){
    println("Pointer: " + drones(i).droneName)
    println("Moving at velocity " + drones(i).textVelocity()) }
  println("Bounds are: " + container.textBoundary())
  println()

  while (moveCounter < runFor) {
    for (i <- drones.indices) {
      container.validMove(drones(i))
      println(drones(i).droneName + "'s Position: " + drones(i).textPosition())
    }

    moveCounter += 1
  }

  println("Completed movement after " + moveCounter + " moves.")
}
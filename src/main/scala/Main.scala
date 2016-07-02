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
  val runFor = 100
  var moveCounter = 0
  var container = new boundary()
  var droneA = new Drone()

  droneA.create("Drone A")
  container.create(radius = 50)

  println("STARTING READOUT:")
  println("Pointer: " + droneA.droneName)
  println("Starting Position: " + droneA.textPosition())
  println("Moving at velocity " + droneA.textVelocity())
  println("Bounds are: " + container.textBoundary())
  println()

  while (moveCounter < runFor) {
    container.validMove(droneA)
    moveCounter += 1
    println( droneA.droneName + "'s Position: " + droneA.textPosition())
  }

  println("Completed movement after " + moveCounter + " moves.")
}
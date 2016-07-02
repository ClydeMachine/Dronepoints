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
  var moveCounter = 1
  var container = new boundary()
  var drones = scala.collection.mutable.ArrayBuffer[Drone]()

  while (drones.size != 3){ //Just have to change this to whatever number of drones you want.
    drones += new Drone()
  }

  drones(0).create("Drone A")
  drones(1).create("Drone B", x = 2, y = -5, z = 1)
  drones(2).create("Drone C", velx = 2, vely = -2, velz = 1, x = -5, y = -5, z = -5)

  container.create(radius = 10)

  println("STARTING READOUT:")
  for(i <- drones.indices){
    println("Pointer: " + drones(i).droneName)
    println("Moving from " + drones(i).textPosition() + " with velocity " + drones(i).textVelocity())
  }
  println("Bounds are: " + container.textBoundary())
  println()

  while (moveCounter <= runFor) {
    printf("---------MOVE %d---------\n", moveCounter)
    for (i <- drones.indices) {
      container.validMove(drones(i))
      println(drones(i).droneName + "'s Position: " + drones(i).textPosition())
    }
    moveCounter += 1
  }

  println("Completed movement after " + moveCounter + " moves.")
}
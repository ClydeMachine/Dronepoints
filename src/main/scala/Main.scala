import java.util.Random

import common.boundary
import drone.Drone

import scala.io.StdIn

object Main extends App {
  /*
  * First, we start by hardcoding everything - modularity will come later as I figure out how to do that.
  *
  * For now, we have one drone named "PointerA", a fixed box-shaped boundary, and a hardcoded velocity.
  * When a boundary is encountered, the drone bounces off that boundary with same speed, but in the opposite
  * direction.
  * */
  val runFor = 10000
  var moveCounter = 1
  var container = new boundary()
  var drones = scala.collection.mutable.ArrayBuffer[Drone]()

  def randomPosition(radius:Int): Int ={
    (math.random*radius*2).toInt - radius
  }

  def randomVelocity(): Int ={
    (math.random*10).toInt - 5
  }

  print("Enter in container radius: ")
  val radius = StdIn.readInt()
  print("\n")
  container.create(radius)
  print("Enter # of drones: ")
  val numOfDrones = StdIn.readInt()
  println()

  while (drones.size != numOfDrones){ //Just have to change this to whatever number of drones you want.
    drones += new Drone()
    drones(drones.size - 1).create("Drone " + drones.size,
      randomPosition(radius), randomPosition(radius), randomPosition(radius),
      randomVelocity(), randomVelocity(), randomVelocity() )
  }



  println("STARTING READOUT:")
  for(i <- drones.indices){
    print("Pointer: " + drones(i).droneName + " ")
    println("Moving from " + drones(i).textPosition() + " with velocity " + drones(i).textVelocity())
  }
  println("Bounds are: " + container.textBoundary())
  println()

  while (moveCounter <= runFor) {
    for (i <- drones.indices) {
      container.validMove(drones(i))
    }
    moveCounter += 1
    var newDrones = scala.collection.mutable.ArrayBuffer[Drone]()
    if (drones.size != 1) {
      for (i <- drones.indices; j <- i until drones.size if j != i) {
        if (drones(i).pointerMap == drones(j).pointerMap) {
          newDrones += drones(i)
          newDrones += drones(j)
        }
      }
      for(i <- newDrones.indices) {
        drones -= newDrones(i)
      }
    }
  }
  println("Simluation finished, printing status of final positions: ")
  for(i <- drones.indices){
    print("Pointer: " + drones(i).droneName + " ")
    println("Moving from " + drones(i).textPosition() + " with velocity " + drones(i).textVelocity())
  }
  println("Completed movement after " + runFor + " moves. Number of drones left: " + drones.size + "/" + numOfDrones)
}


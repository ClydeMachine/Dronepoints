import droid.Droid

object Main extends App {

  /*
  * First, we start by hardcoding everything - modularity will come later as I figure out how to do that.
  *
  * For now, we have one drone named "PointerA", a fixed box-shaped boundary, and a hardcoded velocity.
  * When a boundary is encountered, the drone bounces off that boundary with same speed, but in the opposite
  * direction. 
  *
  * */

  val runFor = 20

  var droidA = new Droid()
  droidA.create("Droid A")


  println("STARTING READOUT:")
  println("Pointer: " + droidA.droidName)
  println("Starting Position: " + droidA.textPosition())
  println("Moving at velocity " + droidA.textVelocity())
  println("Bounds are: " + droidA.textBoundary())
  println()

  while (droidA.moveCounter < runFor) {
    droidA.pointerMove()
    println( droidA.droidName + "'s Position: " + droidA.textPosition())
  }

  println("Completed movement after " + droidA.moveCounter + " moves.")
}
package common

import drone.Drone

/**
  * Created by Ghezra on 6/30/2016.
  */
class boundary {
  var boundaryShape:Int = 0 // 0 uninitiated, 1 rectangle, 2 circle
  var boundaryRadius:Int = 0
  var boundaryMap = Map[String,Int]("x"->0,"y"->0,"z"->0)

  def create() {
    create(1,5)
  }

  def create(shape:Int, radius:Int) {
    boundaryShape = shape
    boundaryRadius = radius
    boundaryMap = Map[String,Int]("x"->(boundaryRadius),"y"->(boundaryRadius),"z"->(boundaryRadius))
  }

  def validMove(body:Drone): Boolean ={
    val pointerMap = body.getPosition()
    val velocityMap = body.getVelocity()

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

    pointerMap("x") += velocityMap("x")
    pointerMap("y") += velocityMap("y")
    pointerMap("z") += velocityMap("z")



  }

  def detectCollision(body:Drone):Int = { //sets up collision detection of 1,2,4,3,5,6,7 for x,y,z,xy,xz,yz,xyz
    val pointerMap = body.getPosition()
    var collide: Int = 0
    if (math.abs(pointerMap("x")) >= (math.abs(boundaryMap("x"))/2))
      collide = 1
    if (math.abs(pointerMap("y")) >= (math.abs(boundaryMap("y"))/2))
      collide += 2
    if (math.abs(pointerMap("z")) >= (math.abs(boundaryMap("z"))/2))
      collide += 4
    collide
  }

  def textBoundary():String = { "(+/-" + math.abs(boundaryMap("x"))/2 + ", +/-" + math.abs(boundaryMap("y"))/2 + ", +/-"+ math.abs(boundaryMap("z"))/2 + ")" }

}
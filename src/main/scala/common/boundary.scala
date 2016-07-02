package common

import drone.Drone
/**
  * Created by Ghezra on 6/30/2016.
  */
class boundary {
  var boundaryShape:Int = 0 // 0 uninitiated, 1 rectangle, 2 circle
  var boundaryRadius:Int = 0
  var boundaryMap = Map[String,Int]("x"->0,"y"->0,"z"->0)

  def create(shape:Int = 1, radius:Int = 5) {
    boundaryShape = shape
    boundaryRadius = radius
    boundaryMap = Map[String,Int]("x"->(boundaryRadius),"y"->(boundaryRadius),"z"->(boundaryRadius))
  }

  def validMove(body:Drone) {
    for(ch <- "xyz"){
      if(math.abs(body.pointerMap(ch.toString)) >= boundaryMap(ch.toString)){
        print("OUT OF BOUNDS ON " + ch + "COORDINATE, ")
        body.velocityMap(ch.toString) = -1 * body.velocityMap(ch.toString)
      }
      body.pointerMap(ch.toString) += body.velocityMap(ch.toString)
    }
  }

  def detectCollision(body:Drone):Int = { //sets up collision detection of 1,2,4,3,5,6,7 for x,y,z,xy,xz,yz,xyz
    var collide = 0
    if (body.pointerMap("x") >= boundaryMap("x")) {collide = 1}
    if (body.pointerMap("y") >= boundaryMap("y")) {collide += 2}
    if (body.pointerMap("z") >= boundaryMap("z")) {collide += 4}
    collide
  }

  def textBoundary():String = { "(+/-" + boundaryMap("x") + ", +/-" + boundaryMap("y") + ", +/-"+ boundaryMap("z") + ")" }

}
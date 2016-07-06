package common

import drone.Drone

class boundary {
  var boundaryShape:Int = 0 // 0 uninitiated, 1 rectangle, 2 circle
  var boundaryRadius:Int = 0
  var boundaryMap = Map[String,Int]("x"->0,"y"->0,"z"->0)

  def create(shape:Int = 1, radius:Int = 5) {
    boundaryShape = shape
    boundaryRadius = radius
    boundaryMap = Map[String,Int]("x"->boundaryRadius,"y"->boundaryRadius,"z"->boundaryRadius)
  }

  def validMove(body:Drone) {
    for(ch <- "xyz"){  //this reflection isn't accurate. Will have to rewrite so the object actually hits the wall instead of turning around prior to actually hitting
      if(math.abs(body.pointerMap(ch.toString) + body.velocityMap(ch.toString)) >= boundaryMap(ch.toString)){
        body.velocityMap(ch.toString) = -1 * body.velocityMap(ch.toString)
      }
      body.pointerMap(ch.toString) += body.velocityMap(ch.toString)
    }
  }

  def textBoundary():String = { "(+/-" + boundaryMap("x") + ", +/-" + boundaryMap("y") + ", +/-"+ boundaryMap("z") + ")" }

}
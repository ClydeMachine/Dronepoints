object MainTest {
  val width = 10
  val depth = 10
  val height = 10
  val runfor = 20
  var movecounter = 0

  def dronepoint(name:String,x:Int,y:Int,z:Int): Unit = {
    // when called define direction and starting pos etc.
    val startpos = (0,0,0)
    var dirx = x
    var diry = y
    var dirz = z
  }

  def env(width:Int,depth:Int,height:Int): Unit = {
    // define collision environment properties
    // for now assume its a box
  }

  def boundarycheck(x:Int,y:Int,z:Int): Boolean = {
    // check if the existing dronepoint position equals or surpasses a boundary
    //if (x) true else if (y) true else if (z) true else false
    // if boundary equals pos, set direction negative and iterate
    true
  }

  def dronemove(): Unit = {
    //move drones, then print each one's information, then wait for a half second
    movecounter += 1

    println("Completed move #" + movecounter)
  }


}

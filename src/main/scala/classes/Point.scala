package classes

class Point(var x: Int = 0, var y: Int = 0) {

  def move(dx: Int, dy: Int) ={
    x = x + dx
    y = y + dy
  }

  override def toString: String = s"($x, $y)"

  val point1 = new Point(2, 3)
 // point1.x
  println(point1)

}

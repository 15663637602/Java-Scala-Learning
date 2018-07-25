package classes


class PrivateP {
  private var _x = 0
  private var _y = 0
  private val bound = 100
  // 子类access protected field, method 不需要super
  protected var protected_name = "leo"
  // 只有当前的子类可以访问父类的 protected[this] var
  protected[this] var pro_secret = "pro_secret"
  // 谁都不能访问(除了当前的对象它自己) private[this]
  private[this] var age = 0

  def x = _x
  def x_= (newValue:Int) = {
    if(newValue < bound) _x = newValue
    else printWarning
  }
  def y = _y
  def y_= (newValue: Int): Unit = {
    if (newValue < bound) _y = newValue else printWarning
  }

  private def printWarning = println("Out of bounds")

  override def toString: String = "("+_x+", "+_y + ")"

  // unable to access the private[this] variable from other objects.
//  def older(p:PrivateP) = {
//    age > s.age
//  }
}

object PrivateP {

  def apply: PrivateP = new PrivateP()
  def main(args: Array[String]): Unit = {
    val point1 = new PrivateP
    point1.x = 99
    point1._y = 101
    println(point1)
    println(point1._y)
  }
}

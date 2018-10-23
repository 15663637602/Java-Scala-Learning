package fundamental._02function

import fundamental.utils.Tool.printGap

/**
  * define TODO
  *
  * @author yuqili
  *         Date 23/10/18  16:48
  * @version 1.0
  **/
object Main {

  def -(n1: Int, n2: Int): Int = n1 - n2

  // declare a method which has a function as parameter
  def m1(f: (Int, Int) => Int): Int = {
    f(4, 5)
  }

  // declare a function
  val f1: (Int, Int) => Int = (x: Int, y: Int) => x + y

  // declare a normal method
  def m2(x:Int, y:Int): Int = x + y

  // convert a method to function
  val f2 = m1 _
  // or
  val f3: ((Int, Int) => Int) => Int = m1

  def main(args: Array[String]): Unit = {
    println(1.+(2))
    printGap
    println(Main.-(3, 5))
    printGap
    println(f1(2, 3))
    printGap
    println(m1(f1))
    printGap
    println(f2)
    printGap
    // m1 的参数正常来说应该是一个函数， 但是也可以传一个方法给它（scala会自动把方法转换成函数)
    println(m1(m2))
  }
}

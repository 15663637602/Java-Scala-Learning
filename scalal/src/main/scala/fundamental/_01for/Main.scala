package fundamental._01for

import fundamental.utils.Tool.printGap

/**
  * define TODO
  *
  * @author yuqili
  *         Date 23/10/18  16:38
  * @version 1.0
  **/
object Main {

  def main(args: Array[String]): Unit = {
    for (i <- 1 to 3; j <- 1 to 3; if i != j ) println(i + " : " + j)
    printGap
    val res = for (i <- 1 until 10) yield i
    println(res)
  }
}

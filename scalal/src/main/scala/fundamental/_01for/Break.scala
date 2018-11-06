package fundamental._01for

import fundamental.utils.Tool.printGap
import util.control.Breaks._

/**
  * define TODO
  *
  * @author yuqili
  *         Date 23/10/18  16:38
  * @version 1.0
  **/
object Break {

  def main(args: Array[String]): Unit = {
    for (i <- 1 to 3; j <- 1 to 3; if i != j ) println(i + " : " + j)
    printGap
    val res = for (i <- 1 until 10) yield i
    println(res)

    // Break Example
    println("\n=== BREAK EXAMPLE ===")
    breakable {
      for (i <- 1 to 10) {
        if (i > 4){
          println("Do Something")
          break
        }
        println(i)
      }
    }
    // Continue Example
    println("\n=== CONTINUE EXAMPLE ===")
    for (i <- 0 until 7){
      breakable{
        if (i == 3)  break
        else println(i)
      }
    }

    // Wrong Continue Example
    println("\n=== Wrong CONTINUE EXAMPLE ===")
    for (i <- 0 until 7){
      breakable{
        if (i == 3)  break
      }
      println(i)
    }
    // If not using breakable, will throw an exception
    println("\n=== NO BREAKABLE EXAMPLE ===")
    for (i <- 0 to 7) {
      if (i == 3) break
      else println(i)
    }
  }
}

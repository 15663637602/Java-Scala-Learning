package algs

import scala.util.Random

/**
  * define TODO
  *
  * @author yuqili
  *         Date 25/10/18  12:16
  * @version 1.0
  **/
object pi {

  def calcPi(seed: Int): Double = {
    var square_count: Double = 0.0
    var circle_count: Double = 0.0
    for (i <- 0 to seed) {
      square_count += 1
      val x: Double = Random.nextDouble()
      val y: Double = Random.nextDouble()
      if (Math.sqrt(x * x + y * y) <= 1) circle_count += 1
    }
    val division =  circle_count / square_count
    division * 4
  }

  def main(args: Array[String]): Unit = {
    val res = calcPi(15000)
    println(res)
  }
}

package exceptions.usetry

import scala.util.{Failure, Success, Try}

object UsingTry {
  def f(i:Int) = Try(24/i)

  def test(n:Int) = {
    f(n) match {
      case Success(r) => r
      case Failure(e) => e.getMessage
    }
  }

  def main(args: Array[String]): Unit = {
    println(f(24))
    println(f(0))
    println(test(0))

  }

}

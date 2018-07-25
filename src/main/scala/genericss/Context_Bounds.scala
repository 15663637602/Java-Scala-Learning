package genericss

class Context_Bounds[T: Ordering](val number1: T, val number2: T) {
  def max(implicit order: Ordering[T]) = if(order.compare(number1, number2) > 0 ) number1 else number2
}

object Context_Bounds {
  def main(args: Array[String]): Unit = {
    val cal = new Context_Bounds(1, 2)
    println(cal.max)
  }
}
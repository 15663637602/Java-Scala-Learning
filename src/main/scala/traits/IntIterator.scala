package traits

class IntIterator(to: Int) extends Iterator[Int] {
  private var current = 0
  override def hasNext:Boolean = current < to
  override def next():Int = {
    if(hasNext) {
      val t = current
      current += 1
      t
    }else 0
  }
}

object IntIterator {
  def main(args: Array[String]): Unit = {
    val i = IntIterator(10)
    println(i.next())
    println(i.next())
  }
  def apply(to: Int): IntIterator = new IntIterator(to)

}

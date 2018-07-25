package mixins.iterate

object StringIteratorTest extends App {
  class RichStringIter extends StringIterator("Scala") with RichIterator

  val richStringIter = new RichStringIter
  richStringIter foreach println

}

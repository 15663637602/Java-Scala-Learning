package mixins.iterate

trait RichIterator extends AbsIterator{
  def foreach(f: T=> Unit):Unit = while (hasNext) f(next())
}

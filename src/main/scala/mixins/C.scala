package mixins

trait C extends A{
  def loudMessage = message.toUpperCase
}

package mixins

class D extends B with C{
  val d= new D
  println(d.message)
  println(d.loudMessage)
}

package genericss

class Father(val name: String) {

}

class Child(name: String) extends Father(name) {

}

object Father {
  def getLostIDCardID[T >: Child](p: T): Unit ={
    if(p.getClass == classOf[Child]) println("schild")
    else if(p.getClass == classOf[Father]) println("father")
    else println("sorry, impossible")
  }

  def main(args: Array[String]): Unit = {
    val jack = new Father("jack")
    val leo = new Child("leo")
    getLostIDCardID(jack)
  }
}
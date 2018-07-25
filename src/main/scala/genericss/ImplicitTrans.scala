package genericss

class ImplicitTrans {

}

class Person2(val name: String) {
  def sayHello = println("Hello, I'm " + name)
  def makeFriends(p: Person): Unit = {
    sayHello
    p.sayHello
  }
}

class Students2(name: String) extends Person2(name)

class Dog2(val name: String) {
  def sayHello = println("wang! wang!   " + name)
}

class Party2[T <% Person2](p1: T, p2: T){
}

object ImplicitTrans {
  implicit def dog2person(obj: Object): Person2 ={
    obj match {
      case dog: Dog2 =>
        new Person2(dog.name)
      case _ => Nil
    }
  }

  def main(args: Array[String]): Unit = {
    val leo = new Students2("Leo")
    val jack = new Students2("Jack")
    val doggy = new Dog2("Bruce")
    val party = new Party2(leo, doggy)
  }

}
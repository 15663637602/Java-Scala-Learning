package genericss

class Person(val name: String) {
  def sayHello = println("Hello, I'm " + name)
  def makeFriends(p: Person): Unit = {
    sayHello
    p.sayHello
  }
}

class Students(name: String) extends Person(name)

class Party[T <: Person](p1: T, p2: T){
  def play = p1.makeFriends(p2)
}

class Dog(val name: String) {
  def sayHello = println("wang! wang!   " + name)
}

object Person {
  def main(args: Array[String]): Unit = {
    val leo = new Students("Leo")
    val jack = new Students("Jack")
    val party = new Party(leo, jack)
    party.play
  }
}
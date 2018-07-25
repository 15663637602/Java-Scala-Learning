package pattern_matching

object Main {
  def judgeIdentify(p: Person): Unit = {
    p match {
      case Teacher(name, subject) => println("Teacher name: " + name + " Subject: "+ subject)
      case Student(name, classroom) => println("Name: " + name + " room: " + classroom)
      case _ => println("Illegal")
    }
  }
  def main(args: Array[String]): Unit = {
    judgeIdentify(new Teacher("leo", "chinese"))
    val jack: Person = Worker("jack")
    judgeIdentify(jack)
  }
}

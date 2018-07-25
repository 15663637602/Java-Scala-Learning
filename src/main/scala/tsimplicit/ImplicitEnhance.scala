package tsimplicit

class ImplicitEnhance

class Man(val name: String)

class Superman(val name: String){
  def emitLaser = println("emit a laser")
}

object Main2 {
  implicit def man2superman(man: Man): Superman = new Superman(man.name)

  def main(args: Array[String]): Unit = {
    val man1 = new Man("man1")
    // Man类是没有emitlaster方法的
    man1.emitLaser
  }
}

package tsimplicit

class ImplicitParameter

class SignPen(val penName: String) {
  def write(content: String) = println(content)
}

object Main3 {
  implicit val signPen = new SignPen("implicitPen")

  def signForExam(name: String)(implicit signPen: SignPen): Unit = {
    signPen.write(name + " come to exam in time, penName: " + signPen.penName)
  }

  def main(args: Array[String]): Unit = {
    signForExam("leo")
    signForExam("leo")(new SignPen("not implicit"))
  }

}

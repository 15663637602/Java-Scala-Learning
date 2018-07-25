package genericss

class Student[T](val localID: T) {
  def getSchoolId(hukouId: T) = "S-" + hukouId + "-" +localID

  def getCard[T](content: T) = {
    content match {
      case _: Int => "int card: " + content
      case _: String => "String card: " + content
      case _ => "card: " + content
    }
  }
}

object Student {
  def main(args: Array[String]): Unit = {
    val leo = new Student[Int](111)
    println(leo.getSchoolId(123))
    println(leo.getCard(312323))
  }
}
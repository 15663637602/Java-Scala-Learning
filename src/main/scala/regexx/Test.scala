package regexx

object Test {
  def main(args: Array[String]): Unit = {
    val pattern = """\w+""".r
    val str = "Scala is Scalable and Cool"
    println(pattern.findFirstIn(str).mkString)
    println(pattern.findAllIn(str).mkString(","))
  }
}

val grades = Map("Leo" -> "A", "Jack" -> "C", "Tom" -> "B")

def getGrade(name: String): Unit = {
  val grade = grades.get(name)
  grade match {
    case Some(mark) => println("your grade is: " + mark)
    case None => println("Sorry, your grade is not in the system")
  }
}

getGrade("asd")

getGrade("Leo")
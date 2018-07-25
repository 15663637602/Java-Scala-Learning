import java.io.FileNotFoundException

def judgeGrade(grade: String): Unit = {
  grade match {
    case "A" => println("Excellent")
    case "B" => println("Good")
    case "C" => println("Just so so")
    case _ => println("haha")
  }
}

judgeGrade("A")

def judgeGrade2(name: String, grade: String): Unit = {
  grade match {
    case "A" => println("Excellent")
    case "B" => println("Good")
    case "C" if name == "Jason" => println(name + ", you did better than last time")
    case "C" if name =="Jack" => println(name + ", you did worse than last time")
    case "C" => println("Just so so")
    case _ if name == "leo" => println(name + ", not too bad")
    case _ => println("work harder")
  }
}

judgeGrade2("leo","D")
judgeGrade2("Jason","C")
judgeGrade2("Jack","C")

def judgeGrade3(grade: String): Unit = {
  grade match {
    case "A" => println("Excellent")
    case "B" => println("Good")
    case "C" => println("Just so so")
    case grade if grade == "F" => println("you got " + grade)
    case badGrade => println("you got " + badGrade + " grade, I hope you could get better grade next time")
  }
}

judgeGrade3("F")
judgeGrade3("Fasd")

def processException(e: Exception): Unit = {
  e match {
    case e1: IllegalArgumentException => println("illegal argument: " + e1)
    case e2: FileNotFoundException => println("file not found: " + e2)
    case _: Exception => println("dont know which exception you have")
  }
}

processException(new IllegalArgumentException)

def greeting(arr: Array[String]): Unit ={
  arr match {
    case Array("Leo") => println("How are you, Leo!")
    case Array(girl1, girl2, girl3) => println("hi 3 girls" + girl1 + girl2 + girl3)
    case Array("Leo", _*) => println("hi, leo, you brought a lot of your friends?")
  }
}

greeting(Array("Leo", "Jack"))

greeting(Array("Leo", "Jack", "Sonsi"))

def greeting2(list: List[String]): Unit = {
  list match {
    case "Leo" :: Nil => println("only you? Leo")
    case girl1 :: girl2 :: girl3 :: Nil => println(girl1 + girl2 + girl3)
    case "Leo" :: tail => println("more than 1 people")
  }
}
greeting2(List("Leo"))
greeting2(List("Leo","Mike"))
greeting2(List("Leo", "Jack", "Susi"))
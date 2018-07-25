package companionObj

import Logger.info

class Student(var name:String, var address:String) {
  private var phone = "110"
  def infoCompObj = println("objects in bansheng: " + Student.sno)
}

object Student {
  private var sno:Int = 100
  def incrementSno()={
    sno += 1
    sno
  }

  def apply(name1:String, address1:String): Student = new Student(name1,address1)

  def main(args: Array[String]): Unit = {
    println("object: " + Student.incrementSno())
    val obj = new Student("xiaom", "dakiy")
    obj.infoCompObj

    info("Create Class")

    // using apply
    println("Using apply()")
    val obj2 = Student("apply_n1", "apply_a1")
    println(obj2.name)
    println(obj2.address)

  }
}

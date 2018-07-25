package classes

object clas extends App {
  val p: Person = new Student
  var s: Student = null
  if(p.isInstanceOf[Student]){
    println("success")
    s = p.asInstanceOf[Student]
  }

  val s1: Student = new Student
  var p1: Person = null
  if(s1.isInstanceOf[Person]){
    println("success")
    p1 = s1.asInstanceOf[Person]
  }

  val s2: Student = new Student
  var p2 = null
  if(s2.isInstanceOf[Person]){
    println("success")
    p2.asInstanceOf[Person]
  }

  println("--------------------")
  //精确的判断类是什么不能用isInstanceOf(用isInstanceOf，如果是继承关系的话，也ok)
  val person: Person = new Student
  println(person.isInstanceOf[Person])
  println(p.getClass == classOf[Person])
  println(p.getClass == classOf[Student])

  // pattern matching
  println("--------------------")
  person match {
    case stu: Student => println("student object")
    case per: Person => println("it's a Person object")
    case _ => println("unknown type")
  }

  person match {
    case per: Person => println("Person object")
    case _ => println("unknown type")
  }

  // Anonymous
  println("--------------------")
  def greeting(a :AnonymousClas{def sayHello:String}): Unit ={
    println(a.sayHello)
  }

  // define an anonymous subclass
  val a = new AnonymousClas("leo"){
    override def sayHello: String = "Hi, Iam " + name
  }
  greeting(a)
}

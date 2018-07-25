package classes

class Child(name:String, age:Int, var score:Double) extends Father(name, age) {
  def this(name:String){
    this(name, 0, 0)
  }
  def this(age:Int){
    this("leo", age, 0)
  }
  def this(score: Double){
    this("leo", 18, score)
  }
}

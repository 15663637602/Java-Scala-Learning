package classes

class Student extends Person{
  private var score = "A"
  def getScore = score

  override def getPrivateName: String = "Hi, I'm" + super.getPrivateName

  override val public_name: String = "student"

  override def age: Int = 30

}

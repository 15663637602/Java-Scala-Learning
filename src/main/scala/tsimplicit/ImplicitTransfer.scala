package tsimplicit

class ImplicitTransfer

class SpecialPerson(val name:String)
class Student(val name: String)
class Older(val name: String)

class TicketHouse {
  var ticketNumber = 0
  def buySpecialTicket(p: SpecialPerson) = {
    ticketNumber += 1
    "T- " + ticketNumber
  }
}

object Main {
  implicit def object2SpecialPerson(obj: Object): SpecialPerson = {
    obj match {
      case stu: Student => new SpecialPerson(stu.name)
      case old: Older => new SpecialPerson(old.name)
      case _ => Nil
    }
  }

  var ticketNumber = 0

  def buySpecialTicket(p: SpecialPerson) = {
    ticketNumber += 1
    "T- " + ticketNumber
  }

  def main(args: Array[String]): Unit = {
    val stu1 = new Student("stu1")
    val older1 = new Older("old1")
    buySpecialTicket(stu1)
    buySpecialTicket(older1)

    val ticketHouse = new TicketHouse

    ticketHouse.buySpecialTicket(stu1)
  }

}


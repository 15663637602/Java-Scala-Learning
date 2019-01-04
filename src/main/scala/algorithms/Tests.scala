package algorithms

/**
  * define TODO
  *
  * @author yuqili
  *         Date 27/12/18  12:02
  * @version 1.0
  **/
object Tests {

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    require(l1 != null && l2 != null)
    var carry: Boolean = false
    var n1 = l1
    var n2 = l2
    val res: ListNode = if ((n1.x + n2.x) >= 10) {
      carry = true
      new ListNode((n1.x + n2.x) % 10)
    } else {
      carry = false
      new ListNode(n1.x + n2.x)
    }
    var nr = res
    while (n1.next != null || n2.next != null || carry) {
      if (n1.next != null && n2.next != null) {
        n1 = n1.next
        n2 = n2.next
        val sum: Int = if (carry) n1.x + n2.x + 1 else n1.x + n2.x
        nr.next = if (sum >= 10) {
          carry = true
          new ListNode(sum % 10 )
        } else {
          carry = false
          new ListNode(sum)
        }
      } else if (n1.next != null){
        n1 = n1.next
        nr.next = if (carry && n1.x == 9) {
          carry = true
          new ListNode(0)
        } else {
          if (carry){
            carry = false
            new ListNode(n1.x + 1)
          } else {
            new ListNode(n1.x)
          }
        }
      } else if (n2.next != null) {
        n2 = n2.next
        nr.next = if (carry && n2.x == 9) {
          carry = true
          new ListNode(0)
        } else {
          if (carry) {
            carry = false
            new ListNode(n2.x + 1)
          } else {
            new ListNode(n2.x)
          }
        }
      } else if (carry) {
        nr.next = new ListNode(1)
        carry = false
      }
      nr = nr.next
    }
    res
  }

  def main(args: Array[String]): Unit = {
//    val l1 = new ListNode(2)
//    l1.next = new ListNode(4)
//    l1.next.next = new ListNode(3)
//    val l2 = new ListNode(5)
//    l2.next = new ListNode(6)
//    l2.next.next = new ListNode(4)
    val l1 = new ListNode(9)
    l1.next = new ListNode(8)
    val l2 = new ListNode(1)
    println(addTwoNumbers(l1, l2).toString)
  }
}

class ListNode(var _x: Int = 0) {
  var next: ListNode = _
  var x: Int = _x

  override def toString: String = {
    val sb: StringBuilder = new StringBuilder
    sb.append(x + ", ")
    var n = this.next
    while (n != null) {
      sb.append(n.x + ", ")
      n = n.next
    }
    sb.dropRight(2).toString
  }
}

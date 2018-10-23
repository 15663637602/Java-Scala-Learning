package algs.addTwoNum

import org.w3c.dom.NodeList

/**
  * define TODO
  *
  * @author yuqili
  *         Date 23/10/18  10:33
  * @version 1.0
  **/
object AddTwoNums {
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    var list1 = l1
    var list2 = l2
    val head: ListNode = new ListNode(0)
    var carry: Boolean = false
    var flag: Boolean = true
    var point: ListNode = head

    while (flag || carry) {
      val sum = {
        if(flag){
          val s = list1.x + list2.x
          if (list1.next == null) {
            flag = false
          } else {
            list1 = list1.next
            list2 = list2.next
          }
          s
        } else {
          0
        }
      }
      point.next = new ListNode()
      point = point.next
      var n: Int = 0
      if (sum > 10) {
        n = (sum % 10) + (if (carry) 1 else 0)
        carry = true
      } else {
        n = sum + (if(carry) 1 else 0)
        carry = false
      }
      point.x = n
    }
    head.next
  }

  def main(args: Array[String]): Unit = {
    val l1 = new ListNode(3)
    val l2 = new ListNode(7)
    val l3 = new ListNode(8)
    l1.next = l2
    l2.next = l3
    val l4 = new ListNode(6)
    val l5 = new ListNode(2)
    val l6 = new ListNode(9)
    l4.next = l5
    l5.next = l6
    println(l1)
    println(l4)
    println("=================")
    val res = addTwoNumbers(l1, l4)
    println(res)
  }
}

class ListNode(var _x: Int = 0) {
  var next: ListNode = _
  var x: Int = _x

  override def toString: String = {
    val b = new StringBuilder()
    var flag = true
    var l = this
    while (flag) {
      if (l.next == null) flag = false
      b.append(l.x + " -> ")
      l = l.next
    }
    b.toString().substring(0, b.length - 4)
  }

}

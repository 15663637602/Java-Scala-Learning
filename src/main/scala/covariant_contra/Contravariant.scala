package covariant_contra

// 逆变就是 协变反过来
// Card[Professional] 是 Card[Master] 的父类
class Contravariant {

}

class Master1

class Professional1 extends Master1

class Card1[-T] (val name: String)

object Main1 {
  // 传递子类型参数是可以的， 传递父类型就得强制转换才行
  def enterMeeting(card1: Card1[Professional1]): Unit = {
    println("Welcome to the meeting")
  }

  val master = new Card1[Master1]("master")
  val pro = new Card1[Professional1]("pro")


  def main(args: Array[String]): Unit = {
    enterMeeting(pro)
    enterMeeting(master)
  }
}
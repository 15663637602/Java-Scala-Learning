package covariant_contra

class Covariant {

}

class Master

class Professional extends Master

// 这个泛型 和 Card是协变： 这样的话， Card会根据 T的继承关系 来设置自己的继承关系
// 即： Card[Professional] 是 Card[Master] 的子类
class Card[+T] (val name: String)

object Main {

  def enterMeet(card: Card[Master]): Unit ={
    println("Welcome to the meeting")
  }

  def main(args: Array[String]): Unit = {
    val leo = new Card[Master]("master_leo")
    val jack = new Card[Professional]("professional_jack")
    enterMeet(leo)
    // 如果不定义为 协变T 那么下面这句会报错s
    enterMeet(jack)
  }
}
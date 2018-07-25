package collectionss

object Trasffer extends App {
  val a = Array(1,2,3,4,5)
  val a2 = for (ele <- a if ele % 2 == 0) println(ele * ele)

  a.filter(_ % 2 == 0).map(_ * 2).foreach(println)
}

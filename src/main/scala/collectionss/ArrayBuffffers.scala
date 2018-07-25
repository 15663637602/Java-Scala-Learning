package collectionss

import scala.collection.mutable.ArrayBuffer

object ArrayBuffffers extends App {
  val a = ArrayBuffer[Int]()

  a += 1

  a += (2,3,4,5)

  a ++= Array(6,7,8,9)

  a.trimEnd(2)

  a.insert(5, 100)

  a.remove(2,2)

  a.foreach(println)

  val b = a.toArray

  println("--------------------------")

  for (i <- b.indices.reverse) println(b(i))

  println(b.sum)
}

package collectionss

import scala.collection.mutable.ArrayBuffer

object FilterNegative {
  def filterNeg(a: ArrayBuffer[Int]): ArrayBuffer[Int] = {
    var foundFirstNegative = false
    var arrayLength = a.length
    var index = 0
    while (index < arrayLength) {
      if (a(index) >= 0) {
        index += 1
      } else {
        if (!foundFirstNegative) {
          foundFirstNegative = true
          index += 1
        } else {
          a.remove(index)
          arrayLength -= 1
        }
      }
    }
    a
  }

  def filterNeg2(a: ArrayBuffer[Int]): ArrayBuffer[Int] = {
    var foundFirstNegative = false
    val keepIndexes = for(i <- 0 until a.length if !foundFirstNegative || a(i) >= 0)yield {
      if(a(i) < 0) foundFirstNegative = true
      i
    }

    for(i <- 0 until keepIndexes.length){
      a(i) = a(keepIndexes(i))
    }
    a.trimEnd(a.length - keepIndexes.length)
    a
  }
}

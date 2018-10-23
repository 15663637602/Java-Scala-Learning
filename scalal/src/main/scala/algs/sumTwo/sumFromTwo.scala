package algs.sumTwo

/**
  * define Give an array of integer and a sum, return the indexes of two integers
  *
  * @author yuqili
  *         Date 22/10/18  15:37
  * @version 1.0
  **/
object sumFromTwo {

  def m(arr: Array[Int], sum: Int): Unit = {
    val map: collection.mutable.Map[Int, Int] = collection.mutable.Map[Int, Int]()
    for (i <- arr.indices) {
      if (map.contains(sum - arr(i))) {
        println(map(sum - arr(i)) + " : " + i)
      } else {
        map += (arr(i) -> i)
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(2,4,6,8,7)
    m(arr, 11)
  }
}

package algs.sumThree

/**
  * define Given an array nums of n integers,
  * are there elements a, b, c in nums such that a + b + c = 0?
  * Find all unique triplets in the array which gives the sum of zero.
  * Given array nums = [-1, 0, 1, 2, -1, -4],
  *
  * A solution set is:
  * [
  * [-1, 0, 1],
  * [-1, -1, 2]
  * ]
  *
  * @author yuqili
  *         Date 25/10/18  16:28
  * @version 1.0
  **/
object Main {

  def threeSum(nums: Array[Int]): List[List[Int]] = {
    val l: collection.mutable.ListBuffer[List[Int]] = collection.mutable.ListBuffer[List[Int]]()
    for ( i <- nums.indices) {
      val curr = nums(i)
      val sumForTwo = 0 - curr
      val restArray = nums.take(i) ++ nums.drop(i + 1)
      val map = collection.mutable.Map[Int, Int]()
      for ( j <- restArray.indices) {
        if ( map.contains(sumForTwo - restArray(j))) {
          val list = List(curr, restArray(j), sumForTwo - restArray(j))
            l += list
        } else {
          map += (restArray(j) -> j)
        }
      }
    }
    val res: collection.mutable.ListBuffer[List[Int]] = collection.mutable.ListBuffer[List[Int]]()
    l.foreach{ list =>
      val t = list.sorted
      if (!res.contains(t)) {
        res += t
      }
    }
    res.toList
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(-1, 0, 1, 2, -1, -4)
    val res = threeSum(arr)
    res.foreach{ l =>
      println(l.toString)
    }
  }
}

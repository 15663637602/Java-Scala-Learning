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

  def threeSum(num: Array[Int]): List[List[Int]] = {
    val l: collection.mutable.ListBuffer[List[Int]] = collection.mutable.ListBuffer[List[Int]]()
    val nums = num.sorted
    for ( i <- nums.indices) {
        if (i == 0 || nums(i) != nums(i - 1)){
          val curr = nums(i)
          val sumForTwo = 0 - curr
          val restArray = nums.drop(i + 1)
          var low = 0
          var high = restArray.length - 1
          while (low < high) {
            val currSum = restArray(low) + restArray(high)
            if (currSum == sumForTwo) {
              l += List(curr, restArray(low), restArray(high))
              while (low < high && restArray(low) == restArray(low + 1)) low += 1
              while (low < high && restArray(high) == restArray(high - 1)) high -= 1
              low += 1
              high -= 1
            } else if(currSum < sumForTwo) {
              low += 1
            }else {
              high -= 1
            }
          }
        }
      }
    l.toList
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(-1, 0, 1, 2, -1, -4, 2)
    val arr2 = Array(0, 0,0)
    val res = threeSum(arr2)
    res.foreach{ l =>
      println(l.toString)
    }
  }
}

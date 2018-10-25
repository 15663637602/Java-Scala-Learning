package algs.sumTwo

/**
  * define Give an array of integer and a sum, return the indexes of two integers
  *
  * @author yuqili
  *         Date 22/10/18  15:37
  * @version 1.0
  **/
object sumFromTwo {

  def m(arr: Array[Int], sum: Int): Array[Int] = {
    val map: collection.mutable.Map[Int, Int] = collection.mutable.Map[Int, Int]()
    for (i <- arr.indices) {
      if (map.contains(sum - arr(i))) {
        println(map(sum - arr(i)) + " : " + i)
      } else {
        map += (arr(i) -> i)
      }
    }
    Array(1 ,2)
  }

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val map: collection.mutable.Map[Int, Int] = collection.mutable.Map[Int, Int]()
    var index1: Int = -1
    var index2: Int = -1
    for ( i <- nums.indices) {
      if (map.contains(target - map(i))) {
        index1 = map(target - map(i))
        index2 = i
      } else {
        map += (nums(i) -> i)
      }
    }
    Array(index1, index2)
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(2,4,6,8,7)
    m(arr, 11)
  }
}

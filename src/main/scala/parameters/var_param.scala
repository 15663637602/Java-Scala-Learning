package parameters

object var_param {
  def sum(nums: Int*): Int = {
    var result: Int = 0
    for(num <- nums) {
      result += num
    }
    println(result)
    result
  }

  def sum2(nums: Int*): Int = {
    if(nums.length == 0) 0
    else nums.head + sum2(nums.tail: _*)
  }

  def main(args: Array[String]): Unit = {
    sum(1,2,3,4,5)
    println()
    sum(1 to 5: _*)
  }
}

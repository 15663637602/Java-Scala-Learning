package algs.maxSubValue

/**
  * define TODO
  *
  * @author yuqili
  *         Date 21/09/18  10:43
  * @version 1.0
  **/
object MaxSubValue {

  def max(now: Double, left: Double): Double = {
    if (now > left) now
    else left
  }

  def max(a: Double, b: Double, c: Double): Double = {
    if (a > b) {
      if (a > c) {
        a
      } else {
        c
      }
    } else {
      if (b > c) {
        b
      } else {
        c
      }
    }
  }

  def dichotomy(set: Array[Double], begin: Int, end: Int): Double = {
    if (begin == end) {
      return set(begin)
    }

    val mid: Int = (begin + end) / 2
    val leftSub: Double = dichotomy(set, begin, mid)
    val rightSub: Double = dichotomy(set, mid + 1, end)

    var sumLeft: Double = set(mid)
    var maxToleft = set(mid)
    for (i <- (begin until mid).reverse) {
      sumLeft += set(i)
      maxToleft = max(sumLeft, maxToleft)
    }

    var sumRight = set(mid + 1)
    var maxToRight = set(mid + 1)
    for (i <- mid + 2 to end) {
      sumRight += set(i)
      maxToRight = max(sumRight, maxToRight)
    }
    val midMax = maxToleft + maxToRight

    max(leftSub, midMax, rightSub)
  }

  // Dichotomy  O(n) = nlog(n)
  def method1(set: Array[Double]): Double = dichotomy(set, 0, set.length - 1)

  // Analysis
  def method2(set: Array[Double]): Unit = {
    // 数组p用来记录前n项和
    val p = new Array[Double](set.length)
    // 数组m用来记录各个位置中的最小前缀
    val m = new Array[Double](set.length)
    p(0) = set(0)
    m(0) = 0
    // 第一次从0遍历到n-1, 算出前i项和
    for (i <- 1 until set.length - 1) {
      p(i) = p(i - 1) + set(i)
    }
    var min: Double = 0
    var sum: Double = 0
    // 第二次算出第n个位置的最小前缀
    for (i <- 0 until set.length - 1) {
      sum += set(i)
      if (sum < min) min = sum
      m(i) = min
    }

    // 两数组相减得出结果
    var max = p(0) - m(0)
    for (i <- 1 until set.length) {
      val temp = p(i) - m(i)
      if (temp > max) max = temp
    }
    println(max)
  }

  def method3(set: Array[Double]): Unit = {
    // s[i] 是以set[i]结尾的数组中总和最大的子数组
    // s[i+1] = max(s[i] + set[i+1], set[i+1])
    val s = new Array[Double](set.length)
    s(0) = set(0)
    for (i <- 1 until set.length){
      s(i) = max(s(i - 1) + set(i), set(i))
    }
    var maxSum = s(0)
    for (i <- 1 until set.length) {
      if (s(i) > maxSum) maxSum = s(i)
    }
    println(maxSum)
  }

  def method4(set: Array[Double]): Unit = {
    val a = new Array[Record](set.length)
    a(0) = new Record(0, set(0))
    for (i <- 1 until set.length) {
      if (a(i - 1).getValue + set(i) > set(i)) {
        a(i) = new Record(a(i - 1).getStart_pos, a(i - 1).getValue + set(i))
      } else {
        a(i) = new Record(i, set(i))
      }
    }

    var maxValue = a(0).getValue
    var start_pos = 0
    var end_pos = 0
    for (i <- 1 until a.length) {
      if(a(i).getValue > maxValue){
        maxValue = a(i).getValue
        start_pos = a(i).getStart_pos
        end_pos = i
      }
    }
    println("value: " + maxValue + " start_pos: " + start_pos + " end_pos: " + end_pos)
  }

  def main(args: Array[String]): Unit = {
    val set: Array[Double] = Array(-1, 12, -3, -10, -4, 7, 2, -5)
    println(method1(set))
    method2(set)
    method3(set)
    method4(set)

  }

  class Record(start_pos: Int, value: Double) {
    def getStart_pos = start_pos
    def getValue = value
  }
}

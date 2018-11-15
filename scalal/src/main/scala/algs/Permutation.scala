package algs

/**
  * define TODO
  *
  * @author yuqili
  *         Date 09/11/18  16:50
  * @version 1.0
  **/
object Permutation {

  def run(str: String): Unit = {
    permutation("", str)
  }

  def permutation(newStr: String, restStr: String): Unit = {
    if (restStr.isEmpty) println(newStr)

    for ( i <- restStr.indices) {
      permutation(newStr + restStr.substring(i, i + 1), restStr.substring(0, i) + restStr.substring(i + 1))
    }
  }

  def main(args: Array[String]): Unit = {
    val str = "aabc"
    run(str)
  }
}

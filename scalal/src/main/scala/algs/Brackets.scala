package algs
/**
  * define TODO
  *
  * @author yuqili
  *         Date 09/11/18  15:56
  * @version 1.0
  **/
object Brackets {

  def generateParenthesis(list: collection.mutable.ListBuffer[String], str: String, l: Int, r: Int, max: Int): Unit = {
    if (str.length == max * 2) {
      list += str
      return
    }
    if (l < max){
      generateParenthesis(list, str + "(",  l+1, r, max)
    }
    if (r < l) {
      generateParenthesis(list, str + ")", l, r + 1, max)
    }
  }

  def generateParenthesis(i: Int): List[String] = {
    val l = collection.mutable.ListBuffer[String]()
    // backtracking
    generateParenthesis(l, "", 0, 0, i)
    l.toList
  }


  def main(args: Array[String]): Unit = {
    val l = generateParenthesis(3)
    l.foreach(println(_))
  }
}

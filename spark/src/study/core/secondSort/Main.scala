package study.core.secondSort

import org.apache.spark.{SparkConf, SparkContext}

object Main {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setAll("SecondSort")
      .setMaster("local")
    val sc = new SparkContext(conf)
    val lines = sc.textFile("/tmp/practice/secondsort/sort.txt")
    val pairs = lines.map(line => (new SecondSortByKey(line.split(" ")(0).toInt, line.split(" ")(0).toInt), line))
    val sortedPairs = pairs.sortByKey()
    val sortedLines = sortedPairs.map(pair => pair._2)
    sortedLines.foreach(line => println(line))
  }
}

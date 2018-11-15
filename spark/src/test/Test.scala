package test

import org.apache.hadoop.fs.FileSystem

/**
  * define TODO
  *
  * @author yuqili
  *         Date 12/11/18  16:53
  * @version 1.0
  **/
object Test {
  val conf = new org.apache.hadoop.conf.Configuration

  val fs: FileSystem = FileSystem.get(conf)

  def main(args: Array[String]): Unit = {

  }
}

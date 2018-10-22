package fundamental

import java.io.File

import scala.collection.mutable.Map
import scala.io.Source

/**
  * define TODO
  *
  * @author yuqili
  *         Date 17/10/18  11:27
  * @version 1.0
  **/
object Test {

  def a = {
    val filename = "/home/yuqili/data/debug/xsd"
    val file = new File(filename)

    if (file.exists() && file.isDirectory) {
      file.listFiles().foreach{ f =>
        if(Source.fromFile(f).getLines().mkString(" ").contains("AnmaerkningStatusModtag")) {
          println(f.getName)
        }
      }
    }
  }

  def rec(p: String): Unit = {
    val file = new File(p)
    if (file.exists() && file.isDirectory) {
      file.listFiles().foreach{ f =>
        if (f.isFile) {
          if (f.getName.endsWith(".xsd")) {
            f.renameTo(new File("/home/yuqili/data/debug/dw/" + f.getName))
          }
          println(f.getAbsolutePath)
        } else if (f.isDirectory) {
          rec(f.getAbsolutePath)
        }
      }
    }
  }

  def main(args: Array[String]): Unit = {
//    rec("/home/yuqili/data/debug/d")
    println(Source.fromFile("/home/yuqili/data/debug/openhr001.xsd")("UTF-8").getLines().mkString("\n"))
  }
}

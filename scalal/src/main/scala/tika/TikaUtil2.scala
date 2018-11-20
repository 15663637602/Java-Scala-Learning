package tika

import java.io.File
import java.nio.file.{Files, Paths}

import org.apache.tika.Tika
import org.apache.tika.io.TikaInputStream

/**
  * define TODO
  *
  * @author yuqili
  *         Date 20/11/18  15:28
  * @version 1.0
  **/
class TikaUtil2 {

}
object TikaUtil2 extends App{
  val tika = new Tika
  val path = "/home/yuqili/data/debug/tes"
  val in = Files.newInputStream(Paths.get(path))
  val tikaIn = TikaInputStream.get(in)
  val mediaType = tika.detect(tikaIn, path)
  println(mediaType)
}

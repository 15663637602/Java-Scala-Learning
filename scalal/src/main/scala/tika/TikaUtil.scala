package tika

import java.io.File

import org.apache.tika.config.TikaConfig
import org.apache.tika.io.TikaInputStream
import org.apache.tika.metadata.Metadata

/**
  * define TODO
  *
  * @author yuqili
  *         Date 20/11/18  14:32
  * @version 1.0
  **/
class TikaUtil {

}

object TikaUtil extends App{
  val filePath = "/home/yuqili/data/debug/samples"
  val f = new File(filePath)

  val tika = new TikaConfig
  val de = tika.getDetector
  val meta = new Metadata
  meta.set("resourceName", f.toString)
  val mime = de.detect(TikaInputStream.get(f), new Metadata)
  println(f + "   " + mime.getSubtype)
}
package xml

import java.io.File

import javax.xml.parsers.{SAXParser, SAXParserFactory}
import org.xml.sax.helpers.DefaultHandler

class SSaxParser {
  lazy val saxfactory: SAXParserFactory = SAXParserFactory.newInstance()

  def getSaxParser(): SAXParser ={
    saxfactory.newSAXParser()
  }
}

object SSaxParser {

  def main(args: Array[String]): Unit = {
    val saxParser = new SSaxParser().getSaxParser()
    val file = new File("/home/yuqili/Project/practice/src/main/scala/xml/example.xml")
    saxParser.parse(file, new DefaultHandler)

  }
}
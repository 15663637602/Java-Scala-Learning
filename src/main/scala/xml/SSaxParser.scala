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
    val file = new File("src/main/scala/xml/book.xml")
    println(file)
    saxParser.parse(file, new UDFHandler)
  }
}
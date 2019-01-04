package xml

import org.xml.sax.Attributes
import org.xml.sax.helpers.DefaultHandler

class UDFHandler extends DefaultHandler {

  override def startDocument(): Unit = {
    println("begin parsing doc")
  }

  override def endDocument(): Unit = {
    println("End doc")
  }

  // called every time the parser gets an open tag '<'
  override def startElement(uri: String, localName: String, qName: String, attributes: Attributes): Unit = {
//    println(uri)
//    println(localName)
    print("<"+qName+">\n")
//    println(attributes.getLength)
  }

  override def endElement(uri: String, localName: String, qName: String): Unit = {
//    println(uri)
//    println(localName)
    print("</" + qName + ">\n")
  }

  override def characters(ch: Array[Char], start: Int, length: Int): Unit = {
    for (i <- start until length) {
      print(ch(i))
    }
  }
}

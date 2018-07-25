package xml

import org.xml.sax.Attributes
import org.xml.sax.helpers.DefaultHandler

class UDFHandler extends DefaultHandler{
  var bname = false
  var bprice = false
  var bdescription = false
  var bcalories = false

  // called every time the parser gets an open tag '<'
  override def startElement(uri: String, localName: String, qName: String, attributes: Attributes): Unit = {
    if (qName.equalsIgnoreCase("name")){
      bname = true
    }
    if (qName.equalsIgnoreCase("name")){
      bname = true
    }
    if (qName.equalsIgnoreCase("name")){
      bname = true
    }
    if (qName.equalsIgnoreCase("name")){
      bname = true
    }


  }
}

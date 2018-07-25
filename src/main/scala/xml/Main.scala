package xml

import scala.xml.XML

object Main extends App {
  val someXml = XML.loadFile("/home/yuqili/Project/practice/src/main/scala/xml/example.xml")
  // 找header下的field
  val headerField = someXml \ "header" \ "field"
  println(headerField)
  println("--------------------")
  // 找所有field
  val allFields = someXml \\ "field"
  println(allFields)
  println("--------------------")
  // 找特定的属性(attribute)，如找header下的所有field的name属性的值
  val fieldwithAttr = someXml \ "header" \\ "field" \\"@name"
  println(fieldwithAttr)
  println("--------------------")
  val fieldwithAttr2 = (someXml \ "header" \\ "field").map(_\"@name").mkString(",")
  println(fieldwithAttr2)
  // still couldn't solve the problem... it seems the app is keep initializing then crash, initializing then crash.... i don't know if it is because I am using the free edition of Openshift

  println("--------------------")
  // 查找并输出属性值和节点值的映射
  val xmlMap = (someXml\"header"\"field").map(n=>(n\"@name", n.text, n\"@required"))
  println(xmlMap)
  println("--------------------")
  // 条件查找
  val filteredXml = (someXml\\"message").filter(_.attribute("name").exists(_.text.equals("Logon")))
  val filteredXml2 = (someXml\\"message").filter(x=>((x\"@name").text) == "Logon")
  println(filteredXml)
  println(filteredXml2)
  println("--------------------")
}

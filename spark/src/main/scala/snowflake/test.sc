import java.net.URI
import java.util.Locale

import org.apache.http.NameValuePair
import org.apache.http.client.utils.URLEncodedUtils
val map = collection.mutable.Map()
// use url escape: + %2B ; blank-space %20 ; / %2F ; ? %3F ; % %25 ; # %23 ; & %26 ; = %3D
var str = "sfURL=ng.com&sfUser=yuqi_li&sfPassword=18646086080%2BLyq&sfDatabase=yqtest2&sfSchema=public&sfWarehouse=etl"
//str = "sadw"
val uri = new URI("?" + str)

val para = URLEncodedUtils.parse(uri, "UTF-8")
  

val i = str.toLowerCase(Locale.US)
    .indexOf("password=")
val start = str.lastIndexOf("&", i)
val end = str.indexOf("&", i)
val nextSepAfterEnd = str.indexOf("&", end + 1)

val passwd = str.substring(start, end)
str.replace(passwd, "")
str.split("&")
//.map(_.split("="))
def optToPair(opt: String) = {
  val i = opt.indexOf("=")
  if (i < 0 || i == opt.length - 1) {
    println(s"Failed to generate kv pairs from: $opt")
  }
  println(opt.substring(0, i))
  println(opt.substring(i+1))
  opt.substring(0, i) -> opt.substring(i+1)
}
optToPair("dwas=dw=")
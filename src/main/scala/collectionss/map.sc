import scala.collection.immutable.SortedMap
import scala.collection.mutable

val m = Map(1 -> "Li", 2 -> "kei")
val name = m.getOrElse(3,"Error")
//val sortedM = SortedMap()
//val linkedHM = mutable.LinkedHashMap
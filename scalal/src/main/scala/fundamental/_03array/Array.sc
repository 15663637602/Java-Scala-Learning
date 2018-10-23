// declare a fixed length array
val arr1 = new Array[Int](8)
val arr2 = new Array[String](8)

println(arr1.toBuffer)

// use static class to initialize an array
val arr3 = Array("java", "scala", "python")
println(arr3(0))

import scala.collection.mutable.ArrayBuffer

val arr4 = ArrayBuffer[Int]()
arr4 += 2
arr4 += (2,3,4)
arr4 ++= Array(5,6)
arr4 ++= ArrayBuffer(7,8,9)
// insert more than 1 elements at index 0
arr4.insert(0, -1, 0)
arr4
arr4.remove(2, 2)
for (i <- arr4.indices) yield arr4(i) * 10
arr4.sorted
arr4.min
arr4.max
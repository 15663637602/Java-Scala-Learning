val t1 = ("scala", 110L, 3.14, ("spark", 1))
t1._1
t1._4._1

val t2, (a, b, c, (d, e)) = ("scala", 110L, 3.14, ("spark", 1))

val arr1 = Array(("xiaoming", 21), ("xiaogou", 23), ("letme", 6))
arr1.toMap

val arr2 = Array("xiaoming", "xiaogou", "letme")
val arr3 = Array(23, 24, 25, 26)
arr2 zip arr3
arr3 zip arr2
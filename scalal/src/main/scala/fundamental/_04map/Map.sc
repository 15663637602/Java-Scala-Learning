// immutable
val map1 = Map("scala" -> 1, "python" -> 2, "java" -> 3)

val map2 = Map(("scala", 1), ("python", 2), ("java", 3))

//get value by key
map1("scala")

// val 是指 引用 不可变
val map3 = collection.mutable.Map("scala" -> 1, "python" -> 2, "java" -> 3)

map3.getOrElse("C#", -1)

//map3("java") = 8
val list1 = List(1, 2, 3)

// below four operations have the same result
val list2 = 0 :: list1
val list3 = list1.::(0)
val list4 = 0 +: list1
val list5 = list1.+:(0)

// append a list
val list6 = List(5,6,7)
val list7 = list1 ++ list6
val list8 = list1 ++: list6
val list9 = list1 ::: list6
val list10 = list6 ++ list1

// mutable
import collection.mutable.ListBuffer
val l1 = ListBuffer(1,2,3)
l1 += 4
l1.append(5)
l1
val l2 = ListBuffer(6,7,8)
// ++ 生成一个新Listbuffer
l1 ++ l2
l1
l1 ++= l2
// :+也是生成一个新Listbuffer
l1 :+ 9
package genericss

// Manifest 用于实例化 泛型数组
class Manifest_Contx


class Meat(val name: String)

class Vegetable(val name: String)

object Main {

  def packageFood[T: Manifest] (food: T*) = {
    val foodPackage = new Array[T](food.length)
    for(i <- 0 until food.length) foodPackage(i) = food(i)
    foodPackage
  }

  def main(args: Array[String]): Unit = {
    val meat1 = new Meat("meat1")
    val meat2 = new Meat("meat2")
    val meat3 = new Meat("meat3")

    val meatPackage = packageFood(meat1, meat2, meat3)

    val veg1 = new Vegetable("veg1")
    val veg2 = new Vegetable("veg2")
    val veg3 = new Vegetable("veg3")
    val vegPackage = packageFood(veg1,veg2,veg3)

    // 这时 泛型是Object
    val mixPackage = packageFood(meat1, veg1)
  }
}
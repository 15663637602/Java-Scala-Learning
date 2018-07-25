package enumerations

class Example {

}

object TrafficLightColor extends Enumeration {
  type TrafficLightColor = Value
  val Red = Value(0, "Stop")
  val Yellow = Value(10)
  val Green = Value("Go")
}

object Margin extends Enumeration {
  type Margin = Value
  val TOP, BOTTOM, LEFT, RIGHT = Value
}

import enumerations.TrafficLightColor._
import enumerations.Margin._

object Example extends App {
  println(BOTTOM, BOTTOM.id)

  def doWhat(color: TrafficLightColor) = {
    if (color == Red) "Stop"
    else if (color == Yellow) "hurry up" else "go"
  }

  def doWhat2(color: TrafficLightColor) = color match {
    case Red => "stop"
    case Yellow => "Hurry up"
    case _ => "go"
  }

  val red = TrafficLightColor(0)
  println(red, red.id)
  println(Yellow)
  println(doWhat(red))
  println(doWhat2(TrafficLightColor.Yellow))

  Margin.values.foreach(v => println(v, v.id))
}

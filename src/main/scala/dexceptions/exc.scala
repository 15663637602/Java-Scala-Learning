package dexceptions

object exc extends App {
  try {
    throw new IllegalArgumentException("x should be negative")
  } catch {
    case e1: ClassCastException => println("ClassCast")
    case e2: IllegalArgumentException => println("Error")
  } finally {
    println("release resources")
  }
}

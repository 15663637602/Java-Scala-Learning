def sum3(x: Double, y: Double, z: Double): Double = x+y+z

def mult3(x: Double, y: Double, z: Double): Double = x*y*z

def min3(x: Double, y: Double, z: Double): Double = x min y min z

def combine3(x: Double, y: Double, z: Double, f:(Double, Double, Double) => Double): Double = f(x, y, z)

combine3(1,2,3, sum3)

def combine32(x: Double, y: Double, z: Double, f:(Double, Double) => Double): Double = f(f(x, y), z)

combine32(1,2,3, (x, y) => x + y)
combine32(1,2,3, _*_)
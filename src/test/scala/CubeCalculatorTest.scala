import org.scalatest.FunSuite
import showtest.CubeCalculator
class CubeCalculatorTest extends FunSuite{

  test("CubeCalculator.cube"){
    assert(CubeCalculator.cube(3) === 237)
  }
}

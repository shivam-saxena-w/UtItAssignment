import com.questionOneTwo.divisionAndFibonacci.LogicFile
import org.scalatest.funsuite.AnyFunSuite

class LogicFileTest extends AnyFunSuite {
  var Logic_file_object = new LogicFile()

//================== Division Test ===================
  test("Test to check division of zero"){
    val num1 = 0
    val num2 = 2
    val res = 0
    assert(Logic_file_object.divisionOf(num1, num2)==res)
  }

  test("Test to check division by zero") {
    assertThrows[ArithmeticException](Logic_file_object.divisionOf(128, 0))
  }

//=================== Fibonacci Test ===================

  test("Test to check fibonacci of zero"){
    val num = 0
    val res = 0
    assert(Logic_file_object.fibonacciOf(num)==res)
  }

  test("Test to check fibonacci "){
    val num = 9
    val res = 34
    assert(Logic_file_object.fibonacciOf(num)==res)
  }

}

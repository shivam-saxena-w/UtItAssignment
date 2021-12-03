package com.knoldus.request

import com.knoldus.models.Employee
import com.knoldus.validator.EmployeeValidator
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.funsuite.AnyFunSuite

class EmployeeExeTest extends AnyFunSuite{
  val employeeValidator = mock[EmployeeValidator]
  val shivam:Employee = new Employee("Shivam","Saxena",22,12000,"Intern","Knoldus","shivam.saxena@gmail.com")
  val userImpl = new EmployeeExe(employeeValidator)

  test("User can be created"){
    when(employeeValidator.employeeIsValid(shivam)) thenReturn(true)
    val result = userImpl.createEmployee(shivam)
    assert(result.isDefined)
  }
  test("User can not be created"){
    when(employeeValidator.employeeIsValid(shivam)) thenReturn(false)
    val result = userImpl.createEmployee(shivam)
    assert(result.isEmpty)
  }
}


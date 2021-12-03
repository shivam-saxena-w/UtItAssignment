package com.knoldus.validator


import com.knoldus.db.CompanyData
import com.knoldus.models.{Company, Employee}
import com.questionOneTwo.emailValidator.EmailValidator
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.funsuite.AnyFunSuite

class EmployeeValidatorTest extends AnyFunSuite{
  val employee = new Employee("Rahul","Soni",22,15000,"Intern","knoldus","rahul.soni@knoldus.com")
  val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")
  val companyRead = mock[CompanyData]
  val emailValidator = mock[EmailValidator]
  val employeeValidator = new EmployeeValidator(companyRead,emailValidator)

  test("Employee should valid"){
    when(companyRead.getCompanyByName(employee.companyName)).thenReturn(Option(knoldusCompany))
    when(emailValidator.emailIsValid(employee.emailId)).thenReturn(true)
    val result = employeeValidator.employeeIsValid(employee)
    assert(result)
  }
  test("employee is not valid bcz of his email is invalid"){
    when(companyRead.getCompanyByName(employee.companyName)).thenReturn(Option(knoldusCompany))
    when(emailValidator.emailIsValid(employee.emailId)).thenReturn(false)
    val result = employeeValidator.employeeIsValid(employee)
    assert(!result)
  }
  test("employee is not valid bcz his company not exist in DB"){
    when(companyRead.getCompanyByName(employee.companyName)).thenReturn(None)
    when(emailValidator.emailIsValid(employee.emailId)).thenReturn(true)
    val result = employeeValidator.employeeIsValid(employee)
    assert(!result)
  }
  test("employee is not valid bcz his company not exist in DB and email is not valid"){
    when(companyRead.getCompanyByName(employee.companyName)).thenReturn(None)
    when(emailValidator.emailIsValid(employee.emailId)).thenReturn(false)
    val result = employeeValidator.employeeIsValid(employee)
    assert(!result)
  }
}


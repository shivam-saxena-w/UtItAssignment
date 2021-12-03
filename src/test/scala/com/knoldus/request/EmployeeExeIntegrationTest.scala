package com.knoldus.request

import com.knoldus.request.EmployeeExe
import com.knoldus.db.CompanyData
import com.knoldus.models.Employee
import com.knoldus.validator.EmployeeValidator
import com.questionOneTwo.emailValidator.EmailValidator
import org.scalatest.funsuite.AnyFunSuite

class EmployeeExeIntegrationTest extends AnyFunSuite{
  val companyName = new CompanyData
  val validateEmail = new EmailValidator
  val employeeValidator = new EmployeeValidator(companyName,validateEmail)

  val employeeExe = new EmployeeExe(employeeValidator)

  test("user can not created bcz company doent exist"){
    val Shivam:Employee = new Employee("Shivam","Saxena",22,12000,"Intern","Google","shivam.saxena@gmail.com")
    val result = employeeExe.createEmployee(Shivam)
    assert(result.isEmpty)
  }

  test("user can not created bcz email is invalid"){
    val Shivam:Employee = new Employee("Shivam","Saxena",22,12000,"Intern","Knoldus","shivam.saxena@gmailcom")
    val result = employeeExe.createEmployee(Shivam)
    assert(result.isEmpty)
  }
  test("user can not created bcz email invalid and company doesnt exist in DB"){
    val Shivam:Employee = new Employee("Shivam","Saxena",22,12000,"Intern","Google","shivam.saxena@gmaicom")
    val result = employeeExe.createEmployee(Shivam)
    assert(result.isEmpty)
  }
  test("user can be created"){
    val Shivam:Employee = new Employee("Shivam","Saxena",22,12000,"Intern","Knoldus","shivam.saxena@gmail.com")
    val result = employeeExe.createEmployee(Shivam)
    assert(result.isDefined)
  }
}


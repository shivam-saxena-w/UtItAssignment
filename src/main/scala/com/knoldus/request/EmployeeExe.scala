package com.knoldus.request
import com.knoldus.validator.EmployeeValidator
import com.knoldus.models.Employee

  class EmployeeExe(employeeValidator: EmployeeValidator) {
    def createEmployee(employee: Employee): Option[String] = {
      if (employeeValidator.employeeIsValid(employee)) Option(employee.emailId)
      else None
    }
  }


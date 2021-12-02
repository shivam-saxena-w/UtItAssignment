package com.knoldus.validator
import com.questionOneTwo.emailValidator.EmailValidator
import com.knoldus.db.CompanyData
import com.knoldus.models.Employee
class EmployeeValidator(companyName: CompanyData, validateEmail: EmailValidator) {

  def employeeIsValid(employee: Employee): Boolean = {

    if(companyName.getCompanyByName(employee.companyName).isDefined && validateEmail.emailIsValid(employee.emailId))
      true
    else
      false
  }
}
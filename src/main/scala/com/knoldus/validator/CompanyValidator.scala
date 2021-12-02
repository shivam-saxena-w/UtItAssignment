package com.knoldus.validator

import com.knoldus.db.CompanyData
import com.knoldus.models.Company
import com.questionOneTwo.emailValidator.EmailValidator

class CompanyValidator(companyName:CompanyData, validateEmail: EmailValidator) {
  def companyIsValid(company: Company): Boolean = {
    if(companyName.getCompanyByName(company.name).isEmpty && validateEmail.emailIsValid(company.emailId)){
      true
    }
    else
      false
  }

}

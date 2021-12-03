package com.knoldus.validator


import com.knoldus.db.CompanyData
import com.knoldus.models.Company
import com.questionOneTwo.emailValidator.EmailValidator
import org.scalatest.funsuite.AnyFunSuite
import org.mockito.MockitoSugar.{mock, when}

class CompanyValidatorTest extends AnyFunSuite{
  val knoldusCompany:Company = Company("Knoldus","knoldus@gmail.com","Noida")
  val companyRead = mock[CompanyData]
  val emailValidator = mock[EmailValidator]
  val companyValidator = new CompanyValidator(companyRead,emailValidator)

  test(" company should valid"){
    when(companyRead.getCompanyByName(knoldusCompany.name)).thenReturn(None)
    when(emailValidator.emailIsValid(knoldusCompany.emailId)).thenReturn(true)
    val result = companyValidator.companyIsValid(knoldusCompany)
    assert(result)
  }
  test("check if company already exists in DB"){
    when(companyRead.getCompanyByName(knoldusCompany.name)).thenReturn(Option(knoldusCompany))
    when(emailValidator.emailIsValid(knoldusCompany.emailId)).thenReturn(true)
    val result = companyValidator.companyIsValid(knoldusCompany)
    assert(!result)
  }

  test("company is invalid as email is not valid"){

    when(companyRead.getCompanyByName(knoldusCompany.name)).thenReturn(None)
    when(emailValidator.emailIsValid(knoldusCompany.emailId)).thenReturn(false)
    val result = companyValidator.companyIsValid(knoldusCompany)
    assert(!result)
  }
  test("Company is invalid as the email id is not valid and it already exists in the DB"){
    when(companyRead.getCompanyByName(knoldusCompany.name)) thenReturn(Option(knoldusCompany))
    when(emailValidator.emailIsValid(knoldusCompany.emailId)) thenReturn(false)
    val result = companyValidator.companyIsValid(knoldusCompany)
    assert(!result)
  }
}

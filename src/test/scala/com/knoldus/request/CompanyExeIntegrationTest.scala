package com.knoldus.request
import com.questionOneTwo.emailValidator.EmailValidator
import com.knoldus.db.CompanyData
import com.knoldus.models.Company
import com.knoldus.validator.CompanyValidator
import org.scalatest.funsuite.AnyFunSuite

class CompanyExeIntegrationTest extends AnyFunSuite{
  val companyName = new CompanyData
  val validateEmail = new EmailValidator
  val companyValidator = new CompanyValidator(companyName,validateEmail)

  test("Company should not be created as already exist in DB"){
    val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")
    val companyImpl = new CompanyExe(companyValidator)
    val result = companyImpl.createCompany(knoldusCompany)
    assert(result.isEmpty)
  }

  test("Company should not be created as email ID is not valid"){
    val ibmCompany: Company = Company("IBM", "IBM@ibmac", "Noida")
    val companyImpl = new CompanyExe(companyValidator)
    val result = companyImpl.createCompany(ibmCompany)
    assert(result.isEmpty)
  }
  test("can not created as email not valid and already exist in DB"){
    val knoldusCompany: Company = Company("Knoldus","knoldus@gmailcom","Noida")
    val companyImpl = new CompanyExe(companyValidator)
    val result = companyImpl.createCompany(knoldusCompany)
    assert(result.isEmpty)
  }
  test("company can be created"){
    val googleCompany: Company = Company("Google", "google@gmail.com", "Gurugram")
    val companyImpl = new CompanyExe(companyValidator)
    val result = companyImpl.createCompany(googleCompany)
    assert(result.isDefined)
  }
}

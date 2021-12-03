package com.knoldus.request

import com.knoldus.models.Company
import com.knoldus.validator.CompanyValidator
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.funsuite.AnyFunSuite

class CompanyExeTest extends AnyFunSuite{
  val companyValidator: CompanyValidator = mock[CompanyValidator]
  val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")

  test("company should be created"){
    val companyImpl = new CompanyExe(companyValidator)
    when(companyValidator.companyIsValid(knoldusCompany)) thenReturn true
    val result = companyImpl.createCompany(knoldusCompany)
    assert(result.isDefined)
  }

  test("company should not be created"){
    val companyImpl = new CompanyExe(companyValidator)
    when(companyValidator.companyIsValid(knoldusCompany)) thenReturn(false)
    val result = companyImpl.createCompany(knoldusCompany)
    assert(result.isEmpty)
  }
}


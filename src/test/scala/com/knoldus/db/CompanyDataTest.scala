package com.knoldus.db
import org.scalatest.funsuite.AnyFunSuite

class CompanyDataTest extends AnyFunSuite{
  val companyDataObj = new CompanyData()

  test("Check if company exists in DB"){
    val comName = "Knoldus"
    val result = companyDataObj.getCompanyByName(comName)
    assert(result.isDefined)
  }

  test("Company should not exist in DB "){
    val comName = "Google"
    val result = companyDataObj.getCompanyByName(comName)
    assert(result.isEmpty)
  }
}
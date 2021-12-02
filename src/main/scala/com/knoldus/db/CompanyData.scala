package com.knoldus.db
import com.knoldus.models.Company
import scala.collection.immutable.HashMap

class CompanyData {
  val knoldusCompany: Company = Company("Knoldus", "knoldus@knoldus.com", "Noida")
  val anotherCompany: Company = Company("AnotherCompany", "AnotherCompany@gmail.com", "Noida")
  val companies: HashMap[String, Company] = HashMap("Knoldus" -> knoldusCompany, "AnotherCompany" -> anotherCompany)
  def getCompanyByName(name: String): Option[Company] = companies.get(name)

}

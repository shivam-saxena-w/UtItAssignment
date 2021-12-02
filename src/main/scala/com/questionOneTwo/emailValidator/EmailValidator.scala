package com.questionOneTwo.emailValidator

class EmailValidator {
  def emailIsValid(emailId: String): Boolean = {
    if("""^([a-zA-Z\d\.-]+)@([a-zA-Z\d-]+)\.(com|net|org|COM|NET|ORG)$""".r.findFirstIn(emailId).isEmpty)
      false
    else
      true
  }
}

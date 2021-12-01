package com.questionOneTwo.emailValidator

class EmailValidator {
  def emailIsValid(emailId: String): Boolean = {
    if("""^([a-zA-Z\d\.-]+)@([a-zA-Z\d-]+)\.(com|COM|net|NET|ORG|org)$""".r.findFirstIn(emailId).isEmpty)
      false
    else
      true
  }
}

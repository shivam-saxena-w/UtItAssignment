import org.scalatest.funsuite.AnyFunSuite
import com.questionOneTwo.emailValidator.EmailValidator

class EmailValidatorTest extends AnyFunSuite {
  var emailObj = new EmailValidator

  test("without name of recipient"){
    assert(!emailObj.emailIsValid("@gmail.com"))
  }

  test("without @ in the email"){
    assert(!emailObj.emailIsValid("John.doe.gmail.com"))
  }

  test("without domain name"){
    assert(!emailObj.emailIsValid("john.doe@"))
  }

  test("other domain name than .com|.net|.org "){
    assert(!emailObj.emailIsValid("john.doe@yahoo.in"))
  }

  test("correct one uppercase"){
    assert(emailObj.emailIsValid("JOHN.DOE@YAHOO.COM"))
  }

  test("correct one lowercase"){
    assert(emailObj.emailIsValid("john.doe@yahoo.com"))
  }

}

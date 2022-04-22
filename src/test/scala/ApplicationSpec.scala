import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class ApplicationSpec extends AnyFlatSpec with should.Matchers {

  behavior of "Account"
  val testAccount = new Account(1, 100)

  it should "be able to deposit money" in {
    testAccount.deposit(100) shouldBe 200
  }

  it should "be able to withdraw enough money" in {
    testAccount.withdraw(50) shouldBe Some(150)
  }

  it should "be able to stop withdraw if there is not enough money" in {
    testAccount.withdraw(500) shouldBe null
  }

  it should "print status of Account" in {
    testAccount.status shouldBe s"Account number 1 has 150 pounds"
  }

  it should "close Account" in {
    testAccount.close shouldBe 0
  }

//  behavior of "Bank"
//  val testAccount1 = new Account(1, 500)
//  val testAccount2 = new Account(2, 100)
//  val testBank= new Bank(Map((testAccount1.id, testAccount1), (testAccount2.id, testAccount2)))
//
//  it should "transfer money from one Account to another Account" in {
//    testBank.transfer(1,2,100)
//    testBank.accounts(1).balance shouldBe 400
//    testBank.accounts(2).balance shouldBe 200
//  }

}

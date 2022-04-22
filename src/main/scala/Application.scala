case class Account(id: Int, var balance: Int) {
  def deposit(value: Int): Int = {
    balance += value
    this.balance
  }

  def withdraw(value: Int): Option[Int] = {
    if (value > balance) {
      println("Not enough funds")
      null
    } else {
      balance -= value
      Some(this.balance)
    }
  }

  def status(): String = {
    s"Account number $id has $balance pounds"
  }

  def close(): Int = {
    balance = 0
    println(s"Account number $id is closed")
    this.balance
  }
}

case class Bank(accounts: Map[Int, Account]) {
  def transfer(idGiver: Int, idReciver: Int, value: Int) : Option[Int] = {
    if (accounts(idGiver).balance < value) {
      println("Not enough funds on first account")
      null
    }
    else {
      accounts(idGiver).balance - value
      val amount = accounts(idReciver).balance + value
      Some(amount)
    }
  }
}

object Application extends App {

  val myAccount = Account(1, 100)
  myAccount.deposit(25)
  println(myAccount.status())
  myAccount.withdraw(50)
  println(myAccount.status())
  myAccount.close()
  println(myAccount.status())

//  val diffAccount = Account(2, 300)
//
//  val myBank = mnbvcb


}

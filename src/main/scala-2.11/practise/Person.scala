package practise

class Person( val firstName : String, val lastName : String) {
  private var newAge : Int = 20
  def age = newAge
  def age_=(n : Int) = {
    newAge = n
  }
}

object testPerson {
  def main(args: Array[String]) {
    val v1 = new Person("Mohammed", "Sameer")
    println(v1.firstName)
    println(v1.lastName)
    println(v1.age)
    v1.age = 25
    println(v1.age)
  }
}

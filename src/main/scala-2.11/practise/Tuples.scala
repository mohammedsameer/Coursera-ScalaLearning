package practise

object testTuples {

  def main(args: Array[String]) {
    val t = ("Mohammed", "Sameer", 30, "1860 Pomar Way")
    println(t._1)
    println(t._2)
    println(t._3)
    println(t._4)
    println("--------")
    val (firstName, lastName, age, address) = t
    println(firstName)
    println(lastName)
    println(age)
    println(address)
    println("--------")
    val myMap = Map("Sameer" -> "San Francisco", "Yash" -> "Boston", "Anupam" -> "Boston")
    myMap.foreach { tuple: (String, String) =>
      val (name, add) = tuple
      println(name + ":" + add)
    }
  }
}

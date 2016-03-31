package practise


class ClassExtensions {
  def addTwo(a: Int, b: Int) : Int = a + b
}

object testClassExtensions {
  //Implicit declaration outside class as it is class extension
  implicit def str2int(s: String) : Int = Integer.parseInt(s)

  def main(args: Array[String]) {
    val v1 = new ClassExtensions
    println(v1.addTwo(1, 2))
    println(v1.addTwo("1", 2))
  }
}
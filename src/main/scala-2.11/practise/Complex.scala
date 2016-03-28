package practise

class Complex(real: Double, imaginary: Double) {
  def re = real
  def img = imaginary
  override def toString() = {
    "Real=>" + re + " Imaginary=>" + img
  }
}

object test {
  def main(args: Array[String]) {
    println("Using properties")
    val v = new Complex(1.5, 2.0)
    println("Real:" + v.re)
    println("Imaginary:" + v.img)

    println("Using toString")
    println(v)
  }
}

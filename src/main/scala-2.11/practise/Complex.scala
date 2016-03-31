package practise

class Complex(val real : Int, val img : Int) {
  def +(that : Complex) : Complex = new Complex(this.real + that.real, this.img + that.img)
  def -(that : Complex) : Complex = new Complex(this.real - that.real, this.img - that.img)
  override def toString = this.real + "+i" + this.img
}

object testComplex {
  def main(args: Array[String]) {
    val v1 = new Complex(5, 4)
    val v2 = new Complex(2, 3)
    println(v1 + v2)
    println(v1 - v2)
  }
}
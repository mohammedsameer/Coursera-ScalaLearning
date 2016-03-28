package practise

class MyGenerics[T] {
  private var contents : T = _
  def set(value : T) =  contents = value
  def get : T = contents
}

object testGenerics {
  def main(args: Array[String]) {
    val v1 = new MyGenerics[Int]
    v1.set(10)
    println(v1.get)
    val v2 = new MyGenerics[String]
    v2.set("Sameer")
    println(v2.get)
  }
}
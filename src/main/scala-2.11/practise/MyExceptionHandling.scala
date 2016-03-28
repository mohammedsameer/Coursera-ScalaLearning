package practise


class ExceptionHandling(val num: Int) {
  if(num < 10) throw new IllegalArgumentException("The number should be 10 or higher")
  println("Input num is:" + num)
}

object ExceptionHandlingTest {
  def main(args: Array[String]) {
    try{
      val v1 = new ExceptionHandling(11)
      val v2 = new ExceptionHandling(9)
    } catch {
      case e : IllegalArgumentException => println("IllegalArgumentException is thrown:" + e.getMessage)
      case e : NumberFormatException => println("NumberFormatException is thrown:" + e.getMessage)
    } finally {
      println("Exceptional handling test complete!")
    }
  }
}

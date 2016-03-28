object sqrtObject {
  /*Newton method of sqrt determination using tail recursion
  * y = 1
  * x = number whose sqrt is to be calculated
  *
  * Steps:
  * Loop until y*y ~= x
  *   a) Compute Quotient x/y=quotient
  *   b) Compute Mean (y+quotient)/2
  *   c) Use mean as new y
  * */
  def sqrt(x: Double): Double = {

    def abs(res:Double): Double = {
      if (res < 0) -res else res
    }
    //Iterates until sqrt(x) determined
    def sqrtItr(y: Double): Double = {
      if (isGoodEnough(y)) y
      else sqrtItr(improve(y))
    }
    //Checks if guess is closest sqrt value
    def isGoodEnough(y: Double) = {
      //Reason: if the remainder is less than
      abs(y * y-x)/x < 0.001
    }
    //Improve the guess
    def improve(y: Double): Double = {
      (y + x / y) / 2
    }

    sqrtItr(1.0)

  }

  //Test
  sqrt(2)
  sqrt(4)
  sqrt(5)
  sqrt(0.000001)
  sqrt(7)
  sqrt(0.1e-20)
  sqrt(1.0e20)
  sqrt(1.0e50)
}

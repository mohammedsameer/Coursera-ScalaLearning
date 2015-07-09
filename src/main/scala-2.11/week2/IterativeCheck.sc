//fixedPoint x=>x/2
object iterativeCheck {

  /**Tolerance constant*/
  val tolerance = 0.0001

  /**
   * Absolute of x
   * @param x, parameter x
   * @return absolute of x
   */
  def abs(x:Double): Double = {
    if(x<0) -x
    else x
  }

  /**
   * Function which returns another function
   * @param f, input function
   * @param x, parameter x
   * @return new function
   */
  def averageDamp(f:Double=>Double)(x:Double) = {
    (x+f(x))/2
  }

  /**
   * Checks if current is closer to expected than next
   * @param curr, parameter current
   * @param next, parameter next
   * @return true is current closer, false otherwise
   */
  def isCloseEnough(curr:Double, next:Double):Boolean ={
     //averaging to avoid unnecessary repeats
     abs((curr - next)/curr)<= tolerance
  }

  /**
   * Iterative function
   * @param f, input function
   * @param firstGuess, firstGuess value
   * @return fixed point number
   */
  def iterativeFun(f:Double=>Double)(firstGuess:Int): Double ={
    def iterate(guess: Double): Double ={
      val next = f(guess)
      //println("curr:" + guess + " next:"+ next)
      //check if curr is within tolerance
      if(isCloseEnough(guess, next)) next
      else iterate(next)
    }

    iterate(firstGuess)
  }

  //Fixed point f(x) = x
  iterativeFun(x=>1+x/2)(1)
  //Sqrt y*y=x, then y=x/y
  //def sqrt(x:Double) = iterativeFun(y=>(y+x/y)/2)(1)
  def sqrt(x:Double) = iterativeFun(averageDamp(y=>x/y))(1)
  sqrt(2)
}
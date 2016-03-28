object factorialObject {

  /**
   * Computes factorial using non-tail recursive function
   * i.e the last call is not simply call to function alone
   * @param x x, whose factorial is to be computed
   * @return factorial value
   */
  def factorial(x:Int):Int = {
    if(x==0) 1
    else x * factorial(x-1)
  }

  //Test
  factorial(4)
  factorial(12)
  /**
   * Computes factorial using tail recursive function
   * i.e the last call is  simply call to function alone
   * @param x x, whose factorial is to be computed
   * @return factorial value
   */
  def factorialTail(x:Int):Int ={
    def loop(acc:Int, x:Int):Int = {
      if(x==0) acc;
      else loop(acc * x, x-1)
    }
    loop(1,x)
  }
  //Test
  factorialTail(3)
  factorialTail(4)
}
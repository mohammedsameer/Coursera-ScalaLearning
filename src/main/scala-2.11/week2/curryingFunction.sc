object curryingFunctionObject {

  /**
   * Generic implementation for sum and product function
   * @param f function
   * @param combine combining function
   * @param unit base value, 0 for sum & 1 for product
   * @param a parameter a
   * @param b parameter b
   * @return
   */
  def mapReduce(f:Int=>Int, combine:(Int, Int)=>Int, unit:Int)(a:Int, b:Int):Int = {
    if(a>b) unit
    else combine(f(a), mapReduce(f,combine,unit)(a+1, b))
  }

  /**
   * Factorial in terms of product
   * @param a parameter a
   * @return factorial of a
   */
  def factorial(a:Int):Int = product(a=>a)(1, a)

  //  def product(f:Int=>Int)(a:Int, b:Int):Int ={
  //    if(a>b) 1
  //    else f(a) * product(f)(a+1,b)
  //  }

  //  def sum(f:Int=>Int)(a: Int, b:Int):Int = {
  //    if(a>b) 0
  //    else f(a) + sum(f)(a+1, b)
  //  }

  /**
   * Product redefined using generic
   * @param f, product function
   * @param a, parameter a
   * @param b, parameter b
   * @return product of a & b
   */
  def product(f:Int=>Int)(a:Int, b:Int):Int = mapReduce(f,(a,b)=>a*b,1)(a,b)

  /**
   * Sum redefined using generic
   * @param f, sum function
   * @param a, parameter a
   * @param b, parameter b
   * @return sum of and b
   */
  def sum(f:Int=>Int)(a: Int, b:Int):Int = mapReduce(f,(a,b)=>a+b,0)(a,b)

  //Test
  product(a=>a*a)(1,2)
  sum(a=>a)(1,5)

  //Test factorial expressed a product
  factorial(4)
}
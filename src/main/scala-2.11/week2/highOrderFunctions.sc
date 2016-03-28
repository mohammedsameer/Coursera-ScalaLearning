object highOrderFunctionObject {

  /**
   * Id function
   * @param a, parameter a
   * @return a
   */
  def id(a:Int): Int = {
    a
  }

  /**
   * Sum of ints from a to b, where a<=b
   * @param a, parameter a
   * @param b, parameter b
   * @return sum ints from a to b
   */
  def sumInts(a:Int, b:Int): Int = {
    if(a>b)  0
    else id(a) + sumInts(a+1, b)
  }

  /**
   * Square function
   * @param a
   * @return square of a
   */
  def square(a:Int): Int = {
    a*a
  }

  /**
   * Sum of sqaures from a to b
   * @param a, parameter a
   * @param b, parameter b
   * @return sum of squares from a to b
   */
  def sumSquare(a:Int, b:Int): Int ={
    if(a>b) 0
    else square(a) + sumSquare(a+1, b)
  }

  /**
   * Cube function
   * @param a, parameter a
   * @return cube of a
   */
  def cube(a:Int):Int={
    a*a*a
  }

  /**
   * Sum of cubes from a to b, where a<=b
   * @param a, parameter a
   * @param b, parameter b
   * @return sum of cubes from a to b
   */
  def sumCubes(a:Int, b:Int): Int = {
    if(a>b)  0
    else cube(a)+ sumCubes(a+1, b)
  }

  /**
   * Factorial of a
   * @param a, parameter a
   * @return factorial of a
   */
  def factorial(a:Int):Int = {
    if(a<=1) 1
    else a * factorial(a-1)
  }

  /**
   * Calculate sum of factorials between a to b, where a<=b
   * @param a, parameter a
   * @param b, parameter b
   * @return sum of factorials from a to b
   */
  def sumFactorial(a:Int, b:Int): Int = {
    if(a>b) 0
    else factorial(a) + sumFactorial(a+1, b)
  }


  //Test
  sumInts(1,5)
  sumCubes(1,3)
  sumFactorial(1,4)
  sumSquare(1,6)


  /**
   * Higher order function i.e. a function which takes function as parameter
   * @param f, high order function
   * @param a, parameter a
   * @param b, parameter b
   * @return sum/cube of ints from a to b
   */
  def sumOld(f:Int=>Int, a:Int, b:Int): Int = {
    if(a>b) 0
    else f(a) + sumOld(f, a+1, b)
  }


  //Test
  sumOld(id, 1, 5)
  sumOld(cube, 1, 3)
  sumOld(square, 1, 6)

  //Test with anonymous definition
  sumOld((a:Int)=>a, 1, 5)
  sumOld(a=>a, 1, 5) //Type optional
  sumOld((a:Int)=>a*a*a, 1, 3)
  sumOld(a=>a*a*a, 1, 3) //Type optional
  sumOld((a:Int)=>a*a, 1, 6)
  sumOld(a:=>a*a, 1, 6) //Type optional

  //Note the separation between function and parameter types
  /**
   * Tail Recursive High order function
   * @param f, high order function
   * @param a, parameter a
   * @param b, parameter b
   * @return sum/product of ints from a to b
   */
  def sumNew(f:Int=>Int) (a:Int, b:Int): Int = {
    def loop(a:Int, acc:Int): Int = {
      if (a>b) acc
      else loop(a+1, f(a)+acc)
    }
    loop(a, 0)
  }

  //Test
  sumNew(id)(1, 5)
  sumNew(cube)(1, 3)
  sumNew(sqaure)(1, 6)
}
object curryingPractiseObject {

  /**
   * Adds params a & b
   * @param a, parameter a
   * @param b, parameter b
   * @return Sum of a & b
   */
  def add(a:Int, b:Int): Int = { a+b }

  /**
   * Subtracts params a & b
   * @param a, parameter a
   * @param b, parameter b
   * @return Difference of a & b
   */
  def subtract(a:Int, b:Int): Int = { a-b }

  /**
   * Divide params a & b
   * @param a, parameter a
   * @param b, parameter b
   * @return Quotient of a & b
   */
  def divide(a:Int, b:Int): Int = {if(b==0) 1 else a/b}

  /**
   * Generic represents of sum , diff & divide  of params, a & b
   * @param f, sum/diff/divide function
   * @param a, parameter a
   * @param b, parameter b
   * @return sum/diff of a & b
   */
  def generic(f:(Int,Int)=>Int)(a:Int,b:Int): Int = {
     f(a,b)
  }

  //Test
  add(1,3)
  subtract(3,1)
  divide(4,2)
  generic((a,b)=>a+b)(1, 3)
  generic((a,b)=>a-b)(3, 1)
  generic((a,b)=>if(b==0) 1 else a/b)(4,2)
}
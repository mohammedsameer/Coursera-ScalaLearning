object gcdObject {

  /**
   * Euclids gcd algorithm
   * @param a, integer a
   * @param b, integer b
   * @return gcd of a & b
   */
  def gcd(a:Int, b:Int):Int = {
    if(b==0) a
    else {
      println("a "+ a + " b " + b + " a%b " + a%b )
      gcd(b, a%b)
    }
  }

// Test
//  gcd(7,21)
//  gcd(12, 42)
  gcd(2, 4)
}
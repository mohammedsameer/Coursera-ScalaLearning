object rationals {
  class Rational(n:Int, d:Int) {

    /** Used to check precondition */
    require(d!=0, "Denominator zero is not permitted")

    /**
     * Rational Constructor
     * @param n, numerator
     */
    def this(n:Int) = {
      this(n,1)
    }

    //Only private & used within the class
    /**
     * Computes gcd of a & b
     * @param a, parameter a
     * @param b, parameter b
     * @return gcd of a & b
     */
    private def gcd(a:Int, b:Int) :Int = {
      if(b==0) a
      else gcd(b, a%b)
    }

    /** Numerator & Denominator val assignments*/
    val num = n/gcd(n,d)
    val den = d/gcd(n,d)

    /**
     * Add (+) function defined using operator
     * @param that, rational number
     * @return sum of this & that rational
     */
    def + (that:Rational):Rational = {
      new Rational(this.num*that.den + that.num * this.den, this.den * that.den)
    }

    /**
     * Negate (unary-) of this
     * @return negated rational number
     */
    def unary_- :Rational= {
      new Rational(-this.num, this.den)
    }

    /**
     * Difference (-) function defined using operator
     * @param that, rational number
     * @return difference of this and that
     */
    def  - (that:Rational):Rational = {
      //same as adding with negated number
      this + -that
    }

    /**
     * Product (*) function defined using operator
     * @param that, rational number
     * @return product of this & that
     */
    def * (that:Rational):Rational = {
      new Rational(this.num*that.num, this.den*that.den)
    }

    /**
     * Less than (<) function defined using operator
     * @param that, rational number
     * @return, checks this < that
     */
    def < (that:Rational): Boolean = {
      this.num*that.den < that.num*this.den
    }

    /**
     * Max between this & that
     * @param that, rational number
     * @return max of this & that
     */
    def max(that:Rational): Rational = {
      if(this < that) that else this
    }

    /**
     * Overrides definition of toString to display rational number
     * @return
     */
    override def toString():String = {
      this.num + "/" + this.den
    }
  }

//Add rational outside class type (Old way of doing outside class)
//  def addRational(r:Rational, s:Rational) : Rational = {
//    new Rational(r.num*s.den + s.num*r.den, r.den*s.den)
//  }
//  def makeString(r:Rational):String = {
//    r.num + "/" + r.den
//  }

  //Test
  val rational1 = new Rational(1,3)
  val rational2 = new Rational(5,7)
  val rational3 = new Rational(3,2)

  //Add
 //makeString(addRational(rational1, rational2))
  rational1 + rational2

  //Negative
  -rational1

  //Subtract
  rational1 - rational2 - rational3

  //Multiply
  rational1 * rational2

  //Less
  rational1 < rational2

  //Max
  rational1 max rational2
}



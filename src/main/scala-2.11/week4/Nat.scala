package week4

//Peano numbers
/**
 * Abstract Nat(n >= 0) class
 */
abstract class Nat {

  def isZero: Boolean
  def predecessor:  Nat
  def successor: Nat
  def + (that:Nat): Nat
  def - (that:Nat): Nat
}

/**
 * Singleton zero object
 */
object Zero extends Nat {

  /**
   * Zero is always zero
   * @return true
   */
  def isZero: Boolean = true

  /**
   * Zero predecessor is not natural number
   * @return exception
   */
  def predecessor: Nat = throw new NoSuchElementException("n < 0 not natural")

  /**
   * Zero successor is simply successor of this
   * @return successor
   */
  def successor: Nat =  new Successor(this)

  /**
   * Zero + that = that
   * @param that, that nat
   * @return that
   */
  def + (that:Nat): Nat = that

  /**
   * Zero - that
   * @param that, that nat
   * @return Zero, if that is Zero, exception otherwise
   */
  def - (that:Nat): Nat = {
    if(that.isZero) that
    else throw new NoSuchElementException("n < 0 not supported")
  }

}

/**
 * Nat successor
 * @param n, n is the predecessor of current element
 */
class Successor(n:Nat) extends Nat {

  /**
   * Successor is not Zero
   * @return false
   */
  def isZero: Boolean = false

  /**
   * Predecessor is n
   * @return, n nat
   */
  def predecessor: Nat = n

  /**
   * Successor of this
   * @return successor
   */
  def successor: Nat =  new Successor(this)

  /**
   * this + that, but n is this is predecessor
   * therefore Successor(n + that)
   * @param that nat
   * @return sum of this + that
   */
  def + (that:Nat): Nat = new Successor(n + that)

  /**
   * this - that, which can be reduced to n - that.predecessor
   * i.e -1 on both elements, but that can be zero, so check
   * @param that nat
   * @return this - that
   */
  def - (that:Nat): Nat = {
    if(that.isZero) n
    else n - that.predecessor
  }
}
import week4._

object nth {

  /**
   * Nth element of list
   * @param n, nth index
   * @param l, list
   * @tparam T, type T
   * @return
   */
  def nth[T](n:Int, l:ConsList[T]): T= {
    if(l.isEmpty) throw new IndexOutOfBoundsException("n<0")
    if(n==0) l.head
    else nth(n-1, l.tail)
  }

  //A list with 3 parameters
  val list = new Cons[Int](1, new Cons[Int](2, new Cons[Int](3, new Nil[Int])))
  nth(2, list)
  nth(-1, list)
}
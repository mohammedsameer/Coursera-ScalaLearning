package week4

/**
 * ConsList
 * @tparam T, generic type T
 */
trait ConsList[T] {
  def isEmpty: Boolean
  def head: T
  def tail: ConsList[T]
}

/**
 * Cons cell
 * @param head
 * @param tail
 * @tparam T, generic type T
 */
class Cons[T](val head: T, val tail: ConsList[T]) extends ConsList[T] {
  def isEmpty: Boolean = false
}

/**
 * Nil cell
 * @tparam T, generic type T
 */
class Nil[T] extends ConsList[T] {
  def isEmpty: Boolean = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}

/**
 * List object using consList to define
 * list(), list(1), list(1,2)
 */
object list {

  def apply[T]:ConsList[T] =  new Nil[T]

  def apply[T](x:T):ConsList[T] =  new Cons[T](x, new Nil[T])

  def apply[T](x:T, y:T):ConsList[T] =  new Cons[T](x, new Cons[T](y, new Nil[T]))
}

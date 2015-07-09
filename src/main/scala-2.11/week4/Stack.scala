package week4

/**
 * Stack for generic type T
 * @tparam T
 */
class Stack[T] {
  var elems: List[T] = Nil

  /**
   * Push elements to stack
   * @param e
   */
  def push(e: T) = {
    elems = e :: elems
  }

  /**
   * Top element of stack
   */
  def top: T = {
    elems.head
  }

  /**
   * Pop element from stack
   */
  def pop = {
    elems = elems.tail
  }

}

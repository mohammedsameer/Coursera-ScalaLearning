import week4._

object practise {
  //Test basic list operations
  var l1  = List(1)
  l1 = 2 :: l1
  //Returns top element
  l1.head
  //Returns list-head i.e. list without head element
  l1.tail
  //Test Stack
  var stack = new Stack[Int]
  //Stack empty []
  stack.push(1)
  stack.push(2)
  //Stack non-empty [2,1]
  stack.top
  stack.pop
  //Stack non-empty [1]
  stack.top
  //Lecture 4.1 test
  list()
  list(1)
  list(1,2)

  /**
   * Pattern matching based evaluation
   * of expression
   * @param e, expression
   * @return result
   */
  def eval(e:Expr):Int = e match {
    case Number(x) => x
    case Sum(e1, e2) => eval(e1) + eval(e2)
  }
  //Test
  eval(Number(2))
  eval(Sum(Number(5),Number(9)))

  /**
   * Show the contents of expression
   * @param e, expression
   * @return contents of expression
   */
  def show(e:Expr):String = e match {
    case Number(x) => x.toString
    case Sum(l, r) => show(l) + "+" + show(r)
  }
  //Test
  show(Sum(Number(5),Number(9)))

}
package practise

trait Parent {
  def isSimilar(x: Any) : Boolean
}

case class Child(x: Int) extends Parent {
  def isSimilar(m: Any) : Boolean = {
    m.isInstanceOf[Child] &&
    m.asInstanceOf[Child].x == x
  }
}

class UpperBound {
  def findSimilar[T <: Parent](e : T, l : List[T]) : Boolean = {
    if (l.isEmpty) false
    else if (e.isSimilar(l.head)) true
    else e.isSimilar(findSimilar[T](e, l.tail))
  }
}

object testBound {
  def main(args: Array[String]) {
    val v1 = new UpperBound()
    val l1 : List[Child] = List(Child(1), Child(2), Child(3))
    println(v1.findSimilar(Child(1), l1))
    println(v1.findSimilar(Child(5), l1))
  }
}

package practise

class HighOrderFun {
  def addList(list:List[Int], square:(Int)=>Int) = {
     var sum = 0
     list.foreach {
      sum += square(_)
    }
    println("Sum of all squares:" + sum)
  }
}

object testHighOrderFun {
  def main(args: Array[String]) {
    val l = List(1, 2, 3, 4, 5)
    val v = new HighOrderFun()
    v.addList(l, (a:Int)=>a*a)
  }
}
/* Case class */
abstract class Expr
case class Var(name : String) extends Expr
case class Number(name : Int) extends Expr
case class UnOp(opr : String, arg : Expr) extends Expr
case class BinaryOp(opr : String, left : Expr, right : Expr) extends Expr

val v1 = Var("sameer")
println(v1)
println(v1.name)
val v2 = BinaryOp("+", Number(1), Number(2))
println(v2)
println(v2.left)
println(v2.right)

/* Pattern matching */
def patternMatch(e : Expr) = e match {
  case Var(name) => println("I am a var class")
  case Number(name) => println("I am a number class")
  case UnOp(opr, arg) => println("I am a UnOp class")
  case BinaryOp(opr, left, right) => println("I am a BinaryOp class")
  case _=> println("Unknown expression")
}

patternMatch(Number(1))
patternMatch(BinaryOp("+", Number(1), Number(2)))
patternMatch(UnOp("+", Number(1)))
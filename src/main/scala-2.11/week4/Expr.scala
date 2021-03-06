package week4
//
///**
// * Expression trait
// */
//trait Expr {
//
//  def isNumber: Boolean
//
//  def isSum: Boolean
//
//  def numValue: Int
//
//  def leftOp: Expr
//
//  def rightOp: Expr
//}
//
///**
// * Numeric val
// * @param n, number n
// */
//class Number(n: Int) extends Expr {
//  def isNumber: Boolean = true
//
//  def isSum: Boolean = false
//  def numValue: Int = n
//
//  def leftOp: Expr = throw new NoSuchElementException("Number.leftOp")
//
//  def rightOp: Expr = throw new NoSuchElementException("Number.rightOp")
//}
//
///**
// * Sum of e1 & e2
// * @param e1, expr e1
// * @param e2, expr e2
// */
// class Sum(e1: Expr, e2: Expr) extends Expr {
//  def isNumber: Boolean = false
//
//  def isSum: Boolean = true
//  def numValue: Int = throw new NoSuchElementException("Sum.numValue")
//
//  def leftOp: Expr = e1
//
//  def rightOp: Expr = e2
//}


trait Expr
case class Number(n:Int) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr

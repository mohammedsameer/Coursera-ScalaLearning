package practise

trait Ord {
  def < (that: Any): Boolean
  def <= (that: Any): Boolean = {(this == that) || (this < that)}
  def > (that: Any): Boolean = {!(this <= that)}
  def >= (that: Any): Boolean = {!(this < that)}
}


class MyDate(y: Int, m: Int, d: Int) extends Ord {
  def year = y
  def month = m
  def day = d

  override def <(that : Any): Boolean = {
    if(!that.isInstanceOf[MyDate])
      sys.error("Cannot compare non-Date type")
      val other = that.asInstanceOf[MyDate]
      other.year > year || (other.year == year) && (other.month > month || (other.month == month && other.day > day))
  }

  override def toString(): String = {"Year:" + year + " Month:" + month + " Day:" + d}
  override def equals(that: Any): Boolean = { that.isInstanceOf[MyDate] &&
    { val other = that.asInstanceOf[MyDate]
      year == other.year && month == other.month && day == other.day}
    }
}

object testMyDateTrait {
  def main(args: Array[String]) {
    val d1 = new MyDate(2010, 1, 1)
    val d2 = new MyDate(2011, 1, 1)
    if(d1 < d2)
      println("d1 < d2")
    else
       println("d1 > d2")
  }
}



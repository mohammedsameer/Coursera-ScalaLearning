package practise

class Color(val r : Int, val g : Int, val b : Int )
case class Red(v: Int) extends Color(v, 0, 0)
case class Green(v: Int) extends Color(0, v, 0)
case class Blue(v: Int) extends Color(0, 0, v)

object ColorTest {
  def printColor(c : Color) = c match {
    case Red(v) => println("Red color: " + v)
    case Green(v) => println("Green color: " + v)
    case Blue(v) => println("Blue color: " + v)
    case col : Color => {print("R:" + col.r + ", ")
                         print("G:" + col.g + ", ")
                         println("B:" + col.b)}
    case _ => println("Unknown color")
  }

  def main(args: Array[String]) {
    printColor(Red(100))
    printColor(Green(200))
    printColor(Blue(300))
    printColor(new Color(100, 200, 300))
    printColor(null)
  }
}


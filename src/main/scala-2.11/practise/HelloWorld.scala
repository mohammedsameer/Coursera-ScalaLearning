package practise

object HelloWorld {
  def main (args: Array[String]) {
    var greeting = ""
    args.foreach(arg => greeting += arg + " ")
    println(greeting)
  }
}

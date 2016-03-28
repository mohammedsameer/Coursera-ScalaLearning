package practise


object Timer {

  def oncePerSec(callback: () => Unit): Unit = {
    while(true) { callback(); Thread sleep 1000}
  }

  def timeflies(): Unit = {
    println("Time flies")
  }

  def main (args: Array[String]) {
    oncePerSec(timeflies)
  }

}

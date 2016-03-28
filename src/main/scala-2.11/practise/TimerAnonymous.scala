package practise


object TimerAnonymous {

  def oncePerSec(callback: () => Unit): Unit = {
    while(true) {callback(); Thread sleep 1000}
  }

  def main(args: Array[String]) {
    oncePerSec(()=>{println("Time flies")})
  }

}

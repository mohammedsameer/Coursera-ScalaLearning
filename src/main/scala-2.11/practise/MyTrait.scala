package practise


abstract class Human {
  def schedule() = { println("Human schedule") }
}

trait Student extends Human {
  override def schedule() = { println("Student schedule") }
  def learn() = { println("Student learning") }
}

trait Worker extends Human {
  override def schedule() = { println("Worker schedule") }
  def work() = { println("Worker working") }
}

//Test
object CollegeStudent extends Worker with Student {
  def main(args: Array[String]) {
    schedule()
  }
}

object CollegeWorker extends Student with Worker {
  def main(args: Array[String]) {
    schedule()
  }
}
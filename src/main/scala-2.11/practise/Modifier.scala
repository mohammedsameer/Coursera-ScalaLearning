package practise

abstract class AbstractModifier(name : String) {
  var myName = name
  def show(arg:Any)
}

class Modifier(firstName : String, lastName : String, name: String) extends AbstractModifier(name) {
  private[practise] var ssn = "111-11-11-11"
  def getName() = show(firstName + " " + lastName)
  def getAge() = {
    import Math._
    show(round((random() * 10)))
  }
  override def show(arg:Any) = println(arg)
}

object testModifier {
  def main(args: Array[String]) {
    val v1 = new Modifier("Mohammed", "Sameer", "Child")
    v1.getName()
    v1.getAge()
    println(v1.ssn)
  }
}
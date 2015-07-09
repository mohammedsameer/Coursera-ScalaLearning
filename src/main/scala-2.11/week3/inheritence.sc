object inheritence {

  /**
   * Parent class with two functions
   */
  class parent {
    def fun1 = 1
    def fun2 = 2
  }
  /**
   * Child class overriding parents two functions
   */
  class child extends  parent {
    override def fun1 = 3
    override def fun2 = 4
  }
  val children = new child();
  children.fun1
  children.fun2
}
object intsets {
  /**
   * Abstract class intSets
   */
   abstract class IntSets {
    /**
     * Abstract contains function
     * @param x, parameter x
     * @return
     */
    def contains(x:Int): Boolean
    /**
     * Abstract include function
     * @param x, parameter x
     * @return
     */
    def incl(x:Int) : IntSets
    /**
     * Abstract union function
     * @param other, other integer sets
     * @return
     */
    def union(other:IntSets): IntSets
  }
  /**
   * Singleton object empty which constructs empty tree
   */
  object Empty extends IntSets {
    /**
     * Checks if element x is contained in empty tree
     * @param x, parameter x
     * @return true if present, false otherwise
     */
    def contains(x:Int): Boolean = false

    /**
     * Include an element x in empty tree
     * @param x, parameter x
     * @return this tree and new included element
     */
    def incl(x:Int):IntSets = new NonEmpty(x, Empty,  Empty)

    /**
     * Unions other tree with empty tree
     * @param other, other integer sets
     * @return union of this & other tree
     */
    def union(other:IntSets):IntSets = other

    /**
     * Overrides toString function
     * @return
     */
    override def toString = "."

  }

  /**
   * NonEmpty class which constructs non empty tree
   * @param elem, current element
   * @param left, left subtree
   * @param right, right subtree
   */
  class NonEmpty(elem:Int, left:IntSets, right:IntSets) extends IntSets {

    /**
     * Checks if element is contained in non-empty tree
     * @param x, parameter x
     * @return true if present, false otherwise
     */
    def contains(x:Int): Boolean = {
      if(x<elem) left contains x
      else if (x>elem) right contains x
      else true
    }

    /**
     * Include an element x  with non empty tree
     * @param x, parameter x
     * @return this tree and new included element
     */
    def incl(x:Int): IntSets = {
      if(x<elem) new NonEmpty(elem, left incl x, right)
      else if (x>elem) new NonEmpty(elem, left, right incl x)
      else this
    }

    /**
     * Unions other tree with empty tree
     * @param other, other integer sets
     * @return union of this & other tree
     */
    def union(other:IntSets): IntSets ={
      ((left union right) union other) incl elem
    }


    /**
     * Overrides toString function
     * @return
     */
    override def toString = "{" + this.left + elem + this.right + "}"
  }


  //Tree Test
  val t1 = new NonEmpty(8, Empty, Empty)
  t1 incl 9
  val t2 = new NonEmpty(7, Empty, Empty)
  val t3 = new NonEmpty(3, Empty, Empty)
  t2 union t3 union t1
  // Covariant test (Lecture 4.2)
  val a: Array[NonEmpty] = Array(new NonEmpty(1, Empty, Empty))
  //Error in following line. In scala array is non variant
  // val b: Array[IntSets] = a
  // b(0) = Empty
  // val r: NonEmpty = a(0)
}
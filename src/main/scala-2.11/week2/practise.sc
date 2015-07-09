object practise {

  /** Set alias*/
  type Set = Int => Boolean

  /**mySetOld of type Int=>Boolean*/
  def mySetOld:Int=>Boolean = {
    x => Array(0,1,1,2,3,5) contains x
  }

  /**mySet of fibonacci using alias*/
  def mySet1:Set ={
    x => Array(0,1,1,2,3,5,-79) contains x
  }

  /**mySet of odd using alias*/
  def mySet2:Set ={
    x => Array(1,3,5,7) contains x
  }

  /**
   * Union of two sets
   * @param s, set S
   * @param t, set T
   * @return union of s & t
   */
  def union(s:Set, t:Set):Set ={
    elem =>s(elem) || t(elem)
  }

  /**
   * Intersect of two sets
   * @param s, set S
   * @param t, set T
   * @return intersect of s & t
   */
  def intersect(s:Set, t:Set):Set ={
    elem =>s(elem) && t(elem)
  }

  /**
   * Diff of two sets
   * @param s, set S
   * @param t, set T
   * @return diff of s & t
   */
  def diff(s:Set, t:Set):Set ={
    elem =>s(elem) && !t(elem)
  }

  /**
   * Filter of two sets
   * @param s, set S
   * @param p, predicate p
   * @return filter of s & p
   */
  def filter(s:Set, p:Set):Set ={
    intersect(s,p)
  }

  /**
   * Checks if the predicate holds good for
   * all elements of set
   * @param s, set s
   * @param p, predicate p p (x=> x >= -50 && x <= 50)
   * @return true if all elements satisfy predicate, false otherwise
   */
  def forall(s: Set, p: Int => Boolean): Boolean = {
    def iter(a: Int): Boolean = {
      if (s(a) && !p(a)) false
      else if (a > 1000) true
      else iter(a+1)
    }
    iter(-1000)
  }

  /**
   * Checks if at least one element in set
   * satisfies predicate
   * @param s, set s
   * @param p, predicate p (x=> x >= -50 && x <= 50)
   * @return true if at least one element in s satisfies predicate, false otherwise
   */
  def exists(s: Set, p: Int => Boolean): Boolean  ={
    !forall(s, a => !p(a))
  }

  /**
   * Maps each element of s using function f
   * @param s, set s
   * @param f, mapping function
   * @return returns mapped set
   */
  def map(s: Set, f: Int => Int): Set ={
    elem => exists(s, x=>f(x)==elem)
  }

  //Test
  mySetOld(3)
  mySet1(4)
  mySet2(4)
  //Note: In above calls to mySet no param passed at function level
  //Union test
  union(mySet1,mySet2)(5)
  union(mySet1,mySet2)(11)
  //Intersect test
  intersect(mySet1,mySet2)(1)
  intersect(mySet1,mySet2)(7)
  //Difference test
  diff(mySet1,mySet2)(0)
  diff(mySet1,mySet2)(7)
  //Filter test
  filter(mySet1,mySet2)(1)
  filter(mySet1,mySet2)(4)
  //Forall test (Unfortunately, we don't have access to elements of set s
  //hence we loop through bounds & check by looping all elements from
  //-bound to +bound)
  forall(mySet1, x=> x >= -50 && x <= 50)
  //Exists test E.g:
  //if say s{1} then if(s(a) && !p(a)) holds good therefore returns false, & !false is true
  //if say s{-71} then if(s(a) && !p(a)) never holds good, therefore returns true, & !true is false
  exists(mySet1, x=> x >= -50 && x <= 50)
  //Map test E.g:
  //s{1} transforms into s{2}
  //E.g
  // 4 is true, because s{2} gets mapped to s{4}
  // 15 is false, because there is no element in s such that a=>f(a)==15
  map(mySet1, x=>x*2)(4)
  map(mySet1, x=>x*2)(15)
}
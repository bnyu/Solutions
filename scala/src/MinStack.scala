import scala.collection.mutable

/** 155. Min Stack
  * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
  * push(x) -- Push element x onto stack.
  * pop() -- Removes the element on top of the stack.
  * top() -- Get the top element.
  * getMin() -- Retrieve the minimum element in the stack.
  */
class MinStack {
  private var allStack = new mutable.MutableList[Int]
  private var minStack = new mutable.MutableList[Int]

  def push(x: Int) {
    if (minStack.isEmpty || x <= minStack.last)
      minStack += x
    allStack += x
  }

  def pop() {
    if (allStack.nonEmpty) {
      val x = allStack.last
      if (minStack.last == x)
        minStack = minStack.dropRight(1)
      allStack = allStack.dropRight(1)
    }
  }

  def top(): Int = {
    if (allStack.nonEmpty) {
      allStack.last
    } else 0
  }

  def getMin(): Int = {
    if (minStack.nonEmpty)
      minStack.last
    else 0
  }
}

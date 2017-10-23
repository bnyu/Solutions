/** 134. Gas Station
  * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
  * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
  * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
  * Note: The solution is guaranteed to be unique.
  */
object GasStation {
  def canCompleteCircuit(gas: Array[Int], cost: Array[Int]): Int = {
    var index = -1
    val num = gas.length
    if (num > 0) {
      for (start <- 0 until num if index == -1) {
        var remain = 0
        for (i <- start until num if remain >= 0) {
          remain += gas(i)
          remain -= cost(i)
        }
        for (i <- 0 until start if remain >= 0) {
          remain += gas(i)
          remain -= cost(i)
        }
        if (remain >= 0)
          index = start
      }
    }
    index
  }
}


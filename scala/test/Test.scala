object Test {
  def main(arg: Array[String]) {
    val list = List(new Interval(1, 4), new Interval(2, 3))
    val ans = Solution056.merge(list)
    print(ans)
  }
}

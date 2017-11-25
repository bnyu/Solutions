object Test {
  def main(arg: Array[String]) {
    val list = List(new Interval(1, 4), new Interval(1, 5))
    Solution056.merge(list)
  }
}

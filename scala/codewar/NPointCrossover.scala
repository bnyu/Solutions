import scala.annotation.tailrec

/**
  * In genetic algorithms, a crossover allows 2 chromosomes to exchange part of their genes.
  */
object NPointCrossover {
  def crossover[T](ns: List[Int], xs: List[T], ys: List[T]): (List[T], List[T]) = {
    val indexes = (List(0) ++ ns ++ List(xs.size)).sorted.distinct
    if (indexes.size < 2) (xs, ys)
    else cross(indexes, Nil, Nil, xs, ys)
  }

  @tailrec
  def cross[T](indexes: List[Int], crossedX: List[T], crossedY: List[T], uncrossedX: List[T], uncrossedY: List[T]): (List[T], List[T]) = {
    val index = indexes.tail.head - indexes.head
    val (xl, ys) = uncrossedX.splitAt(index)
    val (yl, xs) = uncrossedY.splitAt(index)
    if (indexes.size > 2)
      cross(indexes.tail, crossedX ++ xl, crossedY ++ yl, xs, ys)
    else (crossedX ++ xl, crossedY ++ yl)
  }
}

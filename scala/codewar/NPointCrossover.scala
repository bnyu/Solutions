import scala.annotation.tailrec

/**
  * In genetic algorithms, a crossover allows 2 chromosomes to exchange part of their genes.
  */
object NPointCrossover {
  def crossover[T](ns: List[Int], xs: List[T], ys: List[T]): (List[T], List[T]) = {
    val indexes = (List(0) ++ ns ++ List(xs.size)).distinct.sorted
    cross(indexes, Nil, Nil, xs, ys)
  }

  @tailrec
  def cross[T](indexes: List[Int], crossedX: List[T], crossedY: List[T], uncrossedX: List[T], uncrossedY: List[T]): (List[T], List[T]) = {
    val index = indexes.tail.head - indexes.head
    val xs = uncrossedY.drop(index)
    val ys = uncrossedX.drop(index)
    val xl = crossedX ++ uncrossedX.take(index)
    val yl = crossedY ++ uncrossedY.take(index)
    if (indexes.size > 2)
      cross(indexes.tail, xl, yl, xs, ys)
    else (xl, yl)
  }
}


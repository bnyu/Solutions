/**
  * Compute the complex logarithm at any given complex number, accurate to at least 1 in 1e-12.
  * The imaginary part should be inside the interval (−π, π] (i.e if the imaginary part is exactly π, keep it as is).
  */
object Logger {
  def log(complex: Array[Double]): Array[Double] = {
    val re = complex(0)
    val im = complex(1)
    val model = math.sqrt(re * re + im * im)
    if (model == 0) throw new ArithmeticException("")
    val angle = if (im == 0 && re < 0) math.acos(-1) else math.asin(im / model)
    Array(math.log(model), angle)
  }
}

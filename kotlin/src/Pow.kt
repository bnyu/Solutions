/**
 * 50. Pow(x, n)
 * Implement pow(x, n).
 */
class Pow {
    fun myPow(x: Double, n: Int): Double {
        return when {
            n == 0 -> 1.0
            n > 0 -> pow2(x, n)
            else -> 1 / pow2(x, -n)
        }
    }

    private fun pow2(x: Double, n: Int): Double {
        val n2 = n / 2
        return when {n2 == 0 -> x
            n % 2 == 0 -> pow2(x * x, n2)
            else -> pow2(x * x, n2) * x
        }
    }
}

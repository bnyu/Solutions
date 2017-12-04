/**
 * find all odds number smaller than target
 */
class FindAllOdds {

    var bigOdd: Long = 2
        private set

    fun findBiggestOdd(x: Long) {
        if (x > bigOdd) {
            for (n in x downTo bigOdd + 1) {
                var odd = true
                var i = 2
                while (i <= n / i) {
                    if (n % i == 0L) {
                        odd = false
                        break
                    }
                    i++
                }
                if (odd) {
                    bigOdd = if (n > bigOdd) n else bigOdd
                    return
                }
            }
        }
    }

    fun findAllOdds(x: Int): List<Int> {
        val odds: MutableList<Int> = mutableListOf()
        if (x >= 2) {
            var i = 2
            odds.add(i)
            i++
            var size = odds.size
            while (i <= x) {
                var isOdd = true
                for (index in 0 until size) {
                    val odd = odds[index]
                    if (i % odd != 0) {
                        if (odd > i / odd)
                            break
                    } else {
                        isOdd = false
                        break
                    }
                }
                if (isOdd) {
                    odds.add(i)
                    size++
                }
                i += 2
            }
        }
        return odds
    }

}


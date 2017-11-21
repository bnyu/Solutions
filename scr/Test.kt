import java.util.*

fun main(arg: Array<String>) {
    val s = Solution048()
    val random = Random()
    val size = 5
    val array = Array(size, { _ -> IntArray(size) })
    for (i in 0 until size) {
        for (j in 0 until size) {
            val x = random.nextInt(10)
            array[i][j] = x
            print(x.toString() + " ")
        }
        println()
    }
    println()
    s.rotate(array)

    for (i in array) {
        for (x in i) {
            print(x.toString() + " ")
        }
        println()
    }
}

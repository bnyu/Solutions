object Test {
    @JvmStatic
    fun main(arg: Array<String>) {
        val threeSum = ThreeSumClosest()
        val ans = threeSum.threeSumClosest(intArrayOf(-1,0,1,1,10), 3)
        print(ans)
    }
}
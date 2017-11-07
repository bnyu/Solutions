/**
 * 22. Generate Parentheses
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
class Solution022 {
    private val ans = ArrayList<String>()

    fun generateParenthesis(n: Int): List<String> {
        if (n > 0)
            generate("", n, 0)
        return ans
    }

    private fun generate(s: String, leftLeft: Int, leftRight: Int) {
        if (leftLeft == 0 && leftRight == 0)
            ans.add(s)
        else {
            //剩余可用左括号 左括号数-1 右括号数+1
            if (leftLeft > 0)
                generate(s + '(', leftLeft - 1, leftRight + 1)
            //剩余可用右括号 右括号-1
            if (leftRight > 0)
                generate(s + ')', leftLeft, leftRight - 1)
        }
    }
}


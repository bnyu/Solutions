//https://gist.github.com/bnyu/246a3847090198c0d36d54923508d83d
// Accepted

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
class Solution022 {
    private final List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n > 0)
            generate("", n, 0);
        return ans;
    }

    private void generate(String s, int leftLeft, int leftRight) {
        if (leftLeft == 0 && leftRight == 0)
            ans.add(s);
        else {
            if (leftLeft > 0)
                generate(s + '(', leftLeft - 1, leftRight + 1);
            if (leftRight > 0)
                generate(s + ')', leftLeft, leftRight - 1);
        }
    }
}


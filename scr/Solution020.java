//https://gist.github.com/bnyu/d74f9f61b2fcfb544c48ddfafa158736
// Accepted

import java.util.*;

/**
 * 20. Valid Parentheses
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
class Solution020 {
    public boolean isValid(String s) {
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put('(', ')');
        brackets.put('[', ']');
        brackets.put('{', '}');
        Stack<Character> toMatch = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!brackets.containsKey(c) && !brackets.containsValue(c))
                continue;
            if (brackets.containsKey(c))
                toMatch.push(brackets.get(c));
            else {
                if (toMatch.empty())
                    return false;
                char match = toMatch.pop();
                if (match != c)
                    return false;
            }
        }
        return toMatch.empty();
    }
}


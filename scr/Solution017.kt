//https://gist.github.com/bnyu/63a448a51fb8fc8c740b503491d3bdd6
// Accepted

import java.util.ArrayList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 */
class Solution017 {

    private final List<String> ans = new ArrayList<>();

    enum Keyboard {
        _2('2', "abc"),
        _3('3', "def"),
        _4('4', "ghi"),
        _5('5', "jkl"),
        _6('6', "mno"),
        _7('7', "pqrs"),
        _8('8', "tuv"),
        _9('9', "wxyz"),
        _0('0', " "),;

        Keyboard(char num, String letter) {
            this.num = num;
            this.letter = letter;
        }

        private final char num;
        private final String letter;

        public static String getLetter(char num) {
            for (Keyboard keyboard : values())
                if (num == keyboard.num)
                    return keyboard.letter;
            return "";
        }
    }


    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return new ArrayList<>(1);
        final int digitsLength = digits.length();
        final List<String> wolds = new ArrayList<>(digitsLength);
        for (int i = 0; i < digitsLength; i++) {
            String letter = Keyboard.getLetter(digits.charAt(i));
            if (letter.isEmpty())
                return new ArrayList<>(1);
            wolds.add(letter);
        }
        combineLetter("", wolds, 0);
        return ans;
    }

    private void combineLetter(String letter, List<String> words, int index) {
        String word = words.get(index);
        for (int i = 0; i < word.length(); i++) {
            String newLetter = letter + word.charAt(i);
            if (index == words.size() - 1)
                ans.add(newLetter);
            else
                combineLetter(newLetter, words, index + 1);
        }
    }

}


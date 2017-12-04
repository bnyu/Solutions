/**
 * 17. Letter Combinations of a Phone Number
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 */
class LetterCombinationsOfAPhoneNumber {
    private val ans = ArrayList<String>()

    internal enum class Keyboard(private val num: Char, private val letter: String) {
        K2('2', "abc"),
        K3('3', "def"),
        K4('4', "ghi"),
        K5('5', "jkl"),
        K6('6', "mno"),
        K7('7', "pqrs"),
        K8('8', "tuv"),
        K9('9', "wxyz"),
        K0('0', " ");

        companion object {
            fun getLetter(num: Char): String {
                for (keyboard in values())
                    if (num == keyboard.num)
                        return keyboard.letter
                return ""
            }
        }
    }


    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty())
            return ArrayList(1)
        val digitsLength = digits.length
        //把每个按键对应的字母word依次放入wolds
        val wolds = ArrayList<String>(digitsLength)
        for (i in 0 until digitsLength) {
            val word = Keyboard.getLetter(digits[i])
            if (word.isEmpty())
                return ArrayList(1)
            wolds.add(word)
        }
        combineLetter("", wolds, 0)
        return ans
    }

    //一个按键一个的combine index:第几个按键
    private fun combineLetter(letter: String, words: List<String>, index: Int) {
        //当前按键的字母
        val word = words[index]
        for (i in 0 until word.length) {
            //循环选出其中一个字母
            val newLetter = letter + word[i]
            //所有按键组合完
            if (index == words.size - 1)
                ans.add(newLetter)
            //组合下一个按键
            else
                combineLetter(newLetter, words, index + 1)
        }
    }

}


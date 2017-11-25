val Java = "Java"
val Kotlin = "Kotlin"
val Scala = "Scala"


enum class S {
    Accepted,
    TimeLimitExceeded,
    WrongAnswer,
    ;
}


enum class Catalog(val language: String, val problem: Int, val solution: S) {
    FindAllOdds(Kotlin, 0, S.Accepted),
    TwoSum(Kotlin, 1, S.Accepted),
    AddTwoNumbers(Kotlin, 2, S.Accepted),
    LongestSubstringWithoutRepeatingCharacters(Kotlin, 3, S.Accepted),
    LongestPalindromicSubstring(Kotlin, 5, S.Accepted),
    ZigZagConversion(Kotlin, 6, S.Accepted),
    ReverseInteger(Kotlin, 7, S.Accepted),
    PalindromeNumber(Kotlin, 9, S.Accepted),
    RegularExpressionMatching(Kotlin, 10, S.Accepted),
    ContainerWithMostWater(Kotlin, 11, S.Accepted),
    LongestCommonPrefix(Kotlin, 14, S.Accepted),
    ThreeSum(Kotlin, 15, S.Accepted),
    LetterCombinationsOfAPhoneNumber(Kotlin, 17, S.Accepted),
    RemoveNthNodeFromEndOfList(Kotlin, 19, S.Accepted),
    ValidParentheses(Kotlin, 20, S.Accepted),
    MergeTwoSortedLists(Kotlin, 21, S.Accepted),
    GenerateParentheses(Kotlin, 22, S.Accepted),
    MergeKSortedLists(Kotlin, 23, S.Accepted),
    SwapNodesInPairs(Kotlin, 24, S.Accepted),
    ReverseNodesInKGroup(Kotlin, 25, S.Accepted),
    RemoveDuplicatesFromSortedArray(Kotlin, 26, S.Accepted),
    RemoveElement(Kotlin, 27, S.Accepted),
    ImplementStrStr(Kotlin, 28, S.Accepted),
    DivideTwoIntegers(Kotlin, 29, S.Accepted),
    NextPermutation(Kotlin, 31, S.Accepted),
    LongestValidParentheses(Kotlin, 32, S.Accepted),
    SearchInRotatedSortedArray(Kotlin, 33, S.Accepted),
    SearchForARange(Kotlin, 34, S.Accepted),
    SearchInsertPosition(Kotlin, 35, S.Accepted),
    ValidSudoku(Kotlin, 36, S.Accepted),
    SudokuSolver(Kotlin, 37, S.Accepted),
    CombinationSum(Kotlin, 39, S.Accepted),
    CombinationSum2(Kotlin, 40, S.Accepted),
    FirstMissingPositive(Kotlin, 41, S.Accepted),
    TrappingRainWater(Kotlin, 42, S.Accepted),
    WildcardMatching(Kotlin, 44, S.TimeLimitExceeded),
    JumpGame2(Kotlin, 45, S.Accepted),
    Permutations(Kotlin, 46, S.Accepted),
    Permutations2(Kotlin, 47, S.Accepted),
    RotateImage(Kotlin, 48, S.Accepted),

    JumpGame(Scala, 55, S.Accepted),
    MergeIntervals(Scala, 56, S.Accepted),
    InsertInterval(Scala, 57, S.Accepted),
    ;

}

public enum Catalog {
    findAllOdds(0, Solution000.class, Status.accepted),
    twoSum(1, Solution001.class, Status.accepted),
    addTwoNumbers(2, Solution002.class, Status.accepted),
    longestSubstringWithoutRepeatingCharacters(3, Solution003.class, Status.accepted),
    longestPalindromicSubstring(5, Solution005.class, Status.accepted),
    zigZagConversion(6, Solution006.class, Status.accepted),
    reverseInteger(7, Solution007.class, Status.accepted),
    palindromeNumber(9, Solution009.class, Status.accepted),
    regularExpressionMatching(10, Solution010.class, Status.accepted),
    containerWithMostWater(11, Solution011.class, Status.accepted),
    longestCommonPrefix(14, Solution014.class, Status.accepted),
    threeSum(15, Solution015.class, Status.timeLimitExceeded),
    letterCombinationsOfAPhoneNumber(17, Solution017.class, Status.accepted),
    removeNthNodeFromEndOfList(19, Solution019.class, Status.accepted),
    validParentheses(20, Solution020.class, Status.accepted),
    mergeTwoSortedLists(21, Solution021.class, Status.accepted),
    generateParentheses(22, Solution022.class, Status.accepted),
    mergeKSortedLists(23, Solution023.class, Status.accepted),
    swapNodesInPairs(24, Solution024.class, Status.accepted),
    reverseNodesInKGroup(25, Solution025.class, Status.accepted),
    removeDuplicatesFromSortedArray(26, Solution026.class, Status.accepted),
    removeElement(27, Solution027.class, Status.accepted),
    implementStrStr(28, Solution028.class, Status.accepted),
    divideTwoIntegers(29, Solution029.class, Status.accepted),
    nextPermutation(31, Solution031.class, Status.accepted),
    searchInRotatedSortedArray(33, Solution033.class, Status.accepted),
    searchForARange(34, Solution034.class, Status.accepted),
    searchInsertPosition(35, Solution035.class, Status.accepted),
    validSudoku(36, Solution036.class, Status.accepted),
    sudokuSolver(37, Solution037.class, Status.accepted);

    int number;
    Class solution;
    String status;

    Catalog(int number, Class solution, Status status) {
        this.number = number;
        this.solution = solution;
        this.status = status.s;
    }

}

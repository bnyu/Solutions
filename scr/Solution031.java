package p31;
//https://gist.github.com/bnyu/ed580ff35b2cd6df379bfe71e90035a0
// Wrong Answer

/**
 * 31. Next Permutation
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 */
class Solution {
    public void nextPermutation(int[] nums) {
        int sortedIndex = 0;
        int lastIndex = nums.length - 1;
        int index = lastIndex;
        BreakFor:
        for (; sortedIndex <= lastIndex; sortedIndex++) {
            for (int i = sortedIndex + 1; i <= lastIndex; i++) {
                if (nums[sortedIndex] > nums[i])
                    break BreakFor;
            }
        }
        sortedIndex--;
        if (sortedIndex == lastIndex)
            sortedIndex = -1;
        BreakFor:
        for (; index >= 0; index--) {
            if (index <= sortedIndex) {
                int temp = nums[lastIndex];
                nums[lastIndex] = nums[sortedIndex];
                nums[sortedIndex] = temp;
                index = sortedIndex + 1;
                break;
            } else
                for (int j = 1; index - j >= 0; j++) {
                    if (index - j == sortedIndex)
                        break;
                    if (nums[index - j] < nums[index]) {
                        int temp = nums[index - j];
                        nums[index - j] = nums[index];
                        nums[index] = temp;
                        index = index - j + 1;
                        break BreakFor;
                    }
                }
        }

        if (index == -1)
            index = 0;
        for (int i = index, j = lastIndex; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}


//https://gist.github.com/bnyu/ed580ff35b2cd6df379bfe71e90035a0
// Accepted

/**
 * 31. Next Permutation
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 */
class Solution031 {
    public void nextPermutation(int[] nums) {
        int lastIndex = nums.length - 1;
        int index = lastIndex;

        // 尾部是最大序的前一个位置
        int sortedIndex = lastIndex;
        for (; sortedIndex > 0; sortedIndex--) {
            if (nums[sortedIndex - 1] < nums[sortedIndex])
                break;
        }
        sortedIndex--;

        BreakFor:
        for (; index >= 0; index--) {
            if (sortedIndex < 0) {
                index = -1;
                break;
            }
            if (index == sortedIndex) {
                sortedIndex--;
                index = lastIndex;
            }
            for (int j = 1; index - j >= 0; j++) {
                if (index - j < sortedIndex)
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

        //已是最大序 变为最小序
        if (index == -1)
            index = 0;
        for (int i = index, j = lastIndex; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}


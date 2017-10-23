public class Test {
    public static void main(String[] args) {
        Solution031 solution031 = new Solution031();
        int[] nums = new int[]{4,2,0,2,3,0};
        for (int i = 0; i < 3; i++) {
            solution031.nextPermutation(nums);
            for (int x : nums)
                System.out.print(x);
            System.out.println();
        }
    }
}

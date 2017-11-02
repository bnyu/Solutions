import java.util.List;

public class Test {
    public static void main(String[] args) {
        Solution015 solution015 = new Solution015();
        int[] nums = {1,-1,0,2,1,-1,2,0,3,-3};
        List<List<Integer>> ans = solution015.threeSum(nums);
        System.out.println(ans.size());
        for (List<Integer> list : ans) {
            for (int x : list)
                System.out.print(x + " ");
            System.out.println();
        }
    }
}
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<List<Integer>> ans = new Solution039().combinationSum(new int[]{1, 7, 3, 2, 6, 8, 5}, 10);
        for (List<Integer> list : ans) {
            for (int x : list)
                System.out.print(x + " ");
            System.out.println();
        }
    }
}
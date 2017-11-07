import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<List<Integer>> ans = new Solution040().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 10);
        for (List<Integer> list : ans) {
            for (int x : list)
                System.out.print(x + " ");
            System.out.println();
        }
    }
}

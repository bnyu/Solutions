import java.util.Random;

public class Test {
    public static void main(String[] arg) {
        for (int i = 0; i < 50; ++i) {
            int n = new Random().nextInt();
            int rn = new ReverseBits().reverseBits(n);
            int rrn = new ReverseBits().reverseBits(rn);
            if (n == rrn) {
                System.out.println("YES: " + n + " => " + rn);
            } else {
                System.out.println("NO: " + n + " => " + rn);
            }
        }

        ReverseBits reverseBits = new ReverseBits();
        for (int i = -10; i < 10; ++i) {
            int r = reverseBits.reverseBits(i);
            System.out.println(i + " => " + r);
            System.out.println(r + " => " + reverseBits.reverseBits(r));
        }
    }
}

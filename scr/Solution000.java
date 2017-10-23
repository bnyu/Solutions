package p0;
//https://gist.github.com/bnyu/73b55c48e7a9b80c01e3ce042f142524

import java.util.ArrayList;
import java.util.List;

/**
 * find all odds number smaller than target
 */
public class Solution {

    private long bigOdd;

    public long getBigOdd() {
        return bigOdd;
    }

    public void findBiggestOdd(long x) {
        if (x > bigOdd) {
            for (long n = x; n > bigOdd; n--) {
                boolean odd = true;
                for (long i = 2; i <= n / i; i++) {
                    if (n % i == 0) {
                        odd = false;
                        break;
                    }
                }
                if (odd) {
                    bigOdd = n > bigOdd ? n : bigOdd;
                    return;
                }
            }
        }
    }

    public List<Integer> findAllOdds(int x) {
        final List<Integer> odds = new ArrayList<>();
        if (x >= 2) {
            int i = 2;
            odds.add(i);
            i++;
            int size = odds.size();
            while (i <= x) {
                boolean isOdd = true;
                for (int index = 0; index < size; index++) {
                    int odd = odds.get(index);
                    if (i % odd != 0) {
                        if (odd > i / odd) {
                            break;
                        }
                    } else {
                        isOdd = false;
                        break;
                    }
                }
                if (isOdd) {
                    odds.add(i);
                    size++;
                }
                i += 2;
            }
        }
        return odds;
    }


    public static void main(String[] arg) {
        Solution test = new Solution();

        test.findBiggestOdd(1000000000);
        System.out.println(test.getBigOdd());
        List<Integer> odds = test.findAllOdds(10000000);
        System.out.println(odds);
    }
}


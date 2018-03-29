import java.util.HashMap;
import java.util.Scanner;

public class Staircase {

    public static HashMap<Integer, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for (int a0 = 0; a0 < s; a0++) {
            int n = in.nextInt();
            System.out.println(getNoOfWays(n));
        }
    }

    private static int getNoOfWays(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        }
        if (!cache.containsKey(n)) {
            int value = getNoOfWays(n - 1) + getNoOfWays(n - 2) + getNoOfWays(n - 3);
            cache.put(n, value);
        }
        return cache.get(n);
    }
}

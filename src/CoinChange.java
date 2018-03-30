import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for (int coins_i = 0; coins_i < m; coins_i++) {
            coins[coins_i] = in.nextInt();
        }

        System.out.println(getNoOfWays(coins, n, m));
    }

    private static long getNoOfWays(int[] coins, int n, int m) {
        long[] table = new long[n + 1];
        Arrays.fill(table, 0);

        table[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = coins[i]; j <= n; j++) {
                table[j] += table[j - coins[i]];
            }
        }
        return table[n];
    }


}

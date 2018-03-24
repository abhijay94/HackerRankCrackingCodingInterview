import java.util.Arrays;
import java.util.Scanner;

public class RunningMedian {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        float[] median = new float[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        //TODO: This algo is timing out. O(n^2) Implement a faster algorithm using two heaps.
        for (int i =0; i< n; i++) {
            float[] temp_a = new float[i+1];
            for (int j = 0; j<=i; j++) {
                temp_a[j] = a[j];
            }
            Arrays.sort(temp_a);

            if (temp_a.length % 2 != 0) {
                median[i] = temp_a[(temp_a.length/ 2)];
            } else {
                median[i] = (temp_a[temp_a.length / 2] + temp_a[(temp_a.length / 2) - 1])/2;
            }
        }
        for (float i : median){
            System.out.println(String.format("%.1f", i));
        }
    }
}

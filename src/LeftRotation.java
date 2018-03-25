import java.util.Scanner;

public class LeftRotation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        int rotated_a[] = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (i + k < n) {
                rotated_a[i] = a[i + k];
            } else {
                rotated_a[i] = a[i + k - n];
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(rotated_a[i] + " ");
        }

    }

}

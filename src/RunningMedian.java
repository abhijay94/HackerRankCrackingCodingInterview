import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RunningMedian {
    public static double[] getMedians(int[] arr) {
        PriorityQueue<Integer> minHalfHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return -1 * a.compareTo(b);
            }
        });
        PriorityQueue<Integer> maxHalfHeap = new PriorityQueue<>();
        double[] medians = new double[arr.length];

        for (int i = 0; i < arr.length; i++) {
            addNumber(arr[i], minHalfHeap, maxHalfHeap);
            rebalanceHeap(minHalfHeap, maxHalfHeap);
            medians[i] = getMedian(minHalfHeap, maxHalfHeap);
        }

        return medians;
    }

    private static double getMedian(PriorityQueue<Integer> minHalfHeap, PriorityQueue<Integer> maxHalfHeap) {
        PriorityQueue<Integer> biggerHeap = minHalfHeap.size() > maxHalfHeap.size() ? minHalfHeap : maxHalfHeap;
        PriorityQueue<Integer> smallerHeap = minHalfHeap.size() > maxHalfHeap.size() ? maxHalfHeap : minHalfHeap;
        if(biggerHeap.size() == smallerHeap.size()) {
            return ((double)biggerHeap.peek() + smallerHeap.peek()) / 2;
        } else {
            return biggerHeap.peek();
        }
    }

    private static void rebalanceHeap(PriorityQueue<Integer> minHalfHeap, PriorityQueue<Integer> maxHalfHeap) {
        PriorityQueue<Integer> biggerHeap = minHalfHeap.size() > maxHalfHeap.size() ? minHalfHeap : maxHalfHeap;
        PriorityQueue<Integer> smallerHeap = minHalfHeap.size() > maxHalfHeap.size() ? maxHalfHeap : minHalfHeap;
        if(biggerHeap.size() - smallerHeap.size() >= 2) {
            smallerHeap.add(biggerHeap.poll());
        }

    }

    private static void addNumber(int num, PriorityQueue<Integer> minHalfHeap, PriorityQueue<Integer> maxHalfHeap) {
        if (minHalfHeap.isEmpty() || num < minHalfHeap.peek()) {
            minHalfHeap.add(num);
        } else {
            maxHalfHeap.add(num);
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }

        double[] medians = getMedians(a);

        for (double i : medians) {
            System.out.println(String.format("%.1f", i));
        }
    }

}

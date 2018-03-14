import java.util.Scanner;
import java.util.Stack;

public class TwoStacksQueue {
    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<>();
        Stack<T> stackOldestOnTop = new Stack<>();

        //We keep pushing new values to the NewestOnTop Stack until we see a dequeue or a pop operation
        void enqueue(T value) {
            // Push onto NewestOnTop stack
            stackNewestOnTop.push(value);
        }

        /*We move every element to the OldestOnTop stack by popping everything from NewestOnTop and moving it
        to OldestOnTop. Then we finally peek the top of OldestOnTop Stack. New push operations can be continued on
        the NewestOnTopStack unless we encounter another peek or pop.*/
        private T peek() {
            if (stackOldestOnTop.empty()) {
                while (!stackNewestOnTop.empty()) {
                    // Pop from NewestOnTop and push the value to OldestOnTop stack
                    // The order of the elements in the first stack is reversed when everything gets pushed to
                    // the Newest OnTopStack
                    stackOldestOnTop.push(stackNewestOnTop.pop());
                }
            }
            return stackOldestOnTop.peek();
        }

        /*We move every element to the OldestOnTop stack by popping everything from NewestOnTop and moving it
        to OldestOnTop. Then we finally pop the top of OldestOnTop Stack.*/
        private T dequeue() {
            if (stackOldestOnTop.empty()) {
                while (!stackNewestOnTop.empty()) {
                    stackOldestOnTop.push(stackNewestOnTop.pop());
                }
            }
            return stackOldestOnTop.pop();
        }
    }


    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}

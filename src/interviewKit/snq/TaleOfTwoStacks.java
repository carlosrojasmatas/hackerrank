package interviewKit.snq;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TaleOfTwoStacks {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.add(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.remove();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}

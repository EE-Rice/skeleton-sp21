/** Class that prints the Collatz sequence starting from a given number.
 *  @author EERice
 */
public class Collatz {

    /** Buggy implementation of nextNumber! */
    public static int nextNumber(int n) {
        /**
         * 如果 n 为偶数，则下一个数是 n/2。如果 n 为奇数，则下一个数是 3n + 1。如果 n 为 1，则数列结束。
         */
        if (n == 1) {
            return 1;
        } else if (n % 2 == 0) {
            return n / 2;
        } else {
            return 3 * n + 1;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.print(n + " ");
        while (n != 1) {
            n = nextNumber(n);
            System.out.print(n + " ");
        }
        System.out.println();
    }
}


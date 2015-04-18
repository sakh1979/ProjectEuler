/**
 * The following iterative sequence is defined for the set of positive
 * integers:
 *
 * n -> (n/2) (n is even) and
 * n -> 3n + 1 (n is odd).
 *
 * Using the rule above and start with 13, we generate following
 * sequence:
 *
 * 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1.
 *
 * It can be seen that this sequence (starting at 13 and finishing at
 * 1) contains 10 terms. Although it has not been proved yet (Collatz
 * Problem), it is thought that all starting numbers finish at 1.
 *
 * Which starting number, under one million, produces the longest
 * chain? NOTE: Once the chain starts the terms are allowed to go
 * above one million.
 */
public class P014 {

    public P014() {}

    private long nextNumber(long n) {
        return (n % 2) == 0 ? (n/2) : ((3 * n) + 1);
    }

    private int getItemsCount(int n) {
        int  result = 0;
        long currentNum = n;

        if (currentNum == 1) {
            result = 1;
            return result;
        }

        result = 1;

        while (currentNum != 1) {
            currentNum = nextNumber(currentNum);
            result++;
        }

        return result;
    }

    public static void main(String[] args) {

        P014 p014 = new P014();

        int max = 0;
        int maxLength = 0;
        for (int i = 1; i < 1000000; i++) {
            int currentSize = p014.getItemsCount(i);
            if (currentSize > maxLength) {
                maxLength = currentSize;
                max = i;
            }
        }

        System.out.println("Answer: " + max);
    }
}

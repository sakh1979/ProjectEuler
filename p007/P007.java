/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, 13, we can
 * see that the 6th prime is 13. What is the 10,001st prime number?
 */
public class P007 {

    public static boolean isPrime(long n) {

        if (n == 1) return false;

        // 2 and 3 are prime
        if (n < 4) return true;

        if (n % 2 == 0) return false;

        // we have already excluded 4, 6 and 8
        if (n < 9) return true;

        if (n % 3 == 0) return false;

        long f = 5;
        while (f <= Math.sqrt(n)) {
            // step out of the function
            if (n % f == 0) return false;

            // step out of the function
            if (n % (f + 2) == 0) return false;

            f += 6;
        }

        return true;
    }

    public static void main(String[] args) {

        int limit = 10001;

        // we know that 2 is prime
        int count = 1;

        int candidate = 1;

        while (count != limit) {
            candidate += 2;
            if (isPrime(candidate)) {
                count++;
            }
        }

        System.out.println("Answer: " + candidate + " counter: " + count);
    }
}

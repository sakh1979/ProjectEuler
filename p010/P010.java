/**
 * The sum of primes below 10 is: 2 + 3 + 5 + 7 = 17. Find the sum of
 * primes below two million.
 */
public class P010 {

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

        long summation = 0;
        for (int i = 2; i < 2000000; i++) {
            if (isPrime(i)) {
                summation += i;
            }
        }

        System.out.println("Answer: " + summation);
    }
}

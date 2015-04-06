/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 */
public class P003 {

    private static final long N = 600851475143L;

    public static boolean isPrime(long l) {

        for (long i = 2; i <= Math.sqrt(l); i++) {
            if (l % i == 0) return false;
        }

        return true;
    }

    public static boolean isPrimeFactor(long n, long l) {

        return isPrime(l) && n % l == 0;
    }

    public static void main(String[] args) {

        for (long i = 2; i < Math.sqrt(N); i++) {
            if (isPrimeFactor(N, i)) {
                System.out.println(" " + i);
            }
        }
    }
}

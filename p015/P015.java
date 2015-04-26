import java.math.BigInteger;

/**
 * Starting in the top left corner of a 2×2 grid, and only being able
 * to move to the right and down, there are exactly 6 routes to the
 * bottom right corner.
 *
 * How many such routes are there through a 20×20 grid?
 *
 */
public class P015 {

    public static BigInteger factorial(BigInteger n) {
        if (n.equals(new BigInteger("1")) || n.equals(new BigInteger("0"))) {
            return new BigInteger("1");
        }

        return n.multiply(factorial(n.subtract(new BigInteger("1"))));
    }

    public static BigInteger combination(BigInteger n, BigInteger r) {
        BigInteger permutation = factorial(n).divide(factorial(r));
        return permutation.divide(factorial(r));
    }

    public static void main(String[] args) {

        System.out.println("Answer: " +
                           combination(new BigInteger("40"),
                                       new BigInteger("20")));
    }
}

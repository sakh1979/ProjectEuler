import java.math.BigInteger;

/**
 * Factorial digit sum
 *
 * n! means n * (n-1) * ... * 3 * 2 * 1
 *
 * For example, 10! = 10 * 9 * 8 * ... * 3 * 2 * 1 = 362880, and the
 * sum of the digits in the number 10 is 3 + 6 + 2 + 8 + 8 + 0 + 0 =
 * 27.
 *
 * Find the sum of the digits in the number 100!
 */
public class P020 {

    public static BigInteger factorial(BigInteger n) {
        if (n.equals(new BigInteger("1")) ||
            n.equals(new BigInteger("0"))) {
            return new BigInteger("1");
        }

        return n.multiply(factorial(n.subtract(new BigInteger("1"))));
    }

    public static int digitSum(String s) {
        int result = 0;
        char[] stringToCharArray = s.toCharArray();

        for (char c : stringToCharArray) {
            result += Character.getNumericValue(c);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + digitSum(factorial(new BigInteger("100")) + ""));
    }
}

import java.math.BigInteger;

/**
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 *
 * What is the sum of the digits of the number 2^1000?
 *
 */
public class P016 {

    public static void main(String[] args) {
        int result = 0;
        BigInteger expo = new BigInteger("2").pow(1000);
        String expoStr = expo.toString();
        for (int i = 0; i < expoStr.length(); i++) {
            result += Character.getNumericValue(expoStr.charAt(i));
        }

        System.out.println("Answer: " + result);
    }
}

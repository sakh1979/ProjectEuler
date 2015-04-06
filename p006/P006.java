/**
 * The sum of the square of the first then natural number is: 1^2 +
 * 2^2 + 3^2 + ... + 10^2 = 385.
 *
 * The square of the sum of the first then natural number: (1 + 2 +
 * ... + 10)^2 = 552 = 3025
 *
 * Hence the difference between the sum of the squares of the first
 * ten natural numbers and the square of the sum is 3025 − 385 = 2640.
 *
 * Find the difference between the sum of the squares of the first one
 * hundred natural numbers and the square of the sum.
 */
public class P006 {

    public static int sumOfSquares(int n) {
        int result = 0;
        for (int i = 0; i <= n; i++) {
            result += i * i;
        }

        return result;
    }

    public static int squareOfSum(int n) {
        int result = 0;
        for (int i = 0; i <= n; i++) {
            result += i;
        }

        return result * result;
    }

    public static void main(String[] args) {

        int sumOfSquares = sumOfSquares(100);
        int squareOfSum = squareOfSum(100);

        System.out.println("Sum of Square: " + sumOfSquares);
        System.out.println("Square of sum: " + squareOfSum);
        System.out.println("Difference: " + (squareOfSum - sumOfSquares));
    }
}

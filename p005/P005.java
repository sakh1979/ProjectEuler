/**
 * 2520 is the smallest number that can be divided by each of the
 * numbers from 1 to 10 without any remainder. What is the smallest
 * positive number that is evenly divisible by all of the numbers from
 * 1 to 20.
 */
public class P005 {

    public static void main(String[] args) {

        int number;
        for (number = 1; number < 400000000; number++) {
            boolean minNum = true;
            for (int j = 2; j < 20; j++) {
                if (number % j != 0) {
                    minNum = false;
                    break;
                }
            }

            if (minNum) {
                System.out.println("Answer: " + number);
            }
        }
    }
}

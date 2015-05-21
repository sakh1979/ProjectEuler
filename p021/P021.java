import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

/**
 * Let d(n) be defined as the sum of proper divisors of n (numbers
 * less than n which divide evenly into n).
 *
 * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable
 * pair and each of a and b are called amicable numbers.
 *
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20,
 * 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of
 * 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 *
 * Evaluate the sum of all the amicable numbers under 10000.
 */
public class P021 {

    private Set<Integer> setOfAmicableNumbers;

    public P021() {
        setOfAmicableNumbers = new HashSet<Integer>();
    }

    public List<Integer> getAllFactors(int n) {

        List<Integer> result = new ArrayList<Integer>();
        int i = 2;

        while (i < Math.sqrt(n)) {
            if (n  % i == 0) {
                result.add(i);
                result.add(n/i);
            }
            i++;
        }

        if (i*i == n) {
            result.add(i);
        }

        result.add(1);

        return result;
    }

    public int sumIntegers(List<Integer> list) {
        int result = 0;
        for (Integer i : list) {
            result += i;
        }

        return result;
    }

    public void testNumberForAmicable(int n) {
        if (setOfAmicableNumbers.contains(n)) return;

        int a = sumIntegers(getAllFactors(n));
        int b = sumIntegers(getAllFactors(a));

        if (a != b && b == n) {
            setOfAmicableNumbers.add(a);
            setOfAmicableNumbers.add(b);
        }
    }

    public Set<Integer> getSetOfAmicableNumbers() {
        return this.setOfAmicableNumbers;
    }

    public static void main(String[] args) {
        int answer = 0;
        P021 p021 = new P021();

        for (int i = 1; i < 10000; i++) {
            p021.testNumberForAmicable(i);
        }

        for (Integer i : p021.getSetOfAmicableNumbers()) {
            answer += i;
        }

        System.out.println("Answer: " + answer);
    }
}

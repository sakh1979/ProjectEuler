/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c,
 * for which, a^2 + b^2 = c^2. For example, 3^2 + 4^2 = 9 + 16 = 25 =
 * 5^2. There exists exactly one Pythagorean triplet for which a + b +
 * c = 1000. Find the product abc.
 */
public class P009 {

    /**
     * Math is Fun: https://www.mathsisfun.com/numbers/pythagorean-triples.html
     *
     * It is easy to construct sets of Pythagorean Triplets
     *
     * When m and n are any two positive integers, such that m < n:
     * <ul>
     * <li> a = n^2 - m^2
     * <li> b = 2nm
     * <li> c = n^2 + m^2
     *
     * Then a, b, and c form a Pythagorean Triplets
     */
    public static void calculatePythagoreanTriplets() {

        for (int m = 0; m < 100; m++) {
            for (int n = m+1; n < 100; n++) {
                int a = (n*n) - (m*m);
                int b = 2 * n * m;
                int c = (n*n) + (m*m);

                if ((a + b + c) == 1000) {
                    System.out.println(a + " " + b + " " + c + " = " + (a + b + c));
                    System.out.println("Answer: " + (a * b * c));
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {

        calculatePythagoreanTriplets();
    }
}

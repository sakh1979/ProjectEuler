/**
 * If the numbers 1 to 5 are written out in words: one, two, three,
 * four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in
 * total.
 *
 * If all the numbers from 1 to 1000 (one thousand) inclusive were
 * written out in words, how many letters would be used?
 *
 * NOTE: Do not count spaces or hyphens. For example, 342 (three
 * hundred and forty-two) contains 23 letters and 115 (one hundred and
 * fifteen) contains 20 letters. The use of "and" when writing out
 * numbers is in compliance with British usage.
 *
 */
public class P017 {

    public static final String[] onesPlace = {"zero", "one", "two", "three",
                                              "four", "five", "six", "seven",
                                              "eight", "nine"};

    public static final String[] teensPlace = {"ten", "eleven", "twelve", "thirteen",
                                               "fourteen", "fifteen", "sixteen",
                                               "seventeen", "eighteen", "nineteen"};

    public static final String[] tensPlace = {"", "", "twenty", "thirty", "forty",
                                              "fifty", "sixty", "seventy", "eighty",
                                              "ninety"};

    public static final String hundred = "hundred";
    public static final String thousand = "thousand";

    public static String buildOnes(int n) { return onesPlace[n]; }

    public static String buildTeens(int n) { return teensPlace[n]; }

    public static String buildTens(int n) {
        int digit = n % 10;
        String onePlace = buildOnes(digit);
        digit = n / 10;
        String tenPlace = tensPlace[digit];
        if ("zero".equals(onePlace)) {
            return tenPlace;
        }
        else {
            return tenPlace + "-" + onePlace;
        }
    }

    public static String buildHundreds(int n) {
        String hundredPlace = buildOnes(Integer.parseInt((n + "").substring(0, 1)));
        int tensPlace = Integer.parseInt((n + "").substring(1));

        if (tensPlace == 0) {
            return hundredPlace + " " + hundred;
        }
        else {
            return hundredPlace + " " +
                hundred + " and " +
                composeWordsFromInt(tensPlace);
        }
    }

    public static String composeWordsFromInt(int n) {
        if (n >= 0 && n < 10) {
            return buildOnes(n);
        }
        else if (n >= 10 && n < 20) {
            return buildTeens(n - 10);
        }
        else if (n >= 20 && n < 100) {
            return buildTens(n);
        }
        else if (n >= 100 && n < 1000) {
            return buildHundreds(n);
        }
        else if (n == 1000) {
            return "one " + thousand;
        }
        else {
            new Exception("Unsupported Number: " + n);
            return "";
        }
    }

    public static int countLetters(String wordNumber) {
        int counter = 0;
        for (int i = 0; i < wordNumber.length(); i++) {
            if (wordNumber.charAt(i) != ' ' && wordNumber.charAt(i) != '-') {
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        int accumulator = 0;
        for (int i = 1; i < 1001; i++) {
            accumulator += countLetters(composeWordsFromInt(i));
        }
        System.out.println("Answer: " + accumulator);
    }
}

public class P002 {

    public static int fib(int n) {

        int a = 0;
        int b = 1;

        for (int i = 0; i < n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }

        return b;
    }

    public static void main(String[] args) {

        int result = 0;
        
        for (int i = 0; i < 50; i++) {
            int f = fib(i);

            if (f > 4000000) {
                break;
            }

            if (f % 2 == 0) {
                result += f;
            }
        }

        System.out.println("Answer: " + result);
    }
}

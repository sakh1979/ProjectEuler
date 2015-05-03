/**
 * By starting at the top of the triangle below and moving to adjacent
 * numbers on the row below, the maximum total from top to bottom is
 * 23.
 *
 *          3
 *         7 4
 *        2 4 6
 *       8 5 9 3
 *
 * That is, 3 + 7 + 4 + 9 = 23.
 *
 * Find the maximum total from top to bottom of the triangle below:
 *
 *                             75
 *                           95 64
 *                         17 47 82
 *                       18 35 87 10
 *                     20 04 82 47 65
 *                   19 01 23 75 03 34
 *                 88 02 77 73 07 63 67
 *               99 65 04 28 06 16 70 92
 *             41 41 26 56 83 40 80 70 33
 *           41 48 72 33 47 32 37 16 94 29
 *         53 71 44 65 25 43 91 52 97 51 14
 *       70 11 33 28 77 73 17 78 39 68 17 57
 *     91 71 52 38 17 14 91 43 58 50 27 29 48
 *   63 66 04 68 89 53 67 30 73 16 69 87 40 31
 * 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
 *
 * NOTE: As there are only 16384 routes, it is possible to solve this
 * problem by trying every route. However, Problem 67, is the same
 * challenge with a triangle containing one-hundred rows; it cannot be
 * solved by brute force, and requires a clever method! ;o)
 *
 */
public class P018 {

    // size of the triangle
    public static int triangleSize = 15;

    // 2 dimensional array to hold the triangle in memory
    public static int[][] triangle = {
        {75},
        {95, 64},
        {17, 47, 82},
        {18, 35, 87, 10},
        {20,  4, 82, 47, 65},
        {19,  1, 23, 75,  3, 34},
        {88,  2, 77, 73,  7, 63, 67},
        {99, 65,  4, 28,  6, 16, 70, 92},
        {41, 41, 26, 56, 83, 40, 80, 70, 33},
        {41, 48, 72, 33, 47, 32, 37, 16, 94, 29},
        {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
        {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
        {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48},
        {63, 66,  4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
        { 4, 62, 98, 27, 23,  9, 70, 98, 73, 93, 38, 53, 60,  4, 23}
    };

    /**
     * Calculates the Maximum Path Sum of the triangle.
     *
     * I was thinking about tacking this problem using
     * DFS (Depth First Search). But, quickly came to a conclusion that
     * it is not feasible to use brute force DFS for such a large triangle.
     * The reason why it is not feasible to calculate the max path sum
     * using DFS is because there are
     * 2 ^ 99 = 633,825,300,114,114,700,748,351,602,688 combinations.
     *
     * After thinking a while about new solution, I figured that
     * the calculation will be much faster if we start from bottom up.
     *
     * Calculating the max path sum using bottom up approach.
     *
     * Taking the max(c+a, c+b) and replacing the value of c with
     * the max number.
     *
     *    c
     *   / \
     *  a   b
     *
     *  This solution take less than a millisecond to calculate the max
     *  path sum for a triangle with 100 rows.
     *
     *  It actually takes approximately 868091 nanoseconds
     *  on my old 2005 computer with 3 GB RAM.
     *
     * @return maximum path sum
     */
    public static int maxPathSum() {
        int col = triangleSize;
        int row = triangleSize - 1;

        while (row > 0) {
            for (int i = 0; i < col-1; i++) {
                int a = triangle[row][i];
                int b = triangle[row][i+1];
                int c = triangle[row-1][i];

                c = Math.max(c+a, c+b);
                triangle[row-1][i] = c;
            }
            col--;
            row--;
        }

        return triangle[0][0];
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + maxPathSum());
    }
}

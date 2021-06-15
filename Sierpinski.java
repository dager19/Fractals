public class Sierpinski {
    //  Height of an equilateral triangle whose sides are of the specified length.
    public static double height(double length) {
        return Math.sqrt(3) / 2 * length;
    }

    //  Draws a filled equilateral triangle whose bottom vertex is (x, y)
    //  of the specified side length.
    public static void filledTriangle(double x, double y, double length) {
        double[] xp = new double[4];
        double[] yp = new double[4];

        xp[0] = x - length / 2;
        xp[1] = x + length / 2;
        xp[2] = x;
        xp[3] = x - length / 2;

        yp[0] = height(length) + y;
        yp[1] = yp[0];
        yp[2] = y;
        yp[3] = yp[0];

        StdDraw.filledPolygon(xp, yp);
    }

    //  Draws a Sierpinski triangle of order n, such that the largest filled
    //  triangle has bottom vertex (x, y) and sides of the specified length.
    public static void sierpinski(int n, double x, double y, double length) {
        if (n == 0) return;
        filledTriangle(x, y, length);
        sierpinski(n - 1, x - length / 2, y, length / 2);
        sierpinski(n - 1, x + length / 2, y, length / 2);
        sierpinski(n - 1, x, y + height(length), length / 2);
    }

    //  Takes an integer command-line argument n;
    //  draws the outline of an equilateral triangle (pointed upwards) of length 1;
    //  whose bottom-left vertex is (0, 0) and bottom-right vertex is (1, 0); and
    //  draws a Sierpinski triangle of order n that fits snugly inside the outline.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.line(0, 0, 1, 0);
        StdDraw.line(1, 0, .5, Math.sqrt(3) / 2);
        StdDraw.line(.5, Math.sqrt(3) / 2, 0, 0);
        sierpinski(n, .5, 0, .5);
    }
}

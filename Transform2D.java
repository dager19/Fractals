public class Transform2D {
    // Scales the polygon by the factor alpha.
    public static void scale(double[] x, double[] y, double alpha) {
        for (int i = 0; i < x.length; i++) {
            x[i] *= alpha;
            y[i] *= alpha;
        }
    }

    // Translates the polygon by (dx, dy).
    public static void translate(double[] x, double[] y, double dx, double dy) {
        for (int i = 0; i < x.length; i++) {
            x[i] += dx;
            y[i] += dy;
        }
    }

    // Returns a new array object that is an exact copy of the given array.
    // The given array is not mutated.
    public static double[] copy(double[] array) {
        double[] newArray = new double[array.length];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[i];

        }
        return newArray;
    }


    // Rotates the polygon theta degrees counterclockwise, about the origin.
    public static void rotate(double[] x, double[] y, double theta) {
        // x' = x * cos(theta) - y * sin(theta)
        // y' = y * cos(theta) - x * sin(theta)
        theta = Math.toRadians(theta);
        for (int i = 0; i < x.length; i++) {
            double tX = x[i];
            double tY = y[i];
            x[i] = tX * Math.cos(theta) - tY * Math.sin(theta);
            y[i] = tY * Math.cos(theta) + tX * Math.sin(theta);
        }
    }

    // Tests each of the API methods by directly calling them.
    public static void main(String[] args) {
        // Original polygon
        StdDraw.setScale(-5.0, +5.0);
        double[] x = { 1, 2, 2, 1 };
        double[] y = { 1, 1, 3, 2 };
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.polygon(x, y);

        // Rotate polygon
        // 90 degrees counterclockwise
        Transform2D.rotate(x, y, 90.0);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.polygon(x, y);


    }

}

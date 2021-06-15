public class Art {

    private static void draw(double x, double y, double length) {
        //  x and y are the coordinates of the centre of the snowflake
        double[] xp = new double[4];
        double[] yp = new double[4];

        xp[0] = x - length / 2;
        xp[1] = x + length / 2;
        xp[2] = x * 2;
        xp[3] = x - length / 2;

        yp[0] = Math.sqrt(3) / 2 + y;
        yp[1] = yp[0];
        yp[2] = y * 2;
        yp[3] = yp[0];

        StdDraw.filledPolygon(xp, yp);

    }

    private static void snowflake(int n, double x, double y, double length) {
        draw(x, y, length);
        if (n > 1) {
            snowflake(n - 1, x + length, y, length / 3);
            snowflake(n - 1, x - length, y, length / 3);
            snowflake(n - 1, x + length / 2, y + (length / 2) * Math.sqrt(3), length / 3);
            snowflake(n - 1, x + length / 2, y - (length / 2) * Math.sqrt(3), length / 3);
            snowflake(n - 1, x - length / 2, y + (length / 2) * Math.sqrt(3), length / 3);
            snowflake(n - 1, x - length / 2, y - (length / 2) * Math.sqrt(3), length / 3);
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        snowflake(n, 0.5, 0.5, 0.5);
    }
}

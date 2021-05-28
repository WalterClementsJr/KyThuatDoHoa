package Model;

import java.awt.Point;

public class Rotation {
    /**
     * 
     * @param x x điểm cần quay
     * @param y y điểm cần quay
     * @param rotation ?
     * @param anchor gốc quay
     * @return điểm mới
     */
    public static Point rotateAroundO(int x, int y, double rotation, Point anchor) {

        double[] mt1 = new double[]{x, y, 1};
        double[][] mt2 = new double[][]{{Math.cos(rotation), Math.sin(rotation), 0}, {-Math.sin(rotation), Math.cos(rotation), 0}, {0, 0, 1}};
        double[] result;
        int axisX = anchor.x;
        int axisY = anchor.y;
        
        double xx1 = ( double )((x - axisX) * (Math.cos(rotation)));
        double yy1 = ( double )((y - axisY) * (Math.sin(rotation)));
        double xx2 = ( double )((x - axisX) * (Math.sin(rotation)));
        double yy2 = ( double )((y - axisY) * (Math.cos(rotation)));

        double tempX1 = doubleRound((xx1 - yy1)) + (double) axisX;
        double tempY1 = doubleRound(xx2 + yy2) + (double) axisY;
        return new Point( (int)Math.round(tempX1), (int) Math.round(tempY1));
    }
    public static double doubleRound(double value)
    {
        value=(double)Math.round(value * 100000d) / 100000d;
        return value;
    }
}

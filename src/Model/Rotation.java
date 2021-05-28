/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Point;

/**
 *
 * @author Phat
 */
public class Rotation {

    public static Point rotateAroundO(int x, int y, double rotation, Point coordinateNew) {

        double[] mt1 = new double[]{x, y, 1};
        double[][] mt2 = new double[][]{{Math.cos(rotation), Math.sin(rotation), 0}, {-Math.sin(rotation), Math.cos(rotation), 0}, {0, 0, 1}};
        double[] result;
        int axisX = coordinateNew.x;
        int axisY = coordinateNew.y;

        // result = UitlShapes2D.multiply(mt1, mt2);
        //   System.out.println((int) result[0]+ "," + (int) result[1]);
        // System.out.println(new Point ((int) result[0], (int) result[1]).toString());
        double xx1 = ( double )((x - axisX) * (Math.cos(rotation)));
        double yy1 = ( double )((y - axisY) * (Math.sin(rotation)));
        double xx2 = ( double )((x - axisX) * (Math.sin(rotation)));
        double yy2 = ( double )((y - axisY) * (Math.cos(rotation)));

//        xx1 = Double.parseDouble((xx1));
//        yy1 = Double.parseDouble((yy1));
//        xx2 = Double.parseDouble(((xx2)));
//        yy2 = Double.parseDouble(((yy2)));

        double tempX1 = doubleRound((xx1 - yy1)) + (double) axisX;
        double tempY1 = doubleRound(xx2 + yy2) + (double) axisY;
        //System.out.println(String.valueOf(tempX1) + String.valueOf(tempY1));
        return new Point( (int)Math.round(tempX1), (int) Math.round(tempY1));
        
//        double[] mt1 = new double[]{x, y, 1};
//        double[][] mt2 = new double[][]{{Math.cos(rotation), Math.sin(rotation), 0}, {-Math.sin(rotation), Math.cos(rotation), 0}, {0, 0, 1}};
//        double[] result;
//        int axisX = coordinateNew.x;
//        int axisY = coordinateNew.y;
//
//         result = UitlShapes2D.multiply(mt1, mt2);
//           System.out.println((int) result[0]+ "," + (int) result[1]);
//         //System.out.println(new Point ((int) result[0], (int) result[1]).toString());
//        double xx1 = ( double )((x - axisX) * (Math.cos(rotation)));
//        double yy1 = ( double )((y - axisY) * (Math.sin(rotation)));
//        double xx2 = ( double )((x - axisX) * (Math.sin(rotation)));
//        double yy2 = ( double )((y - axisY) * (Math.cos(rotation)));
//
//
//        double tempX1 = result[0] + (double) axisX;
//        double tempY1 =  result[1] + (double) axisY;
//    
//      return new Point ( (int)Math.floor(tempX1),(int) Math.floor(tempY1) );
    }
    public static double doubleRound(double value)
    {
        value=(double)Math.round(value * 100000d) / 100000d;
        return value;
    }
}

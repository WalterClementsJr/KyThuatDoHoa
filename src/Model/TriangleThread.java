/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author MinhTo
 */
public class TriangleThread extends Triangle {

    private ArrayList<Point> listA;
    private ArrayList<Point> listB;
    private ArrayList<Point> listC;

    private double angle;
    public static int index = 0;
    public Point coordinateNew;

    public TriangleThread(ArrayList<Point> listA, ArrayList<Point> listB, ArrayList<Point> listC, double angle, Point coordinateNew, Point A, Point B, Point C) {
        super(A, B, C);
        this.listA = listA;
        this.listB = listB;
        this.listC = listC;
        this.angle = angle;
        this.coordinateNew = coordinateNew;
    }

    public ArrayList<Point> getListA() {
        return listA;
    }

    public void setListA(ArrayList<Point> listA) {
        this.listA = listA;
    }

    public ArrayList<Point> getListB() {
        return listB;
    }

    public void setListB(ArrayList<Point> listB) {
        this.listB = listB;
    }

    public ArrayList<Point> getListC() {
        return listC;
    }

    public void setListC(ArrayList<Point> listC) {
        this.listC = listC;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public static int getIndex() {
        return index;
    }

    public static void setIndex(int index) {
        TriangleThread.index = index;
    }

    public Point getCoordinateNew() {
        return coordinateNew;
    }

    public void setCoordinateNew(Point coordinateNew) {
        this.coordinateNew = coordinateNew;
    }

}

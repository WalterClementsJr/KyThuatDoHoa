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
public class RectThread extends MyRect1 {

    private ArrayList<Point> listA;
    private ArrayList<Point> listB;
    private ArrayList<Point> listC;
    private ArrayList<Point> listD;
    private double angle;
    public static int index = 0;
    public Point coordinateNew;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public RectThread(ArrayList<Point> listA, ArrayList<Point> listB, ArrayList<Point> listC, ArrayList<Point> listD, double angle, Point A, Point B, Point C, Point D, Point coordinate) {
        super(A, B, C, D);
        this.listA = listA;
        this.listB = listB;
        this.listC = listC;
        this.listD = listD;
        this.angle = angle;
        this.coordinateNew = coordinate;
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

    public ArrayList<Point> getListD() {
        return listD;
    }

    public void setListD(ArrayList<Point> listD) {
        this.listD = listD;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public void addListA(Point a) {
        listA.add(a);

    }

    public void addListB(Point a) {
        listB.add(a);

    }

    public void addListC(Point a) {
        listC.add(a);

    }

    public void addListD(Point a) {
        listD.add(a);

    }
}

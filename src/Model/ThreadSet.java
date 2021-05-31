/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Point;

/**
 *
 * @author MinhTo
 */
public class ThreadSet extends Thread {

    private Thread t;
    private String nameThread = "HinhChuNhat";
    private RectThread rectThread;

    public ThreadSet(RectThread rectThread) {
        this.rectThread = rectThread;

    }

    public RectThread getRectThread() {
        return rectThread;
    }

    public void setRectThread(RectThread rectThread) {
        this.rectThread = rectThread;
    }

    @Override
    public void run() {
        {
            Point a1 = rectThread.getA();
            Point b1 = rectThread.getB();
            Point c1 = rectThread.getC();
            Point d1 = rectThread.getD();

            double angle = rectThread.getAngle();
            for (int i = 1; i <= (2 * Math.PI / angle); i++) {
                Point a3 = new Point();
                Point b3 = new Point();
                Point c3 = new Point();
                Point d3 = new Point();

                a3 = Rotation.rotateAroundO(a1.x, a1.y, -angle * i, rectThread.coordinateNew);
                b3 = Rotation.rotateAroundO(b1.x, b1.y, -angle * i, rectThread.coordinateNew);
                c3 = Rotation.rotateAroundO(c1.x, c1.y, -angle * i, rectThread.coordinateNew);
                d3 = Rotation.rotateAroundO(d1.x, d1.y, -angle * i, rectThread.coordinateNew);

                //CHU NHAT
                rectThread.getListA().add(a3);
                rectThread.getListB().add(b3);
                rectThread.getListC().add(c3);
                rectThread.getListD().add(d3);
            }
        }
    }
}

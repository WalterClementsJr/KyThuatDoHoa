/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import sun.awt.www.content.image.gif;

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

        System.out.println("Creating " + nameThread);

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
            System.out.println("Running " + nameThread);
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

//                Point aaa = new Point();
//                Point bbb = new Point();
//                Point ccc = new Point();
//                Point ddd = new Point();
//                aaa = TrucToaDo.expandX(a3);
//                bbb = TrucToaDo.expandX(b3);
//                ccc = TrucToaDo.expandX(c3);
//                ddd = TrucToaDo.expandX(d3);
                //CHU NHAT
                rectThread.getListA().add(a3);
                rectThread.getListB().add(b3);
                rectThread.getListC().add(c3);
                rectThread.getListD().add(d3);

                System.out.println(" Hình chữ nhật quay " + i);

            }

        }
    }
}

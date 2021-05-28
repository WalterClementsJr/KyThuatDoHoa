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
public class ThreadTriangleSet extends Thread {

    private Thread t;
    private String nameThread = "TamGiac";
    private TriangleThread triangleThread;

    public ThreadTriangleSet(TriangleThread triangleThread) {
        this.triangleThread = triangleThread;
    }

    public String getNameThread() {
        return nameThread;
    }

    public void setNameThread(String nameThread) {
        this.nameThread = nameThread;
    }

    public TriangleThread getTriangleThread() {
        return triangleThread;
    }

    public void setTriangleThread(TriangleThread triangleThread) {
        this.triangleThread = triangleThread;
    }


    

    @Override
    public void run() {
         
         {  
            System.out.println("Running " + nameThread);
            Point a1 = triangleThread.getA();
            Point b1 = triangleThread.getB();
              Point c1 = triangleThread.getC();


            double angle = triangleThread.getAngle();
            for (int i = 1; i <= (2 * Math.PI / angle); i++) {
                Point a3 = new Point();
                Point b3 = new Point();
                Point c3 = new Point();
             

                a3 = Rotation.rotateAroundO(a1.x, a1.y, -angle * i,triangleThread.coordinateNew);
                b3 = Rotation.rotateAroundO(b1.x, b1.y, -angle * i, triangleThread.coordinateNew);
                c3 = Rotation.rotateAroundO(c1.x, c1.y, -angle * i,triangleThread.coordinateNew);
         

                triangleThread.getListA().add(a3);
                triangleThread.getListB().add(b3);
                triangleThread.getListC().add(c3);
               

                System.out.println("Tam giac quay " + i);

            }

        }
    }
}

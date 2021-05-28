/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.swing.JComponent;

/**
 *
 * @author MinhTo
 */
public class ThreadTriangleGet extends Thread {

    private Thread t;
    private String nameThread = "Tam giac";
    private TriangleThread triangle;
    private JComponent cp;

    public ThreadTriangleGet(TriangleThread triangle) {
        this.triangle = triangle;
    }

    public String getNameThread() {
        return nameThread;
    }

    public void setNameThread(String nameThread) {
        this.nameThread = nameThread;
    }

    public TriangleThread getTriangle() {
        return triangle;
    }

    public void setTriangle(TriangleThread triangle) {
        this.triangle = triangle;
    }

    public ThreadTriangleGet(TriangleThread triangle, JComponent cp) {
        this.triangle = triangle;
        this.cp = cp;
    }

    public JComponent getCp() {
        return cp;
    }

    public void setCp(JComponent cp) {
        this.cp = cp;
    }

 

  

    @Override
    public void run() {
        {
            if (triangle.getListA().size() > 0) {
                if (triangle.index >= triangle.getListA().size() - 1) {
                    triangle.index = 0;
                } else {
                    triangle.index++;
                    System.out.println("Sending\t" + triangle.index);

                    System.out.println("\n" + triangle.index + "Sent");

                }
                cp.repaint();
            }
        }

    }
}

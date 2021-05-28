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
public class ThreadGet extends Thread {

    private Thread t;
    private String nameThread = "HinhChuNhat";
    private RectThread rectThread;
    private JComponent cp;

    public RectThread getRectThread() {
        return rectThread;
    }

    public void setRectThread(RectThread rectThread) {
        this.rectThread = rectThread;
    }

    public JComponent getCp() {
        return cp;
    }

    public void setCp(JComponent cp) {
        this.cp = cp;
    }

    public ThreadGet(RectThread rectThread, JComponent c) {
        this.rectThread = rectThread;
        this.cp = c;
        System.out.println("Creating " + nameThread);
    }

    @Override
    public void run() {
        {
            if (rectThread.getListA().size() > 0) {
                if (rectThread.index >= rectThread.getListA().size() - 1) {
                    rectThread.index = 0;
                } else {
                    rectThread.index++;
                    System.out.println("Sending\t" + rectThread.index);

                    System.out.println("\n" + rectThread.index + "Sent");

                }
                cp.repaint();
            }
        }

    }
}

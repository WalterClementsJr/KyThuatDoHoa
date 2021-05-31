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
    }

    @Override
    public void run() {
        {
            if (rectThread.getListA().size() > 0) {
                if (rectThread.index >= rectThread.getListA().size() - 1) {
                    rectThread.index = 0;
                } else {
                    rectThread.index++;
                }
                cp.repaint();
            }
        }

    }
}

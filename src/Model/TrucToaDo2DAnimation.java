/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Tuong
 */
public class TrucToaDo2DAnimation extends JPanel {

    public static int deltaX = 375 / 5;//nửa chiều dài của trục Ox chia cho độ lớn 1 pixel
    public static int deltaY = 250 / 5;//nửa chiều dài của trục oy chia cho độ lớn 1 pixel
    public static final double ANGLE = (2 * Math.PI / 8);

    public BufferedImage canvas
            = new BufferedImage(750, 500, BufferedImage.TYPE_INT_ARGB);

    public static Graphics canvasGraphics;

    Heli heli = new Heli(new Point(-20, -0), 10, 30);
    Heli originHeli;

    ArrayList<Shapes2D> stuffDraw = new ArrayList<>();

    public static Timer timer;
    public static TimerTask task;
    public static boolean pause = true;

    public static Shapes2D tempShape;
    private boolean drawGrid = true;
    private boolean drawOxy = true;

    public TrucToaDo2DAnimation() {
        canvasGraphics = this.canvas.getGraphics();

        stuffDraw.add(MyRect.random(150, 100, false));
        stuffDraw.add(Circle.random(150, 100, false));
        stuffDraw.add(MyRect.random(150, 100, false));
        stuffDraw.add(MyRect.random(150, 100, false));
        stuffDraw.add(Ellipse.random(150, 100, false));
        stuffDraw.add(MyRect.random(150, 100, false));
        stuffDraw.add(Ellipse.random(150, 100, false));
        stuffDraw.add(MyRect.random(150, 100, false));
        stuffDraw.add(Ellipse.random(150, 100, false));
        stuffDraw.add(MyRect.random(150, 100, false));

        timer = new Timer();
        task = new TimerTask() {
            int counter = 1;

            @Override
            public void run() {
                int t = 0;
                if (pause) {
                    return;
                }

                heli.draw(canvasGraphics);
                heli.xoay(ANGLE + counter % 10, heli.getCenter());

                for (int i = 0; i < stuffDraw.size(); i++) {
                    stuffDraw.get(i).dich(0, -1);
                    if (stuffDraw.get(i).isOut(100)) {
                        if (stuffDraw.get(i) instanceof MyRect) {
                            stuffDraw.set(i, MyRect.random(150, 100, true));
                        } else if (stuffDraw.get(i) instanceof Circle) {
                            stuffDraw.set(i, Circle.random(150, 100, true));
                        } else if (stuffDraw.get(i) instanceof Ellipse) {
                            stuffDraw.set(i, Ellipse.random(150, 100, true));
                        }
                    }
                }
                counter++;
                repaint();
            }
        };

        timer.scheduleAtFixedRate(task, 0, 100);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (drawGrid) {
            veGrid(canvasGraphics);
        }
        if (drawOxy) {
            veOxy(canvasGraphics);
        }

        heli.draw(canvasGraphics);

        for (Shapes2D s : stuffDraw) {
            s.draw(canvasGraphics);
        }

        g.drawImage(canvas, 0, 0, this);
    }

    public void veOxy(Graphics g) {
        //vẽ 2 trục Ox, Oy
        g.setColor(Color.red);
        TrucToaDo.bresenhamLine(g, 0, -deltaY + 1, 0, deltaY);
        TrucToaDo.bresenhamLine(g, -deltaX, 0, deltaX - 1, 0);

        g.setColor(Color.black);
    }

    public void veGrid(Graphics g) {
        super.paintComponent(g);
        int chieuDaiPanel = this.getWidth();
        int chieuRongPanel = this.getHeight();
        //vẽ các đường dọc
        for (int i = 0; i <= chieuDaiPanel; i = i + 5) {
            g.setColor(Color.LIGHT_GRAY);
            g.drawLine(i, 0, i, chieuRongPanel);
        }
        //vẽ các dường ngang
        for (int i = 0; i <= chieuRongPanel; i = i + 5) {
            g.setColor(Color.LIGHT_GRAY);
            g.drawLine(0, i, chieuDaiPanel, i);
        }
    }

    public void setDrawGrid(boolean b) {
        drawGrid = b;
    }

    public void setDrawOxy(boolean b) {
        drawOxy = b;
    }
}

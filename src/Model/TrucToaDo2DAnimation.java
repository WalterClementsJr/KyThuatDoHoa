/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.fHome;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

/**
 *
 * @author Tuong
 */
public class TrucToaDo2DAnimation extends JPanel {

    public static int deltaX = 375 / 5;//nửa chiều dài của trục Ox chia cho độ lớn 1 pixel
    public static int deltaY = 250 / 5;//nửa chiều dài của trục oy chia cho độ lớn 1 pixel
    public static int MAX_OBJECT = 15;

    // chiều tịnh tiến heli
    public static int heliX, heliY;
    public static final double ANGLE = (2 * Math.PI / 8);

    public BufferedImage canvas
            = new BufferedImage(750, 500, BufferedImage.TYPE_INT_ARGB);

    public static Graphics canvasGraphics;

    public static Heli heli = new Heli(new Point(-20, -0), 10, 30);

    ArrayList<Shapes2D> stuffDraw = new ArrayList<>();

    public static Timer timer;
    public static TimerTask task;
    public static boolean pause = true;

    public static Shapes2D tempShape;
    private boolean drawGrid = true;
    private boolean drawOxy = true;

    public TrucToaDo2DAnimation() {
        canvasGraphics = this.canvas.getGraphics();

        int random;
        for (int i = 0; i < MAX_OBJECT; i++) {
            random = (int) (Math.random() * 4);
            switch (random) {
                case 0:
                    stuffDraw.add(MyRect.random(150, 100, false));
                    break;
                case 1:
                    stuffDraw.add(Circle.random(150, 100, false));
                    break;
                case 2:
                    stuffDraw.add(Ellipse.random(150, 100, false));
                    break;
                default:
                    stuffDraw.add(Ellipse.random(150, 100, false));
            }
        }

        timer = new Timer();
        task = new TimerTask() {
            int counter = 1;

            @Override
            public void run() {
                if (pause) {
                    return;
                }

                heli.xoay(ANGLE + counter % 10, heli.getCenter());

                if (fHome.left && fHome.up) {
                    heliX = -1;
                    heliY = 1;
                } else if (fHome.left && fHome.down) {
                    heliX = -1;
                    heliY = -1;
                } else if (fHome.right && fHome.up) {
                    heliX = 1;
                    heliY = 1;
                } else if (fHome.right && fHome.down) {
                    heliX = 1;
                    heliY = -1;
                } else if (fHome.left) {
                    heliX = -1;
                    heliY = 0;
                } else if (fHome.up) {
                    heliX = 0;
                    heliY = 1;
                } else if (fHome.right) {
                    heliX = 1;
                    heliY = 0;
                } else if (fHome.down) {
                    heliX = 0;
                    heliY = -1;
                }

                if (TrucToaDo2DAnimation.heli.getCenter().x > 75) {
                    heliX = -1;
                } else if (TrucToaDo2DAnimation.heli.getCenter().x < -75) {
                    heliX = 1;
                } else if (TrucToaDo2DAnimation.heli.getCenter().y > 50) {
                    heliY = -1;
                } else if (TrucToaDo2DAnimation.heli.getCenter().y < -50) {
                    heliY = 1;
                }
                heli.dich(heliX, heliY);
                heliX = heliY = 0;

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
        timer.scheduleAtFixedRate(task, 0, 90);
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

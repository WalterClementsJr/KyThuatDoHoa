/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Tuong
 */
public class TrucToaDo2DAnimation extends JPanel {

    public static int deltaX = 375 / 5;//nửa chiều dài của trục Ox chia cho độ lớn 1 pixel
    public static int deltaY = 250 / 5;//nửa chiều dài của trục oy chia cho độ lớn 1 pixel

    public static ArrayList<Shapes2D> shapeList = new ArrayList<>();
    public static Shapes2D tempShape;
    private boolean drawGrid = true;
    private boolean drawOxy = true;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (drawGrid) veGrid(g);
        if (drawOxy) veOxy(g);

        for (Shapes2D shape : shapeList) {
            System.out.println(shapeList.size());
            shape.draw(g);
        }

        if (tempShape != null) {
            tempShape.draw(g);
        }
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

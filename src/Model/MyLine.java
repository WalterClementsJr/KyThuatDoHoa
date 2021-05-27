package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class MyLine implements Shapes2D {

    private Point A, B;
    Graphics g;

    public MyLine(Point a, Point b) {
        A = a;
        B = b;
    }


    @Override
    public void draw(Graphics g) {
        g.setColor(DEFAULT_COLOR);
        TrucToaDo.bresenhamLine(g, A.x, A.y, B.x, B.y);
    }

    @Override
    public void draw(Graphics g, Color c) {
        g.setColor(c);
        TrucToaDo.bresenhamLine(g, A.x, A.y, B.x, B.y);
    }

    @Override
    public void fill(Graphics g, Color color) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


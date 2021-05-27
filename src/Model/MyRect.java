package Model;

import static Model.TrucToaDo.bresenhamLine;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class MyRect implements Shapes2D {

    private Point A, B;

    public MyRect(Point a, Point b) {
        A = a;
        B = b;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(DEFAULT_COLOR);
        bresenhamLine(g, A.x, A.y, B.x, A.y);
        bresenhamLine(g, B.x, A.y, B.x, B.y);
        bresenhamLine(g, B.x, B.y, A.x, B.y);
        bresenhamLine(g, A.x, B.y, A.x, A.y);
    }

    @Override
    public void draw(Graphics g, Color c) {
        g.setColor(c);
        bresenhamLine(g, A.x, A.y, B.x, A.y);
        bresenhamLine(g, B.x, A.y, B.x, B.y);
        bresenhamLine(g, B.x, B.y, A.x, B.y);
        bresenhamLine(g, A.x, B.y, A.x, A.y);
    }

    @Override
    public void fill(Graphics g, Color color) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

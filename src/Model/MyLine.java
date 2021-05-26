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
        TrucToaDo.bresenhamLine(g, A.x, A.y, B.x, B.y);
    }

}

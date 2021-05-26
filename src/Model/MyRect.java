package Model;

import static Model.TrucToaDo.bresenhamLine;
import java.awt.Graphics;
import java.awt.Point;

public class MyRect implements Shapes2D {

    private Point A;
    int dai, rong;

    public MyRect(Point a, int dai, int rong) {
        A = a;
        this.dai = dai;
        this.rong = rong;
    }

    @Override
    public void draw(Graphics g) {
        int x1 = A.x + dai;
        int y1 = A.y + rong;
        bresenhamLine(g, A.x, A.y, x1, A.y);
        bresenhamLine(g, x1, A.y, x1, y1);
        bresenhamLine(g, A.x, y1, x1, y1);
        bresenhamLine(g, A.x, A.y, A.x, y1);
    }

}

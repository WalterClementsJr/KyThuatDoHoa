package Model;

import static Model.TrucToaDo.bresenhamLine;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class MyRect implements Shapes2D {

    private Point A, B,C,D;
    private Point originalA, originalB, originalC, originalD;


    public MyRect(Point a, Point c) {
        A = a;
        C = c;
        B=new Point(C.x,A.y);
        D=new Point(A.x,C.y);
        
        originalA = A;
        originalB = B;
        originalC = C;
        originalD = D;
    }

    public MyRect(Point A, Point B, Point C, Point D) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
        originalA = A;
        originalB = B;
        originalC = C;
        originalD = D;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(DEFAULT_COLOR);
        bresenhamLine(g, A.x, A.y, B.x, B.y);
        bresenhamLine(g, B.x, B.y, C.x, C.y);
        bresenhamLine(g, C.x, C.y, D.x, D.y);
        bresenhamLine(g, D.x, D.y, A.x, A.y);
        A = originalA; B = originalB; C = originalC; D = originalD;
    }

    @Override
    public void draw(Graphics g, Color c) {
        g.setColor(c);
        bresenhamLine(g, A.x, A.y, B.x, A.y);
        bresenhamLine(g, B.x, A.y, B.x, B.y);
        bresenhamLine(g, B.x, B.y, A.x, B.y);
        bresenhamLine(g, A.x, B.y, A.x, A.y);
        A = originalA; B = originalB; C = originalC; D = originalD;
    }

    @Override
    public void fill(Graphics g, Color color) {
    }

    @Override
    public void xoay(double radian, Point anchor) {
        A = Rotation.rotateAroundO(A.x, A.y, radian, anchor);
        B = Rotation.rotateAroundO(B.x, B.y, radian, anchor);
        C = Rotation.rotateAroundO(C.x, C.y, radian, anchor);
        D = Rotation.rotateAroundO(D.x, D.y, radian, anchor);
    }

    @Override
    public void dich(int x, int y) {
        A.x += x; A.y += y;
        B.x += x; B.y += y;
        C.x += x; C.y += y;
        D.x += x; D.y += y;
    }
    
    

}

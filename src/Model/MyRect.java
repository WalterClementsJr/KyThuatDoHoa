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


    public Point getA() {
        return A;
    }

    public void setA(Point A) {
        this.A = A;
    }

    public Point getB() {
        return B;
    }

    public void setB(Point B) {
        this.B = B;
    }

    public Point getC() {
        return C;
    }

    public void setC(Point C) {
        this.C = C;
    }

    public Point getD() {
        return D;
    }

    public void setD(Point D) {
        this.D = D;
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
        A.x =originalA.x+ x; A.y =originalA.y+ y;
        B.x =originalB.x+ x; B.y =originalB.y+ y;
        C.x =originalC.x+x; C.y =originalC.y+y;
        D.x =originalD.x+x; D.y =originalD.y+y;
    }

    @Override
    public void bienDang(double heSoBienDang) {
        A.x =(int) Math.round(originalA.x*heSoBienDang)-originalA.x; A.y =(int) Math.round(originalA.y*heSoBienDang)-originalA.y;
        B.x =(int) Math.round(originalB.x*heSoBienDang)-originalA.x; B.y =(int) Math.round(originalB.y*heSoBienDang)-originalA.y;
        C.x =(int) Math.round(originalC.x*heSoBienDang)-originalA.x; C.y =(int) Math.round(originalC.y*heSoBienDang)-originalA.y;
        D.x =(int) Math.round(originalD.x*heSoBienDang)-originalA.x; D.y =(int) Math.round(originalD.y*heSoBienDang)-originalA.y;
    }

    @Override
    public void doiXungOx() {
        A.y = -A.y;
        B.y = -B.y;
        C.y = -C.y;
        D.y=-D.y;
    }

    @Override
    public void doiXungOy() {
        A.x = -A.x; 
        B.x = -B.x;
        C.x = -C.x;
        D.x=-D.x;
    }
   
}

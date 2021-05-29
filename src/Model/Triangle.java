/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

/**
 *
 * @author walker
 */
public class Triangle implements Shapes2D {

    private Point A, B, C;
    private Point originalA, originalB, originalC;
    int canh;

    public Triangle(Point a, int canh) {
        A = a;
        this.canh = canh;
    }

    /**
     * Vẽ tam giác với 2 điểm kéo thả
     *
     * @param a
     * @param b
     */
    public Triangle(Point A, Point B, Point C) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.originalA = new Point(A.x,A.y);
        this.originalB = new Point(B.x,B.y);
        this.originalC = new Point(C.x,C.y);
    }

    public Triangle(Point a, Point b) {
        A = new Point();
        B = new Point();
        C = new Point();
        
        A.x = (a.x + b.x) / 2;
        A.y = Math.max(a.y, b.y);
        B.x = Math.min(a.x, b.x);
        B.y = Math.min(a.y, b.y);
        C.x = Math.max(a.x, b.x);
        C.y = Math.min(a.y, b.y);
        
        this.originalA = new Point(A.x,A.y);
        this.originalB = new Point(B.x,B.y);
        this.originalC = new Point(C.x,C.y);
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);

        TrucToaDo.bresenhamLine(g, A.x, A.y, B.x, B.y);
        TrucToaDo.bresenhamLine(g, C.x, C.y, B.x, B.y);
        TrucToaDo.bresenhamLine(g, A.x, A.y, C.x, C.y);
//        A = originalA; B = originalB; C = originalC;
    }

    @Override
    public void draw(Graphics g, Color c) {
        g.setColor(c);

        TrucToaDo.bresenhamLine(g, A.x, A.y, B.x, B.y);
        TrucToaDo.bresenhamLine(g, C.x, C.y, B.x, B.y);
        TrucToaDo.bresenhamLine(g, A.x, A.y, C.x, C.y);
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

    public int getCanh() {
        return canh;
    }

    public void setCanh(int canh) {
        this.canh = canh;
    }


    @Override
    public void xoay(double radian, Point anchor) {
//        if (radian > 6) {
//            radian %= 6;
//        }
        A = Rotation.rotateAroundO(originalA.x, originalA.y, radian, anchor);
        B = Rotation.rotateAroundO(originalB.x, originalB.y, radian, anchor);
        C = Rotation.rotateAroundO(originalC.x, originalC.y, radian, anchor);
    }

    @Override
    public void dich(int x, int y) {
        A.x =originalA.x +x; A.y =originalA.y +y;
        B.x =originalB.x +x; B.y =originalB.y +y;
        C.x =originalC.x +x; C.y =originalC.y +y;
    }
    @Override
    public void doiXungOx() {
        A.y = -A.y;
        B.y = -B.y;
        C.y = -C.y;
    }

    @Override
    public void doiXungOy() {
        A.x = -A.x; 
        B.x = -B.x;
        C.x = -C.x;

}

    @Override
    public void thuPhong(double heSoThuPhong) {
        //thu phóng rồi tịnh tiến về A
        double tempAx = originalA.x;
        tempAx=tempAx*heSoThuPhong;
        int dentaX=originalA.x - (int) Math.round(tempAx);        
        A.x=originalA.x;
        double tempAy=A.y;
        tempAy=tempAy*heSoThuPhong;
        int dentaY=originalA.y - (int) Math.round(tempAy);
        A.y =originalA.y;
        
        double tempBx = originalB.x;
        tempBx=tempBx*heSoThuPhong;
        B.x =(int) Math.round(tempBx)+dentaX;
        double tempBy = originalB.y;
        tempBy=tempBy*heSoThuPhong;
        B.y =(int) Math.round(tempBy)+dentaY;
        double tempCx = originalC.x;
        tempCx=tempCx*heSoThuPhong;
        C.x =(int) Math.round(tempCx)+dentaX;
        double tempCy = originalC.y;
        tempCy=tempCy*heSoThuPhong;
        C.y =(int) Math.round(tempCy)+dentaY;
    }
    
}
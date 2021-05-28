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

    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);

        TrucToaDo.bresenhamLine(g, A.x, A.y, B.x, B.y);
        TrucToaDo.bresenhamLine(g, C.x, C.y, B.x, B.y);
        TrucToaDo.bresenhamLine(g, A.x, A.y, C.x, C.y);
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
//        Polygon triangle = new Polygon();
//        Point x = TrucToaDo.convertPointDescart(A);
//        Point y = TrucToaDo.convertPointDescart(B);
//        Point z = TrucToaDo.convertPointDescart(C);
//
//        triangle.addPoint(x.x, x.y);
//        triangle.addPoint(y.x, y.y);
//        triangle.addPoint(z.x, z.y);
//        g.setColor(color);
//        g.fillPolygon(triangle);
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

}

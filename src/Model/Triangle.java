/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author walker
 */
public class Triangle implements Shapes2D {

    private Point A;
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
    public Triangle(Point a, Point b) {
        canh = Math.abs(a.y - b.y);
        A = new Point((a.x + b.x) / 2, Math.max(a.y, b.y));
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        //khai bao tọa độ các đỉnh
        int xA, yA, xB, yB, xC, yC, aH;
        xA = A.x;
        yA = A.y;
        aH = (int) Math.sqrt(3) * canh / 2;
        xB = xA + canh;
        yB = yA;//+ aH để đỉnh luôn ở trên
        xC = xA + canh / 2;
        yC = yA + aH;
        TrucToaDo.bresenhamLine(g, xA, yA, xB, yB);
        TrucToaDo.bresenhamLine(g, xA, yA, xC, yC);
        TrucToaDo.bresenhamLine(g, xB, yB, xC, yC);
    }
}

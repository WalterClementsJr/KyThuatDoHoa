/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static Model.TrucToaDo.putPixel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author walker
 */
public class Circle implements Shapes2D {

    Point O, originalO;
    int radius, originalRadius;

    public Circle(Point A, int radius) {
        this.O = A;
        this.radius = radius;
        originalO = new Point(O.x,O.y);
        originalRadius=radius;
    }
    
    public Circle(Point A, Point B) {
        this.O = A; 
        originalO=new Point(O.x,O.y);
        this.radius = (int) Math.sqrt((B.x - A.x) * (B.x - A.x) + (B.y - A.y) * (B.y - A.y)) / 5;
        originalRadius=radius;
    }

    @Override
    public void draw(Graphics g) {
        int x, y, p;
        x = 0;
        y = radius;
        p = 3 - 2 * radius;
        putPixel(g, O.x + radius, O.y + 0);
        putPixel(g, O.x - radius, O.y - 0);
        putPixel(g, O.x - 0, O.y + radius);
        putPixel(g, O.x + 0, O.y - radius);
        while (x < y) {
            if (p < 0) {
                p += 4 * x + 6;
            } else {
                p += 4 * (x - y) + 10;
                y--;
            }
            x++;
            putPixel(g, O.x + x, O.y + y);
            putPixel(g, O.x - x, O.y - y);
            putPixel(g, O.x - y, O.y + x);
            putPixel(g, O.x + y, O.y - x);
            putPixel(g, O.x + y, O.y + x);
            putPixel(g, O.x - y, O.y - x);
            putPixel(g, O.x - x, O.y + y);
            putPixel(g, O.x + x, O.y - y);
        }
        putPixel(g, O.x + y, O.y + y);
        putPixel(g, O.x - y, O.y - y);
        putPixel(g, O.x - y, O.y + y);
        putPixel(g, O.x + y, O.y - y);
    }

    @Override
    public void draw(Graphics g, Color c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void fill(Graphics g, Color color) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void xoay(double radian, Point anchor) {
        O = Rotation.rotateAroundO(originalO.x, originalO.y, radian, anchor);
    }

    @Override
    public void dich(int x, int y) {
        O.x = O.x+x; O.y = O.y + y;
    }

    @Override
    public void doiXungOx() {
        O.y=-O.y;
}

    @Override
    public void doiXungOy() {
        O.x=-O.x;      
    }

    @Override
    public void thuPhong(double heSoThuPhong) {
        radius=(int) Math.round(originalRadius*heSoThuPhong);
    }

    @Override
    public void setRadianAndAnchor(double radian, Point anchor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static Model.TrucToaDo.putPixel;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author walker
 */
public class Circle implements Shapes2D {

    Point A;
    int radius;

    public Circle(Point A, int radius) {
        this.A = A;
        this.radius = radius;
    }

    @Override
    public void draw(Graphics g) {
        int x, y, p;
        x = 0;
        y = radius;
        p = 3 - 2 * radius;
        putPixel(g, A.x + radius, A.y + 0);
        putPixel(g, A.x - radius, A.y - 0);
        putPixel(g, A.x - 0, A.y + radius);
        putPixel(g, A.x + 0, A.y - radius);
        while (x < y) {
            if (p < 0) {
                p += 4 * x + 6;
            } else {
                p += 4 * (x - y) + 10;
                y--;
            }
            x++;
            putPixel(g, A.x + x, A.y + y);
            putPixel(g, A.x - x, A.y - y);
            putPixel(g, A.x - y, A.y + x);
            putPixel(g, A.x + y, A.y - x);
            putPixel(g, A.x + y, A.y + x);
            putPixel(g, A.x - y, A.y - x);
            putPixel(g, A.x - x, A.y + y);
            putPixel(g, A.x + x, A.y - y);
        }
        putPixel(g, A.x + y, A.y + y);
        putPixel(g, A.x - y, A.y - y);
        putPixel(g, A.x - y, A.y + y);
        putPixel(g, A.x + y, A.y - y);
    }

}

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
public class Ellipse implements Shapes2D {

    // top left 
    Point A;
    // bottom right
    Point B;

    Point O;
    int dai, cao;

    public Ellipse(Point A, Point B) {
        this.A = A;
        this.B = B;
        O = new Point();
        dai = Math.abs(A.x - B.x);
        cao = Math.abs(A.y - B.y);
        O.x = (A.x + B.x) / 2;
        O.y = (A.y + B.y) / 2;
    }

    void plot(Graphics g, int xc, int yc, int x, int y) {
        putPixel(g, xc + x, yc + y);
        putPixel(g, xc - x, yc + y);
        putPixel(g, xc + x, yc - y);
        putPixel(g, xc - x, yc - y);
    }

    @Override
    public void draw(Graphics g) {
        long x, y, fx, fy, a2, b2, p;
        x = 0;
        y = cao;
        a2 = dai * dai; //dai^2
        b2 = cao * cao; // cao^2
        fx = 0;
        fy = 2 * a2 * y; // 2a^2y
        plot(g, O.x, O.y, Math.round(x), Math.round(y));
        p = Math.round(b2 - (a2 * cao) + (0.25 * dai));

        while (fx < fy) {
            x++;
            fx += 2 * b2; //2b2
            if (p < 0) {
                p += b2 * (2 * x + 3);
            } else {
                y--;
                p += b2 * (2 * x + 3) + a2 * (-2 * y + 2);

                fy -= 2 * a2; // 2a2
            }
            plot(g, O.x, O.y, Math.round(x), Math.round(y));
        }
        p = Math.round(b2 * (x + 0.5) * (x + 0.5) + a2 * (y - 1) * (y - 1) - a2 * b2);

        while (y > 0) {
            y--;
            fy -= 2 * a2; // 2a2
            if (p >= 0) {
                p += a2 * (3 - 2 * y);
            } else {
                x++;
                fx += 2 * b2; // 2b2
                p += b2 * (2 * x + 2) + a2 * (-2 * y + 3);

            }
            plot(g, O.x, O.y, Math.round(x), Math.round(y));
        }
    }

    @Override
    public void draw(Graphics g, Color c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void fill(Graphics g, Color color) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

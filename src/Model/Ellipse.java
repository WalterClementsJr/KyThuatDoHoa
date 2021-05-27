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

    Point O;
    int dai, cao;

    public Ellipse(Point A, Point B) {
        O = new Point();
        dai = Math.abs(A.x - B.x);
        cao = Math.abs(A.y - B.y);
        O.x = (A.x + B.x) / 2;
        O.y = (A.y + B.y) / 2;
    }

    public static void drawHalfDottedEllipse(Graphics g, Point a, int dai) {
        double dx, dy, d1, d2;
        int x, y, cao = (int) dai / 2;
        x = 0;
        y = cao;

        // Initial decision parameter of region 1
        d1 = (cao * cao) - (dai * dai * cao) + (0.25 * dai * dai);
        dx = 2 * cao * cao * x;
        dy = 2 * dai * dai * y;
        int count = 0;
        int count2 = 0;

        while (dx < dy) {
            if (x % 5 == 0) {
//                ctx.fillRect((x + xc), (y + yc), 4, 4);
//                ctx.fillRect((-x + xc), (y + yc), 4, 4);
                TrucToaDo.putPixel(g, x + a.x, y + a.y);
                TrucToaDo.putPixel(g, -x + a.x, y + a.y);
                count++;
                if (count % 4 != 0) {
//                    ctx.fillRect((x + xc), (-y + yc), 4, 4);
//                    ctx.fillRect((-x + xc), (-y + yc), 4, 4);
                    TrucToaDo.putPixel(g, x + a.x, -y + a.y);
                    TrucToaDo.putPixel(g, -x + a.x, -y + a.y);
                }
            }

            if (d1 < 0) {
                x++;
                dx = dx + (2 * cao * cao);
                d1 = d1 + dx + (cao * cao);
            } else {
                x++;
                y--;
                dx = dx + (2 * cao * cao);
                dy = dy - (2 * dai * dai);
                d1 = d1 + dx - dy + (cao * cao);
            }
        }

        // Decision parameter of region 2
        d2 = (((cao * cao) * ((x + 0.5) * (x + 0.5)))
                + ((dai * dai) * ((y) * (y)))
                - (dai * dai * cao * cao));

        // Plotting points of region 2
        while (y >= 0) {

            if (y % 5 == 0) {
//                ctx.fillRect((x + xc), (y + yc), 4, 4);
//                ctx.fillRect((-x + xc), (y + yc), 4, 4);
                TrucToaDo.putPixel(g, x + a.x, y + a.y);
                TrucToaDo.putPixel(g, -x + a.x, y + a.y);
                count2++;
                if (count2 % 4 != 0) {
//                    ctx.fillRect((x + xc), (-y + yc), 4, 4);
//                    ctx.fillRect((-x + xc), (-y + yc), 4, 4);
                    TrucToaDo.putPixel(g, x + a.x, -y + a.y);
                    TrucToaDo.putPixel(g, -x + a.x, -y + a.y);
                }
            }

            // Checking and updating parameter
            // value based on algorithm
            if (d2 > 0) {
                y--;
                dy = dy - (2 * dai * dai);
                d2 = d2 + (dai * dai) - dy;
            } else {
                y--;
                x++;
                dx = dx + (2 * cao * cao);
                dy = dy - (2 * dai * dai);
                d2 = d2 + dx - dy + (dai * dai);
            }
        }
    }

    public static void drawHalfDashed(Graphics g, int xO, int yO, int a, int b) {
        //Gấp 5 lần
        xO = xO * 5;
        yO = yO * 5;
//        a = a * 5;
//        b = b * 5;

        System.out.println("half dashed");
        //khai bao cac bien cua thuat toan Midpoint
        int dem = 0;
        int dx, dy, p0, q0, x, y;
        x = 0;
        y = b;

        //Khai bao cac bien vung I
        p0 = (int) ((b * b) - (a * a * b) + (0.25 * a * a));
        dx = 2 * b * b * x;
        dy = 2 * a * a * y;

        //Ve vung I
        while (dx < dy) {
            // Ve diem dua tren doi xung
            if (dem < 3) {
                putPixel(g, x +xO, y + -yO);
                putPixel(g, -x +xO, y + -yO);
                dem++;
            } else if (dem < 7) {
                dem++;
            } else {
                dem = 0;
                putPixel(g, x +xO, y + -yO);
                putPixel(g, -x +xO, y + -yO);
            }
            putPixel(g, x +xO, -y + yO);
            putPixel(g, -x +xO, -y + yO);

            // Kiem tra va cap nhat cac gia tri
            if (p0 < 0) {
                x++;
                dx = dx + (2 * b * b);
                p0 = p0 + dx + (b * b);
            } else {
                x++;
                y--;
                dx = dx + (2 * b * b);
                dy = dy - (2 * a * a);
                p0 = p0 + dx - dy + (b * b);
            }
        }
        // Ve vung II
        q0 = (int) (((b * b) * ((x + 0.5) * (x + 0.5))) + ((a * a) * ((y) * (y))) - (a * a * b * b));
        while (y >= 0) {

            // Ve 4 diem
            if (dem < 3) {
                putPixel(g, x +xO, y + -yO);
                putPixel(g, -x +xO, y + -yO);
                dem++;
            } else if (dem < 7) {
                dem++;
            } else {
                dem = 0;
                putPixel(g, x +xO, y + -yO);
                putPixel(g, -x +xO, y + -yO);
            }

            putPixel(g, x +xO, -y + -yO);
            putPixel(g, -x +xO, -y + -yO);
            // Kiem tra va cap nhat cac gia tri
            if (q0 > 0) {
                y--;
                dy = dy - (2 * a * a);
                q0 = q0 + (a * a) - dy;
            } else {
                y--;
                x++;
                dx = dx + (2 * b * b);
                dy = dy - (2 * a * a);
                q0 = q0 + dx - dy + (a * a);
            }
        }
    }

    static void plot(Graphics g, int xc, int yc, int x, int y) {
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
        p = Math.round(b2 * (x + 0.5) * (x + 0.5) + a2 * (y) * (y) - a2 * b2);

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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Tuong
 */
public class TrucToaDo extends JPanel {

    public static int deltaX = 375 / 5;//nửa chiều dài của trục Ox chia cho độ lớn 1 pixel
    public static int deltaY = 250 / 5;//nửa chiều dài của trục oy chia cho độ lớn 1 pixel

    
    public static ArrayList<Shapes2D> shapeList = new ArrayList<>();
    @Override
    public void paint(Graphics g) {
        System.out.println("painting");
        super.paint(g);
        veTrucToaDo(g);

//        Triangle t = new Triangle(30,30,20);
//        t.draw(g);
//        MyLine line =new MyLine(new Point(0, 0), new Point(10, 30));
//        line.draw(g);
//        
//        MyRect rect = new MyRect(new Point(0,0), new Point(10,50));
//        rect.draw(g);
//        
//        Circle c = new Circle(new Point(0,0), 30);
//        c.draw(g);

        for (Shapes2D shape:shapeList) {
            System.out.println(shapeList.size());
            shape.draw(g);
        }
    }

    public void veTrucToaDo(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        int chieuDaiPanel = this.getWidth();
        int chieuRongPanel = this.getHeight();
        //vẽ các đường dọc
        for (int i = 0; i <= chieuDaiPanel; i = i + 5) {
            g.setColor(Color.LIGHT_GRAY);
            g.drawLine(i, 0, i, chieuRongPanel);
        }
        //vẽ các dường ngang
        for (int i = 0; i <= chieuRongPanel; i = i + 5) {
            g.setColor(Color.LIGHT_GRAY);
            g.drawLine(0, i, chieuDaiPanel, i);
        }
        //vẽ 2 trục Ox, Oy
        g.setColor(Color.red);
        bresenhamLine(g, 0, -deltaY + 1, 0, deltaY);
        bresenhamLine(g, -deltaX, 0, deltaX - 1, 0);
//            veDoanThang(g, 0, -deltaY + 1, 0, deltaY);
//            veDoanThang(g, -deltaX, 0, deltaX - 1, 0);

        g.setColor(Color.black);
    }

    public static void putPixel(Graphics g, int x, int y) {
        if (x > 0 && y > 0) {
            x = (x + deltaX) * 5;
            y = (deltaY - y) * 5;
        } else if (x >= 0 && y < 0) {
            x = (x + deltaX) * 5;
            y = (y * -1 + deltaY) * 5;
        } else if (x <= 0 && y > 0) {
            x = (x + deltaX) * 5;
            y = (deltaY - y) * 5;
        } else if (x < 0 && y < 0) {
            x = (x + deltaX) * 5;
            y = (y * -1 + deltaY) * 5;
        } else {
            x = (x + deltaX) * 5;
            y = (y + deltaY) * 5;
        }
        g.fillRect(x, y, 5, 5);
    }

    public static void bresenhamLine(Graphics g, int x1, int y1, int x2, int y2) {
        int x, y, Dx, Dy, p;
        Dx = Math.abs(x2 - x1);
        Dy = Math.abs(y2 - y1);
//        p = 2 * Dy - Dx;
        x = x1;
        y = y1;
        putPixel(g, x, y); //ve diem pixel dau tien

        int x_unit = 1, y_unit = 1;

        putPixel(g, x, y);

        //xét trường hợp để cho y_unit và x_unit để vẽ tăng lên hay giảm xuống
        if (x2 - x1 < 0) {
            x_unit = -x_unit;
        }
        if (y2 - y1 < 0) {
            y_unit = -y_unit;
        }
        if (Dx >= Dy) {
            p = 2 * Dy - Dx;

            while (x != x2) {
                if (p < 0) {
                    p += 2 * Dy;
                } else {
                    p += 2 * (Dy - Dx);
                    y += y_unit;
                }
                x += x_unit;
                putPixel(g, x, y);
            }
        } else {
            p = 2 * Dx - Dy;

            while (y != y2) {
                if (p < 0) {
                    p += 2 * Dx;
                } else {
                    p += 2 * (Dx - Dy);
                    x += x_unit;
                }
                y += y_unit;
                putPixel(g, x, y);
            }
        }
    }


    void plot(Graphics g, int xc, int yc, int x, int y) {
        putPixel(g, xc + x, yc + y);
        putPixel(g, xc - x, yc + y);
        putPixel(g, xc + x, yc - y);
        putPixel(g, xc - x, yc - y);
    }

    void Mid_ellipse(Graphics g, int xc, int yc, int a, int b) {
        long x, y, fx, fy, a2, b2, p;
        x = 0;
        y = b;
        a2 = a * a; //a^2
        b2 = b * b; // b^2
        fx = 0;
        fy = 2 * a2 * y; // 2a^2y
        plot(g, xc, yc, Math.round(x), Math.round(y));
        p = Math.round(b2 - (a2 * b) + (0.25 * a));

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
            plot(g, xc, yc, Math.round(x), Math.round(y));
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
            plot(g, xc, yc, Math.round(x), Math.round(y));
        }
    }

    public static void dashedLine(Graphics g, int x1, int y1, int x2, int y2) {
        int x, y, dx, dy, p, const1, const2, dem, chieuDaiMoiDoan, khoangCachMoiDoan;
        y = y1;
        dx = x2 - x1;
        dy = y2 - y1;
        p = 2 * dy - dx;
        const1 = 2 * dy;
        const2 = 2 * (dy - dx);
        dem = 0;
        chieuDaiMoiDoan = 6;
        khoangCachMoiDoan = 2;
        for (x = x1; x <= x2; x++) {
            dem++;
            if (dem <= chieuDaiMoiDoan) {
                putPixel(g, x, y);
            } else {
                if (dem > chieuDaiMoiDoan + khoangCachMoiDoan) {
                    //reset bien dem
                    dem = 1;
                    putPixel(g, x, y);
                }
            }

            if (p < 0) {
                p += const1; // p=p + 2dy
            } else {
                p += const2; //p=p+2dy-2dx
                y++;
            }
        }
    }

    public static void dashDotLine(Graphics g, int x1, int y1, int x2, int y2) {
        int x, y, dx, dy, p, const1, const2, dem, chieuDaiMoiDoan, khoangCachMoiDoan;
        y = y1;
        dx = x2 - x1;
        dy = y2 - y1;
        p = 2 * dy - dx;
        const1 = 2 * dy;
        const2 = 2 * (dy - dx);
        dem = 0;
        chieuDaiMoiDoan = 6;
        khoangCachMoiDoan = 2;

        for (x = x1; x <= x2; x++) {
            dem++;
            if (dem <= chieuDaiMoiDoan) {
                putPixel(g, x, y);
            } else {
                if ((dem > chieuDaiMoiDoan && dem <= chieuDaiMoiDoan + khoangCachMoiDoan) || (dem > chieuDaiMoiDoan + khoangCachMoiDoan + 1 && dem <= chieuDaiMoiDoan + 2 * khoangCachMoiDoan + 1)) //vẽ 2 khoảng trăng 2 bên chấm
                {
                    //không putPixel để vẽ khoảng trắng
                } else {
                    if (dem == chieuDaiMoiDoan + khoangCachMoiDoan + 1) {
                        putPixel(g, x, y); //vẽ chấm
                    } else {
                        dem = 1;
                        putPixel(g, x, y);
                    }
                }
            }

            if (p < 0) {
                p += const1; // p=p + 2dy
            } else {
                p += const2; //p=p+2dy-2dx
                y++;
            }
        }
    }

    /**
     * chuyển tọa độ real java sang fake
     * @param p
     * @param deltaX
     * @param deltaY
     * @param xAxisSize
     * @param yAxisSize
     * @return 
     */
    public static Point convertDescart(Point p, double deltaX, double deltaY, int xAxisSize, int yAxisSize) {

        double x = Math.floor(p.getX() / 5);
        double y = -Math.floor(p.getY() / 5);
        if (x >= 0 && y >= 0) {
            x = x - deltaX;
            y = y - deltaY;
        } else if (x >= 0 && y <= 0) {
            x = x - deltaX;
            y = y + deltaY;
        } else if (x <= 0 && y >= 0) {
            x = x + deltaX;
            y = y - deltaY;
        } else {
            x = deltaX-x;
            y = y + deltaY;
        }
        Point pointNew = new Point();
        pointNew.setLocation(x, y);
        return pointNew;
    }

    /**
     * tọa độ 
     * @param p
     * @param deltaX
     * @param deltaY
     * @param xAxisSize
     * @param yAxisSize
     * @return 
     */
    public static Point convertPointDescart(Point p, double deltaX, double deltaY, int xAxisSize, int yAxisSize) {
        deltaX = deltaX + 10;
        deltaX = (deltaX * 5);
        deltaY = (deltaY * 5);
        double x = (p.getX()) * 5;
        double y = (p.getY()) * 5;
        if (x >= 0 && y >= 0) {
            x = x + deltaX;
            y = deltaY - y;
        } else if (x >= 0 && y <= 0) {
            x = x + deltaX;
            y = -y + deltaY;
        } else if (x <= 0 && y >= 0) {
            x = deltaX - x;
            y = deltaY - y;
        } else {
            x = deltaX - x;
            y = deltaY - y;
        }
        Point pointNew = new Point();
        pointNew.setLocation(x , y );
        return pointNew;
    }
}

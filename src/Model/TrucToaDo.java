
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
    public static Shapes2D tempShape;
    public static Shapes2D tempFlag;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        veTrucToaDo(g);

//        dash2DotLine(g, 0, 0, 40, 20);
//        dashDotLine(g, 0, 0, 40, 20);
//        dashedLine(g, 0, 0, 40, 20);
//        drawArrow(g, 10, 10, 40, 10);
        for (Shapes2D shape : shapeList) {
            shape.draw(g);
        }

        if (tempShape != null) {
            tempShape.draw(g);
            tempShape = null;
        }

        if (tempFlag != null) {
            tempFlag.draw(g);
        }
//MyLine.dashedLine(g, -20, 1, 20, 1);
    }

    public void veTrucToaDo(Graphics g) {
        super.paintComponent(g);
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

    public static void dash2DotLine(Graphics g, int x1, int y1, int x2, int y2) {
        // DDA algorithm
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
                if ((dem > chieuDaiMoiDoan && dem <= chieuDaiMoiDoan + khoangCachMoiDoan)
                        || (dem > chieuDaiMoiDoan + khoangCachMoiDoan + 1 && dem <= chieuDaiMoiDoan + 2 * khoangCachMoiDoan + 1)
                        || (dem > chieuDaiMoiDoan + 2 * khoangCachMoiDoan + 2 && dem <= chieuDaiMoiDoan + 3 * khoangCachMoiDoan + 2)) //vẽ 2 khoảng trăng 2 bên chấm
                {
                    //không putPixel để vẽ khoảng trắng
                } else {
                    if ((dem == chieuDaiMoiDoan + khoangCachMoiDoan + 1) || (dem == chieuDaiMoiDoan + 2 * khoangCachMoiDoan + 2)) {
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

    public static void drawArrow(Graphics g, int x1, int y1, int x2, int y2) {
        int x, y, dx, dy, p, const1, const2;
        y = y1;
        dx = x2 - x1;
        dy = y2 - y1;
        p = 2 * dy - dx;
        const1 = 2 * dy;
        const2 = 2 * (dy - dx);
        for (x = x1; x <= x2; x++) {
            putPixel(g, x, y);
            if (p < 0) {
                p += const1; // p=p + 2dy
            } else {
                p += const2; //p=p+2dy-2dx
                y++;
            }
        }
        putPixel(g, x2 - 1, y2 - 1);
        putPixel(g, x2 - 1, y2 + 1);
    }

    /**
     * chuyển tọa độ real java sang fake
     *
     * @param p
     * @param deltaX
     * @param deltaY
     * @param xAxisSize
     * @param yAxisSize
     * @return
     */
    public static Point convertDescart(Point p) {
        double x = Math.round(p.getX() / 5);
        double y = -Math.round(p.getY() / 5);
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
            x = x + deltaX;
            y = y + deltaY;
        }
        Point pointNew = new Point();
        pointNew.setLocation(x, y);
        return pointNew;

    }

    /**
     * tọa độ
     *
     * @param p
     * @param deltaX
     * @param deltaY
     * @param xAxisSize
     * @param yAxisSize
     * @return
     */
    public static Point convertDescartReverse(Point p) {
        int deltaXTemp = deltaX * 5;
        int deltaYTemp = deltaY * 5;
        double x = Math.round(p.getX() * 5);
        double y = Math.round(p.getY() * 5);
        double xJva = 750;
        double yJva = 500;
        if (x >= 0 && y >= 0) {
            x = xJva - (deltaXTemp - x);
            y = yJva - (y + deltaYTemp);
        } else if (x >= 0 && y <= 0) {
            x = xJva - (deltaXTemp - x);
            y = yJva - (deltaYTemp + y);
        } else if (x <= 0 && y >= 0) {
            x = xJva - (deltaXTemp - x);
            y = yJva - (y + deltaYTemp);
        } else {
            x = xJva - (deltaXTemp - x);
            y = yJva - (deltaYTemp + y);
        }
        Point pointNew = new Point();
        pointNew.setLocation(x - 1, y - 1);
        return pointNew;
    }

    public static Point getPointInAxisNew(Point p, int xAxis, int yAxis) {
        Point newP = new Point();
        //tra về điểm trong hệ toạ độ mới
        newP.x = p.x + xAxis;
        newP.y = p.y + yAxis;
        return newP;

    }

    public static Point expandX(Point p) // cộng thêm để bù vào phần bên
    {
        Point diem = new Point();
        diem.x = p.x + 10;
        return new Point(diem.x, p.y);
    }

    public static void main(String[] args) {
        Point a = new Point(15, 15);
        Point b = convertDescartReverse(a);
        Point c = convertDescart(b);
    }
}

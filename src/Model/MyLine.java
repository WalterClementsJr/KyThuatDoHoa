package Model;

import static Model.TrucToaDo.putPixel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class MyLine implements Shapes2D {

    private Point A, B, originalA, originalB;

    public MyLine(Point a, Point b) {
        A = a;
        B = b;
        originalA = new Point(A.x,A.y);
        originalB = new Point(B.x,B.y);
    }
    public static void dashedLine(Graphics g, int x1, int y1, int x2, int y2) {
        int x, y, Dx, Dy, p, dem, chieuDaiMoiDoan, khoangCachMoiDoan;
        Dx = Math.abs(x2 - x1);
        Dy = Math.abs(y2 - y1);
        x = x1;
        y = y1;
        TrucToaDo.putPixel(g, x, y);
        
        int x_unit = 1, y_unit = 1;
        dem = 0;
        chieuDaiMoiDoan = 3;
        khoangCachMoiDoan = 3;
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
                dem++;
                if (p < 0) {
                    p += 2 * Dy;
                } else {
                    p += 2 * (Dy - Dx);
                    y += y_unit;
                }
                x += x_unit;
                if (dem <= chieuDaiMoiDoan) {
                    System.out.println("put");
                    TrucToaDo.putPixel(g, x, y);
                }
                else
                {
                    if (dem>chieuDaiMoiDoan&&dem<=chieuDaiMoiDoan+khoangCachMoiDoan)
                    {
                        System.out.println("no put");
                        //không put pixel
                    }
                    else
                    {
                        dem=1;
                        System.out.println("put");
                        TrucToaDo.putPixel(g, x, y);
                    }
                }
            }
        } else {
            p = 2 * Dx - Dy;

            while (y != y2) {
                dem++;
                if (p < 0) {
                    p += 2 * Dx;
                } else {
                    p += 2 * (Dx - Dy);
                    x += x_unit;
                }
                y += y_unit;
                if (dem <= chieuDaiMoiDoan) {
                    System.out.println("put");
                    TrucToaDo.putPixel(g, x, y);
                }
                else
                {
                    if (dem>chieuDaiMoiDoan&&dem<=chieuDaiMoiDoan+khoangCachMoiDoan)
                    {
                        System.out.println("no put");
                        //không put pixel
                    }
                    else
                    {
                        dem=1;
                        System.out.println("put");
                        TrucToaDo.putPixel(g, x, y);
                    }
                }
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(DEFAULT_COLOR);
        TrucToaDo.bresenhamLine(g, A.x, A.y, B.x, B.y);
    }

    @Override
    public void draw(Graphics g, Color c) {
        g.setColor(c);
        TrucToaDo.bresenhamLine(g, A.x, A.y, B.x, B.y);
//        A = originalA; B = originalB;
    }

    @Override
    public void fill(Graphics g, Color color) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void xoay(double radian, Point anchor) {
        A = Rotation.rotateAroundO(A.x, A.y, radian, anchor);
        B = Rotation.rotateAroundO(B.x, B.y, radian, anchor);
    }

    @Override
    public void dich(int x, int y) {
        A.x =A.x+ x; A.y =A.y+ y;
        B.x =B.x+ x; B.y =B.y+ y;
    }

    @Override
    public void doiXungOx() {
        A.y = -A.y; 
        B.y=-B.y;
}

    @Override
    public void doiXungOy() {
        A.x=-A.x;
        B.x=-B.x;
    }

    @Override
    public void thuPhong(double heSoThuPhong) {
        //thu phóng và tịnh tiến về lại điểm A
        double tempAx = originalA.x;
        System.out.println(originalA);
        tempAx=tempAx*heSoThuPhong;
        int dentaX=originalA.x - (int) Math.round(tempAx);        
        A.x=originalA.x;
        double tempAy=A.y;
        tempAy=tempAy*heSoThuPhong;
        int dentaY=originalA.y - (int) Math.round(tempAy);
        A.y =originalA.y;
        
        double tempBx = originalB.x;
        System.out.println(originalB);
        tempBx=tempBx*heSoThuPhong;
        B.x =(int) Math.round(tempBx)+dentaX;
        double tempBy = originalB.y;
        tempBy=tempBy*heSoThuPhong;
        B.y =(int) Math.round(tempBy)+dentaY;
          

    }
    
    
}


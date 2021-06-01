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
import java.util.ArrayList;

/**
 *
 * @author walker
 */
public class Ellipse implements Shapes2D {

    Point O, originalO;
    int dai, cao, originalDai, originalCao;
    static int dem = 0;
    double radian = 0;
    Point anchor = new Point(0, 0);
    public Color colorShape=Color.BLACK;
    ArrayList<Point> DSDiem=new ArrayList<Point>();
    ArrayList<Point> originalDSDiem=new ArrayList<Point>();
    @Override
    public void setColor(Color colorShape) {
        this.colorShape=colorShape;
    }

    public Point getO() {
        return O;
    }

    public int getDai() {
        return dai;
    }

    public int getCao() {
        return cao;
    }

    public void setDai(int dai) {
        this.dai = dai;
    }

    public void setCao(int cao) {
        this.cao = cao;
    }
    
    public Ellipse(Point A, Point B) {
        O = new Point();
        dai = Math.abs(A.x - B.x);
        cao = Math.abs(A.y - B.y);
        O.x = (A.x + B.x) / 2;
        O.y = (A.y + B.y) / 2;
        originalO = new Point(O.x, O.y);
        originalDai = dai;
        originalCao = cao;
        createEllipse(originalO,originalDai,originalCao);
    }
    public void createEllipse(Point originalO, int dai, int cao)
    {
        long x, y, fx, fy, a2, b2, p;
        x = 0;
        y = cao;
        a2 = dai * dai; //dai^2
        b2 = cao * cao; // cao^2
        fx = 0;
        fy = 2 * a2 * y; // 2a^2y
        generatePointsWithRotate(originalO.x, originalO.y, Math.round(x), Math.round(y), radian, anchor);
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
            generatePointsWithRotate(originalO.x, originalO.y, Math.round(x), Math.round(y), radian, anchor);
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
            generatePointsWithRotate(originalO.x, originalO.y, Math.round(x), Math.round(y), radian, anchor);
        }
    }

    @Override
    public void setRadianAndAnchor(double radian, Point anchor) {
        this.radian = radian;
        this.anchor = anchor;
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
                TrucToaDo.putPixel(g, x + a.x, y + a.y);
                TrucToaDo.putPixel(g, -x + a.x, y + a.y);
                count++;
                if (count % 4 != 0) {
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
                TrucToaDo.putPixel(g, x + a.x, y + a.y);
                TrucToaDo.putPixel(g, -x + a.x, y + a.y);
                count2++;
                if (count2 % 4 != 0) {
                    TrucToaDo.putPixel(g, x + a.x, -y + a.y);
                    TrucToaDo.putPixel(g, -x + a.x, -y + a.y);
                }
            }

            // Checking and updating parameter value based on algorithm
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

    public static void drawHalfDashed(Graphics g, int xc, int yc, int a, int b) {
        long x, y, fx, fy, a2, b2, p;
        x = 0;
        y = b;
        a2 = a * a; //a^2
        b2 = b * b; // b^2
        fx = 0;
        fy = 2 * a2 * y; // 2a^2y
        int chieuDaiMoiDoan = 4;
        int khoangCachMoiDoan = 2;
        plotDash(g, xc, yc, Math.round(x), Math.round(y), chieuDaiMoiDoan, khoangCachMoiDoan);
        p = Math.round(b2 - (a2 * b) + (0.25 * a));

        while (fx < fy) {
            dem++;
            x++;
            fx += 2 * b2; //2b2
            if (p < 0) {
                p += b2 * (2 * x + 3);
            } else {
                y--;
                p += b2 * (2 * x + 3) + a2 * (-2 * y + 2);

                fy -= 2 * a2; // 2a2
            }
            plotDash(g, xc, yc, Math.round(x), Math.round(y), chieuDaiMoiDoan, khoangCachMoiDoan);
        }
        p = Math.round(b2 * (x + 0.5) * (x + 0.5) + a2 * (y - 1) * (y - 1) - a2 * b2);

        while (y > 0) {
            dem++;
            y--;
            fy -= 2 * a2; // 2a2
            if (p >= 0) {
                p += a2 * (3 - 2 * y);
            } else {
                x++;
                fx += 2 * b2; // 2b2
                p += b2 * (2 * x + 2) + a2 * (-2 * y + 3);

            }
            plotDash(g, xc, yc, Math.round(x), Math.round(y), chieuDaiMoiDoan, khoangCachMoiDoan);
        }
    }

    public void plot(Graphics g, int xc, int yc, int x, int y) {
        putPixel(g, xc + x, yc + y);
        putPixel(g, xc - x, yc + y);
        putPixel(g, xc + x, yc - y);
        putPixel(g, xc - x, yc - y);
    }

    public void generatePointsWithRotate(int xc, int yc, int x, int y, double radian, Point anchor) {
        Point a = Rotation.rotateAroundO(xc + x, yc + y, radian, anchor);
        Point b = Rotation.rotateAroundO(xc - x, yc + y, radian, anchor);
        Point c = Rotation.rotateAroundO(xc + x, yc - y, radian, anchor);
        Point d = Rotation.rotateAroundO(xc - x, yc - y, radian, anchor);
        DSDiem.add(a);
        DSDiem.add(b);
        DSDiem.add(c);
        DSDiem.add(d);
        Point originalA=new Point(a.x,a.y);
        Point originalB=new Point(b.x,b.y);
        Point originalC=new Point(c.x,c.y);
        Point originalD=new Point(d.x,d.y);
        originalDSDiem.add(originalA);
        originalDSDiem.add(originalB);
        originalDSDiem.add(originalC);
        originalDSDiem.add(originalD);
        
    }

    static void plotDash(Graphics g, int xc, int yc, int x, int y, int chieuDaiMoiDoan, int khoangCachMoiDoan) {

        if (dem <= chieuDaiMoiDoan) {
            putPixel(g, xc + x, yc + y);
            putPixel(g, xc - x, yc + y);
        } else {
            if (dem > chieuDaiMoiDoan && dem <= chieuDaiMoiDoan + khoangCachMoiDoan) {
                //không put pixel
            } else {
                dem = 1;
                putPixel(g, xc + x, yc + y);
                putPixel(g, xc - x, yc + y);
            }
        }
        putPixel(g, xc + x, yc - y);
        putPixel(g, xc - x, yc - y);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(colorShape);
        for (Point i:DSDiem)
        {
            putPixel(g, i.x, i.y);
        }
//        O = originalO;
    }

    @Override
    public void draw(Graphics g, Color c) {
    }

    @Override
    public void fill(Graphics g, Color color) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void xoay(double radian, Point anchor) {
        O = Rotation.rotateAroundO(originalO.x, originalO.y, radian, anchor);
        for (int i=0;i<DSDiem.size();i++)
        {
            DSDiem.set(i, Rotation.rotateAroundO(originalDSDiem.get(i).x, originalDSDiem.get(i).y, radian, anchor));
        }
    }

    @Override
    public void dich(int x, int y) {
        O.x = O.x + x;
        O.y = O.y + y;
        for (int i=0;i<DSDiem.size();i++)
        {
            DSDiem.get(i).x=DSDiem.get(i).x+x;
            DSDiem.get(i).y=DSDiem.get(i).y+y;
            originalDSDiem.get(i).x=DSDiem.get(i).x;
            originalDSDiem.get(i).y=DSDiem.get(i).y;
        }
        originalO.x = O.x;
        originalO.y = O.y;
    }

    @Override
    public void doiXungOx() {
        O.y = -O.y;
        for (int i=0;i<DSDiem.size();i++)
        {
            DSDiem.get(i).y=-DSDiem.get(i).y;
            originalDSDiem.get(i).x=DSDiem.get(i).x;
            originalDSDiem.get(i).y=DSDiem.get(i).y;        
        }
        originalO.x = O.x;
        originalO.y = O.y;
    }

    @Override
    public void doiXungOy() {
        O.x = -O.x;
        for (int i=0;i<DSDiem.size();i++)
        {
            DSDiem.get(i).x=-DSDiem.get(i).x;
            originalDSDiem.get(i).x=DSDiem.get(i).x;    
            originalDSDiem.get(i).y=DSDiem.get(i).y;  
        }
        originalO.x = O.x;
        originalO.y = O.y;
    }

    @Override
    public void thuPhong(double heSoThuPhong) {
        if (DSDiem.get(0).y==O.y)
        {
            radian=-Math.PI/2;
        }
        else
        {
            radian=-Math.atan((double) (DSDiem.get(0).x-O.x)/(DSDiem.get(0).y-O.y));//tính góc quay dựa vào hệ số góc
        }
        double tempOx = originalO.x;
        tempOx = tempOx * heSoThuPhong;
        O.x =(int) Math.round(tempOx);
        double tempOy = originalO.y;
        tempOy = tempOy * heSoThuPhong;
        O.y =(int) Math.round(tempOy);
        anchor.x=O.x;
        anchor.y=O.y;
        DSDiem.clear();
        originalDSDiem.clear();
        createEllipse(O, (int) Math.round(originalDai*heSoThuPhong), (int) Math.round(originalCao*heSoThuPhong));
        originalDai=(int) Math.round(originalDai*heSoThuPhong);
        originalCao=(int) Math.round(originalCao*heSoThuPhong);
        originalO.x = O.x;
        originalO.y = O.y;
        
        
//            double tempX= i.x;
//        tempX = tempX * heSoThuPhong;
//        int dentaX = originalO.x - (int) Math.round(tempX);
//        i.x = (int) Math.round(tempX) + dentaX;
//        double tempY = i.y;
//        tempY = tempY * heSoThuPhong;
//        int dentaY = originalO.y - (int) Math.round(tempY);
//        i.y = (int) Math.round(tempY) + dentaY;
//        for (Point i:DSDiem)
//        {
//            
//        }
//
//        double tempBx = originalB.x;
//
//        tempBx = tempBx * heSoThuPhong;
//        B.x = (int) Math.round(tempBx) + dentaX;
//        double tempBy = originalB.y;
//        tempBy = tempBy * heSoThuPhong;
//        B.y = (int) Math.round(tempBy) + dentaY;
//        originalA.x = A.x;
//        originalA.y = A.y;
//        originalB.x = B.x;
//        originalB.y = B.y;
////        originalDai = dai;
////        originalCao = cao;
    }

    @Override
    public boolean isOut(int maxHeight) {
        if (O.y - dai / 2 < -1 * maxHeight / 2 - 20) {
            return true;
        }
        return false;
    }

    public static Ellipse random(int maxWidth, int maxHeight, boolean fromTop) {
        int x = (int) (Math.random() * maxWidth - maxWidth / 2);
        int y = (int) (Math.random() * maxHeight - maxHeight / 2);

        int h = (int) (Math.random() * maxWidth / 5);
        int w = (int) (Math.random() * maxHeight / 5);

        if (!fromTop) {
            return new Ellipse(
                    new Point(x, y),
                    new Point(x + h, y + w));
        } else {
            return new Ellipse(
                    new Point(x, maxHeight / 2 + 5),
                    new Point(x + h, (int) (maxHeight / 2 + Math.random() * 10)));
        }
    }
}

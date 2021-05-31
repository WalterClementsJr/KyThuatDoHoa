package Model;

import static Model.TrucToaDo.bresenhamLine;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class MyRect implements Shapes2D {

    private Point A, B, C, D;
    private Point originalA, originalB, originalC, originalD;
    public Color colorShape = Color.BLACK;

    @Override
    public void setColor(Color colorShape) {
        this.colorShape = colorShape;
    }

    public MyRect(Point a, Point c) {
        A = a;
        C = c;
        B = new Point(C.x, A.y);
        D = new Point(A.x, C.y);

        originalA = new Point(A.x, A.y);
        originalB = new Point(B.x, B.y);
        originalC = new Point(C.x, C.y);
        originalD = new Point(D.x, D.y);
    }

    public MyRect(Point A, Point B, Point C, Point D) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
        originalA = new Point(this.A.x, this.A.y);
        originalB = new Point(this.B.x, this.B.y);
        originalC = new Point(this.C.x, this.C.y);
        originalD = new Point(this.D.x, this.D.y);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(colorShape);
        bresenhamLine(g, A.x, A.y, B.x, B.y);
        bresenhamLine(g, B.x, B.y, C.x, C.y);
        bresenhamLine(g, C.x, C.y, D.x, D.y);
        bresenhamLine(g, D.x, D.y, A.x, A.y);
//        A = originalA; B = originalB; C = originalC; D = originalD;
    }

    @Override
    public void setRadianAndAnchor(double radian, Point anchor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void draw(Graphics g, Color c) {
        g.setColor(c);
        bresenhamLine(g, A.x, A.y, B.x, A.y);
        bresenhamLine(g, B.x, A.y, B.x, B.y);
        bresenhamLine(g, B.x, B.y, A.x, B.y);
        bresenhamLine(g, A.x, B.y, A.x, A.y);
        A = originalA;
        B = originalB;
        C = originalC;
        D = originalD;
    }

    @Override
    public void fill(Graphics g, Color color) {
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

    public Point getD() {
        return D;
    }

    public void setD(Point D) {
        this.D = D;
    }

    @Override
    public void xoay(double radian, Point anchor) {
        A = Rotation.rotateAroundO(originalA.x, originalA.y, radian, anchor);
        B = Rotation.rotateAroundO(originalB.x, originalB.y, radian, anchor);
        C = Rotation.rotateAroundO(originalC.x, originalC.y, radian, anchor);
        D = Rotation.rotateAroundO(originalD.x, originalD.y, radian, anchor);
    }

    @Override
    public void dich(int x, int y) {
        A.x = A.x + x;
        A.y = A.y + y;
        B.x = B.x + x;
        B.y = B.y + y;
        C.x = C.x + x;
        C.y = C.y + y;
        D.x = D.x + x;
        D.y = D.y + y;
        originalA.x = A.x;
        originalA.y = A.y;
        originalB.x = B.x;
        originalB.y = B.y;
        originalC.x = C.x;
        originalC.y = C.y;
        originalD.x = D.x;
        originalD.y = D.y;
    }

    @Override
    public void thuPhong(double heSoThuPhong) {
        //thu phóng rồi tịnh tiến về A
        double tempAx = originalA.x;
        tempAx = tempAx * heSoThuPhong;
        int dentaX = originalA.x - (int) Math.round(tempAx);
        A.x = originalA.x;
        double tempAy = A.y;
        tempAy = tempAy * heSoThuPhong;
        int dentaY = originalA.y - (int) Math.round(tempAy);
        A.y = originalA.y;

        double tempBx = originalB.x;
        tempBx = tempBx * heSoThuPhong;
        B.x = (int) Math.round(tempBx) + dentaX;
        double tempBy = originalB.y;
        tempBy = tempBy * heSoThuPhong;
        B.y = (int) Math.round(tempBy) + dentaY;
        double tempCx = originalC.x;
        tempCx = tempCx * heSoThuPhong;
        C.x = (int) Math.round(tempCx) + dentaX;
        double tempCy = originalC.y;
        tempCy = tempCy * heSoThuPhong;
        C.y = (int) Math.round(tempCy) + dentaY;
        double tempDx = originalD.x;
        tempDx = tempDx * heSoThuPhong;
        D.x = (int) Math.round(tempDx) + dentaX;
        double tempDy = originalD.y;
        tempDy = tempDy * heSoThuPhong;
        D.y = (int) Math.round(tempDy) + dentaY;
        originalA.x = A.x;
        originalA.y = A.y;
        originalB.x = B.x;
        originalB.y = B.y;
        originalC.x = C.x;
        originalC.y = C.y;
        originalD.x = D.x;
        originalD.y = D.y;
    }

    @Override
    public void doiXungOx() {
        A.y = -A.y;
        B.y = -B.y;
        C.y = -C.y;
        D.y = -D.y;
        originalA.y = A.y;
        originalB.y = B.y;
        originalC.y = C.y;
        originalD.y = D.y;
    }

    @Override
    public void doiXungOy() {
        A.x = -A.x;
        B.x = -B.x;
        C.x = -C.x;
        D.x = -D.x;
        originalA.x = A.x;
        originalB.x = B.x;
        originalC.x = C.x;
        originalD.x = D.x;
    }

    public boolean isOut(int maxHeight) {
        if (A.y < -1 * maxHeight / 2 - 20) {
            return true;
        }
        return false;
    }

    public static MyRect random(int maxWidth, int maxHeight, boolean fromTop) {
        int x = (int) (Math.random() * maxWidth - maxWidth / 2);
        int y = (int) (Math.random() * maxHeight - maxHeight / 2);

        int dai = (int) (Math.random() * maxWidth / 5);
        int rong = (int) (Math.random() * maxHeight / 5);

        if (!fromTop) {
            return new MyRect(new Point(x, y), new Point(x + dai, y + rong));
        } else {
            return new MyRect(
                    new Point(x, maxHeight / 2),
                    new Point(x + dai, (int) (maxHeight / 2 + Math.random() * 10)));
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static Model.Shapes2D.DEFAULT_COLOR;
import static Model.TrucToaDo.bresenhamLine;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author walker
 */
public class Heli implements Shapes2D {

    Point center;
    ArrayList<Triangle> blades = new ArrayList<>();

    HeliBody body;
    public Color colorShape=Color.BLACK;
    @Override
    public void setColor(Color colorShape) {
        this.colorShape=colorShape;
    }
    /**
     * draw windmill from center
     *
     * @param center
     * @param width
     * @param height
     */
    public Heli(Point center, int width, int height) {
        this.center = center;
        body = new HeliBody(center, width, height);
        int h = height * 7 / 10;
        int w = h / 3;
        blades.add(new Triangle(
                new Point(center.x, center.y),
                new Point(center.x + w, center.y + h),
                new Point(center.x - w, center.y + h)));
        blades.add(new Triangle(
                new Point(center.x, center.y),
                new Point(center.x + h, center.y + w),
                new Point(center.x + h, center.y - w)));
        blades.add(new Triangle(
                new Point(center.x, center.y),
                new Point(center.x - w, center.y - h),
                new Point(center.x + w, center.y - h)));
        blades.add(new Triangle(
                new Point(center.x, center.y),
                new Point(center.x - h, center.y + w),
                new Point(center.x - h, center.y - w)));
    }

    @Override
    public void draw(Graphics g) {
        body.draw(g);
        for (Triangle t : blades) {
            t.draw(g);
        }
    }

    @Override
    public void draw(Graphics g, Color c) {
    }

    @Override
    public void fill(Graphics g, Color color) {
    }

    @Override
    public void xoay(double radian, Point anchor) {
        for (Triangle t : blades) {
            t.xoay(radian, anchor);
        }
    }

    @Override
    public void dich(int x, int y) {
        center.x += x;
        center.y += y;
        body.dich(x, y);
        for (Triangle t : blades) {
            t.dich(x, y);
        }
    }

    @Override
    public void doiXungOx() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void doiXungOy() {
    }

    public void bienDang(double heSoBienDang) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point p) {
        this.center = p;
    }

    public ArrayList<Triangle> getBlades() {
        return blades;
    }

    public HeliBody getBody() {
        return body;
    }

    @Override
    public void thuPhong(double heSoThuPhong) {
        body.thuPhong(heSoThuPhong);
        for (Triangle t : blades) {
            t.thuPhong(heSoThuPhong);
        }
    }

    @Override
    public void setRadianAndAnchor(double radian, Point anchor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isOut(int maxHeight) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

class HeliBody implements Shapes2D {

    Triangle head, tail;
    MyRect box;
    public Color colorShape=Color.BLACK;
    @Override
    public void setColor(Color colorShape) {
        this.colorShape=colorShape;
    }
    public HeliBody(Point center, int width, int height) {
        head = new Triangle(
                new Point(center.x, center.y + height / 5),
                new Point(center.x - width / 2, center.y),
                new Point(center.x + width / 2, center.y)) {
            @Override
            public void draw(Graphics g) {
                g.setColor(DEFAULT_COLOR);
                TrucToaDo.bresenhamLine(g, getA().x, getA().y, getB().x, getB().y);
                TrucToaDo.bresenhamLine(g, getC().x, getC().y, getA().x, getA().y);
            }
        };

        tail = new Triangle(
                new Point(center.x, center.y - height * 6 / 5),
                new Point(center.x - width / 5, (center.y - height * 3 / 5)),
                new Point(center.x + width / 5, (center.y - height * 3 / 5))) {
            @Override
            public void draw(Graphics g) {
                g.setColor(DEFAULT_COLOR);
                TrucToaDo.bresenhamLine(g, getA().x, getA().y, getB().x, getB().y);
                TrucToaDo.bresenhamLine(g, getC().x, getC().y, getA().x, getA().y);
            }
        };

        box = new MyRect(
                new Point(center.x - width / 2, center.y),
                new Point(center.x + width / 2, center.y),
                new Point(center.x + width / 2, (int) (center.y - height * 3 / 5)),
                new Point(center.x - width / 2, (int) (center.y - height * 3 / 5))) {
            @Override
            public void draw(Graphics g) {
                bresenhamLine(g, getB().x, getB().y, getC().x, getC().y);
                bresenhamLine(g, getC().x, getC().y, getD().x, getD().y);
                bresenhamLine(g, getD().x, getD().y, getA().x, getA().y);
            }
        };
    }

    @Override
    public void draw(Graphics g) {
        head.draw(g);
        box.draw(g);
        tail.draw(g);

    }

    @Override
    public void draw(Graphics g, Color c) {
    }

    @Override
    public void setRadianAndAnchor(double radian, Point anchor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void fill(Graphics g, Color color) {
    }

    @Override
    public void xoay(double radian, Point anchor) {
    }

    @Override
    public void dich(int x, int y) {
        head.dich(x, y);
        box.dich(x, y);
        tail.dich(x, y);
    }

    @Override
    public void doiXungOx() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void doiXungOy() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void bienDang(double heSoBienDang) {
    }

    @Override
    public void thuPhong(double heSoThuPhong) {
        head.thuPhong(heSoThuPhong);
        box.thuPhong(heSoThuPhong);
    }

    @Override
    public boolean isOut(int maxHeight) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

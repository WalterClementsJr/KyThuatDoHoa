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
public class WindMill implements Shapes2D {
    Point center;
    ArrayList<Triangle> blades = new ArrayList<>();

    WindMillBody body;

    /**
     * draw windmill from center
     * @param center
     * @param width
     * @param height 
     */
    public WindMill(Point center, int width, int height) {
        this.center = center;
        body = new WindMillBody(center, width, height);
        int h = height * 7 / 10;
        int w =  h / 3;
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
                new Point(center.x - w , center.y - h),
                new Point(center.x + w , center.y - h)));
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
        body.dich(x, y);
        for (Triangle t : blades) {
            t.dich(x, y);
        }
    }

    @Override
    public void doiXungOx() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doiXungOy() {
    }

    public void bienDang(double heSoBienDang) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Point getCenter() {
        return center;
    }

    public ArrayList<Triangle> getBlades() {
        return blades;
    }

    public WindMillBody getBody() {
        return body;
    }

    @Override
    public void thuPhong(double heSoThuPhong) {
        body.thuPhong(heSoThuPhong);
        for (Triangle t : blades) {
            t.thuPhong(heSoThuPhong);
        }
    }
    
    

}

class WindMillBody implements Shapes2D {
    Triangle roof;
    MyRect box;

    public WindMillBody(Point top, int width, int height) {
        roof = new Triangle(
                new Point(top.x, top.y),
                new Point(top.x - width / 2, top.y - height / 3),
                new Point(top.x + width / 2, top.y - height / 3)) {
            @Override
            public void draw(Graphics g) {
                g.setColor(DEFAULT_COLOR);
                TrucToaDo.bresenhamLine(g, getA().x, getA().y, getB().x, getB().y);
                TrucToaDo.bresenhamLine(g, getC().x, getC().y, getA().x, getA().y);
            }
        };
        box = new MyRect(
                new Point(top.x - width / 2, top.y - height/3),
                new Point(top.x + width / 2, top.y - height/3),
                new Point(top.x + width / 2, (int) (top.y - height)),
                new Point(top.x - width / 2, (int) (top.y - height))) {
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
        roof.draw(g);
        box.draw(g);

    }

    @Override
    public void draw(Graphics g, Color c) {
    }

    @Override
    public void fill(Graphics g, Color color) {
    }

    @Override
    public void xoay(double radian, Point anchor) {
    }

    @Override
    public void dich(int x, int y) {
        roof.dich(x, y);
        box.dich(x, y);
    }

    @Override
    public void doiXungOx() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doiXungOy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void bienDang(double heSoBienDang) {
    }

    @Override
    public void thuPhong(double heSoThuPhong) {
        roof.thuPhong(heSoThuPhong);
        box.thuPhong(heSoThuPhong);
    }

}

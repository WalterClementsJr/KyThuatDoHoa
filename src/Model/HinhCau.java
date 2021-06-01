/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Tuong
 */
public class HinhCau implements Shapes3D {

    private int x0, y0, z0, banKinh;
    private Point O;

    public HinhCau(int x0, int y0, int z0, int banKinh) {
        this.x0 = x0;
        this.y0 = y0;
        this.z0 = z0;
        this.banKinh = banKinh;

        O = Projection.cavalier(x0, y0, z0);
    }

    @Override
    public void draw(Graphics g) {
        TrucToaDo3D.tempShape = new Circle(O, banKinh);
        TrucToaDo3D.tempShape.draw(g);
        Ellipse.drawHalfDashed(g, O.x, O.y, banKinh, banKinh / 2);
        //vẽ đỉnh
        TrucToaDo3D.veChu(g, "O(" + x0 + ";" + y0 + ";" + z0 + ")", O.x + 2, O.y + 2);
        TrucToaDo.putPixel(g, O.x, O.y);

    }
}

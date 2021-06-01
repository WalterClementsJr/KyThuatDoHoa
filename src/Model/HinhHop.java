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
public class HinhHop implements Shapes3D {

    private int x0, y0, z0, dai, rong, cao;
    private Point O, A, B, C, D, E, F, G;

    public HinhHop(int x0, int y0, int z0, int dai, int rong, int cao) {
        this.x0 = x0;
        this.y0 = y0;
        this.z0 = z0;
        this.dai = dai;
        this.rong = rong;
        this.cao = cao;

        O = Projection.cavalier(x0, y0, z0);
        A = Projection.cavalier(x0 + dai, y0, z0);
        B = Projection.cavalier(x0 + dai, y0 + rong, z0);
        C = Projection.cavalier(x0, y0 + rong, z0);
        D = Projection.cavalier(x0 + dai, y0, z0 + cao);
        E = Projection.cavalier(x0, y0, z0 + cao);
        F = Projection.cavalier(x0, y0 + rong, z0 + cao);
        G = Projection.cavalier(x0 + dai, y0 + rong, z0 + cao);

    }

    @Override
    public void draw(Graphics g) {
        MyLine.dashedLine(g, O.x, O.y, A.x, A.y);
        TrucToaDo.bresenhamLine(g, A.x, A.y, B.x, B.y);
        TrucToaDo.bresenhamLine(g, B.x, B.y, C.x, C.y);
        MyLine.dashedLine(g, C.x, C.y, O.x, O.y);
        TrucToaDo.bresenhamLine(g, E.x, E.y, D.x, D.y);
        TrucToaDo.bresenhamLine(g, D.x, D.y, G.x, G.y);
        TrucToaDo.bresenhamLine(g, G.x, G.y, F.x, F.y);
        TrucToaDo.bresenhamLine(g, F.x, F.y, E.x, E.y);
        MyLine.dashedLine(g, E.x, E.y, O.x, O.y);
        TrucToaDo.bresenhamLine(g, D.x, D.y, A.x, A.y);
        TrucToaDo.bresenhamLine(g, G.x, G.y, B.x, B.y);
        TrucToaDo.bresenhamLine(g, F.x, F.y, C.x, C.y);

        //vẽ đỉnh
        TrucToaDo3D.veChu(g, "O(" + x0 + ";" + y0 + ";" + z0 + ")", O.x + 2, O.y + 2);
        TrucToaDo3D.veChu(g, "A(" + (x0 + dai) + ";" + y0 + ";" + z0 + ")", A.x + 2, A.y + 2);
        TrucToaDo3D.veChu(g, "B(" + (x0 + dai) + ";" + (y0 + rong) + ";" + z0 + ")", B.x + 3, B.y);
        TrucToaDo3D.veChu(g, "C(" + x0 + ";" + (y0 + rong) + ";" + z0 + ")", C.x - 9, C.y + 2);
        TrucToaDo3D.veChu(g, "D(" + (x0 + dai) + ";" + y0 + ";" + (z0 + cao) + ")", D.x + 2, D.y + 2);
        TrucToaDo3D.veChu(g, "E(" + x0 + ";" + y0 + ";" + (z0 + cao) + ")", E.x + 2, E.y + 2);
        TrucToaDo3D.veChu(g, "F(" + x0 + ";" + (y0 + rong) + ";" + (z0 + cao) + ")", F.x - 10, F.y - 2);
        TrucToaDo3D.veChu(g, "G(" + (x0 + dai) + ";" + (y0 + rong) + ";" + (z0 + cao) + ")", G.x + 3, G.y);

    }

}

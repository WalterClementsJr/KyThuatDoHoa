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
public class HinhHop implements Shapes3D{
    private int x0, y0, z0, dai, rong, cao;
    private Point O,A,B,C,D,E,F,G;
    public HinhHop(int x0, int y0, int z0, int dai, int rong, int cao) {
        this.x0=x0;
        this.y0=y0;
        this.z0=z0;
        this.dai=dai;
        this.rong=rong;
        this.cao=cao;
        
        O=Projection.cavalier(x0, y0, z0);
        A=Projection.cavalier(x0+dai, y0, z0);
        B=Projection.cavalier(x0+dai, y0+rong, z0);
        C=Projection.cavalier(x0, y0+rong, z0);
        D=Projection.cavalier(x0+dai, y0, z0+cao);
        E=Projection.cavalier(x0, y0, z0+cao);
        F=Projection.cavalier(x0, y0+rong, z0+cao);
        G=Projection.cavalier(x0+dai, y0+rong, z0+cao);
        
    }

    @Override
    public void draw(Graphics g) {
        TrucToaDo.bresenhamLine(g, O.x, O.y, A.x, A.y);
        TrucToaDo.bresenhamLine(g, A.x, A.y, B.x, B.y);
        TrucToaDo.bresenhamLine(g, B.x, B.y, C.x, C.y);
        TrucToaDo.bresenhamLine(g, C.x, C.y, O.x, O.y);
        TrucToaDo.bresenhamLine(g, E.x, E.y, D.x, D.y);
        TrucToaDo.bresenhamLine(g, D.x, D.y, G.x, G.y);
        TrucToaDo.bresenhamLine(g, G.x, G.y, F.x, F.y);
        TrucToaDo.bresenhamLine(g, F.x, F.y, E.x, E.y);
        TrucToaDo.bresenhamLine(g, E.x, E.y, O.x, O.y);
        TrucToaDo.bresenhamLine(g, D.x, D.y, A.x, A.y);
        TrucToaDo.bresenhamLine(g, G.x, G.y, B.x, B.y);
        TrucToaDo.bresenhamLine(g, F.x, F.y, C.x, C.y);
    }
    
}

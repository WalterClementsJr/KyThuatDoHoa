/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author walker
 */
public class Triangle implements Shapes2D {
    private int xDinh, yDinh, canh;

    
    public Triangle(int xDinh, int yDinh, int canh) {
        this.xDinh = xDinh;
        this.yDinh = yDinh;
        this.canh = canh;
    }

    
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);  //dat mau hinh ve la red
        //khai bao tọa độ các đỉnh
        int xA, yA, xB, yB, xC, yC, aH;
        xA = xDinh;
        yA = yDinh;
        aH = (int) Math.sqrt(3) * canh / 2;
        xB = xA + canh;
        yB = yA;//+ aH để đỉnh luôn ở trên
        xC = xA + canh / 2;
        yC = yA + aH;
        TrucToaDo.bresenhamLine(g, xA, yA, xB, yB);
        TrucToaDo.bresenhamLine(g, xA, yA, xC, yC);
        TrucToaDo.bresenhamLine(g, xB, yB, xC, yC);
    }
}

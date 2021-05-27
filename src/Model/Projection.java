/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Point;

/**
 *
 * @author LuuTienPhat
 */
public class Projection {

    int x, y, z;
    Point a;

    public Projection(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

     public static Point cavalier(int x, int y, int z) {
        int x1 = x - y;
        int y1 = z - y;
        return new Point(x1, y1);
    }
}

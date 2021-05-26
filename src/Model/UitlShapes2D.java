/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Graphics;

/**
 *
 * @author MinhTo
 */
public class UitlShapes2D {
        public static void putPixel(Graphics g,int x, int y,int pSize) {
         g.fillRect((x -1 ) * pSize + 1, (y - 1) * pSize + 1, pSize-1, pSize-1); 
    }
}

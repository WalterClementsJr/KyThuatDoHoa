/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author Tuong
 */
public class Pixel extends JComponent {

    int x, y;
    int deltaX = 375 / 5;//nửa chiều dài của trục Ox chia cho độ lớn 1 pixel
    int deltaY = 250 / 5;//nửa chiều dài của trục oy chia cho độ lớn 1 pixel

    public Pixel(int x, int y) {
        this.x = x;
        this.y = y;

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        if (x >= 0 && y >= 0) {
            x = (x + deltaX - 1) * 5;
            y = (deltaY - y) * 5;
        } else if (x >= 0 && y <= 0) {
            x = (x + deltaX - 1) * 5;
            y = (y * -1 + deltaY - 1) * 5;
        } else if (x <= 0 && y >= 0) {
            x = (x + deltaX) * 5;
            y = (deltaY - y) * 5;
        } else {
            x = (x + deltaX) * 5;
            y = (y * -1 + deltaY) * 5;
        }
        g.fillRect(x, y, 5, 5);
    }

}

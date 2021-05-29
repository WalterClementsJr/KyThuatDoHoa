package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public interface Shapes2D {

    static final Color DEFAULT_COLOR = Color.BLACK;

    public void draw(Graphics g);
    
    public void draw(Graphics g, Color c);   
    
    public void setRadianAndAnchor(double radian, Point anchor);//dành cho vẽ elip

    public void fill(Graphics g, Color color);

    public void xoay(double radian, Point anchor);

    public void dich(int x, int y);

    public void doiXungOx();

    public void doiXungOy();

    public void thuPhong(double heSoThuPhong);

    public boolean isOut(int maxHeight);
}

package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public interface Shapes2D {
    static final Color DEFAULT_COLOR = Color.BLACK;

    public void draw(Graphics g);
    
    public void draw(Graphics g, Color c);    

    public void fill(Graphics g, Color color);
}

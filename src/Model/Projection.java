package Model;

import java.awt.Point;

public class Projection {

    int x, y, z;
    Point a;

    public Projection(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static Point cavalier(int x, int y, int z) {
        int x1 =(int) Math.round(x - y*Math.sqrt(2)/2);
        int y1 =(int) Math.round(z - y*Math.sqrt(2)/2);
        return new Point(x1, y1);
    }
}

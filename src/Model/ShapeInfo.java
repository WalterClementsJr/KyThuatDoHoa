/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author zoroONE01
 */
public class ShapeInfo {

    private String name;
    private String type;
    private int y0;
    private int x0;
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private int xStart;
    private int yStart;
    private int xEnd;
    private int yEnd;
    private int a;
    private int b;
    private int r;
    private int h;

    public ShapeInfo() {
    }

    public ShapeInfo(String name, String type, int y0, int x0, int x1, int x2, int y1, int y2, int xStart, int yStart, int xEnd, int yEnd, int a, int b, int r, int h) {
        this.name = name;
        this.type = type;
        this.y0 = y0;
        this.x0 = x0;
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.xStart = xStart;
        this.yStart = yStart;
        this.xEnd = xEnd;
        this.yEnd = yEnd;
        this.a = a;
        this.b = b;
        this.r = r;
        this.h = h;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getY0() {
        return y0;
    }

    public void setY0(int y0) {
        this.y0 = y0;
    }

    public int getX0() {
        return x0;
    }

    public void setX0(int x0) {
        this.x0 = x0;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public int getxStart() {
        return xStart;
    }

    public void setxStart(int xStart) {
        this.xStart = xStart;
    }

    public int getyStart() {
        return yStart;
    }

    public void setyStart(int yStart) {
        this.yStart = yStart;
    }

    public int getxEnd() {
        return xEnd;
    }

    public void setxEnd(int xEnd) {
        this.xEnd = xEnd;
    }

    public int getyEnd() {
        return yEnd;
    }

    public void setyEnd(int yEnd) {
        this.yEnd = yEnd;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setTriangle(int name) {
        this.name = "Triangle" + String.valueOf(name);
        this.type = "Triangle";
        x0 = (xStart + xEnd) / 2;
        y0 = Math.max(yStart, yEnd);
        x1 = Math.min(xStart, xEnd);
        y1 = Math.min(yStart, yEnd);
        x2 = Math.max(xStart, xEnd);
        y2 = Math.min(yStart, yEnd);
        this.h = Math.abs(y0 - y2);
    }

    public void setRectangle(int name) {
        this.name = "Rectangle" + String.valueOf(name);
        this.type = "Rectangle";
        x0 = xStart;
        y0 = yEnd;
        x1 = xEnd;
        y1 = yEnd;
        x2 = xEnd;
        y2 = yEnd;
        a = Math.abs(xEnd - xStart);
        b = Math.abs(yEnd - yStart);
    }

    public void setline(int name) {
        this.name = "Line" + String.valueOf(name);
        this.type = "Line";
        a = (int) Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));

    }

    public void setCircle(int name) {
        this.name = "Circle" + String.valueOf(name);
        this.type = "Circle";
        r = (int) Math.sqrt((xEnd - xStart) * (xEnd - xStart) + (yEnd - yStart) * (yEnd - yStart));
        x0 = xStart;
        y0 = yStart;
    }

    public void setEllipse(int name) {
        this.name = "Ellipse" + String.valueOf(name);
        this.type = "Ellipse";
        a = Math.abs(xStart - xEnd);
        b = Math.abs(yStart - yEnd);
        x0 = (xStart + xEnd) / 2;
        y0 = (yStart + yStart) / 2;
    }
}

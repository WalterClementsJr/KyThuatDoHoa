/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Circle;
import Model.Ellipse;
import Model.MyFlag;
import Model.MyLine;
import Model.MyRect;
import Model.ShapeInfo;

import Model.ThreadGet;
import Model.ThreadSet;
import Model.ThreadTriangleGet;
import Model.ThreadTriangleSet;
import Model.Triangle;

import Model.TrucToaDo;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author zoroONE01
 */
public class pn2D extends javax.swing.JPanel {

    //mấy biến này đúng thì mới thực hiện chức năng
    boolean selectDuongThang = false; //vẽ đường thẳng
    boolean selectHCN = false; //vẽ hình chữ nhận
    boolean selectTamGiac = false; //vẽ hình tam giác
    boolean selectOval = false; //vẽ hình oval
    boolean selectTron = false;
    boolean selectXoay = false;

    int x1, y1, x2, y2;

    public final String DRAW_LINE = "line";
    public final String DRAW_RECT = "rect";
    public final String DRAW_CIRCLE = "circle";
    public final String DRAW_TRIANGLE = "triangle";
    public final String DRAW_ELLIPSE = "ellipse";
    public String mode = "";

    ArrayList<ShapeInfo> listShapeInfo = new ArrayList<>();
    ShapeInfo shape;
    DefaultListModel<String> dlm;
    int[] listIndexSelected = null;
    String name = "";
    Point pQuay;  //TOA ĐỘ Cờ

    //QUAY HINH CHU NHAT
    ArrayList<Point> listA = new ArrayList<>();
    ArrayList<Point> listB = new ArrayList<>();
    ArrayList<Point> listC = new ArrayList<>();
    ArrayList<Point> listD = new ArrayList<>();
    static int iAuto = 1;
    //QUAY tam giac
    ArrayList<Point> listTA = new ArrayList<>();
    ArrayList<Point> listTB = new ArrayList<>();
    ArrayList<Point> listTC = new ArrayList<>();
    //QUAY HINH Duong thăng
    ArrayList<Point> listDt = new ArrayList<>();

    // luong quay hình chứ nhật
    public static ThreadSet tSet = null;
    public static ThreadGet tGet = null;
    public static final ThreadLocal<Thread> threadLocal = new ThreadLocal<>();

    // luồng quay tam giac
    public static ThreadTriangleSet tamGiacThreadSet = null;
    public static ThreadTriangleGet tamGiacThreadGet = null;

    ;
    public Timer timer = new Timer("MyTimer");
    public static int counter = 1;
    TimerTask timerTask;
    public static int selectedRotating = 0;

    public pn2D() {
        initComponents();
        setListShape();
        lbFlag.setVisible(false);

        timerTask = new TimerTask() {
            @Override
            public void run() {
                counter++;//increments the counter
                if (tGet != null) {
                    tGet.run();
                }
                if (tamGiacThreadGet != null) {
                    tamGiacThreadGet.run();
                }
            }
        };
        timer.scheduleAtFixedRate(timerTask, 30, 100);//this line starts the timer at the same time its executed
    }

    public void setListShape() {
        listShape.setModel(new DefaultListModel<>());
        dlm = (DefaultListModel<String>) listShape.getModel();
        for (ShapeInfo shapeInfo : listShapeInfo) {
            dlm.addElement(shapeInfo.getName());
        }
    }

    public void setTriangleChanged(Triangle t, int index) {
        tfx0.setText(String.valueOf(t.getA().x));
        tfy0.setText(String.valueOf(t.getA().y));
        tfx1.setText(String.valueOf(t.getB().x));
        tfy1.setText(String.valueOf(t.getB().y));
        tfx2.setText(String.valueOf(t.getC().x));
        tfy2.setText(String.valueOf(t.getC().y));
        listShapeInfo.get(index).setX0(t.getA().x);
        listShapeInfo.get(index).setY0(t.getA().y);
        listShapeInfo.get(index).setX1(t.getB().x);
        listShapeInfo.get(index).setY1(t.getB().y);
        listShapeInfo.get(index).setX2(t.getC().x);
        listShapeInfo.get(index).setY2(t.getC().y);
    }

    public void setRectChanged(MyRect r, int index) {
        tfx0.setText(String.valueOf(r.getA().x));
        tfy0.setText(String.valueOf(r.getA().y));
        tfx1.setText(String.valueOf(r.getB().x));
        tfy1.setText(String.valueOf(r.getB().y));
        tfx2.setText(String.valueOf(r.getC().x));
        tfy2.setText(String.valueOf(r.getC().y));
        listShapeInfo.get(index).setX0(r.getA().x);
        listShapeInfo.get(index).setY0(r.getA().y);
        listShapeInfo.get(index).setX1(r.getB().x);
        listShapeInfo.get(index).setY1(r.getB().y);
        listShapeInfo.get(index).setX2(r.getC().x);
        listShapeInfo.get(index).setY2(r.getC().y);
    }

    public void setLineChanged(MyLine l, int index) {
        tfX1.setText(String.valueOf(l.getA().x));
        tfY1.setText(String.valueOf(l.getA().y));
        tfX2.setText(String.valueOf(l.getB().x));
        tfY2.setText(String.valueOf(l.getB().y));
        listShapeInfo.get(index).setxStart(l.getA().x);
        listShapeInfo.get(index).setyStart(l.getA().y);
        listShapeInfo.get(index).setxEnd(l.getB().x);
        listShapeInfo.get(index).setyEnd(l.getB().y);
    }

    public void setEllipseChanged(Ellipse e, int index) {
        tfx0.setText(String.valueOf(e.getO().x));
        tfy0.setText(String.valueOf(e.getO().y));
        tfa.setText(String.valueOf(e.getDai()));
        tfb.setText(String.valueOf(e.getCao()));
        listShapeInfo.get(index).setX0(e.getO().x);
        listShapeInfo.get(index).setY0(e.getO().y);
        listShapeInfo.get(index).setA(e.getDai());
        listShapeInfo.get(index).setA(e.getCao());
    }

    public void setCircleChanged(Circle c, int index) {
        tfx0.setText(String.valueOf(c.getO().x));
        tfy0.setText(String.valueOf(c.getO().y));
        tfr.setText(String.valueOf(c.getRadius()));
        listShapeInfo.get(index).setX0(c.getO().x);
        listShapeInfo.get(index).setY0(c.getO().y);
        listShapeInfo.get(index).setR(c.getRadius());
    }

    public void setNullTf() {
        tfx0.setText("");
        tfx1.setText("");
        tfx2.setText("");
        tfy0.setText("");
        tfy1.setText("");
        tfy2.setText("");
        tfa.setText("");
        tfb.setText("");
        tfr.setText("");
        tfh.setText("");
        tfX1.setText("");
        tfX2.setText("");
        tfY1.setText("");
        tfY2.setText("");
    }

    public void setTextTf() {
        tfx0.setText(String.valueOf(listShapeInfo.get(listIndexSelected[0]).getX0()));
        tfx1.setText(String.valueOf(listShapeInfo.get(listIndexSelected[0]).getX1()));
        tfx2.setText(String.valueOf(listShapeInfo.get(listIndexSelected[0]).getX2()));
        tfy0.setText(String.valueOf(listShapeInfo.get(listIndexSelected[0]).getY0()));
        tfy1.setText(String.valueOf(listShapeInfo.get(listIndexSelected[0]).getY1()));
        tfy2.setText(String.valueOf(listShapeInfo.get(listIndexSelected[0]).getY2()));
        tfa.setText(String.valueOf(listShapeInfo.get(listIndexSelected[0]).getA()));
        tfb.setText(String.valueOf(listShapeInfo.get(listIndexSelected[0]).getB()));
        tfr.setText(String.valueOf(listShapeInfo.get(listIndexSelected[0]).getR()));
        tfh.setText(String.valueOf(listShapeInfo.get(listIndexSelected[0]).getH()));
        tfX1.setText(String.valueOf(listShapeInfo.get(listIndexSelected[0]).getxStart()));
        tfX2.setText(String.valueOf(listShapeInfo.get(listIndexSelected[0]).getxEnd()));
        tfY1.setText(String.valueOf(listShapeInfo.get(listIndexSelected[0]).getyStart()));
        tfY2.setText(String.valueOf(listShapeInfo.get(listIndexSelected[0]).getyEnd()));
    }

    public void lbSelected(JLabel lb) {
        lb.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    }

    public int numberName(String type) {
        int num = 0;
        for (ShapeInfo shapeInfo : listShapeInfo) {
            try {
                if (shapeInfo.getType().equals(type)) {
                    num++;
                }
            } catch (Exception e) {
                num = 0;
            }

        }
        return num;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbFlag = new javax.swing.JLabel();
        pnMain = new Model.TrucToaDo();
        pnThongTin = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listShape = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tfY1 = new javax.swing.JTextField();
        tfX2 = new javax.swing.JTextField();
        tfY2 = new javax.swing.JTextField();
        tfx0 = new javax.swing.JTextField();
        tfy0 = new javax.swing.JTextField();
        tfh = new javax.swing.JTextField();
        tfX1 = new javax.swing.JTextField();
        tfr = new javax.swing.JTextField();
        tfa = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tfb = new javax.swing.JTextField();
        lbXoaTatCa = new javax.swing.JLabel();
        lbDelete = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        tfx1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        tfy1 = new javax.swing.JTextField();
        tfx2 = new javax.swing.JTextField();
        tfy2 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        pnFooter = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        toadoJava = new javax.swing.JLabel();
        toaDoCurrent = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSliderGocQuay = new javax.swing.JSlider();
        jTextFieldDiemDenX = new javax.swing.JTextField();
        jTextFieldDiemDenY = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextFieldThuPhong = new javax.swing.JTextField();
        pnChucNang = new javax.swing.JPanel();
        lbHinhCN = new javax.swing.JLabel();
        lbHinhTamGiac = new javax.swing.JLabel();
        lbHinhDuongThang = new javax.swing.JLabel();
        lbHinhTron = new javax.swing.JLabel();
        lbHinhOval = new javax.swing.JLabel();
        lbXoay = new javax.swing.JLabel();
        lbLatOy = new javax.swing.JLabel();
        lbLatOx = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        lbFlag.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/icons8_flag_filled_20px_2.png"))); // NOI18N
        lbFlag.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnMain.setBackground(new java.awt.Color(255, 255, 255));
        pnMain.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnMain.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnMainMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pnMainMouseMoved(evt);
            }
        });
        pnMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnMainMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnMainMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnMainMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pnMainMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout pnMainLayout = new javax.swing.GroupLayout(pnMain);
        pnMain.setLayout(pnMainLayout);
        pnMainLayout.setHorizontalGroup(
            pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );
        pnMainLayout.setVerticalGroup(
            pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        add(pnMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 750, 500));

        pnThongTin.setBackground(new java.awt.Color(255, 255, 255));
        pnThongTin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnThongTin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Thông tin chi tiết");
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnThongTin.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 200, 30));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        listShape.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listShape.setSelectionBackground(new java.awt.Color(153, 153, 153));
        listShape.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listShapeMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(listShape);

        pnThongTin.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 160, 160));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("X1");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnThongTin.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 25, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Y1");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnThongTin.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 470, 25, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Y2");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnThongTin.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 510, 25, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("X2");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnThongTin.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 25, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("x0");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnThongTin.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 25, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("h");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnThongTin.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, 25, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("y0");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnThongTin.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 25, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("r");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnThongTin.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 25, 30));

        tfY1.setEditable(false);
        tfY1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfY1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfY1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnThongTin.add(tfY1, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 470, 45, 30));

        tfX2.setEditable(false);
        tfX2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfX2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfX2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnThongTin.add(tfX2, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 510, 45, 30));

        tfY2.setEditable(false);
        tfY2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfY2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfY2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnThongTin.add(tfY2, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 510, 45, 30));

        tfx0.setEditable(false);
        tfx0.setBackground(new java.awt.Color(220, 220, 220));
        tfx0.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfx0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfx0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnThongTin.add(tfx0, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 260, 45, 30));

        tfy0.setEditable(false);
        tfy0.setBackground(new java.awt.Color(220, 220, 220));
        tfy0.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfy0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfy0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnThongTin.add(tfy0, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 260, 45, 30));

        tfh.setEditable(false);
        tfh.setBackground(new java.awt.Color(220, 220, 220));
        tfh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfh.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnThongTin.add(tfh, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 420, 45, 30));

        tfX1.setEditable(false);
        tfX1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfX1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfX1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnThongTin.add(tfX1, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 470, 45, 30));

        tfr.setEditable(false);
        tfr.setBackground(new java.awt.Color(220, 220, 220));
        tfr.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfr.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfr.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnThongTin.add(tfr, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 420, 45, 30));

        tfa.setEditable(false);
        tfa.setBackground(new java.awt.Color(220, 220, 220));
        tfa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnThongTin.add(tfa, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 380, 45, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("a");
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnThongTin.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 25, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("b");
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnThongTin.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, 25, 30));

        tfb.setEditable(false);
        tfb.setBackground(new java.awt.Color(220, 220, 220));
        tfb.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfb.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnThongTin.add(tfb, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 380, 45, 30));

        lbXoaTatCa.setBackground(new java.awt.Color(0, 0, 0));
        lbXoaTatCa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbXoaTatCa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/icons8_delete_database_20px.png"))); // NOI18N
        lbXoaTatCa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbXoaTatCa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbXoaTatCa.setOpaque(true);
        lbXoaTatCa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbXoaTatCaMousePressed(evt);
            }
        });
        pnThongTin.add(lbXoaTatCa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 70, 30));

        lbDelete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/icons8_trash_20px.png"))); // NOI18N
        lbDelete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbDeleteMousePressed(evt);
            }
        });
        pnThongTin.add(lbDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 550, 70, 30));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        pnThongTin.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 160, 10));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("x1");
        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnThongTin.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 25, 30));

        tfx1.setEditable(false);
        tfx1.setBackground(new java.awt.Color(220, 220, 220));
        tfx1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfx1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfx1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnThongTin.add(tfx1, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 300, 45, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("y1");
        jLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnThongTin.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 25, 30));

        tfy1.setEditable(false);
        tfy1.setBackground(new java.awt.Color(220, 220, 220));
        tfy1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfy1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfy1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnThongTin.add(tfy1, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 300, 45, 30));

        tfx2.setEditable(false);
        tfx2.setBackground(new java.awt.Color(220, 220, 220));
        tfx2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfx2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfx2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnThongTin.add(tfx2, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 340, 45, 30));

        tfy2.setEditable(false);
        tfy2.setBackground(new java.awt.Color(220, 220, 220));
        tfy2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfy2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfy2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnThongTin.add(tfy2, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 340, 45, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("y2");
        jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnThongTin.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 25, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("x2");
        jLabel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnThongTin.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 25, 30));

        add(pnThongTin, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, -40, 200, 590));

        pnFooter.setBackground(new java.awt.Color(255, 255, 255));
        pnFooter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnFooter.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        pnFooter.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 35, 30, 10));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        pnFooter.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 35, 30, 10));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        pnFooter.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 35, 30, 10));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/icons8_move_30px.png"))); // NOI18N
        jLabel2.setText("Java:");
        pnFooter.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        toadoJava.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        toadoJava.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        toadoJava.setText("Ox : Oy");
        toadoJava.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnFooter.add(toadoJava, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 70, 30));

        toaDoCurrent.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        toaDoCurrent.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        toaDoCurrent.setText("Ox : Oy");
        toaDoCurrent.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnFooter.add(toaDoCurrent, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 60, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/icons8_move_30px.png"))); // NOI18N
        jLabel1.setText("Descartes:");
        pnFooter.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 110, -1));

        jSliderGocQuay.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderGocQuayStateChanged(evt);
            }
        });
        pnFooter.add(jSliderGocQuay, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, 30));

        jTextFieldDiemDenX.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextFieldDiemDenX.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldDiemDenX.setToolTipText("Nhập khoảng cách x");
        jTextFieldDiemDenX.setBorder(null);
        jTextFieldDiemDenX.setSelectionColor(new java.awt.Color(153, 153, 153));
        pnFooter.add(jTextFieldDiemDenX, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 30, 30));

        jTextFieldDiemDenY.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextFieldDiemDenY.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldDiemDenY.setToolTipText("Nhập khoảng cách y");
        jTextFieldDiemDenY.setBorder(null);
        jTextFieldDiemDenY.setSelectionColor(new java.awt.Color(153, 153, 153));
        pnFooter.add(jTextFieldDiemDenY, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, 30, 30));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/icons8_joystick_30px.png"))); // NOI18N
        jButton1.setToolTipText("Tịnh tiến 1 khoảng x, y");
        jButton1.setBorder(null);
        jButton1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnFooter.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, 30, 30));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/icons8_zoom_to_extents_30px.png"))); // NOI18N
        jButton2.setToolTipText("Thu phóng");
        jButton2.setBorder(null);
        jButton2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        pnFooter.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, 30, 30));

        jTextFieldThuPhong.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextFieldThuPhong.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldThuPhong.setToolTipText("Nhập hệ số thu phóng");
        jTextFieldThuPhong.setBorder(null);
        jTextFieldThuPhong.setSelectionColor(new java.awt.Color(153, 153, 153));
        pnFooter.add(jTextFieldThuPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 30, 30));

        add(pnFooter, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 1000, 50));

        pnChucNang.setBackground(new java.awt.Color(255, 255, 255));
        pnChucNang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnChucNang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbHinhCN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/icons8_rectangular_30px_1.png"))); // NOI18N
        lbHinhCN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbHinhCN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbHinhCNMousePressed(evt);
            }
        });
        pnChucNang.add(lbHinhCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        lbHinhTamGiac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/icons8_triangle_30px.png"))); // NOI18N
        lbHinhTamGiac.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbHinhTamGiac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbHinhTamGiacMousePressed(evt);
            }
        });
        pnChucNang.add(lbHinhTamGiac, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        lbHinhDuongThang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/icons8_line_30px.png"))); // NOI18N
        lbHinhDuongThang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbHinhDuongThang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbHinhDuongThangMousePressed(evt);
            }
        });
        pnChucNang.add(lbHinhDuongThang, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        lbHinhTron.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/icons8_circle_30px.png"))); // NOI18N
        lbHinhTron.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbHinhTron.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbHinhTronMousePressed(evt);
            }
        });
        pnChucNang.add(lbHinhTron, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        lbHinhOval.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/icons8_oval_30px.png"))); // NOI18N
        lbHinhOval.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbHinhOval.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbHinhOvalMousePressed(evt);
            }
        });
        pnChucNang.add(lbHinhOval, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        lbXoay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbXoay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/icons8_flag_filled_30px_1.png"))); // NOI18N
        lbXoay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbXoay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbXoayMousePressed(evt);
            }
        });
        pnChucNang.add(lbXoay, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, -1));

        lbLatOy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/icons8_flip_vertical_30px_1.png"))); // NOI18N
        lbLatOy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbLatOy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbLatOyMousePressed(evt);
            }
        });
        pnChucNang.add(lbLatOy, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, -1, -1));

        lbLatOx.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/icons8_flip_horizontal_30px_1.png"))); // NOI18N
        lbLatOx.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbLatOx.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbLatOxMousePressed(evt);
            }
        });
        pnChucNang.add(lbLatOx, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, -1, -1));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        pnChucNang.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 30, 10));

        add(pnChucNang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -50, 50, 600));
    }// </editor-fold>//GEN-END:initComponents

    private void lbHinhDuongThangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHinhDuongThangMousePressed
        if (!selectDuongThang) {
            selectHCN = false;
            selectTamGiac = false;
            selectOval = false;
            selectTron = false;
            selectXoay = false;
            lbSelected(lbHinhDuongThang);
            lbHinhCN.setBorder(null);
            lbHinhTamGiac.setBorder(null);
            lbHinhOval.setBorder(null);
            lbHinhTron.setBorder(null);
            lbXoay.setBorder(null);
        } else {
            lbHinhDuongThang.setBorder(null);
        }
        selectDuongThang = !selectDuongThang;

        mode = DRAW_LINE;
    }//GEN-LAST:event_lbHinhDuongThangMousePressed

    private void lbHinhCNMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHinhCNMousePressed
        if (!selectHCN) {
            selectDuongThang = false;
            selectTamGiac = false;
            selectOval = false;
            selectTron = false;
            selectXoay = false;

            lbSelected(lbHinhCN);
            lbHinhDuongThang.setBorder(null);
            lbHinhTamGiac.setBorder(null);
            lbHinhOval.setBorder(null);
            lbHinhTron.setBorder(null);
            lbXoay.setBorder(null);
        } else {
            lbHinhCN.setBorder(null);
        }
        selectHCN = !selectHCN;

        mode = DRAW_RECT;
    }//GEN-LAST:event_lbHinhCNMousePressed

    private void lbHinhTamGiacMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHinhTamGiacMousePressed
        if (!selectTamGiac) {
            selectDuongThang = false;
            selectHCN = false;
            selectOval = false;
            selectTron = false;
            selectXoay = false;

            lbSelected(lbHinhTamGiac);
            lbHinhDuongThang.setBorder(null);
            lbHinhCN.setBorder(null);
            lbHinhOval.setBorder(null);
            lbHinhTron.setBorder(null);
            lbXoay.setBorder(null);
        } else {
            lbHinhTamGiac.setBorder(null);
        }
        selectTamGiac = !selectTamGiac;

        mode = DRAW_TRIANGLE;
    }//GEN-LAST:event_lbHinhTamGiacMousePressed

    private void lbHinhOvalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHinhOvalMousePressed
        if (!selectOval) {
            selectDuongThang = false;
            selectHCN = false;
            selectTamGiac = false;
            selectTron = false;
            selectXoay = false;

            lbSelected(lbHinhOval);
            lbHinhDuongThang.setBorder(null);
            lbHinhCN.setBorder(null);
            lbHinhTamGiac.setBorder(null);
            lbHinhTron.setBorder(null);
            lbXoay.setBorder(null);
        } else {
            lbHinhOval.setBorder(null);
        }
        selectOval = !selectOval;

//        mode = DRAW_CIRCLE;
        mode = DRAW_ELLIPSE;

    }//GEN-LAST:event_lbHinhOvalMousePressed

    private void pnMainMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnMainMouseEntered
        if (selectDuongThang || selectHCN || selectOval || selectTamGiac || selectTron) {
            pnMain.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        }
        if (selectXoay) {
            pnMain.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
        }

    }//GEN-LAST:event_pnMainMouseEntered

    private void pnMainMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnMainMouseExited
        pnMain.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_pnMainMouseExited

    private void pnMainMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnMainMouseMoved

        Point point = TrucToaDo.convertDescart(evt.getPoint());
        String xyCurrent = (int) point.getX() + " : " + (int) point.getY();
        toaDoCurrent.setText(xyCurrent);
        int xJv = evt.getX() + 50;
        int yJv = evt.getY() + 50;
        toadoJava.setText(xJv + " : " + yJv);
//       

    }//GEN-LAST:event_pnMainMouseMoved

    private void pnMainMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnMainMouseDragged
        Point point = TrucToaDo.convertDescart(evt.getPoint());
        String xyCurrent = (int) point.getX() + " : " + (int) point.getY();
        toaDoCurrent.setText(xyCurrent);
        int xJv = evt.getX() + 50;
        int yJv = evt.getY() + 50;
        toadoJava.setText(xJv + " : " + yJv);

        x2 = evt.getX();
        y2 = evt.getY();
        Point start = TrucToaDo.convertDescart(new Point(x1, y1));
        Point end = TrucToaDo.convertDescart(evt.getPoint());

        if (mode.equals(DRAW_LINE) && selectDuongThang) {
            TrucToaDo.tempShape = new MyLine(
                    start,
                    end);
        } else if (mode.equals(DRAW_RECT) && selectHCN) {
            TrucToaDo.tempShape = new MyRect(
                    start, end);

        } else if (mode.equals(DRAW_TRIANGLE) && selectTamGiac) {
//            TrucToaDo.tempShape = new Triangle(
//                    start,
//                    (int) Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1))/5);
            TrucToaDo.tempShape = new Triangle(
                    start,
                    end);
        } else if (mode.equals(DRAW_CIRCLE) && selectTron) {
            TrucToaDo.tempShape = new Circle(
                    start,
                    (int) Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1)) / 5);
        } else if (mode.equals(DRAW_ELLIPSE) && selectOval) {
            TrucToaDo.tempShape = new Ellipse(
                    start,
                    end);
        }
        repaint();
    }//GEN-LAST:event_pnMainMouseDragged

    private void pnMainMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnMainMousePressed

        x1 = evt.getX();
        y1 = evt.getY();
        Point start = TrucToaDo.convertDescart(new Point(x1, y1));

        if (selectXoay) {
            TrucToaDo.tempFlag = new MyFlag(x1, y1);
            pQuay = new Point(x1, y1);
            listShape.clearSelection();
//            shape = listShapeInfo.get(selectedRotating);
        } else {
            TrucToaDo.tempFlag = null;
        }
        repaint();
    }//GEN-LAST:event_pnMainMousePressed

    private void pnMainMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnMainMouseReleased
        shape = new ShapeInfo();

        x2 = evt.getX();
        y2 = evt.getY();

        Point start = TrucToaDo.convertDescart(new Point(x1, y1));
        shape.setxStart(start.x);
        shape.setyStart(start.y);

        Point end = TrucToaDo.convertDescart(evt.getPoint());
        shape.setxEnd(end.x);
        shape.setyEnd(end.y);

        if (mode.equals(DRAW_LINE) && selectDuongThang) {
            shape.setline(numberName("Line"));
            TrucToaDo.shapeList.add(new MyLine(
                    start,
                    end));
        } else if (mode.equals(DRAW_RECT) && selectHCN) {
            shape.setRectangle(numberName("Rectangle"));
            TrucToaDo.shapeList.add(new MyRect(
                    start, end));

        } else if (mode.equals(DRAW_TRIANGLE) && selectTamGiac) {
            shape.setTriangle(numberName("Triangle"));
            TrucToaDo.shapeList.add(new Triangle(
                    start,
                    end));
        } else if (mode.equals(DRAW_CIRCLE) && selectTron) {
            shape.setCircle(numberName("Circle"));
            TrucToaDo.shapeList.add(new Circle(
                    start,
                    (int) Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1)) / 5));
        } else if (mode.equals(DRAW_ELLIPSE) && selectOval) {
            shape.setEllipse(numberName("Ellipse"));
            TrucToaDo.shapeList.add(new Ellipse(
                    start,
                    end));
        }
        setNullTf();
        listIndexSelected = null;
        if (shape.getName() != null) {
            listShapeInfo.add(shape);
            setListShape();
            repaint();
        }
    }//GEN-LAST:event_pnMainMouseReleased

    private void lbHinhTronMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHinhTronMousePressed
        if (!selectTron) {
            selectDuongThang = false;
            selectHCN = false;
            selectOval = false;
            selectTamGiac = false;
            selectXoay = false;
            lbSelected(lbHinhTron);
            lbHinhDuongThang.setBorder(null);
            lbHinhCN.setBorder(null);
            lbHinhOval.setBorder(null);
            lbHinhTamGiac.setBorder(null);
            lbXoay.setBorder(null);
        } else {
            lbHinhTron.setBorder(null);
        }
        selectTron = !selectTron;

        mode = DRAW_CIRCLE;
    }//GEN-LAST:event_lbHinhTronMousePressed

    private void listShapeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listShapeMousePressed
        try {
            listIndexSelected = listShape.getSelectedIndices();
        } catch (Exception e) {
            listIndexSelected = null;
        }
        if (listIndexSelected != null) {
            for (int i=0;i<TrucToaDo.shapeList.size();i++)
            {
                for (int j=0;j<listIndexSelected.length;j++)
                {
                    if (i==listIndexSelected[j])
                    {
                        TrucToaDo.shapeList.get(i).setColor(Color.BLUE);
                        break;
                    }
                    else
                    {
                        TrucToaDo.shapeList.get(i).setColor(Color.BLACK);
                    }
                }
                
            }
            shape = listShapeInfo.get(listIndexSelected[0]);
            name = listShapeInfo.get(listIndexSelected[0]).getName();
            selectedRotating = listIndexSelected[0];
            setTextTf();
            repaint();
        }
    }//GEN-LAST:event_listShapeMousePressed

    private void lbDeleteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDeleteMousePressed
        if (listIndexSelected != null) {
            int select = JOptionPane.showConfirmDialog(this, "XÓA", "Xóa " + name + "", JOptionPane.YES_NO_OPTION, 0);
            if (select == 0) {
                TrucToaDo.shapeList.remove(listIndexSelected[0]);
                TrucToaDo.tempShape = null;
                listShapeInfo.remove(listIndexSelected[0]);
                pnMain.repaint();
                setListShape();
                listIndexSelected = null;
                setNullTf();
                TrucToaDo.tempFlag = null;
                selectXoay = false;
                lbXoay.setBorder(null);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Chọn Shape");
        }
        repaint();

    }//GEN-LAST:event_lbDeleteMousePressed

    private void lbXoaTatCaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbXoaTatCaMousePressed
        if (!listShapeInfo.isEmpty()) {
            int select = JOptionPane.showConfirmDialog(this, "XÓA TẤT CẢ", "Xóa tất cả các Shape?", JOptionPane.YES_NO_OPTION, 0);
            if (select == 0) {
                TrucToaDo.shapeList.clear();
                TrucToaDo.tempShape = null;
                listShapeInfo.clear();
                pnMain.repaint();
                setListShape();
                listIndexSelected = null;
                setNullTf();
                TrucToaDo.tempFlag = null;
                selectXoay = false;
                lbXoay.setBorder(null);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Danh sách rỗng");
        }
        repaint();
    }//GEN-LAST:event_lbXoaTatCaMousePressed

    private void lbXoayMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbXoayMousePressed
        if (!selectXoay) {
            selectDuongThang = false;
            selectHCN = false;
            selectOval = false;
            selectTamGiac = false;
            selectTron = false;
            lbSelected(lbXoay);
            lbHinhDuongThang.setBorder(null);
            lbHinhCN.setBorder(null);
            lbHinhOval.setBorder(null);
            lbHinhTamGiac.setBorder(null);
            lbHinhTron.setBorder(null);
        } else {
            TrucToaDo.tempFlag = null;
            lbXoay.setBorder(null);
        }
        repaint();
        selectXoay = !selectXoay;
    }//GEN-LAST:event_lbXoayMousePressed

    private void jSliderGocQuayStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderGocQuayStateChanged

        if (selectXoay) {
            if (listShape.getSelectedIndex() >= 0) {
                double gocQuay = (double) jSliderGocQuay.getValue() * Math.PI / 100 * 10;
                Point trucQuay = TrucToaDo.convertDescart(pQuay);
                for (int i = 0; i < listIndexSelected.length; i++) {
                    if (TrucToaDo.shapeList.get(listIndexSelected[i]) instanceof Ellipse) {
                        TrucToaDo.shapeList.get(listIndexSelected[i]).xoay(gocQuay, trucQuay);
                        TrucToaDo.shapeList.get(listIndexSelected[i]).setRadianAndAnchor(gocQuay, trucQuay);
                        Ellipse e = (Ellipse) TrucToaDo.shapeList.get(listIndexSelected[i]);
                        setEllipseChanged(e, listIndexSelected[i]);
                        repaint();
                    } else {
                        TrucToaDo.shapeList.get(listIndexSelected[i]).xoay(gocQuay, trucQuay);
                        if (TrucToaDo.shapeList.get(listIndexSelected[i]) instanceof Circle) {
                            Circle c = (Circle) TrucToaDo.shapeList.get(listIndexSelected[i]);
                            setCircleChanged(c, listIndexSelected[i]);

                        } else if (TrucToaDo.shapeList.get(listIndexSelected[i]) instanceof MyRect) {
                            MyRect r = (MyRect) TrucToaDo.shapeList.get(listIndexSelected[i]);
                            setRectChanged(r, listIndexSelected[i]);

                        } else if (TrucToaDo.shapeList.get(listIndexSelected[i]) instanceof MyLine) {
                            MyLine l = (MyLine) TrucToaDo.shapeList.get(listIndexSelected[i]);
                            setLineChanged(l, listIndexSelected[i]);

                        } else if (TrucToaDo.shapeList.get(listIndexSelected[i]) instanceof Triangle) {
                            Triangle t = (Triangle) TrucToaDo.shapeList.get(listIndexSelected[i]);
                            setTriangleChanged(t, listIndexSelected[i]);
                        }
                        repaint();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn shape!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn cờ!");
        }
    }//GEN-LAST:event_jSliderGocQuayStateChanged

    private void lbLatOyMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLatOyMousePressed

        if (listShape.getSelectedIndex() >= 0) {
            for (int i = 0; i < listIndexSelected.length; i++) {
                TrucToaDo.shapeList.get(listIndexSelected[i]).doiXungOy();
                TrucToaDo.tempShape = null;
                repaint();
                if (TrucToaDo.shapeList.get(listIndexSelected[i]) instanceof Circle) {
                    setCircleChanged((Circle) TrucToaDo.shapeList.get(listIndexSelected[i]), listIndexSelected[i]);
                } else if (TrucToaDo.shapeList.get(listIndexSelected[i]) instanceof MyRect) {
                    setRectChanged((MyRect) TrucToaDo.shapeList.get(listIndexSelected[i]), listIndexSelected[i]);
                } else if (TrucToaDo.shapeList.get(listIndexSelected[i]) instanceof MyLine) {
                    setLineChanged((MyLine) TrucToaDo.shapeList.get(listIndexSelected[i]), listIndexSelected[i]);
                } else if (TrucToaDo.shapeList.get(listIndexSelected[i]) instanceof Triangle) {
                    setTriangleChanged((Triangle) TrucToaDo.shapeList.get(listIndexSelected[i]), listIndexSelected[i]);
                } else if (TrucToaDo.shapeList.get(listIndexSelected[i]) instanceof Ellipse) {
                    setEllipseChanged((Ellipse) TrucToaDo.shapeList.get(listIndexSelected[i]), listIndexSelected[i]);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn shape!");
        }
    }//GEN-LAST:event_lbLatOyMousePressed

    private void lbLatOxMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLatOxMousePressed

        if (listShape.getSelectedIndex() >= 0) {

            for (int i = 0; i < listIndexSelected.length; i++) {
                TrucToaDo.shapeList.get(listIndexSelected[i]).doiXungOx();
                TrucToaDo.tempShape = null;
                repaint();
                if (TrucToaDo.shapeList.get(listIndexSelected[i]) instanceof Circle) {
                    setCircleChanged((Circle) TrucToaDo.shapeList.get(listIndexSelected[i]), listIndexSelected[i]);
                } else if (TrucToaDo.shapeList.get(listIndexSelected[i]) instanceof MyRect) {
                    setRectChanged((MyRect) TrucToaDo.shapeList.get(listIndexSelected[i]), listIndexSelected[i]);
                } else if (TrucToaDo.shapeList.get(listIndexSelected[i]) instanceof MyLine) {
                    setLineChanged((MyLine) TrucToaDo.shapeList.get(listIndexSelected[i]), listIndexSelected[i]);
                } else if (TrucToaDo.shapeList.get(listIndexSelected[i]) instanceof Triangle) {
                    setTriangleChanged((Triangle) TrucToaDo.shapeList.get(listIndexSelected[i]), listIndexSelected[i]);
                } else if (TrucToaDo.shapeList.get(listIndexSelected[i]) instanceof Ellipse) {
                    setEllipseChanged((Ellipse) TrucToaDo.shapeList.get(listIndexSelected[i]), listIndexSelected[i]);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn shape!");
        }
    }//GEN-LAST:event_lbLatOxMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (jTextFieldDiemDenX.getText().isBlank() || jTextFieldDiemDenY.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ chiều tịnh tiến!");
        }
        if (listShape.getSelectedIndex() >= 0) {
            for (int i = 0; i < listIndexSelected.length; i++) {
                TrucToaDo.shapeList.get(listIndexSelected[i]).dich(Integer.valueOf(jTextFieldDiemDenX.getText()), Integer.valueOf(jTextFieldDiemDenY.getText()));
                TrucToaDo.tempShape = null;
                repaint();
                if (TrucToaDo.shapeList.get(listIndexSelected[i]) instanceof Circle) {
                    setCircleChanged((Circle) TrucToaDo.shapeList.get(listIndexSelected[i]), listIndexSelected[i]);
                } else if (TrucToaDo.shapeList.get(listIndexSelected[i]) instanceof MyRect) {
                    setRectChanged((MyRect) TrucToaDo.shapeList.get(listIndexSelected[i]), listIndexSelected[i]);
                } else if (TrucToaDo.shapeList.get(listIndexSelected[i]) instanceof MyLine) {
                    setLineChanged((MyLine) TrucToaDo.shapeList.get(listIndexSelected[i]), listIndexSelected[i]);
                } else if (TrucToaDo.shapeList.get(listIndexSelected[i]) instanceof Triangle) {
                    setTriangleChanged((Triangle) TrucToaDo.shapeList.get(listIndexSelected[i]), listIndexSelected[i]);
                } else if (TrucToaDo.shapeList.get(listIndexSelected[i]) instanceof Ellipse) {
                    setEllipseChanged((Ellipse) TrucToaDo.shapeList.get(listIndexSelected[i]), listIndexSelected[i]);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn shape!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (jTextFieldThuPhong.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập hệ số!");
            return;
        }
        if (listShape.getSelectedIndex() >= 0) {
            for (int i = 0; i < listIndexSelected.length; i++) {
                TrucToaDo.shapeList.get(listIndexSelected[i]).thuPhong(Double.valueOf(jTextFieldThuPhong.getText()));
                TrucToaDo.tempShape = null;
                repaint();
                if (TrucToaDo.shapeList.get(listIndexSelected[i]) instanceof Circle) {
                    setCircleChanged((Circle) TrucToaDo.shapeList.get(listIndexSelected[i]), listIndexSelected[i]);
                } else if (TrucToaDo.shapeList.get(listIndexSelected[i]) instanceof MyRect) {
                    setRectChanged((MyRect) TrucToaDo.shapeList.get(listIndexSelected[i]), listIndexSelected[i]);
                } else if (TrucToaDo.shapeList.get(listIndexSelected[i]) instanceof MyLine) {
                    setLineChanged((MyLine) TrucToaDo.shapeList.get(listIndexSelected[i]), listIndexSelected[i]);
                } else if (TrucToaDo.shapeList.get(listIndexSelected[i]) instanceof Triangle) {
                    setTriangleChanged((Triangle) TrucToaDo.shapeList.get(listIndexSelected[i]), listIndexSelected[i]);
                } else if (TrucToaDo.shapeList.get(listIndexSelected[i]) instanceof Ellipse) {
                    setEllipseChanged((Ellipse) TrucToaDo.shapeList.get(listIndexSelected[i]), listIndexSelected[i]);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn shape!");
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSlider jSliderGocQuay;
    private javax.swing.JTextField jTextFieldDiemDenX;
    private javax.swing.JTextField jTextFieldDiemDenY;
    private javax.swing.JTextField jTextFieldThuPhong;
    private javax.swing.JLabel lbDelete;
    private javax.swing.JLabel lbFlag;
    private javax.swing.JLabel lbHinhCN;
    private javax.swing.JLabel lbHinhDuongThang;
    private javax.swing.JLabel lbHinhOval;
    private javax.swing.JLabel lbHinhTamGiac;
    private javax.swing.JLabel lbHinhTron;
    private javax.swing.JLabel lbLatOx;
    private javax.swing.JLabel lbLatOy;
    private javax.swing.JLabel lbXoaTatCa;
    private javax.swing.JLabel lbXoay;
    private javax.swing.JList<String> listShape;
    private javax.swing.JPanel pnChucNang;
    private javax.swing.JPanel pnFooter;
    private javax.swing.JPanel pnMain;
    private javax.swing.JPanel pnThongTin;
    private javax.swing.JTextField tfX1;
    private javax.swing.JTextField tfX2;
    private javax.swing.JTextField tfY1;
    private javax.swing.JTextField tfY2;
    private javax.swing.JTextField tfa;
    private javax.swing.JTextField tfb;
    private javax.swing.JTextField tfh;
    private javax.swing.JTextField tfr;
    private javax.swing.JTextField tfx0;
    private javax.swing.JTextField tfx1;
    private javax.swing.JTextField tfx2;
    private javax.swing.JTextField tfy0;
    private javax.swing.JTextField tfy1;
    private javax.swing.JTextField tfy2;
    private javax.swing.JLabel toaDoCurrent;
    private javax.swing.JLabel toadoJava;
    // End of variables declaration//GEN-END:variables
}

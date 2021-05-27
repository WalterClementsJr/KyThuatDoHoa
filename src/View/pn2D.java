/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Circle;
import Model.Ellipse;
import Model.MyLine;
import Model.MyRect;
import Model.Pixel;
import Model.Triangle;
import Model.TrucToaDo;
import java.awt.Color;
import java.awt.Cursor;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.Graphics;
import java.awt.Point;
import static java.awt.image.ImageObserver.ALLBITS;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

/**
 *
 * @author zoroONE01
 */
public class pn2D extends javax.swing.JPanel {

    //mấy biến này đúng thì mới thực hiện chức năng nha
    boolean selectDuongThang = false; //vẽ đường thẳng
    boolean selectHCN = false; //vẽ hình chữ nhận
    boolean selectTamGiac = false; //vẽ hình tam giác
    boolean selectOval = false; //vẽ hình oval
    boolean selectDiChuyen = false; //chức năng di chuyển các hình
    boolean selectXoa = false; //chức năng xóa

    int x1, y1, x2, y2;
    

    public final String DRAW_LINE = "line";
    public final String DRAW_RECT = "rect";
    public final String DRAW_CIRCLE = "circle";
    public final String DRAW_TRIANGLE = "triangle";
    public final String DRAW_ELLIPSE = "ellipse";
    
    public String mode = DRAW_LINE;
    
    public pn2D() {
        initComponents();

    }

//    @Override
//    public void paint(Graphics g) {
//        super.paint(g); //To change body of generated methods, choose Tools | Templates.
//        
//    }
    public void lbSelected(JLabel lb) {
        lb.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnThongTin = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        pnMain = new Model.TrucToaDo();
        pnFooter = new javax.swing.JPanel();
        lbUndo = new javax.swing.JLabel();
        lbRedo = new javax.swing.JLabel();
        lbDiChuyen = new javax.swing.JLabel();
        lbXoay = new javax.swing.JLabel();
        lbLatOy = new javax.swing.JLabel();
        lbLatOx = new javax.swing.JLabel();
        lbPhongTo = new javax.swing.JLabel();
        lbThuNho = new javax.swing.JLabel();
        lbXoa = new javax.swing.JLabel();
        toaDoCurrent = new javax.swing.JLabel();
        toadoJava = new javax.swing.JLabel();
        pnChucNang = new javax.swing.JPanel();
        lbHinhCN = new javax.swing.JLabel();
        lbHinhTamGiac = new javax.swing.JLabel();
        lbHinhDuongThang = new javax.swing.JLabel();
        lbHinhOval = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnThongTin.setBackground(new java.awt.Color(255, 255, 255));
        pnThongTin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnThongTin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Thông tin chi tiết");
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnThongTin.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 140, 30));

        add(pnThongTin, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 0, 200, 500));

        pnMain.setBackground(new java.awt.Color(255, 255, 255));
        pnMain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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
            .addGap(0, 748, Short.MAX_VALUE)
        );
        pnMainLayout.setVerticalGroup(
            pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
        );

        add(pnMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 750, 500));

        pnFooter.setBackground(new java.awt.Color(255, 255, 255));
        pnFooter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnFooter.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbUndo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictrue/icons8_undo_30px_1.png"))); // NOI18N
        lbUndo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnFooter.add(lbUndo, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, -1, -1));

        lbRedo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictrue/icons8_redo_30px.png"))); // NOI18N
        lbRedo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnFooter.add(lbRedo, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 10, -1, -1));

        lbDiChuyen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictrue/icons8_move_30px.png"))); // NOI18N
        lbDiChuyen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbDiChuyen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbDiChuyenMousePressed(evt);
            }
        });
        pnFooter.add(lbDiChuyen, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, -1));

        lbXoay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictrue/icons8_rotate_30px.png"))); // NOI18N
        lbXoay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnFooter.add(lbXoay, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        lbLatOy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictrue/icons8_flip_vertical_30px_1.png"))); // NOI18N
        lbLatOy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnFooter.add(lbLatOy, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, -1, -1));

        lbLatOx.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictrue/icons8_flip_horizontal_30px_1.png"))); // NOI18N
        lbLatOx.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnFooter.add(lbLatOx, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, -1, -1));

        lbPhongTo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictrue/icons8_zoom_in_30px.png"))); // NOI18N
        lbPhongTo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnFooter.add(lbPhongTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, -1, -1));

        lbThuNho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictrue/icons8_zoom_out_30px.png"))); // NOI18N
        lbThuNho.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnFooter.add(lbThuNho, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, -1, -1));

        lbXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictrue/icons8_erase_30px_2.png"))); // NOI18N
        lbXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbXoaMousePressed(evt);
            }
        });
        pnFooter.add(lbXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, -1, -1));

        toaDoCurrent.setText("jLabel1");
        pnFooter.add(toaDoCurrent, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 100, -1));

        toadoJava.setText("jLabel1");
        pnFooter.add(toadoJava, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 100, -1));

        add(pnFooter, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 1000, 50));

        pnChucNang.setBackground(new java.awt.Color(255, 255, 255));
        pnChucNang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnChucNang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbHinhCN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictrue/icons8_rectangular_30px_1.png"))); // NOI18N
        lbHinhCN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbHinhCN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbHinhCNMousePressed(evt);
            }
        });
        pnChucNang.add(lbHinhCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        lbHinhTamGiac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictrue/icons8_triangle_30px.png"))); // NOI18N
        lbHinhTamGiac.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbHinhTamGiac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbHinhTamGiacMousePressed(evt);
            }
        });
        pnChucNang.add(lbHinhTamGiac, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        lbHinhDuongThang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictrue/icons8_line_30px.png"))); // NOI18N
        lbHinhDuongThang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbHinhDuongThang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbHinhDuongThangMousePressed(evt);
            }
        });
        pnChucNang.add(lbHinhDuongThang, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 14, -1, -1));

        lbHinhOval.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictrue/icons8_oval_30px.png"))); // NOI18N
        lbHinhOval.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbHinhOval.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbHinhOvalMousePressed(evt);
            }
        });
        pnChucNang.add(lbHinhOval, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        add(pnChucNang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 500));
    }// </editor-fold>//GEN-END:initComponents

    private void lbHinhDuongThangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHinhDuongThangMousePressed
        if (!selectDuongThang) {
            selectHCN = false;
            selectTamGiac = false;
            selectOval = false;
            selectDiChuyen = false;
            selectXoa = false;
            lbSelected(lbHinhDuongThang);
            lbHinhCN.setBorder(null);
            lbHinhTamGiac.setBorder(null);
            lbHinhOval.setBorder(null);
            lbDiChuyen.setBorder(null);
            lbXoa.setBorder(null);
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
            selectDiChuyen = false;
            selectXoa = false;
            lbSelected(lbHinhCN);
            lbHinhDuongThang.setBorder(null);
            lbHinhTamGiac.setBorder(null);
            lbHinhOval.setBorder(null);
            lbDiChuyen.setBorder(null);
            lbXoa.setBorder(null);
        } else {
            lbHinhCN.setBorder(null);
        }
        selectHCN = !selectHCN;

        // TODO add your handling code here:
        mode = DRAW_RECT;
    }//GEN-LAST:event_lbHinhCNMousePressed

    private void lbHinhTamGiacMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHinhTamGiacMousePressed
        if (!selectTamGiac) {
            selectDuongThang = false;
            selectHCN = false;
            selectOval = false;
            selectDiChuyen = false;
            selectXoa = false;
            lbSelected(lbHinhTamGiac);
            lbHinhDuongThang.setBorder(null);
            lbHinhCN.setBorder(null);
            lbHinhOval.setBorder(null);
            lbDiChuyen.setBorder(null);
            lbXoa.setBorder(null);
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
            selectDiChuyen = false;
            selectXoa = false;
            lbSelected(lbHinhOval);
            lbHinhDuongThang.setBorder(null);
            lbHinhCN.setBorder(null);
            lbHinhTamGiac.setBorder(null);
            lbDiChuyen.setBorder(null);
            lbXoa.setBorder(null);
        } else {
            lbHinhOval.setBorder(null);
        }
        selectOval = !selectOval;
        // TODO add your handling code here:
//        mode = DRAW_CIRCLE;
        mode = DRAW_ELLIPSE;

    }//GEN-LAST:event_lbHinhOvalMousePressed

    private void lbDiChuyenMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDiChuyenMousePressed
        if (!selectDiChuyen) {
            lbSelected(lbDiChuyen);
            selectDuongThang = false;
            selectHCN = false;
            selectTamGiac = false;
            selectOval = false;
            selectXoa = false;
            lbHinhDuongThang.setBorder(null);
            lbHinhCN.setBorder(null);
            lbHinhTamGiac.setBorder(null);
            lbHinhOval.setBorder(null);
            lbXoa.setBorder(null);
        } else {
            lbDiChuyen.setBorder(null);
        }
        selectDiChuyen = !selectDiChuyen;

// TODO add your handling code here:
    }//GEN-LAST:event_lbDiChuyenMousePressed

    private void pnMainMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnMainMouseEntered
        if (selectDuongThang || selectHCN || selectOval || selectTamGiac || selectXoa) {
            pnMain.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        }
        if (selectDiChuyen) {
            pnMain.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
        }

    }//GEN-LAST:event_pnMainMouseEntered

    private void pnMainMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnMainMouseExited
        pnMain.setCursor(Cursor.getDefaultCursor());// TODO add your handling code here:
    }//GEN-LAST:event_pnMainMouseExited

    private void lbXoaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbXoaMousePressed
        if (!selectXoa) {
            lbSelected(lbXoa);
            selectDuongThang = false;
            selectHCN = false;
            selectTamGiac = false;
            selectOval = false;
            selectDiChuyen = false;
            lbHinhDuongThang.setBorder(null);
            lbHinhCN.setBorder(null);
            lbHinhTamGiac.setBorder(null);
            lbHinhOval.setBorder(null);
            lbDiChuyen.setBorder(null);
        } else {
            lbXoa.setBorder(null);
        }
        selectXoa = !selectXoa;// TODO add your handling code here:
        
        TrucToaDo.shapeList.clear();
        TrucToaDo.tempShape = null;
        repaint();
    }//GEN-LAST:event_lbXoaMousePressed

    private void pnMainMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnMainMouseMoved
        // TODO add your handling code here:
        Point point = TrucToaDo.convertDescart(evt.getPoint(), TrucToaDo.deltaX, TrucToaDo.deltaY, ALLBITS, ALLBITS);
        String xyCurrent = "(" + point.getX() + ";" + point.getY() + ")";
        toaDoCurrent.setText(xyCurrent);
        int xJv = evt.getX() + 50;
        int yJv = evt.getY() + 50;
        toadoJava.setText("(" + xJv + ";" + yJv + ")");

    }//GEN-LAST:event_pnMainMouseMoved

    private void pnMainMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnMainMouseDragged
        Point point = TrucToaDo.convertDescart(evt.getPoint(), TrucToaDo.deltaX, TrucToaDo.deltaY, ALLBITS, ALLBITS);
        String xyCurrent = "(" + point.getX() + ";" + point.getY() + ")";
        toaDoCurrent.setText(xyCurrent);
        int xJv = evt.getX() + 50;
        int yJv = evt.getY() + 50;
        toadoJava.setText("(" + xJv + ";" + yJv + ")");
        
        x2 = evt.getX();
        y2 = evt.getY();
        Point start = TrucToaDo.convertDescart(new Point(x1, y1), TrucToaDo.deltaX, TrucToaDo.deltaY, ALLBITS, ALLBITS);
        Point end = TrucToaDo.convertDescart(evt.getPoint(), TrucToaDo.deltaX, TrucToaDo.deltaY, ALLBITS, ALLBITS);
        
        if (mode.equals(DRAW_LINE)) {
            TrucToaDo.tempShape = new MyLine(
                    start,
                    end);
        } else if (mode.equals(DRAW_RECT)) {
            TrucToaDo.tempShape = new MyRect(
                    start, end);
            
        } else if (mode.equals(DRAW_TRIANGLE)) {
//            TrucToaDo.tempShape = new Triangle(
//                    start,
//                    (int) Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1))/5);
            TrucToaDo.tempShape = new Triangle(
                    start,
                    end);
        } else if (mode.equals(DRAW_CIRCLE)) {
            TrucToaDo.tempShape = new Circle(
                    start,
                    (int) Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1))/10);
        } else if (mode.equals(DRAW_ELLIPSE)) {
            TrucToaDo.tempShape =new Ellipse(
                    start,
                    end);
        }
        repaint();
    }//GEN-LAST:event_pnMainMouseDragged

    private void pnMainMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnMainMousePressed

        x1 = evt.getX();
        y1 = evt.getY();


    }//GEN-LAST:event_pnMainMousePressed

    private void pnMainMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnMainMouseReleased

        x2 = evt.getX();
        y2 = evt.getY();
        Point start = TrucToaDo.convertDescart(new Point(x1, y1), TrucToaDo.deltaX, TrucToaDo.deltaY, ALLBITS, ALLBITS);
        Point end = TrucToaDo.convertDescart(evt.getPoint(), TrucToaDo.deltaX, TrucToaDo.deltaY, ALLBITS, ALLBITS);
        
        // TODO set info into table
        System.out.println(start.getX() +" - "+ start.getY());
        
        if (mode.equals(DRAW_LINE)) {
            TrucToaDo.shapeList.add(new MyLine(
                    start,
                    end));
        } else if (mode.equals(DRAW_RECT)) {
            TrucToaDo.shapeList.add(new MyRect(
                    start, end));
            
        } else if (mode.equals(DRAW_TRIANGLE)) {
//            TrucToaDo.shapeList.add(new Triangle(
//                    start,
//                    (int) Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1))/5));
            TrucToaDo.shapeList.add(new Triangle(
                    start,
                    end));
        } else if (mode.equals(DRAW_CIRCLE)) {
            TrucToaDo.shapeList.add(new Circle(
                    start,
                    (int) Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1))/10));
        } else if (mode.equals(DRAW_ELLIPSE)) {
            TrucToaDo.shapeList.add(new Ellipse(
                    start,
                    end));
        }
        repaint();
    }//GEN-LAST:event_pnMainMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel lbDiChuyen;
    private javax.swing.JLabel lbHinhCN;
    private javax.swing.JLabel lbHinhDuongThang;
    private javax.swing.JLabel lbHinhOval;
    private javax.swing.JLabel lbHinhTamGiac;
    private javax.swing.JLabel lbLatOx;
    private javax.swing.JLabel lbLatOy;
    private javax.swing.JLabel lbPhongTo;
    private javax.swing.JLabel lbRedo;
    private javax.swing.JLabel lbThuNho;
    private javax.swing.JLabel lbUndo;
    private javax.swing.JLabel lbXoa;
    private javax.swing.JLabel lbXoay;
    private javax.swing.JPanel pnChucNang;
    private javax.swing.JPanel pnFooter;
    private javax.swing.JPanel pnMain;
    private javax.swing.JPanel pnThongTin;
    private javax.swing.JLabel toaDoCurrent;
    private javax.swing.JLabel toadoJava;
    // End of variables declaration//GEN-END:variables
}

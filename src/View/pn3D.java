/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.HinhCau;
import Model.HinhHop;
import Model.TrucToaDo;
import Model.TrucToaDo3D;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

/**
 *
 * @author zoroONE01
 */
public class pn3D extends javax.swing.JPanel {

    /**
     * Creates new form pn3D
     */
    boolean selectHinhHop = false;
    boolean selectHinhCau = false;
    boolean selectDiChuyen = false;
    boolean selectXoa = false;
    public final String Ve_HinhHop = "hinhHop";
    public final String Ve_HinhCau = "hinhCau";
    
    public String mode = Ve_HinhHop;

    public pn3D() {
        initComponents();
    }

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

        jSpinner6 = new javax.swing.JSpinner();
        pnThongTin = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSpinnerXo = new javax.swing.JSpinner();
        jSpinnerYo = new javax.swing.JSpinner();
        jSpinnerZo = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSpinnerDai = new javax.swing.JSpinner();
        jSpinnerRong = new javax.swing.JSpinner();
        jSpinnerCao = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSpinnerBanKinh = new javax.swing.JSpinner();
        pnMain = new Model.TrucToaDo3D();
        pnFooter = new javax.swing.JPanel();
        lbDiChuyen = new javax.swing.JLabel();
        lbXoay = new javax.swing.JLabel();
        lbLatOy = new javax.swing.JLabel();
        lbLatOx = new javax.swing.JLabel();
        lbPhongTo = new javax.swing.JLabel();
        lbThuNho = new javax.swing.JLabel();
        lbXoa = new javax.swing.JLabel();
        lbUndo = new javax.swing.JLabel();
        lbRedo = new javax.swing.JLabel();
        pnChucNang = new javax.swing.JPanel();
        lbHinhCau = new javax.swing.JLabel();
        lbHinhHop = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnThongTin.setBackground(new java.awt.Color(255, 255, 255));
        pnThongTin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnThongTin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Thông tin chi tiết");
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnThongTin.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 140, 30));

        jLabel1.setText("X");
        pnThongTin.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel2.setText("Y");
        pnThongTin.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel3.setText("Z");
        pnThongTin.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jSpinnerXo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerXoStateChanged(evt);
            }
        });
        pnThongTin.add(jSpinnerXo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 120, -1));

        jSpinnerYo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerYoStateChanged(evt);
            }
        });
        pnThongTin.add(jSpinnerYo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 100, -1));

        jSpinnerZo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerZoStateChanged(evt);
            }
        });
        pnThongTin.add(jSpinnerZo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 120, -1));

        jLabel4.setText("Dài");
        pnThongTin.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jLabel5.setText("Rộng");
        pnThongTin.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jLabel6.setText("Cao");
        pnThongTin.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jSpinnerDai.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerDaiStateChanged(evt);
            }
        });
        jSpinnerDai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jSpinnerDaiMousePressed(evt);
            }
        });
        pnThongTin.add(jSpinnerDai, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 120, -1));

        jSpinnerRong.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerRongStateChanged(evt);
            }
        });
        pnThongTin.add(jSpinnerRong, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 120, -1));

        jSpinnerCao.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerCaoStateChanged(evt);
            }
        });
        pnThongTin.add(jSpinnerCao, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 120, -1));

        jLabel7.setText("√2");
        pnThongTin.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 20, 20));

        jLabel8.setText("Bán kính");
        pnThongTin.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        jSpinnerBanKinh.setEnabled(false);
        jSpinnerBanKinh.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerBanKinhStateChanged(evt);
            }
        });
        pnThongTin.add(jSpinnerBanKinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 120, -1));

        add(pnThongTin, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 0, 200, 500));

        pnMain.setBackground(new java.awt.Color(255, 255, 255));
        pnMain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnMainMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnMainMouseExited(evt);
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

        lbUndo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictrue/icons8_undo_30px_1.png"))); // NOI18N
        lbUndo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnFooter.add(lbUndo, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, -1, -1));

        lbRedo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictrue/icons8_redo_30px.png"))); // NOI18N
        lbRedo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnFooter.add(lbRedo, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 10, -1, -1));

        add(pnFooter, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 1000, 50));

        pnChucNang.setBackground(new java.awt.Color(255, 255, 255));
        pnChucNang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnChucNang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbHinhCau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictrue/icons8_longitude_30px.png"))); // NOI18N
        lbHinhCau.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbHinhCau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbHinhCauMousePressed(evt);
            }
        });
        pnChucNang.add(lbHinhCau, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        lbHinhHop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictrue/icons8_sugar_cube_30px.png"))); // NOI18N
        lbHinhHop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbHinhHop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbHinhHopMousePressed(evt);
            }
        });
        pnChucNang.add(lbHinhHop, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 14, -1, -1));

        add(pnChucNang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 500));
    }// </editor-fold>//GEN-END:initComponents

    private void lbHinhHopMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHinhHopMousePressed
        TrucToaDo3D.tempShape=null;
        TrucToaDo3D.shape3D=null;
        repaint();
        if (!selectHinhHop) {
            selectHinhCau = false;
            selectDiChuyen = false;
            selectXoa = false;
            lbSelected(lbHinhHop);
            lbHinhCau.setBorder(null);
            lbDiChuyen.setBorder(null);
            lbXoa.setBorder(null);
        } else {
            lbHinhHop.setBorder(null);
        }
        selectHinhHop = !selectHinhHop;// TODO add your handling code here:
        mode=Ve_HinhHop;
        jSpinnerDai.setEnabled(true);
        jSpinnerRong.setEnabled(true);
        jSpinnerCao.setEnabled(true);
        jSpinnerBanKinh.setEnabled(false);
    }//GEN-LAST:event_lbHinhHopMousePressed

    private void lbHinhCauMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHinhCauMousePressed
        TrucToaDo3D.tempShape=null;
        TrucToaDo3D.shape3D=null;
        repaint();
        if (!selectHinhCau) {
            selectHinhHop = false;
            selectDiChuyen = false;
            selectXoa = false;
            lbSelected(lbHinhCau);
            lbHinhHop.setBorder(null);
            lbDiChuyen.setBorder(null);
            lbXoa.setBorder(null);
        } else {
            lbHinhCau.setBorder(null);
        }
        selectHinhCau = !selectHinhCau;// TODO add your handling code here:
        mode=Ve_HinhCau;
        jSpinnerDai.setEnabled(false);
        jSpinnerRong.setEnabled(false);
        jSpinnerCao.setEnabled(false);
        jSpinnerBanKinh.setEnabled(true);
    }//GEN-LAST:event_lbHinhCauMousePressed

    private void lbDiChuyenMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDiChuyenMousePressed
        if (!selectHinhHop) {
            selectHinhCau = false;
            selectHinhHop = false;
            selectXoa = false;
            lbSelected(lbDiChuyen);
            lbHinhCau.setBorder(null);
            lbHinhHop.setBorder(null);
            lbXoa.setBorder(null);
        } else {
            lbDiChuyen.setBorder(null);
        }
        selectDiChuyen = !selectDiChuyen;// TODO add your handling code here:
    }//GEN-LAST:event_lbDiChuyenMousePressed

    private void pnMainMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnMainMouseEntered
        if (selectHinhCau || selectHinhHop || selectXoa) {
            pnMain.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        }
        if (selectDiChuyen) {
            pnMain.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
        }// TODO add your handling code here:
    }//GEN-LAST:event_pnMainMouseEntered

    private void pnMainMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnMainMouseExited
        pnMain.setCursor(Cursor.getDefaultCursor());// TODO add your handling code here:
    }//GEN-LAST:event_pnMainMouseExited

    private void lbXoaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbXoaMousePressed
        if (!selectXoa) {
            selectHinhCau = false;
            selectHinhHop = false;
            selectDiChuyen = false;
            lbSelected(lbXoa);
            lbHinhCau.setBorder(null);
            lbHinhHop.setBorder(null);
            lbDiChuyen.setBorder(null);
        } else {
            lbXoa.setBorder(null);
        }
        selectXoa = !selectXoa;// TODO add your handling code here:
        TrucToaDo3D.tempShape=null;
        TrucToaDo3D.shape3D=null;
        repaint();
    }//GEN-LAST:event_lbXoaMousePressed

    private void jSpinnerXoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerXoStateChanged
        // TODO add your handling code here:
        jSpinnerYoStateChanged(evt);
    }//GEN-LAST:event_jSpinnerXoStateChanged

    private void jSpinnerDaiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSpinnerDaiMousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jSpinnerDaiMousePressed

    private void jSpinnerDaiStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerDaiStateChanged
        // TODO add your handling code here:
        jSpinnerYoStateChanged(evt);
    }//GEN-LAST:event_jSpinnerDaiStateChanged

    private void jSpinnerYoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerYoStateChanged
        // TODO add your handling code here
        if (mode.equals(Ve_HinhHop))
        {
            TrucToaDo3D.shape3D=new HinhHop((int) jSpinnerXo.getValue(), (int) jSpinnerYo.getValue(), (int) jSpinnerZo.getValue(), (int) jSpinnerDai.getValue(),(int) jSpinnerRong.getValue(),(int) jSpinnerCao.getValue());
        }
        else
        {
            if (mode.equals(Ve_HinhCau))
            {
                TrucToaDo3D.shape3D=new HinhCau((int) jSpinnerXo.getValue(), (int) jSpinnerYo.getValue(), (int) jSpinnerZo.getValue(), (int) jSpinnerBanKinh.getValue());
            }
        }
        repaint();
    }//GEN-LAST:event_jSpinnerYoStateChanged

    private void jSpinnerZoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerZoStateChanged
        // TODO add your handling code here:
        jSpinnerYoStateChanged(evt);
    }//GEN-LAST:event_jSpinnerZoStateChanged

    private void jSpinnerRongStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerRongStateChanged
        // TODO add your handling code here:
        jSpinnerYoStateChanged(evt);
    }//GEN-LAST:event_jSpinnerRongStateChanged

    private void jSpinnerCaoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerCaoStateChanged
        // TODO add your handling code here:
        jSpinnerYoStateChanged(evt);
    }//GEN-LAST:event_jSpinnerCaoStateChanged

    private void jSpinnerBanKinhStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerBanKinhStateChanged
        // TODO add your handling code here:
        jSpinnerYoStateChanged(evt);
    }//GEN-LAST:event_jSpinnerBanKinhStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSpinner jSpinner6;
    private javax.swing.JSpinner jSpinnerBanKinh;
    private javax.swing.JSpinner jSpinnerCao;
    private javax.swing.JSpinner jSpinnerDai;
    private javax.swing.JSpinner jSpinnerRong;
    private javax.swing.JSpinner jSpinnerXo;
    private javax.swing.JSpinner jSpinnerYo;
    private javax.swing.JSpinner jSpinnerZo;
    private javax.swing.JLabel lbDiChuyen;
    private javax.swing.JLabel lbHinhCau;
    private javax.swing.JLabel lbHinhHop;
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
    // End of variables declaration//GEN-END:variables
}

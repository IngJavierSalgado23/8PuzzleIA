/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salgado;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author antonio
 */
public class Puzzle extends javax.swing.JFrame {

    AgenteNoInformado agenteNI = new AgenteNoInformado();
    AgenteInformado agenteI = new AgenteInformado();
    private Refresh taskRefresh;
    ArrayList<Nodo> route = new ArrayList();
    private int nodosVisitados = 0;

    public Puzzle() {
        initComponents();
    }

    class Refresh extends SwingWorker<Void, Void> {

        @Override
        protected Void doInBackground() throws Exception {
            lblNodos.setText("0");
            for (int i = 0; i < route.size(); i++) {
                refreshPuzzle(route.get(i));
                labelMov.setText(String.valueOf(i));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Puzzle.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            lblNodos.setText(String.valueOf(nodosVisitados));
            JOptionPane.showMessageDialog(null, "Ganaste");
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnRUN = new javax.swing.JButton();
        la3 = new javax.swing.JLabel();
        la0 = new javax.swing.JLabel();
        la1 = new javax.swing.JLabel();
        la4 = new javax.swing.JLabel();
        la2 = new javax.swing.JLabel();
        la5 = new javax.swing.JLabel();
        la8 = new javax.swing.JLabel();
        la7 = new javax.swing.JLabel();
        la6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        labelMov = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lblNodos = new javax.swing.JLabel();

        jLabel2.setText("jLabel1");

        jLabel3.setText("jLabel1");

        jLabel5.setText("jLabel1");

        jLabel7.setText("jLabel1");

        jLabel8.setBackground(new java.awt.Color(255, 0, 0));
        jLabel8.setForeground(new java.awt.Color(255, 51, 51));
        jLabel8.setText("jLabel1");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel11.setBackground(new java.awt.Color(255, 0, 0));
        jLabel11.setForeground(new java.awt.Color(255, 51, 51));
        jLabel11.setText("jLabel1");
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel10.setBackground(new java.awt.Color(255, 0, 0));
        jLabel10.setForeground(new java.awt.Color(255, 51, 51));
        jLabel10.setText("jLabel1");
        jLabel10.setAlignmentY(0.0F);
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel13.setBackground(new java.awt.Color(255, 0, 0));
        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setText("jLabel1");
        jLabel13.setAlignmentY(0.0F);
        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnRUN.setText("No Informado");
        btnRUN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRUNActionPerformed(evt);
            }
        });

        la3.setBackground(new java.awt.Color(255, 0, 0));
        la3.setForeground(new java.awt.Color(255, 51, 51));
        la3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salgado/images/4.png"))); // NOI18N
        la3.setAlignmentY(0.0F);
        la3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        la0.setBackground(new java.awt.Color(255, 0, 0));
        la0.setForeground(new java.awt.Color(255, 51, 51));
        la0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salgado/images/1.png"))); // NOI18N
        la0.setAlignmentY(0.0F);
        la0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        la1.setBackground(new java.awt.Color(255, 0, 0));
        la1.setForeground(new java.awt.Color(255, 51, 51));
        la1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salgado/images/2.png"))); // NOI18N
        la1.setAlignmentY(0.0F);
        la1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        la4.setBackground(new java.awt.Color(255, 0, 0));
        la4.setForeground(new java.awt.Color(255, 51, 51));
        la4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salgado/images/5.png"))); // NOI18N
        la4.setAlignmentY(0.0F);
        la4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        la2.setBackground(new java.awt.Color(255, 0, 0));
        la2.setForeground(new java.awt.Color(255, 51, 51));
        la2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salgado/images/3.png"))); // NOI18N
        la2.setAlignmentY(0.0F);
        la2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        la5.setBackground(new java.awt.Color(255, 0, 0));
        la5.setForeground(new java.awt.Color(255, 51, 51));
        la5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salgado/images/6.png"))); // NOI18N
        la5.setAlignmentY(0.0F);
        la5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        la8.setBackground(new java.awt.Color(255, 0, 0));
        la8.setForeground(new java.awt.Color(255, 51, 51));
        la8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salgado/images/0.png"))); // NOI18N
        la8.setToolTipText("");
        la8.setAlignmentY(0.0F);
        la8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        la7.setBackground(new java.awt.Color(255, 0, 0));
        la7.setForeground(new java.awt.Color(255, 51, 51));
        la7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salgado/images/8.png"))); // NOI18N
        la7.setAlignmentY(0.0F);
        la7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        la6.setBackground(new java.awt.Color(255, 0, 0));
        la6.setForeground(new java.awt.Color(255, 51, 51));
        la6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salgado/images/7.png"))); // NOI18N
        la6.setAlignmentY(0.0F);
        la6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Movimientos:");

        labelMov.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelMov.setText("0");

        jButton1.setText("Informado");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Nodos Visitados:");

        lblNodos.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblNodos.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(la6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(la0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(la3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(la7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(la8, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(la1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(la2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(la4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(la5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(labelMov, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(lblNodos)))
                .addGap(77, 77, 77))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnRUN)
                .addGap(28, 28, 28)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(la1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(la2)
                    .addComponent(la0)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(la4)
                        .addComponent(la5, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(la3))
                    .addComponent(labelMov))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(la7)
                        .addComponent(la6)
                        .addComponent(la8))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNodos, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRUN)
                    .addComponent(jButton1))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRUNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRUNActionPerformed
        agenteNI.createAgenteNoInformado();
        refreshPuzzle(agenteNI.getInicio());
        this.route = agenteNI.route;
        this.nodosVisitados = agenteNI.getNodosVisitado();
        taskRefresh = new Refresh();
        taskRefresh.execute();
    }//GEN-LAST:event_btnRUNActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        agenteI.createAgenteInformado();
        refreshPuzzle(agenteI.getInicio());
        this.route = agenteI.route;
        this.nodosVisitados = agenteI.getNodosVisitado();
        taskRefresh = new Refresh();
        taskRefresh.execute();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void refreshPuzzle(Nodo nuevo) {
        int[] puzzle = new int[9];
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                puzzle[count] = nuevo.getPuzzle()[i][j];
                count++;
            }
        }
        la0.setIcon((new ImageIcon(Puzzle.class.getResource("images/" + String.valueOf(puzzle[0]) + ".png"))));
        la1.setIcon((new ImageIcon(Puzzle.class.getResource("images/" + String.valueOf(puzzle[1]) + ".png"))));
        la2.setIcon((new ImageIcon(Puzzle.class.getResource("images/" + String.valueOf(puzzle[2]) + ".png"))));
        la3.setIcon((new ImageIcon(Puzzle.class.getResource("images/" + String.valueOf(puzzle[3]) + ".png"))));
        la4.setIcon((new ImageIcon(Puzzle.class.getResource("images/" + String.valueOf(puzzle[4]) + ".png"))));
        la5.setIcon((new ImageIcon(Puzzle.class.getResource("images/" + String.valueOf(puzzle[5]) + ".png"))));
        la6.setIcon((new ImageIcon(Puzzle.class.getResource("images/" + String.valueOf(puzzle[6]) + ".png"))));
        la7.setIcon((new ImageIcon(Puzzle.class.getResource("images/" + String.valueOf(puzzle[7]) + ".png"))));
        la8.setIcon((new ImageIcon(Puzzle.class.getResource("images/" + String.valueOf(puzzle[8]) + ".png"))));
        labelMov.setText("0");
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Puzzle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRUN;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel la0;
    private javax.swing.JLabel la1;
    private javax.swing.JLabel la2;
    private javax.swing.JLabel la3;
    private javax.swing.JLabel la4;
    private javax.swing.JLabel la5;
    private javax.swing.JLabel la6;
    private javax.swing.JLabel la7;
    private javax.swing.JLabel la8;
    private javax.swing.JLabel labelMov;
    private javax.swing.JLabel lblNodos;
    // End of variables declaration//GEN-END:variables
}

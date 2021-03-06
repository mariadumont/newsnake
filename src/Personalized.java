
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alu20482156n
 */
public class Personalized extends javax.swing.JDialog {

    /**
     * Creates new form Personalized
     */
    private boolean radioButtonSelected;

    public Personalized(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        radioButtonSelected = false;
        setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNumCols = new javax.swing.JTextField();
        jTextFieldNumRows = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldSpeed = new javax.swing.JTextField();
        jRadioButtonClassic = new javax.swing.JRadioButton();
        jRadioButtonNoWalls = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Num Cols:");

        jLabel2.setText("Num Rows:");

        jTextFieldNumCols.setText("20");
        jTextFieldNumCols.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNumColsActionPerformed(evt);
            }
        });

        jTextFieldNumRows.setText("20");
        jTextFieldNumRows.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNumRowsActionPerformed(evt);
            }
        });

        jButton1.setText("ok");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Speed:");

        jTextFieldSpeed.setText("300");
        jTextFieldSpeed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSpeedActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonClassic);
        jRadioButtonClassic.setText("Classic snake");
        jRadioButtonClassic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonClassicActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonNoWalls);
        jRadioButtonNoWalls.setText("No walls mode");
        jRadioButtonNoWalls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonNoWallsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButtonClassic)
                        .addGap(35, 35, 35)
                        .addComponent(jRadioButtonNoWalls)
                        .addContainerGap(57, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldNumCols)
                            .addComponent(jTextFieldNumRows)
                            .addComponent(jTextFieldSpeed))
                        .addGap(52, 52, 52))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNumCols, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNumRows, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonClassic)
                    .addComponent(jRadioButtonNoWalls))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNumColsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNumColsActionPerformed
        ConfigSingleton.getInstance().setNumCols(Integer.parseInt(jTextFieldNumCols.getText()));
    }//GEN-LAST:event_jTextFieldNumColsActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (radioButtonSelected) {
            ConfigSingleton.getInstance().setDeltaTime(Integer.parseInt(jTextFieldSpeed.getText()));
            ConfigSingleton.getInstance().setDeltaTimeInit(Integer.parseInt(jTextFieldSpeed.getText()));

            ConfigSingleton.getInstance().setNumCols(Integer.parseInt(jTextFieldNumCols.getText()));
            ConfigSingleton.getInstance().setNumRows(Integer.parseInt(jTextFieldNumRows.getText()));
            dispose();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldSpeedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSpeedActionPerformed

    }//GEN-LAST:event_jTextFieldSpeedActionPerformed

    private void jTextFieldNumRowsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNumRowsActionPerformed

    }//GEN-LAST:event_jTextFieldNumRowsActionPerformed

    private void jRadioButtonClassicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonClassicActionPerformed
        radioButtonSelected = true;
        ConfigSingleton.getInstance().setNoWalls(false);
    }//GEN-LAST:event_jRadioButtonClassicActionPerformed

    private void jRadioButtonNoWallsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonNoWallsActionPerformed
        radioButtonSelected = true;
        ConfigSingleton.getInstance().setNoWalls(true);
    }//GEN-LAST:event_jRadioButtonNoWallsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRadioButtonClassic;
    private javax.swing.JRadioButton jRadioButtonNoWalls;
    private javax.swing.JTextField jTextFieldNumCols;
    private javax.swing.JTextField jTextFieldNumRows;
    private javax.swing.JTextField jTextFieldSpeed;
    // End of variables declaration//GEN-END:variables
}

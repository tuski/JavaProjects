/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alo.art.academy;

import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author tuski-Revolve
 */
public class calculation extends javax.swing.JFrame {
  PreparedStatement pst = null;
    ResultSet rset = null;
    String currentdate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
     int total=0;
   //String d= inpdatechosser.getDate().toString();
    //String inp_date= ((JTextField) inpdatechosser.getDateEditor().getUiComponent()).getText();
    
    /**
     * Creates new form calculation
     */
    public calculation() {
        initComponents();
        
        
    }
    
      public Connection getConnection() {

        String driver = "org.apache.derby.jdbc.EmbeddedDriver";

        try {
            Class.forName(driver).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

      Connection conn=null;
        try {
            conn = DriverManager.getConnection("jdbc:derby:AloArtDB");
            System.out.println("Opened default database successfully");

            // call me
        } catch (Exception ex) {
            } 
        return conn;   
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inpdatechosser = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        showcal = new javax.swing.JTable();
        chk_income = new javax.swing.JButton();
        expdatechosser = new com.toedter.calendar.JDateChooser();
        chkexpense = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        expense_table = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        incometxt = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        expntxt = new javax.swing.JLabel();
        del_income_record = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setTitle("Debit-Credit");

        inpdatechosser.setDateFormatString("yyyy-MM-dd");

        showcal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        showcal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(showcal);

        chk_income.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        chk_income.setText("Check Income");
        chk_income.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_incomeActionPerformed(evt);
            }
        });

        expdatechosser.setDateFormatString("yyyy-MM-dd");

        chkexpense.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        chkexpense.setText("Check Expense");
        chkexpense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkexpenseActionPerformed(evt);
            }
        });

        expense_table.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        expense_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(expense_table);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alo/art/academy/Print.png"))); // NOI18N
        jButton2.setText("Print Income Table");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alo/art/academy/Print.png"))); // NOI18N
        jButton3.setText("Print Expense Table");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText("Total:");

        incometxt.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        incometxt.setText("0");

        jLabel2.setText("Total:");

        expntxt.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        expntxt.setText("0");

        del_income_record.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        del_income_record.setText("Delete Income Record");
        del_income_record.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                del_income_recordActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton4.setText("Delete Expense Record");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(incometxt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 581, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(expntxt)
                        .addGap(161, 161, 161)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2)
                        .addGap(60, 60, 60)
                        .addComponent(del_income_record))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(inpdatechosser, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(chk_income)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(expdatechosser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addComponent(chkexpense))
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chk_income, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chkexpense, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(expdatechosser, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(inpdatechosser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(del_income_record)
                            .addComponent(jButton3)
                            .addComponent(jButton4))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(incometxt))
                        .addGap(7, 7, 7))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(expntxt, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chk_incomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_incomeActionPerformed
        
    try {

            Connection conn = getConnection();

            PreparedStatement ps
                    = conn.prepareStatement("select id,name,amount,receipid,receivedby  from income where idate=?");
      ps.setString(1,((JTextField) inpdatechosser.getDateEditor().getUiComponent()).getText());
            rset = ps.executeQuery();
            showcal.setModel(DbUtils.resultSetToTableModel(rset));
             
            
          DefaultTableModel model =   (DefaultTableModel) showcal.getModel();
            int total = 0;
           // TableModel model
            
    for (int i = 0; i < showcal.getRowCount(); i++){
        int amount = Integer.parseInt( showcal.getValueAt(i, 2).toString());
        total =total+ amount;
    }
    Object[] row={"","Total:",total};
    model.addRow(row);
   
incometxt.setText(""+total);
    
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }//GEN-LAST:event_chk_incomeActionPerformed

   
    
    
    private void chkexpenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkexpenseActionPerformed
 try {

            Connection conn = getConnection();

            PreparedStatement ps
                    = conn.prepareStatement("select id,name,amount,receipid from expense where edate=?");
      ps.setString(1,((JTextField) expdatechosser.getDateEditor().getUiComponent()).getText());
            rset = ps.executeQuery();
            expense_table.setModel(DbUtils.resultSetToTableModel(rset));
        
            DefaultTableModel model =   (DefaultTableModel) expense_table.getModel();
             total=0;
    for (int i = 0; i < expense_table.getRowCount(); i++){
        int amount = Integer.parseInt( expense_table.getValueAt(i, 2).toString());
        total =total+ amount;
    }
     Object[] row={"","Total:",total};
    model.addRow(row);
   
expntxt.setText(""+total);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }//GEN-LAST:event_chkexpenseActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

      //  String head= "Income Table Amount: "+total+" Date: "+((JTextField) expdatechosser.getDateEditor().getUiComponent()).getText();
       // System.out.println(head);
        MessageFormat header = new MessageFormat("Income Table");
                MessageFormat footer = new MessageFormat("");
        
        
        try
        {
        showcal.print(JTable.PrintMode.NORMAL, header, footer);
       // incometxt.print(getGraphics());
        }
        catch(PrinterException e)
           {
               JOptionPane.showMessageDialog(null, e.getMessage());
                }
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        MessageFormat header = new MessageFormat("Expense Table");
                MessageFormat footer = new MessageFormat("");
        
        
        try
        {
        expense_table.print(JTable.PrintMode.NORMAL, header, footer);
        }
        catch(PrinterException e)
           {
               JOptionPane.showMessageDialog(null, e.getMessage());
                }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void del_income_recordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_del_income_recordActionPerformed
            int row= showcal.getSelectedRow();
            DefaultTableModel model =   (DefaultTableModel) showcal.getModel();

            String id= model.getValueAt(row, 0).toString();
            String name= model.getValueAt(row, 1).toString();
            String amnt= model.getValueAt(row, 2).toString();
            
       if(row>=0)
            {
            model.removeRow(row);
            try {

            Connection conn = getConnection();

             PreparedStatement ps1
                    = conn.prepareStatement("delete from  income where id=? and name=? and amount=?");
      ps1.setString(1,id);
         ps1.setString(2,name);
            ps1.setString(3,amnt);
           ps1.executeUpdate();
            
            
            PreparedStatement ps
                    = conn.prepareStatement("select id,name,amount,receipid,receivedby  from income where idate=?");
      ps.setString(1,((JTextField) inpdatechosser.getDateEditor().getUiComponent()).getText());
            rset = ps.executeQuery();
            showcal.setModel(DbUtils.resultSetToTableModel(rset));
        
            DefaultTableModel model2 =   (DefaultTableModel) showcal.getModel();
             total=0;
    for (int i = 0; i < showcal.getRowCount(); i++){
        int amount = Integer.parseInt( showcal.getValueAt(i, 2).toString());
        total =total+ amount;
    }
     Object[] rowval={"","Total:",total};
    model2.addRow(rowval);
   
incometxt.setText(""+total);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

            
            }
            
        // TODO add your handling code here:
    }//GEN-LAST:event_del_income_recordActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        int row= expense_table.getSelectedRow();
            DefaultTableModel model =   (DefaultTableModel) expense_table.getModel();

            String id= model.getValueAt(row, 0).toString();
            String name= model.getValueAt(row, 1).toString();
            String amnt= model.getValueAt(row, 2).toString();
            
       if(row>=0)
            {
            model.removeRow(row);
            try {

            Connection conn = getConnection();

             PreparedStatement ps1
                    = conn.prepareStatement("delete from  expense where id=? and name=? and amount=?");
      ps1.setString(1,id);
         ps1.setString(2,name);
            ps1.setString(3,amnt);
           ps1.executeUpdate();
            
            
            PreparedStatement ps
                    = conn.prepareStatement("select id,name,amount,receipid from expense where edate=?");
      ps.setString(1,((JTextField) expdatechosser.getDateEditor().getUiComponent()).getText());
            rset = ps.executeQuery();
            expense_table.setModel(DbUtils.resultSetToTableModel(rset));
        
            DefaultTableModel model2 =   (DefaultTableModel) expense_table.getModel();
             total=0;
    for (int i = 0; i < expense_table.getRowCount(); i++){
        int amount = Integer.parseInt( expense_table.getValueAt(i, 2).toString());
        total =total+ amount;
    }
     Object[] rowval={"","Total:",total};
    model2.addRow(rowval);
   
expntxt.setText(""+total);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

            
            }

    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(calculation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(calculation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(calculation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(calculation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new calculation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chk_income;
    private javax.swing.JButton chkexpense;
    private javax.swing.JButton del_income_record;
    private com.toedter.calendar.JDateChooser expdatechosser;
    private javax.swing.JTable expense_table;
    private javax.swing.JLabel expntxt;
    private javax.swing.JLabel incometxt;
    private com.toedter.calendar.JDateChooser inpdatechosser;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable showcal;
    // End of variables declaration//GEN-END:variables
}

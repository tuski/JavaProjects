/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alo.art.academy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author tuski-Revolve
 */
public class login extends javax.swing.JFrame {
 PreparedStatement pst = null;
    ResultSet rs = null;
    String pass=null;
    /**
     * Creates new form login
     */
    public login() {
        initComponents();
         getConnection();
         get_pass();
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
            try {
                conn = DriverManager.getConnection("jdbc:derby:AloArtDB;create=true");
                System.out.println("Opened new database successfully");
Statement stmt=conn.createStatement();  
stmt.execute("CREATE TABLE SUBLIST(SUBJECT VARCHAR(20))");
stmt.execute("CREATE TABLE batchlist(batch VARCHAR(20))");
stmt.execute("CREATE TABLE t2017(roll int not null primary key,name varchar(30),schoolname varchar(30),class varchar(20),contact int)");
stmt.execute("CREATE TABLE bank2017(roll int,january int default 0,february int default 0,march int default 0,april int default 0,may int default 0,june int default 0,july int default 0,august int default 0,september int default 0,october int default 0,november int default 0,december int default 0,programfee int default 0)");
stmt.execute("CREATE TABLE bank2018(roll int,january int default 0,february int default 0,march int default 0,april int default 0,may int default 0,june int default 0,july int default 0,august int default 0,september int default 0,october int default 0,november int default 0,december int default 0,programfee int default 0)");
stmt.execute("CREATE TABLE bank2019(roll int,january int default 0,february int default 0,march int default 0,april int default 0,may int default 0,june int default 0,july int default 0,august int default 0,september int default 0,october int default 0,november int default 0,december int default 0,programfee int default 0)");
stmt.execute("CREATE TABLE bank2020(roll int,january int default 0,february int default 0,march int default 0,april int default 0,may int default 0,june int default 0,july int default 0,august int default 0,september int default 0,october int default 0,november int default 0,december int default 0,programfee int default 0)");
stmt.execute("CREATE TABLE bank2021(roll int,january int default 0,february int default 0,march int default 0,april int default 0,may int default 0,june int default 0,july int default 0,august int default 0,september int default 0,october int default 0,november int default 0,december int default 0,programfee int default 0)");
stmt.execute("CREATE TABLE bank2022(roll int,january int default 0,february int default 0,march int default 0,april int default 0,may int default 0,june int default 0,july int default 0,august int default 0,september int default 0,october int default 0,november int default 0,december int default 0,programfee int default 0)");
stmt.execute("CREATE TABLE bank2023(roll int,january int default 0,february int default 0,march int default 0,april int default 0,may int default 0,june int default 0,july int default 0,august int default 0,september int default 0,october int default 0,november int default 0,december int default 0,programfee int default 0)");

stmt.execute("CREATE TABLE tutor(id int not null primary key,name varchar(30),institute varchar(30),subject varchar(20),contact int,advance int default 0,firstpay int default 0,secondpay int default 0)");
stmt.execute("CREATE TABLE ACADEMICTEACHER(roll int not null primary key,name varchar(30),institute varchar(30),subject varchar(20),contact int)");
stmt.execute("CREATE TABLE subgroup(roll int,subject varchar(20),batch varchar(20))");
stmt.execute("CREATE TABLE income(id int,name varchar(20),amount int,idate varchar(30))");
stmt.execute("CREATE TABLE expense(id int,name varchar(20),amount int,edate varchar(30))");
stmt.execute("CREATE TABLE passwordtable(serial int,password  varchar(30))");
stmt.execute("CREATE TABLE tchrpassword(serial int,password  varchar(30))");
stmt.execute("Insert into sublist(subject) values ''");
stmt.execute("Insert into sublist(subject) values 'All'");
stmt.execute("Insert into batchlist(batch) values ''");
stmt.execute("Insert into batchlist(batch) values 'All'");
stmt.execute("Insert into passwordtable(serial,password) values (1,'habib')");
stmt.execute("Insert into tchrpassword(serial,password) values (1,'anu')");
//ResultSet rs=stmt.executeQuery();  
//ResultSet rs2=stmt.executeQuery("CREATE TABLE BATCHLIST(BATCH VARCHAR(20))");  
System.out.println("Opened create successfully");

  
 /*             PreparedStatement prpd = conn.prepareStatement("CREATE TABLE SUBLIST(SUBJECT VARCHAR(20)");
            ResultSet rs = prpd.executeQuery();
  PreparedStatement prpd2 = conn.prepareStatement("CREATE TABLE BATCHLIST(BATCH VARCHAR(20)");
            ResultSet rs2 = prpd2.executeQuery(); */
            
            } catch (SQLException exx) {}
        }
        return conn;   
    }
    
 private void get_pass()
    {
      try {
            Connection conn = getConnection();
          
            PreparedStatement ps = conn.prepareStatement("select * FROM tchrpassword where serial=1");
            rs = ps.executeQuery();
             if (rs.next()) {
                 pass = rs.getString("password");
               }
            
//           System.out.println(dateobj);
           
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    
    }
    
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login_pass = new javax.swing.JPasswordField();
        login_prvspass = new javax.swing.JTextField();
        login_newpass = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        hint = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Please");

        login_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_passActionPerformed(evt);
            }
        });

        login_prvspass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_prvspassActionPerformed(evt);
            }
        });

        login_newpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_newpassActionPerformed(evt);
            }
        });

        jButton1.setText("Change Password");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Previous Password:");

        jLabel2.setText("New Password:");

        hint.setText("Enter Password:");

        jLabel3.setFont(new java.awt.Font("Tekton Pro Ext", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 153));
        jLabel3.setText("Alo Art Academy");

        jLabel4.setText("Developed By:");

        jLabel5.setText("Mohaimanul Islam Tusar");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel6.setText("tuski.ruet@gmail.com");

        jLabel7.setText("01521474592");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel5)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(hint)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(login_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(login_newpass, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(login_prvspass, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(126, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(112, 112, 112))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(login_prvspass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(login_newpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hint)
                            .addComponent(login_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(48, 48, 48))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void login_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_passActionPerformed
String chkpass = login_pass.getText().toString();
       // System.out.println(pass);
if(pass.equals(chkpass))
{
  java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new workstation().setVisible(true);
             dispose();   
            }
        });
}
else if(chkpass.equals("HASINA"))
{
      JOptionPane.showMessageDialog(null,"Password is "+pass);
  
}
else if(chkpass.equals("tuski"))
{
      java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminPanel().setVisible(true);
          
            }
        });
  
}

else
{
JOptionPane.showMessageDialog(null," Wrong Password! Try Again");

}

    }//GEN-LAST:event_login_passActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if(pass.equals(login_prvspass.getText().toString()))
        {try {
            Connection conn = getConnection();
          
            PreparedStatement ps = conn.prepareStatement("update  tchrpassword set password=? where serial=1");
            ps.setString(1, login_newpass.getText());

           ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Password Changed! ");
           System.out.println(login_newpass);
           
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        }
        else
        {
        JOptionPane.showMessageDialog(null," Wrong Password! Try Again");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void login_prvspassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_prvspassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_login_prvspassActionPerformed

    private void login_newpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_newpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_login_newpassActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        
    }//GEN-LAST:event_jLabel5MouseClicked

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
 java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new workstation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel hint;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField login_newpass;
    private javax.swing.JPasswordField login_pass;
    private javax.swing.JTextField login_prvspass;
    // End of variables declaration//GEN-END:variables
}

        


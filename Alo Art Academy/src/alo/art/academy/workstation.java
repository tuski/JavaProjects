package alo.art.academy;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import exception.recevedByException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.text.DateFormatSymbols;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Vector;
import java.util.Date;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class workstation extends javax.swing.JFrame {

    //  Connection conn=null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Vector originalTableModel;
    String printData = null;
    String pass = null;
    String currentdate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
//      Calendar cal = Calendar.getInstance();
//        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
//        String curTime=sdf.format(cal.getTime());

//System.out.println(df.format(dateobj));
    public workstation() {
        initComponents();
        getConnection();
        fillsubjcombo();
       fillbatchcombo();
        get_pass();
        getMONthYear();

    }

    public Connection getConnection() {

        String driver = "org.apache.derby.jdbc.EmbeddedDriver";

        try {
            Class.forName(driver).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //  String dbURL2 = "jdbc:derby:DBALOART;";
        // String user = "Aloart";
        //String password = "habib2017";
        //Connection conn = DriverManager.getConnection(dbURL2, user, password);
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:derby:AloArtDB");
            System.out.println("Opened default database successfully");

            // call me
        } catch (Exception ex) {
            try {
                conn = DriverManager.getConnection("jdbc:derby:AloArtDB;create=true");
                System.out.println("Opened new database successfully");
                Statement stmt = conn.createStatement();
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
                stmt.execute("CREATE TABLE income(TransactionID int auto_increment,id int,name varchar(20),amount int,idate varchar(30))");
                stmt.execute("CREATE TABLE expense(TransactionID int auto_increment,id int,name varchar(20),amount int,edate varchar(30))");
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
            } catch (SQLException exx) {
            }
        }
        return conn;
    }

    private void get_pass() {
        try {
            Connection conn = getConnection();

            PreparedStatement ps = conn.prepareStatement("select * FROM passwordtable where serial=1");
            rs = ps.executeQuery();
            if (rs.next()) {
                pass = rs.getString("password");
            }

//           System.out.println(dateobj);
            conn.close();
                rs.close();
                ps.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }
    
    
    private void getMONthYear(){
      Calendar cal = Calendar.getInstance();
       

         String[] monthName = { "January", "February", "March", "April", "May", "June", "July",
        "August", "September", "October", "November", "December" };
        String crntmonth = monthName[cal.get(Calendar.MONTH)];
        String chkComboMonth= bank_monthcombo.getSelectedItem().toString();
        
        String chkYear = new SimpleDateFormat("yyyy").format(new Date());
       // String ComboYear=yrcombo.getSelectedItem().toString();
                
        
        if(crntmonth.equals("January")){
            bank_monthcombo.setSelectedItem("January");
            tutor_month.setSelectedItem("January");
            duecombo.setSelectedItem("January");
        }
         else if(crntmonth.equals("February")){
            bank_monthcombo.setSelectedItem("February");
             tutor_month.setSelectedItem("February");
              duecombo.setSelectedItem("February");
        }
          else if(crntmonth.equals("March")){
            bank_monthcombo.setSelectedItem("March");
             tutor_month.setSelectedItem("March");
             duecombo.setSelectedItem("March");
        }
           else if(crntmonth.equals("April")){
            bank_monthcombo.setSelectedItem("April");
                        tutor_month.setSelectedItem("April");
                        duecombo.setSelectedItem("April");
        }
            else if(crntmonth.equals("May")){
            bank_monthcombo.setSelectedItem("May");
            tutor_month.setSelectedItem("May");
            duecombo.setSelectedItem("May");
        }
             else if(crntmonth.equals("June")){
            bank_monthcombo.setSelectedItem("June");
            tutor_month.setSelectedItem("June");
             duecombo.setSelectedItem("June");
        }
              else if(crntmonth.equals("July")){
            bank_monthcombo.setSelectedItem("July");
             tutor_month.setSelectedItem("July");
               duecombo.setSelectedItem("July");
        }
               else if(crntmonth.equals("August")){
            bank_monthcombo.setSelectedItem("August");
             tutor_month.setSelectedItem("August");
              duecombo.setSelectedItem("August");
        }
                else if(crntmonth.equals("September")){
            bank_monthcombo.setSelectedItem("September");
              tutor_month.setSelectedItem("September");
              duecombo.setSelectedItem("September");
        }
                 else if(crntmonth.equals("October")){
            bank_monthcombo.setSelectedItem("October");
            tutor_month.setSelectedItem("October");
            duecombo.setSelectedItem("October");
        }
                  else if(crntmonth.equals("November")){
            bank_monthcombo.setSelectedItem("November");
             tutor_month.setSelectedItem("November");
             duecombo.setSelectedItem("November");
        }
        else if(crntmonth.equals("December")){
            bank_monthcombo.setSelectedItem("December");
             tutor_month.setSelectedItem("December");
              duecombo.setSelectedItem("December");
        }
        
        if(chkYear.equals("2017")){
            yrcombo.setSelectedItem("2017");
        }
       else if(chkYear.equals("2018")){
            yrcombo.setSelectedItem("2018");
        }

       else if(chkYear.equals("2019")){
            yrcombo.setSelectedItem("2019");
        }
         else if(chkYear.equals("2020")){
            yrcombo.setSelectedItem("2020");
        }

       else if(chkYear.equals("2021")){
            yrcombo.setSelectedItem("2021");
        }
         else if(chkYear.equals("2022")){
            yrcombo.setSelectedItem("2022");
        }

       else if(chkYear.equals("2023")){
            yrcombo.setSelectedItem("2023");
        }
        
        
        
    }

    private void fillsubjcombo() {

        try {
//why habib db is searching?
//table er name er age db name habibdb
            combosubj.removeAllItems();
            batchsubcombo.removeAllItems();
            rmvsubj.removeAllItems();
            settings_subject_combo.removeAllItems();
            Connection conn = getConnection();
            PreparedStatement prpd = conn.prepareStatement("SELECT SUBJECT FROM SUBLIST");
            ResultSet rs = prpd.executeQuery();

            while (rs.next()) {
                String pat = rs.getString("SUBJECT");
                combosubj.addItem(pat);
                batchsubcombo.addItem(pat);
                rmvsubj.addItem(pat);
                settings_subject_combo.addItem(pat);
            }

            conn.close();
            rs.close();
            prpd.close();

        } catch (Exception e) {
            e.printStackTrace();
            //JOptionPane.showMessageDialog(null, e);
        }

    }

    private void fillbatchcombo() {

      //  String subj=settings_subject_combo.getSelectedItem().toString();
        try {
            // Connection conn = getConnection();
            //just wait.. this is very very bad programming.. let me do something
            btchcombo.removeAllItems();
            batchbatchcombo.removeAllItems();
            rmvbatchcmbo.removeAllItems();
            Connection conn = getConnection();
            PreparedStatement prpd = conn.prepareStatement("SELECT BATCH FROM BATCHLIST ");
//             prpd.setString(1,subj);
            ResultSet rs = prpd.executeQuery();

            while (rs.next()) {
                String pat = rs.getString("BATCH");
                btchcombo.addItem(pat);
                batchbatchcombo.addItem(pat);
                rmvbatchcmbo.addItem(pat);
            }
            conn.close();
            rs.close();
            prpd.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public boolean chkinfo() {
        if (txt_sRoll == null || txt_sName == null) {
            return false;
        } else {
            try {
                Integer.parseInt(txt_sRoll.getText());
                return true;
            } catch (Exception e) {
                return false;
            }
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

        jComboBox1 = new javax.swing.JComboBox<>();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jButton2 = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_sName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_schlname = new javax.swing.JTextField();
        txt_class = new javax.swing.JTextField();
        txt_smbl = new javax.swing.JTextField();
        btn_insertsdata = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        sinfotxtarea = new javax.swing.JTextArea();
        txt_sRoll = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        combosubj = new javax.swing.JComboBox<>();
        btchcombo = new javax.swing.JComboBox<>();
        addgrpbtch = new javax.swing.JButton();
        infocombo = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        stdntinfotable = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        sinfototal = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        bank_money = new javax.swing.JTextField();
        bank_save = new javax.swing.JButton();
        bank_print = new javax.swing.JButton();
        bank_roll = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        bank_monthcombo = new javax.swing.JComboBox<>();
        yrcombo = new javax.swing.JComboBox<>();
        banksttchrcombo = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        bank_table = new javax.swing.JTable();
        duecombo = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        yrcombo2 = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        bank_output = new javax.swing.JTextArea();
        jButton9 = new javax.swing.JButton();
        due_print = new javax.swing.JButton();
        recevdBY_txt = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        batchsubcombo = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        SUBGROUPTABLE = new javax.swing.JTable();
        batchbatchcombo = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        searchbtchgrp = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        rowcount = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        ac_tchr = new javax.swing.JButton();
        tutor_info = new javax.swing.JButton();
        tchrrollbox = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        tchr_info = new javax.swing.JTable();
        jLabel42 = new javax.swing.JLabel();
        tchr_rowcount = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        del_tchr_info = new javax.swing.JButton();
        del_tutor_info = new javax.swing.JButton();
        tutor_month = new javax.swing.JComboBox<>();
        tutor_id = new javax.swing.JTextField();
        tutor_description = new javax.swing.JTextField();
        tutor_save_info = new javax.swing.JButton();
        tutor_show_info = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        addsubbox = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        addbatch = new javax.swing.JTextField();
        addbatchbt = new javax.swing.JButton();
        subaddbtn = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        rmvsubject = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        rmvbatch = new javax.swing.JTextField();
        rmvbatchbtn = new javax.swing.JButton();
        settings_subject_combo = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        rolltoupdate = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        up_name = new javax.swing.JTextField();
        up_schl = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        up_class = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        up_mblno = new javax.swing.JTextField();
        updb = new javax.swing.JButton();
        delrecord = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        rmvsubj = new javax.swing.JComboBox<>();
        rmvbatchcmbo = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        grpbtchtable = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        prvspass = new javax.swing.JTextField();
        chng_pass = new javax.swing.JButton();
        passinbox2 = new javax.swing.JPasswordField();
        newpass = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        income_name_txt = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        income_ammou_txt = new javax.swing.JTextField();
        save_income = new javax.swing.JButton();
        income_calender = new com.toedter.calendar.JDateChooser();
        jLabel39 = new javax.swing.JLabel();
        expense_name_txt1 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        expense_ammou_txt1 = new javax.swing.JTextField();
        exp_cal = new com.toedter.calendar.JDateChooser();
        save_expense = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Alo Art Academy");
        setBackground(new java.awt.Color(102, 102, 255));
        setForeground(java.awt.Color.darkGray);

        jTabbedPane2.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane2.setToolTipText("");

        jLabel1.setText("Student/ Teacher Name:");

        jLabel2.setText("Schoo/ Institutel Name:");

        jLabel3.setText("Class/ Subject:");

        jLabel4.setText("Mobile No:");

        txt_schlname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_schlnameActionPerformed(evt);
            }
        });

        btn_insertsdata.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btn_insertsdata.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alo/art/academy/add.png"))); // NOI18N
        btn_insertsdata.setText("    Add");
        btn_insertsdata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertsdataActionPerformed(evt);
            }
        });

        sinfotxtarea.setEditable(false);
        sinfotxtarea.setColumns(20);
        sinfotxtarea.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 15)); // NOI18N
        sinfotxtarea.setRows(5);
        sinfotxtarea.setText("Welcome to Alo Art Academy");
        jScrollPane1.setViewportView(sinfotxtarea);

        txt_sRoll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sRollActionPerformed(evt);
            }
        });

        jLabel6.setText("Roll/ ID:");

        jLabel16.setText("Subject Name:");

        jLabel17.setText("Batch Name:");

        combosubj.setMaximumRowCount(20);
        combosubj.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combosubj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combosubjActionPerformed(evt);
            }
        });

        btchcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        addgrpbtch.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        addgrpbtch.setText("Add");
        addgrpbtch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addgrpbtchActionPerformed(evt);
            }
        });

        infocombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Student", "Academic Teacher", "Tutor" }));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alo/art/academy/clear.png"))); // NOI18N
        jButton6.setText("Clear All");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        stdntinfotable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Roll", "Name", "School Name", "Contact"
            }
        ));
        jScrollPane7.setViewportView(stdntinfotable);

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alo/art/academy/info.png"))); // NOI18N
        jButton7.setText("Show Student Info");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel44.setText("Total:");

        sinfototal.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        sinfototal.setText("0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btn_insertsdata)
                        .addGap(54, 54, 54)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jButton7)
                                .addGap(123, 123, 123))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel44)
                                .addGap(33, 33, 33)
                                .addComponent(sinfototal)
                                .addGap(109, 109, 109))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1))
                                        .addGap(77, 77, 77))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txt_class, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_schlname, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_sName))
                                        .addGap(67, 67, 67)))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17)
                                    .addComponent(combosubj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btchcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addgrpbtch)))
                            .addComponent(infocombo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_sRoll, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_smbl, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addComponent(jScrollPane7)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_sRoll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_sName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_schlname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_class, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combosubj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btchcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(addgrpbtch)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_smbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(infocombo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btn_insertsdata)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jButton7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel44)
                                    .addComponent(sinfototal)))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Student Info", jPanel5);

        jLabel13.setText("Enter Roll No:");

        bank_save.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        bank_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alo/art/academy/save.png"))); // NOI18N
        bank_save.setText("Save");
        bank_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bank_saveActionPerformed(evt);
            }
        });

        bank_print.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        bank_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alo/art/academy/Print.png"))); // NOI18N
        bank_print.setText("  Print");
        bank_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bank_printActionPerformed(evt);
            }
        });

        bank_roll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bank_rollActionPerformed(evt);
            }
        });

        jLabel14.setText("Amount of Money:");

        bank_monthcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December", "Program Fee" }));
        bank_monthcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bank_monthcomboActionPerformed(evt);
            }
        });

        yrcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2017", "2018", "2019", "2020", "2021", "2022", "2023" }));
        yrcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yrcomboActionPerformed(evt);
            }
        });

        banksttchrcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Student", "Academic Teacher", "Tutor Advance Pay", "Tutor First Pay", "Tutor Second Pay" }));
        banksttchrcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                banksttchrcomboActionPerformed(evt);
            }
        });

        bank_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Roll", "Name", "School Name", "Contact"
            }
        ));
        jScrollPane5.setViewportView(bank_table);

        duecombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December", "Program Fee" }));
        duecombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duecomboActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alo/art/academy/due.png"))); // NOI18N
        jButton1.setText(" Due");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        yrcombo2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2017", "2018", "2019", "2020", "2021", "2022", "2023" }));

        bank_output.setEditable(false);
        bank_output.setColumns(20);
        bank_output.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        bank_output.setRows(5);
        jScrollPane2.setViewportView(bank_output);

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alo/art/academy/todayincome.png"))); // NOI18N
        jButton9.setText("Today's Income");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        due_print.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        due_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alo/art/academy/Print.png"))); // NOI18N
        due_print.setText("Print");
        due_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                due_printActionPerformed(evt);
            }
        });

        jLabel22.setText("Received By:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(bank_money, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bank_roll, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(banksttchrcombo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bank_monthcombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bank_save, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(bank_print, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(jButton9))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(yrcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(recevdBY_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(duecombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(yrcombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(due_print, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(62, 62, 62))
            .addComponent(jScrollPane5)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(duecombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yrcombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(due_print, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bank_roll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addGap(8, 8, 8)
                        .addComponent(bank_money, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(banksttchrcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel22)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(bank_monthcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(yrcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(recevdBY_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(bank_save, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bank_print))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );

        jTabbedPane2.addTab("Fees Info", jPanel7);

        jLabel15.setText("Subject  Name:");

        batchsubcombo.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        batchsubcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        batchsubcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batchsubcomboActionPerformed(evt);
            }
        });

        SUBGROUPTABLE.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        SUBGROUPTABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Roll", "Batch Name", "Subject Name"
            }
        ));
        jScrollPane3.setViewportView(SUBGROUPTABLE);

        batchbatchcombo.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        batchbatchcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        batchbatchcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batchbatchcomboActionPerformed(evt);
            }
        });

        jLabel20.setText("Batch Name:");

        searchbtchgrp.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        searchbtchgrp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alo/art/academy/search.png"))); // NOI18N
        searchbtchgrp.setText("Search");
        searchbtchgrp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtchgrpActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel41.setText("Total:");

        rowcount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rowcount.setText("0");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(batchsubcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(batchbatchcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(searchbtchgrp)))
                .addContainerGap(728, Short.MAX_VALUE))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1061, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rowcount)
                .addGap(181, 181, 181))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(batchsubcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(batchbatchcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchbtchgrp))
                .addGap(21, 21, 21)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(rowcount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Batch Info", jPanel8);

        ac_tchr.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        ac_tchr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alo/art/academy/info.png"))); // NOI18N
        ac_tchr.setText("Academic Teacher Info");
        ac_tchr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ac_tchrActionPerformed(evt);
            }
        });

        tutor_info.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        tutor_info.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alo/art/academy/info.png"))); // NOI18N
        tutor_info.setText("Tutor Info");
        tutor_info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tutor_infoActionPerformed(evt);
            }
        });

        tchrrollbox.setToolTipText("Search");
        tchrrollbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tchrrollboxActionPerformed(evt);
            }
        });

        tchr_info.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Institute", "Contact", "Subject"
            }
        ));
        jScrollPane6.setViewportView(tchr_info);

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel42.setText("Total:");

        tchr_rowcount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tchr_rowcount.setText("0");

        jLabel43.setForeground(new java.awt.Color(255, 0, 51));
        jLabel43.setText("Search ID:");

        del_tchr_info.setText("Delete Teacher Info");
        del_tchr_info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                del_tchr_infoActionPerformed(evt);
            }
        });

        del_tutor_info.setText("Delete Tutor Info");
        del_tutor_info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                del_tutor_infoActionPerformed(evt);
            }
        });

        tutor_month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));

        tutor_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tutor_idActionPerformed(evt);
            }
        });

        tutor_description.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tutor_descriptionActionPerformed(evt);
            }
        });

        tutor_save_info.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        tutor_save_info.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alo/art/academy/save.png"))); // NOI18N
        tutor_save_info.setText("Save Tutor Info");
        tutor_save_info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tutor_save_infoActionPerformed(evt);
            }
        });

        tutor_show_info.setText("Show Tutor List");
        tutor_show_info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tutor_show_infoActionPerformed(evt);
            }
        });

        jLabel23.setText("ID:");

        jLabel24.setText("Description:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1061, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ac_tchr)
                    .addComponent(del_tchr_info))
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tutor_info)
                    .addComponent(del_tutor_info))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tutor_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tutor_id, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel42))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tchr_rowcount)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel24)
                                            .addComponent(tutor_description, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addComponent(tutor_show_info))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel43)
                            .addComponent(tchrrollbox, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(tutor_save_info)
                        .addGap(44, 44, 44))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ac_tchr)
                                    .addComponent(tutor_info)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel24))
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tutor_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tutor_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tutor_description, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tutor_save_info))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(del_tchr_info)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(del_tutor_info)
                                .addComponent(tutor_show_info))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel43)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tchrrollbox, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel42)
                        .addComponent(tchr_rowcount)))
                .addContainerGap(119, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Teacher Info", jPanel1);

        jLabel18.setText("Add a New Subject:");

        jLabel19.setText("Add a New Batch:");

        addbatchbt.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        addbatchbt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alo/art/academy/add (2).png"))); // NOI18N
        addbatchbt.setText("Add");
        addbatchbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbatchbtActionPerformed(evt);
            }
        });

        subaddbtn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        subaddbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alo/art/academy/add (2).png"))); // NOI18N
        subaddbtn.setText("Add");
        subaddbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subaddbtnActionPerformed(evt);
            }
        });

        jLabel29.setText("Remove a Subject:");

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alo/art/academy/delete.png"))); // NOI18N
        jButton5.setText("Remove");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel35.setText("Remove a Batch:");

        rmvbatchbtn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        rmvbatchbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alo/art/academy/delete.png"))); // NOI18N
        rmvbatchbtn.setText("Remove");
        rmvbatchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rmvbatchbtnActionPerformed(evt);
            }
        });

        settings_subject_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel18)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(subaddbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addsubbox)
                            .addComponent(rmvsubject))
                        .addGap(110, 110, 110)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rmvbatchbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel35)
                            .addComponent(rmvbatch)
                            .addComponent(settings_subject_combo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(53, 53, 53)
                        .addComponent(addbatch, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(addbatchbt)))
                .addContainerGap(341, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addsubbox, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addbatch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(settings_subject_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addbatchbt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(subaddbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jLabel35))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rmvsubject, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(rmvbatch))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(rmvbatchbtn))
                .addContainerGap(371, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Settings", jPanel2);

        jLabel7.setText("Enter Roll:");

        rolltoupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rolltoupdateActionPerformed(evt);
            }
        });

        jLabel9.setText("Name:");

        up_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                up_nameActionPerformed(evt);
            }
        });

        jLabel10.setText("School Name:");

        jLabel11.setText("Class:");

        jLabel12.setText("Mobile No:");

        updb.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        updb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alo/art/academy/update.png"))); // NOI18N
        updb.setText(" Update");
        updb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updbActionPerformed(evt);
            }
        });

        delrecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alo/art/academy/delete.png"))); // NOI18N
        delrecord.setText("  Delete");
        delrecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delrecordActionPerformed(evt);
            }
        });

        jButton3.setText("Remove Batch");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        rmvsubj.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        rmvsubj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rmvsubjActionPerformed(evt);
            }
        });

        rmvbatchcmbo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        grpbtchtable.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        grpbtchtable.setForeground(new java.awt.Color(51, 51, 255));
        grpbtchtable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(grpbtchtable);

        jButton4.setText("Add Batch");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel5.setText("Subject:");

        jLabel45.setText("Batch:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rolltoupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(292, 784, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(up_class)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel9))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(up_mblno))
                                .addGap(80, 80, 80))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(up_schl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                    .addComponent(up_name, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rmvsubj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel45)
                                    .addComponent(rmvbatchcmbo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(644, 644, 644))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(updb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(delrecord)
                        .addGap(81, 81, 81))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rolltoupdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(up_name, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(up_schl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel11))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rmvsubj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(up_class, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addGap(10, 10, 10)
                        .addComponent(rmvbatchcmbo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jButton4))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(up_mblno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(updb)
                            .addComponent(delrecord)))
                    .addComponent(jButton3))
                .addContainerGap(251, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Update", jPanel6);

        prvspass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prvspassActionPerformed(evt);
            }
        });

        chng_pass.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        chng_pass.setText("Change Password");
        chng_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chng_passActionPerformed(evt);
            }
        });

        passinbox2.setToolTipText("Enter Password");
        passinbox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passinbox2ActionPerformed(evt);
            }
        });

        jLabel21.setText("Previous Password:");

        jLabel36.setText("New Password:");

        jLabel37.setText("Enter Income Name:");

        income_name_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                income_name_txtActionPerformed(evt);
            }
        });

        jLabel38.setText("Amount:");

        save_income.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        save_income.setText("Save Income");
        save_income.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_incomeActionPerformed(evt);
            }
        });

        income_calender.setDateFormatString("yyyy-MM-dd");

        jLabel39.setText("Enter Expense  Name:");

        expense_name_txt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expense_name_txt1ActionPerformed(evt);
            }
        });

        jLabel40.setText("Amount:");

        exp_cal.setDateFormatString("yyyy-MM-dd");

        save_expense.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        save_expense.setText("Save Expense");
        save_expense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_expenseActionPerformed(evt);
            }
        });

        jLabel8.setText("Enter Password:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addComponent(income_calender, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38)
                    .addComponent(save_income)
                    .addComponent(income_ammou_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(income_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(189, 189, 189)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel40)
                    .addComponent(exp_cal, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39)
                    .addComponent(save_expense)
                    .addComponent(expense_ammou_txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(expense_name_txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 441, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passinbox2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(308, 308, 308)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chng_pass)
                    .addComponent(jLabel36)
                    .addComponent(prvspass, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newpass, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(268, 268, 268))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passinbox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prvspass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jLabel36)
                .addGap(22, 22, 22)
                .addComponent(newpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(chng_pass)
                .addGap(86, 86, 86)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(expense_name_txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(expense_ammou_txt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(exp_cal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(income_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(income_ammou_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(income_calender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(save_income)
                            .addComponent(save_expense))))
                .addContainerGap(163, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Debit-Credit", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_sRollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sRollActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sRollActionPerformed

    private void batchbatchcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batchbatchcomboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_batchbatchcomboActionPerformed

    private void txt_schlnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_schlnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_schlnameActionPerformed

    private void btn_insertsdataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insertsdataActionPerformed
        String item = infocombo.getSelectedItem().toString();
        String student = "Student";
        String academic_teacher = "Academic Teacher";
        String tutor = "Tutor";
        int roll = Integer.parseInt(txt_sRoll.getText());

        if (item.equals(student)) {
            if (chkinfo() != false) {
                try {
                    Connection conn = getConnection();

                    PreparedStatement ps = conn.prepareStatement("INSERT INTO T2017(ROLL,NAME,SCHOOLNAME,CLASS,CONTACT)" + "VALUES(?,?,?,?,?)");
                    ps.setInt(1, roll);
                    ps.setString(2, txt_sName.getText());
                    ps.setString(3, txt_schlname.getText());
                    ps.setString(4, txt_class.getText());
                    ps.setString(5, txt_smbl.getText());
                    ps.executeUpdate();
                    PreparedStatement ps2 = conn.prepareStatement("INSERT INTO BANK2017(ROLL)" + "VALUES(?)");
                    PreparedStatement ps3 = conn.prepareStatement("INSERT INTO BANK2018(ROLL)" + "VALUES(?)");
                    PreparedStatement ps4 = conn.prepareStatement("INSERT INTO BANK2019(ROLL)" + "VALUES(?)");
                    PreparedStatement ps5 = conn.prepareStatement("INSERT INTO BANK2020(ROLL)" + "VALUES(?)");
                    PreparedStatement ps6 = conn.prepareStatement("INSERT INTO BANK2021(ROLL)" + "VALUES(?)");
                    PreparedStatement ps7 = conn.prepareStatement("INSERT INTO BANK2022(ROLL)" + "VALUES(?)");
                    PreparedStatement ps8 = conn.prepareStatement("INSERT INTO BANK2023(ROLL)" + "VALUES(?)");

                    ps2.setInt(1, roll);
                    ps3.setInt(1, roll);
                    ps4.setInt(1, roll);
                    ps5.setInt(1, roll);
                    ps6.setInt(1, roll);
                    ps7.setInt(1, roll);
                    ps8.setInt(1, roll);

                    ps2.executeUpdate();
                    ps3.executeUpdate();
                    ps4.executeUpdate();
                    ps5.executeUpdate();
                    ps6.executeUpdate();
                    ps7.executeUpdate();
                    ps8.executeUpdate();

                    sinfotxtarea.setText("Successfull!\nRoll: " + txt_sRoll.getText() + "\nName: " + txt_sName.getText() + "\nSchool Name: " + txt_schlname.getText() + "\nClass: " + txt_class.getText() + "\nContact No.: " + txt_smbl.getText());
                    //txt_sRoll.setText("");txt_sName.setText("");
                    txt_schlname.setText("");
                    txt_class.setText("");
                    txt_smbl.setText("");
                    conn.close();
                    rs.close();
                    ps.close();
                    ps2.close();
                    ps3.close();
                    ps4.close();
                    ps5.close();
                    ps6.close();
                    ps7.close();
                    ps8.close();
                    //sinfotxtarea.append(tutor);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                System.out.println(txt_sRoll.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Please Enter Roll and Name");
            }
        }
        if (item.equals(academic_teacher)) {
            if (chkinfo() != false) {
                try {
                    Connection conn = getConnection();
//                int roll= Integer.parseInt(txt_sRoll.getText());
                    PreparedStatement ps = conn.prepareStatement("INSERT INTO ACADEMICTEACHER(ROLL,NAME,INSTITUTE,SUBJECT,CONTACT)" + "VALUES(?,?,?,?,?)");
                    PreparedStatement ps2 = conn.prepareStatement("INSERT INTO BANK2017(ROLL)" + "VALUES(?)");
                    ps.setInt(1, roll);
                    ps.setString(2, txt_sName.getText());
                    ps.setString(3, txt_schlname.getText());
                    ps.setString(4, txt_class.getText());
                    ps.setString(5, txt_smbl.getText());
                    ps2.setInt(1, roll);
                    ps.executeUpdate();
                    ps2.executeUpdate();
                    sinfotxtarea.setText("Successfull!\nID: " + txt_sRoll.getText() + "\nName: " + txt_sName.getText() + "\nInstitute Name: " + txt_schlname.getText() + "\nSubject: " + txt_class.getText() + "\nContact No.: " + txt_smbl.getText());
                    txt_sRoll.setText("");
                    txt_sName.setText("");
                    txt_schlname.setText("");
                    txt_class.setText("");
                    txt_smbl.setText("");
                    
                   
                    PreparedStatement ps3 = conn.prepareStatement("INSERT INTO BANK2018(ROLL)" + "VALUES(?)");
                    PreparedStatement ps4 = conn.prepareStatement("INSERT INTO BANK2019(ROLL)" + "VALUES(?)");
                    PreparedStatement ps5 = conn.prepareStatement("INSERT INTO BANK2020(ROLL)" + "VALUES(?)");
                    PreparedStatement ps6 = conn.prepareStatement("INSERT INTO BANK2021(ROLL)" + "VALUES(?)");
                    PreparedStatement ps7 = conn.prepareStatement("INSERT INTO BANK2022(ROLL)" + "VALUES(?)");
                    PreparedStatement ps8 = conn.prepareStatement("INSERT INTO BANK2023(ROLL)" + "VALUES(?)");

                    
                    ps3.setInt(1, roll);
                    ps4.setInt(1, roll);
                    ps5.setInt(1, roll);
                    ps6.setInt(1, roll);
                    ps7.setInt(1, roll);
                    ps8.setInt(1, roll);

                    
                    ps3.executeUpdate();
                    ps4.executeUpdate();
                    ps5.executeUpdate();
                    ps6.executeUpdate();
                    ps7.executeUpdate();
                    ps8.executeUpdate();

                    conn.close();
                    rs.close();
                    ps.close();
                    ps2.close();
                    ps3.close();
                    ps4.close();
                    ps5.close();
                    ps6.close();
                    ps7.close();
                    ps8.close();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                System.out.println(txt_sRoll.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Please Enter ID and Name");
            }
        }

        if (item.equals(tutor)) {
            if (chkinfo() != false) {
                try {
                    Connection conn = getConnection();
                    //   int roll= Integer.parseInt(txt_sRoll.getText());
                    PreparedStatement ps = conn.prepareStatement("INSERT INTO TUTOR(ID,NAME,INSTITUTE,SUBJECT,CONTACT)" + "VALUES(?,?,?,?,?)");
                    // PreparedStatement ps2 = conn.prepareStatement("INSERT INTO BANK2017(ROLL)"+ "VALUES(?)");
                    ps.setInt(1, roll);
                    ps.setString(2, txt_sName.getText());
                    ps.setString(3, txt_schlname.getText());
                    ps.setString(4, txt_class.getText());
                    ps.setString(5, txt_smbl.getText());
                    // ps2.setInt(1, roll);
                    ps.executeUpdate();
                    // ps2.executeUpdate();
                    sinfotxtarea.setText("Successfull!\nID: " + txt_sRoll.getText() + "\nName: " + txt_sName.getText() + "\nInstitute Name: " + txt_schlname.getText() + "\nSubject: " + txt_class.getText() + "\nContact No.: " + txt_smbl.getText());
                    txt_sRoll.setText("");
                    txt_sName.setText("");
                    txt_schlname.setText("");
                    txt_class.setText("");
                    txt_smbl.setText("");

                    conn.close();
                    ps.close();
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                System.out.println(txt_sRoll.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Please Enter ID and Name");
            }
        }


    }//GEN-LAST:event_btn_insertsdataActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void subaddbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subaddbtnActionPerformed
        String item = addsubbox.getText().toString();
        if (item.equals("All") || item.equals("")) {
            JOptionPane.showMessageDialog(null, "Wrong Subject Name");
        } else {
            try {

                Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement("INSERT INTO  SUBLIST(SUBJECT)" + "VALUES(?)");
                ps.setString(1, addsubbox.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, addsubbox.getText() + " Subject Added!");
                addsubbox.setText("");
                fillsubjcombo();
                
                conn.close();
ps.close();
rs.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        }

    }//GEN-LAST:event_subaddbtnActionPerformed

    private void addbatchbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbatchbtActionPerformed
        // TODO add your handling code here:
        String sub=settings_subject_combo.getSelectedItem().toString();
        String item = addbatch.getText().toString();
        if (item.equals("All") || item.equals("")) {
            JOptionPane.showMessageDialog(null, "Wrong Subject Name");
        } else {
            try {

                Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement("INSERT INTO  BATCHLIST(BATCH,subject)" + "VALUES(?,?)");

                ps.setString(1, addbatch.getText());
                                ps.setString(2, sub);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, addbatch.getText() + " Batch Added!");
                addbatch.setText("");
                fillbatchcombo();
                
                conn.close();
                ps.close();
                rs.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }

    }//GEN-LAST:event_addbatchbtActionPerformed

    private void addgrpbtchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addgrpbtchActionPerformed

        if (chkinfo() != false) {
            try {
                String srchRoll = txt_sRoll.getText();
                int roll = Integer.parseInt(srchRoll);
                Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement("INSERT INTO  subgroup (ROLL,SUBJECT,BATCH)" + "VALUES(?,?,?)");
                ps.setInt(1, roll);
                ps.setString(2, combosubj.getSelectedItem().toString());
                ps.setString(3, btchcombo.getSelectedItem().toString());
                ps.executeUpdate();
                sinfotxtarea.append("\nRoll: " + txt_sRoll.getText() + "\nSubject: " + combosubj.getSelectedItem().toString() + "\nBatch: " + btchcombo.getSelectedItem().toString());
                JOptionPane.showMessageDialog(null, "Batch Added!");
                conn.close();
                ps.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Enter Roll and Name");
        }

    }//GEN-LAST:event_addgrpbtchActionPerformed

    private void searchbtchgrpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtchgrpActionPerformed
        Calendar mCalendar = Calendar.getInstance();
        String month = mCalendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
        int crntyear = Calendar.getInstance().get(Calendar.YEAR);
        //System.out.println(crntyear);     
        try {

            Connection conn = getConnection();

            String s = "All";
            String sub = batchsubcombo.getSelectedItem().toString();
            String batch = batchbatchcombo.getSelectedItem().toString();
            //System.out.println(sub);
            if (sub.equals(s)) {
                PreparedStatement ps = conn.prepareStatement("SELECT distinct t2017.roll,t2017.name, subgroup.subject,subgroup.batch,bank" + crntyear + "." + month + " FROM t2017 JOIN subgroup ON subgroup.roll=t2017.roll join bank" + crntyear + " ON bank" + crntyear + ".roll=t2017.roll ORDER BY t2017.roll ASC");
                //PreparedStatement ps2 = conn.prepareStatement("SELECT COUNT(DISTINCT ROLL) FROM SUBGROUP");

                rs = ps.executeQuery();
                //rs2 = ps2.executeQuery();
                SUBGROUPTABLE.setModel(DbUtils.resultSetToTableModel(rs));
                int a;
                a = SUBGROUPTABLE.getRowCount();
                rowcount.setText("" + a);
                System.out.println(a);

                ps.close();
            } else if (batch.equals(s)) {
                PreparedStatement ps
                        = conn.prepareStatement("SELECT distinct t2017.roll,t2017.name,subgroup.batch,bank" + crntyear + "." + month + " FROM t2017 join SUBGROUP ON subgroup.roll=t2017.roll join bank" + crntyear + " ON bank" + crntyear + ".roll=t2017.roll WHERE SUBJECT=? ORDER BY t2017.roll ASC");
                ps.setString(1, batchsubcombo.getSelectedItem().toString());
                rs = ps.executeQuery();
                SUBGROUPTABLE.setModel(DbUtils.resultSetToTableModel(rs));
                int a;
                a = SUBGROUPTABLE.getRowCount();
                rowcount.setText("" + a);
                System.out.println(a);
                
                ps.close();
            } else {
                PreparedStatement ps
                        = conn.prepareStatement("SELECT distinct t2017.roll,t2017.name,subgroup.batch,bank" + crntyear + "." + month + " FROM t2017 join SUBGROUP ON subgroup.roll=t2017.roll join bank" + crntyear + " ON bank" + crntyear + ".roll=t2017.roll WHERE SUBJECT=? and BATCH=? ORDER BY t2017.roll ASC");
                ps.setString(1, batchsubcombo.getSelectedItem().toString());
                ps.setString(2, batchbatchcombo.getSelectedItem().toString());
                rs = ps.executeQuery();
                SUBGROUPTABLE.setModel(DbUtils.resultSetToTableModel(rs));
                int a;
                a = SUBGROUPTABLE.getRowCount();
                rowcount.setText("" + a);
                System.out.println(a);

                ps.close();
            }
conn.close();
rs.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }


    }//GEN-LAST:event_searchbtchgrpActionPerformed

    public StringBuilder get_stdnt_batch_grp(){
        StringBuilder stdntbatch= new StringBuilder("");
        
         try {
            Connection conn = getConnection();
          
            PreparedStatement ps = conn.prepareStatement("select subject,batch FROM subgroup where roll=?");
            ps.setString(1, bank_roll.getText());
            rs = ps.executeQuery();
            
             while (rs.next()) {
                 String btch= rs.getString("subject");
                 String grp=rs.getString("batch");
                 
                 stdntbatch.append(btch+"("+grp+")    " ) ;
               }
             
             conn.close();
             rs.close();
                ps.close();
            
//           System.out.println(dateobj);
           
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return stdntbatch;
    }
    
    
    public void set_output(int roll) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate1 = LocalDate.now();
        String localDate = dtf.format(localDate1);
              Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
        String curTime=sdf.format(cal.getTime());


        String name = null, school = null, cls = null;
        String month = bank_monthcombo.getSelectedItem().toString();
        String item = banksttchrcombo.getSelectedItem().toString();
        String sroll = bank_roll.getText();
        String tk = bank_money.getText();
        String recevedBY= recevdBY_txt.getText();
        
        int recpID= getRecipID()-1;
        StringBuilder grpBatch= get_stdnt_batch_grp();

        if (item.equals("Student")) {
            try {

                Connection conn = getConnection();

                String sql = "select Name,SCHOOLNAME,Class FROM  t2017 WHERE roll=?";
                pst = conn.prepareStatement(sql);
                pst.setInt(1, roll);

                rs = pst.executeQuery();

                if (rs.next()) {
                    name = rs.getString("Name");

                    school = rs.getString("SCHOOLNAME");
                    cls = rs.getString("CLASS");
                }

                printData = "\nContact:0721-760006\n\nPayment of " + month + "\nDate: " + localDate +"\nTime: "+curTime+"\n\nReceip ID: "+recpID+ "\nRoll: " + sroll + "\nName: " + name + "\nSchool Name: " + school + "\nClass: " + cls +"\nSubject: "+grpBatch.toString()+ "\nTotal Ammount: " + tk + " Tk."+"\n\n\t\t\tReceved By: "+recevedBY;

                bank_output.setText(printData);
                
                conn.close();
                 pst.close();
                 rs.close();
                        

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }        // TODO add your handling code here:
        }

        if (item.equals("Academic Teacher")) {
            try {

                Connection conn = getConnection();

                String sql = "select Name,institute,subject FROM  academicteacher WHERE roll=?";
                pst = conn.prepareStatement(sql);
                pst.setInt(1, roll);

                rs = pst.executeQuery();

                if (rs.next()) {
                    name = rs.getString("Name");

                    school = rs.getString("institute");
                    cls = rs.getString("subject");
                }

                printData = "\nContact:0721-760006\nPayment of " + month + "\nDate: " + localDate +"\nTime: "+curTime+"\n\nReceip ID: "+recpID+ "\nRoll: " + sroll + "\nName: " + name + "\nInstitute Name: " + school + "\nSubject: " + cls + "\nAmmount: " + tk + " Tk."+"\n\n\t\t\tReceved By: "+recevedBY;

                bank_output.setText(printData);
                
                
                conn.close();
                 pst.close();
                 rs.close();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }        // TODO add your handling code here:
        }

        if (item.equals("Tutor Advance Pay")) {
            try {

                Connection conn = getConnection();

                String sql = "select Name,institute,subject FROM  tutor WHERE id=?";
                pst = conn.prepareStatement(sql);
                pst.setInt(1, roll);

                rs = pst.executeQuery();

                if (rs.next()) {
                    name = rs.getString("Name");

                    school = rs.getString("institute");
                    cls = rs.getString("subject");
                }

                printData = "\nContact:0721-760006\nPayment of " + item + "\nDate: " + localDate +"\nTime: "+curTime+"\n\nReceip ID: "+recpID+ "\nRoll: " + sroll + "\nName: " + name + "\nInstitute Name: " + school + "\nSubject: " + cls + "\nAmmount: " + tk + " Tk."+"\n\n\t\t\tReceved By: "+recevedBY;

                bank_output.setText(printData);
                
                
                conn.close();
                 pst.close();
                 rs.close();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }        // TODO add your handling code here:
        }

        if (item.equals("Tutor First Pay")) {
            try {

                Connection conn = getConnection();

                String sql = "select Name,institute,subject FROM  tutor WHERE id=?";
                pst = conn.prepareStatement(sql);
                pst.setInt(1, roll);

                rs = pst.executeQuery();

                if (rs.next()) {
                    name = rs.getString("Name");

                    school = rs.getString("institute");
                    cls = rs.getString("subject");
                }

                printData = "\nContact:0721-760006\nPayment of " + item + "\nDate: " + localDate +"\nTime: "+curTime+"\n\nReceip ID: "+recpID+ "\nRoll: " + sroll + "\nName: " + name + "\nInstitute Name: " + school + "\nSubject: " + cls + "\nAmmount: " + tk + " Tk."+"\n\n\t\t\tReceved By: "+recevedBY;

                bank_output.setText(printData);
                
                conn.close();
                 pst.close();
                 rs.close();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }        // TODO add your handling code here:
        }

        if (item.equals("Tutor Second Pay")) {
            try {

                Connection conn = getConnection();

                String sql = "select Name,institute,subject FROM  tutor WHERE id=?";
                pst = conn.prepareStatement(sql);
                pst.setInt(1, roll);

                rs = pst.executeQuery();

                if (rs.next()) {
                    name = rs.getString("Name");

                    school = rs.getString("institute");
                    cls = rs.getString("subject");
                }

                printData = "\nContact:0721-760006\nPayment of " + item + "\nDate: " + localDate +"\nTime: "+curTime+"\n\nReceip ID: "+recpID+ "\nRoll: " + sroll + "\nName: " + name + "\nInstitute Name: " + school + "\nSubject: " + cls + "\nAmmount: " + tk + " Tk."+"\n\n\t\t\tReceved By: "+recevedBY;

                bank_output.setText(printData);
                
                conn.close();
                 pst.close();
                 rs.close();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }        // TODO add your handling code here:
        }

        bank_roll.setText("");
        bank_money.setText("");
    }


    private void bank_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bank_saveActionPerformed
        String item = banksttchrcombo.getSelectedItem().toString();
        int roll = Integer.parseInt(bank_roll.getText());
        int amount = Integer.parseInt(bank_money.getText());
        String month = bank_monthcombo.getSelectedItem().toString();
        String student = "Student";
        String academic_teacher = "Academic Teacher";
        String year = yrcombo.getSelectedItem().toString();

        if(recevdBY_txt.getText().toString().equals("")){
            
            try {
		throw new recevedByException("Please Enter 'Received By' Name");
		} catch (recevedByException e) {

			e.printStackTrace();
		}
            
        }
        
        else{ 
        if (item.equals("Student")) {
            try {
                Connection conn = getConnection();
                if (month.equals("January")) {
                    PreparedStatement ps = conn.prepareStatement("UPDATE  BANK" + year + " SET january=? WHERE ROLL=?");
                    ps.setInt(1, amount);
                    ps.setInt(2, roll);
                    ps.executeUpdate();

                    income_amount(roll, amount);
                    ps.close();
                }
                if (month.equals("February")) {
                    PreparedStatement ps = conn.prepareStatement("UPDATE  BANK" + year + " SET february=? WHERE ROLL=?");
                    ps.setInt(1, amount);
                    ps.setInt(2, roll);
                    ps.executeUpdate();

                    income_amount(roll, amount);
                     ps.close();
                }
                if (month.equals("March")) {
                    PreparedStatement ps = conn.prepareStatement("UPDATE  BANK" + year + " SET march=? WHERE ROLL=?");
                    ps.setInt(2, roll);
                    ps.setInt(1, amount);
                    ps.executeUpdate();
                    income_amount(roll, amount);
                   ps.close();
                }
                if (month.equals("April")) {
                    PreparedStatement ps = conn.prepareStatement("UPDATE  BANK" + year + " SET april=? WHERE ROLL=?");
                    ps.setInt(2, roll);
                    ps.setInt(1, amount);
                    ps.executeUpdate();
                    income_amount(roll, amount);
                     ps.close();
                }
                if (month.equals("May")) {
                    PreparedStatement ps = conn.prepareStatement("UPDATE  BANK" + year + " SET may=? WHERE ROLL=?");
                    ps.setInt(2, roll);
                    ps.setInt(1, amount);
                    ps.executeUpdate();
                    income_amount(roll, amount);
                     ps.close();
                }
                if (month.equals("June")) {
                    PreparedStatement ps = conn.prepareStatement("UPDATE   BANK" + year + " SET june=? WHERE ROLL=?");
                    ps.setInt(2, roll);
                    ps.setInt(1, amount);
                    ps.executeUpdate();
                    income_amount(roll, amount);
                     ps.close();
                }
                if (month.equals("July")) {
                    PreparedStatement ps = conn.prepareStatement("UPDATE  BANK" + year + " SET july=? WHERE ROLL=?");
                    ps.setInt(2, roll);
                    ps.setInt(1, amount);
                    ps.executeUpdate();
                    income_amount(roll, amount);
                     ps.close();
                }
                if (month.equals("August")) {
                    PreparedStatement ps = conn.prepareStatement("UPDATE  BANK" + year + " SET august=? WHERE ROLL=?");
                    ps.setInt(2, roll);
                    ps.setInt(1, amount);
                    ps.executeUpdate();
                    income_amount(roll, amount);
                    ps.close();
                }
                if (month.equals("September")) {
                    PreparedStatement ps = conn.prepareStatement("UPDATE  BANK" + year + " SET september=? WHERE ROLL=?");
                    ps.setInt(2, roll);
                    ps.setInt(1, amount);
                    ps.executeUpdate();
                    income_amount(roll, amount);
                    ps.close();
                }
                if (month.equals("October")) {
                    PreparedStatement ps = conn.prepareStatement("UPDATE  BANK" + year + " SET october=? WHERE ROLL=?");
                    ps.setInt(2, roll);
                    ps.setInt(1, amount);
                    ps.executeUpdate();
                    income_amount(roll, amount);
                    ps.close();
                }
                if (month.equals("November")) {
                    PreparedStatement ps = conn.prepareStatement("UPDATE  BANK" + year + " SET november=? WHERE ROLL=?");
                    ps.setInt(2, roll);
                    ps.setInt(1, amount);
                    ps.executeUpdate();
                    income_amount(roll, amount);
                     ps.close();
                }
                if (month.equals("December")) {
                    PreparedStatement ps = conn.prepareStatement("UPDATE  BANK" + year + " SET december=? WHERE ROLL=?");
                    ps.setInt(2, roll);
                    ps.setInt(1, amount);
                    ps.executeUpdate();
                    income_amount(roll, amount);
                     ps.close();
                }
                if (month.equals("Program Fee")) {
                    PreparedStatement ps = conn.prepareStatement("UPDATE  BANK" + year + " SET programfee=? WHERE ROLL=?");
                    ps.setInt(2, roll);
                    ps.setInt(1, amount);
                    ps.executeUpdate();
                    income_amount(roll, amount);
                     ps.close();
                }

                conn.close();
               
                rs.close();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            
            
            

            set_output(roll);
            JOptionPane.showMessageDialog(null, "Payment Saved");
        }

        if (item.equals("Academic Teacher")) {
            try {
                Connection conn = getConnection();
                if (month.equals("January")) {
                    PreparedStatement ps = conn.prepareStatement("UPDATE  BANK" + year + " SET january=? WHERE ROLL=?");
                    ps.setInt(1, amount);
                    ps.setInt(2, roll);
                    ps.executeUpdate();
                    //set_output(roll);
                    expense_amount(roll, amount);
                     ps.close();
                }
                if (month.equals("February")) {
                    PreparedStatement ps = conn.prepareStatement("UPDATE  BANK" + year + " SET february=? WHERE ROLL=?");
                    ps.setInt(1, amount);
                    ps.setInt(2, roll);
                    ps.executeUpdate();
                    // set_output(roll);
                    expense_amount(roll, amount);
                     ps.close();
                }
                if (month.equals("March")) {
                    PreparedStatement ps = conn.prepareStatement("UPDATE  BANK" + year + " SET march=? WHERE ROLL=?");
                    ps.setInt(2, roll);
                    ps.setInt(1, amount);
                    ps.executeUpdate();
                    expense_amount(roll, amount);
                     ps.close();
                }
                if (month.equals("April")) {
                    PreparedStatement ps = conn.prepareStatement("UPDATE  BANK" + year + " SET april=? WHERE ROLL=?");
                    ps.setInt(2, roll);
                    ps.setInt(1, amount);
                    ps.executeUpdate();
                    expense_amount(roll, amount);
                    ps.close();
                }
                if (month.equals("May")) {
                    PreparedStatement ps = conn.prepareStatement("UPDATE  BANK" + year + " SET may=? WHERE ROLL=?");
                    ps.setInt(2, roll);
                    ps.setInt(1, amount);
                    ps.executeUpdate();
                    expense_amount(roll, amount);
                     ps.close();
                }
                if (month.equals("June")) {
                    PreparedStatement ps = conn.prepareStatement("UPDATE   BANK" + year + " SET june=? WHERE ROLL=?");
                    ps.setInt(2, roll);
                    ps.setInt(1, amount);
                    ps.executeUpdate();
                    expense_amount(roll, amount);
                     ps.close();
                }
                if (month.equals("July")) {
                    PreparedStatement ps = conn.prepareStatement("UPDATE  BANK" + year + " SET july=? WHERE ROLL=?");
                    ps.setInt(2, roll);
                    ps.setInt(1, amount);
                    ps.executeUpdate();
                    expense_amount(roll, amount);
                     ps.close();
                }
                if (month.equals("August")) {
                    PreparedStatement ps = conn.prepareStatement("UPDATE  BANK" + year + " SET august=? WHERE ROLL=?");
                    ps.setInt(2, roll);
                    ps.setInt(1, amount);
                    ps.executeUpdate();
                    expense_amount(roll, amount);
                     ps.close();
                }
                if (month.equals("September")) {
                    PreparedStatement ps = conn.prepareStatement("UPDATE  BANK" + year + " SET september=? WHERE ROLL=?");
                    ps.setInt(2, roll);
                    ps.setInt(1, amount);
                    ps.executeUpdate();
                    expense_amount(roll, amount);
                     ps.close();
                }
                if (month.equals("October")) {
                    PreparedStatement ps = conn.prepareStatement("UPDATE  BANK" + year + " SET october=? WHERE ROLL=?");
                    ps.setInt(2, roll);
                    ps.setInt(1, amount);
                    ps.executeUpdate();
                    expense_amount(roll, amount);
                    ps.close();
                }
                if (month.equals("November")) {
                    PreparedStatement ps = conn.prepareStatement("UPDATE  BANK" + year + " SET november=? WHERE ROLL=?");
                    ps.setInt(2, roll);
                    ps.setInt(1, amount);
                    ps.executeUpdate();
                    expense_amount(roll, amount);
                    ps.close();
                }
                if (month.equals("December")) {
                    PreparedStatement ps = conn.prepareStatement("UPDATE  BANK" + year + " SET december=? WHERE ROLL=?");
                    ps.setInt(2, roll);
                    ps.setInt(1, amount);
                    ps.executeUpdate();
                    expense_amount(roll, amount);
                     ps.close();
                }
                
                 conn.close();
                rs.close();


            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

            set_output(roll);
            JOptionPane.showMessageDialog(null, "Payment Saved");
        }

        //   String srchRoll = rolltoupdate.getText();
        // int roll = Integer.parseInt(srchRoll);
        if (item.equals("Tutor Advance Pay")) {
            try {

                Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement("UPDATE  tutor SET advance=? WHERE id=?");

                ps.setInt(1, amount);
                ps.setInt(2, roll);
                ps.executeUpdate();
                income_amount(roll, amount);
                
                conn.close();
                     ps.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            set_output(roll);
            JOptionPane.showMessageDialog(null, "Payment Saved");

        }
        if (item.equals("Tutor First Pay")) {
            try {

                Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement("UPDATE  tutor SET firstpay=? WHERE id=?");
                ps.setInt(2, roll);
                ps.setInt(1, amount);
                ps.executeUpdate();
                income_amount(roll, amount);

                conn.close();
                 ps.close();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            set_output(roll);
            JOptionPane.showMessageDialog(null, "Payment Saved");

        }
        if (item.equals("Tutor Second Pay")) {
            try {

                Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement("UPDATE  tutor SET secondpay=? WHERE id=?");
                ps.setInt(2, roll);
                ps.setInt(1, amount);
                ps.executeUpdate();
                income_amount(roll, amount);

                conn.close();
                 ps.close();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            set_output(roll);
            JOptionPane.showMessageDialog(null, "Payment Saved");

        }
        
        
        }

    }//GEN-LAST:event_bank_saveActionPerformed

    private void rmvbatchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rmvbatchbtnActionPerformed
        try {

            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM  batchlist WHERE BATCH=?");
            ps.setString(1, rmvbatch.getText());
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, rmvbatch.getText() + " Batch Deleted!");
            rmvbatch.setText("");
            fillbatchcombo();
            conn.close();
ps.close();
rs.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_rmvbatchbtnActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        try {

            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE  FROM SUBLIST WHERE SUBJECT=?");
            ps.setString(1, rmvsubject.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, rmvsubject.getText() + " Subject Deleted!");
            rmvsubject.setText("");
            fillsubjcombo();
            conn.close();
ps.close();
rs.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void ac_tchrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ac_tchrActionPerformed
        Calendar mCalendar = Calendar.getInstance();
        String month = mCalendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
        int crntyear = Calendar.getInstance().get(Calendar.YEAR);

        try {

            Connection conn = getConnection();

            PreparedStatement ps
                    = conn.prepareStatement("SELECT ACADEMICTEACHER.roll,ACADEMICTEACHER.name,ACADEMICTEACHER.institute,ACADEMICTEACHER.subject,ACADEMICTEACHER.contact,bank2017.january,bank2017.february,bank2017.march,bank2017.april,bank2017.may,bank2017.june,bank2017.july,bank2017.august,bank2017.september,bank2017.october,bank2017.november,bank2017.december FROM ACADEMICTEACHER join bank2017 on ACADEMICTEACHER.roll=bank2017.roll ORDER BY roll ASC");
            // ps.setString(1, batchsubcombo.getSelectedItem().toString());
            rs = ps.executeQuery();
            tchr_info.setModel(DbUtils.resultSetToTableModel(rs));
            tchr_rowcount.setText("" + tchr_info.getRowCount());
conn.close();
ps.close();
rs.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }


    }//GEN-LAST:event_ac_tchrActionPerformed

    private void tutor_infoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tutor_infoActionPerformed
        try {

            Connection conn = getConnection();

            PreparedStatement ps
                    = conn.prepareStatement("SELECT * FROM TUTOR ORDER BY ID ASC");
            // ps.setString(1, batchsubcombo.getSelectedItem().toString());
            rs = ps.executeQuery();
            tchr_info.setModel(DbUtils.resultSetToTableModel(rs));
            tchr_rowcount.setText("" + tchr_info.getRowCount());
conn.close();
ps.close();
rs.close();
        
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            }    }//GEN-LAST:event_tutor_infoActionPerformed

    private void banksttchrcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_banksttchrcomboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_banksttchrcomboActionPerformed

    private void bank_rollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bank_rollActionPerformed
        String item = banksttchrcombo.getSelectedItem().toString();
        String year = yrcombo.getSelectedItem().toString();

        if (item.equals("Student") || item.equals("Academic Teacher")) {
            try {

                Connection conn = getConnection();

                PreparedStatement ps
                        = conn.prepareStatement("SELECT * FROM BANK" + year + "  WHERE ROLL=?");
                ps.setString(1, bank_roll.getText());
                rs = ps.executeQuery();
                bank_table.setModel(DbUtils.resultSetToTableModel(rs));
                conn.close();
                ps.close();
                rs.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } else if (item.equals("Tutor")) {
            try {

                Connection conn = getConnection();

                PreparedStatement ps
                        = conn.prepareStatement("SELECT * FROM TUTOR WHERE ID=?");
                ps.setString(1, bank_roll.getText());
                rs = ps.executeQuery();
                bank_table.setModel(DbUtils.resultSetToTableModel(rs));
                
                                conn.close();
                ps.close();
                rs.close();


            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }


    }//GEN-LAST:event_bank_rollActionPerformed

    private void bank_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bank_printActionPerformed

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();
        //String printData ="  Alo Art Academy\n\tCell:0721760006\nRoll:"+ bank_roll.getText() + "\tDate:"+localDate+"\nName:" + bank_money.getText();
        /*       PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(new OutputPrinter(printData));
        boolean doPrint = job.printDialog();
        if (doPrint) {
            try {
                job.print();
            } catch (PrinterException e) {
                // Print job did not complete.
            }*/

        MessageFormat header = new MessageFormat("Alo Art Academy");
        MessageFormat footer = new MessageFormat("");

        // PrinterJob job
        try {

            bank_output.print(header, footer);
        } catch (PrinterException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());


    }    }//GEN-LAST:event_bank_printActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String month = duecombo.getSelectedItem().toString();
        String year = yrcombo2.getSelectedItem().toString();

        try {
            Connection conn = getConnection();

            if (month.equals("January")) {
                PreparedStatement ps = conn.prepareStatement("SELECT distinct  t2017.roll,t2017.name,subgroup.subject,subgroup.batch,bank" + year + ".january FROM t2017 join subgroup ON subgroup.roll=t2017.roll join bank" + year + " ON bank" + year + ".roll=t2017.roll WHERE bank" + year + ".january=0 ORDER BY t2017.roll ASC");
                rs = ps.executeQuery();
                bank_table.setModel(DbUtils.resultSetToTableModel(rs));
                    ps.close();
                // ps.executeUpdate();
            }
            if (month.equals("February")) {
                PreparedStatement ps = conn.prepareStatement("SELECT distinct t2017.roll,t2017.name,subgroup.subject,subgroup.batch,bank" + year + ".february FROM t2017 join subgroup ON subgroup.roll=t2017.roll join bank" + year + " ON bank" + year + ".roll=t2017.roll WHERE bank" + year + ".february=0 ORDER BY t2017.roll ASC");
                rs = ps.executeQuery();
                bank_table.setModel(DbUtils.resultSetToTableModel(rs));

            }
            if (month.equals("March")) {
                PreparedStatement ps = conn.prepareStatement("SELECT distinct t2017.roll,t2017.name,subgroup.subject,subgroup.batch,bank" + year + ".march FROM t2017 join subgroup ON subgroup.roll=t2017.roll join bank" + year + " ON bank" + year + ".roll=t2017.roll WHERE bank" + year + ".march=0 ORDER BY t2017.roll ASC");
                rs = ps.executeQuery();
                bank_table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            if (month.equals("April")) {
                PreparedStatement ps = conn.prepareStatement("SELECT distinct  t2017.roll,t2017.name,subgroup.subject,subgroup.batch,bank" + year + ".april FROM t2017 join subgroup ON subgroup.roll=t2017.roll join bank" + year + " ON bank" + year + ".roll=t2017.roll WHERE bank" + year + ".april=0 ORDER BY t2017.roll ASC");
                rs = ps.executeQuery();
                bank_table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            if (month.equals("May")) {
                PreparedStatement ps = conn.prepareStatement("SELECT distinct t2017.roll,t2017.name,subgroup.subject,subgroup.batch,bank" + year + ".may FROM t2017 join subgroup ON subgroup.roll=t2017.roll join bank" + year + " ON bank" + year + ".roll=t2017.roll WHERE bank" + year + ".may=0 ORDER BY t2017.roll ASC");
                rs = ps.executeQuery();
                bank_table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            if (month.equals("June")) {
                PreparedStatement ps = conn.prepareStatement("SELECT distinct t2017.roll,t2017.name,subgroup.subject,subgroup.batch,bank" + year + ".june FROM t2017 join subgroup ON subgroup.roll=t2017.roll join bank" + year + " ON bank" + year + ".roll=t2017.roll WHERE bank" + year + ".june=0 ORDER BY t2017.roll ASC");

                rs = ps.executeQuery();
                bank_table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            if (month.equals("July")) {
                PreparedStatement ps = conn.prepareStatement("SELECT distinct t2017.roll,t2017.name,subgroup.subject,subgroup.batch,bank" + year + ".july FROM t2017 join subgroup ON subgroup.roll=t2017.roll join bank" + year + " ON bank" + year + ".roll=t2017.roll WHERE bank" + year + ".july=0 ORDER BY t2017.roll ASC");
                rs = ps.executeQuery();
                bank_table.setModel(DbUtils.resultSetToTableModel(rs));

            }
            if (month.equals("August")) {
                PreparedStatement ps = conn.prepareStatement("SELECT distinct t2017.roll,t2017.name,subgroup.subject,subgroup.batch,bank" + year + ".august FROM t2017 join subgroup ON subgroup.roll=t2017.roll join bank" + year + " ON bank" + year + ".roll=t2017.roll WHERE bank" + year + ".august=0 ORDER BY t2017.roll ASC");
                rs = ps.executeQuery();
                bank_table.setModel(DbUtils.resultSetToTableModel(rs));

            }
            if (month.equals("September")) {
                PreparedStatement ps = conn.prepareStatement("SELECT distinct t2017.roll,t2017.name,subgroup.subject,subgroup.batch,bank" + year + ".september FROM t2017 join subgroup ON subgroup.roll=t2017.roll join bank" + year + " ON bank" + year + ".roll=t2017.roll WHERE bank" + year + ".september=0 ORDER BY t2017.roll ASC");
                rs = ps.executeQuery();
                bank_table.setModel(DbUtils.resultSetToTableModel(rs));

            }
            if (month.equals("October")) {
                PreparedStatement ps = conn.prepareStatement("SELECT distinct t2017.roll,t2017.name,subgroup.subject,subgroup.batch,bank" + year + ".october FROM t2017 join subgroup ON subgroup.roll=t2017.roll join bank" + year + " ON bank" + year + ".roll=t2017.roll WHERE bank" + year + ".october=0 ORDER BY t2017.roll ASC");
                rs = ps.executeQuery();
                bank_table.setModel(DbUtils.resultSetToTableModel(rs));

            }
            if (month.equals("November")) {
                PreparedStatement ps = conn.prepareStatement("SELECT distinct t2017.roll,t2017.name,subgroup.subject,subgroup.batch,bank" + year + ".november FROM t2017 join subgroup ON subgroup.roll=t2017.roll join bank" + year + " ON bank" + year + ".roll=t2017.roll WHERE bank" + year + ".november=0 ORDER BY t2017.roll ASC");
                rs = ps.executeQuery();
                bank_table.setModel(DbUtils.resultSetToTableModel(rs));

            }
            if (month.equals("December")) {
                PreparedStatement ps = conn.prepareStatement("SELECT distinct t2017.roll,t2017.name,subgroup.subject,subgroup.batch,bank" + year + ".december FROM t2017 join subgroup ON subgroup.roll=t2017.roll join bank" + year + " ON bank" + year + ".roll=t2017.roll WHERE bank" + year + ".december=0 ORDER BY t2017.roll ASC");
                rs = ps.executeQuery();
                bank_table.setModel(DbUtils.resultSetToTableModel(rs));

            }
            if (month.equals("Program Fee")) {
                PreparedStatement ps = conn.prepareStatement("SELECT distinct t2017.roll,t2017.name,subgroup.subject,subgroup.batch,bank" + year + ".programfee FROM t2017 join subgroup ON subgroup.roll=t2017.roll join bank" + year + " ON bank" + year + ".roll=t2017.roll WHERE bank" + year + ".programfee=0 ORDER BY t2017.roll ASC");
                rs = ps.executeQuery();
                bank_table.setModel(DbUtils.resultSetToTableModel(rs));

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tchrrollboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tchrrollboxActionPerformed
        // TODO add your handling code here:
        
        
        searchTableContents(tchrrollbox.getText().toString());

    }//GEN-LAST:event_tchrrollboxActionPerformed

    
    
    
    private void prvspassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prvspassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prvspassActionPerformed

    private void chng_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chng_passActionPerformed

        if (pass.equals(prvspass.getText().toString())) {
            try {
                Connection conn = getConnection();

                PreparedStatement ps = conn.prepareStatement("update  passwordtable set password=? where serial=1");
                ps.setString(1, newpass.getText());

                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Password Changed! ");
                System.out.println(pass);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, " Wrong Password! Try Again");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_chng_passActionPerformed

    private void save_incomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_incomeActionPerformed
        try {
            Random rand=new Random();
int randnum= rand.nextInt(500);
            Connection conn = getConnection();
            //int money=  Integer.parseInt(bank_money.getText().toString());
            PreparedStatement ps
                    = conn.prepareStatement("insert into income(id,name,amount,idate) values(?,?,?,?)");

           ps.setInt(1, randnum);
            ps.setString(2, income_name_txt.getText().toString());
            ps.setString(3, income_ammou_txt.getText().toString());
            // ps.setInt(3, amount);
            ps.setString(4, ((JTextField) income_calender.getDateEditor().getUiComponent()).getText());
            // System.out.println("insert");
            //ps.setTimestamp(4, date);
            ps.executeUpdate();
            //tchr_info.setModel(DbUtils.resultSetToTableModel(rs));
            JOptionPane.showMessageDialog(null, "Income: " + income_name_txt.getText().toString() + "\nAmount: " + income_ammou_txt.getText().toString() + "\nSaved!");
            income_ammou_txt.setText("");
            income_name_txt.setText("");
            conn.close();
ps.close();
rs.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_save_incomeActionPerformed

    private void income_name_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_income_name_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_income_name_txtActionPerformed

    private void expense_name_txt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expense_name_txt1ActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_expense_name_txt1ActionPerformed

    private void save_expenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_expenseActionPerformed
        try {
Random rand=new Random();
int randnum= rand.nextInt(500);
            Connection conn = getConnection();
            //int money=  Integer.parseInt(bank_money.getText().toString());
            PreparedStatement ps
                    = conn.prepareStatement("insert into expense(id,name,amount,edate) values(?,?,?,?)");

            ps.setInt(1, randnum);
            ps.setString(2, expense_name_txt1.getText().toString());
            ps.setString(3, expense_ammou_txt1.getText().toString());
            // ps.setInt(3, amount);
            ps.setString(4, ((JTextField) exp_cal.getDateEditor().getUiComponent()).getText());
            // System.out.println("insert");
            //ps.setTimestamp(4, date);
            ps.executeUpdate();
            //tchr_info.setModel(DbUtils.resultSetToTableModel(rs));
            JOptionPane.showMessageDialog(null, "Expense: " + expense_name_txt1.getText().toString() + "\nAmount: " + expense_ammou_txt1.getText().toString() + "\nSaved!");
            expense_ammou_txt1.setText("");
            expense_name_txt1.setText("");
            conn.close();
ps.close();
rs.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }//GEN-LAST:event_save_expenseActionPerformed

    private void duecomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duecomboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_duecomboActionPerformed

    private void yrcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yrcomboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yrcomboActionPerformed

    private void bank_monthcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bank_monthcomboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bank_monthcomboActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        txt_sRoll.setText("");
        txt_sName.setText("");
        txt_schlname.setText("");
        txt_class.setText("");
        txt_smbl.setText("");
        sinfotxtarea.setText("Welcome to Alo Art Academy");

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        try {

            Connection conn = getConnection();

            PreparedStatement ps
                    = conn.prepareStatement("SELECT * from t2017  ORDER BY roll ASC");
            // ps.setString(1, batchsubcombo.getSelectedItem().toString());
            rs = ps.executeQuery();
            stdntinfotable.setModel(DbUtils.resultSetToTableModel(rs));
            sinfototal.setText("" + stdntinfotable.getRowCount());
 conn.close();
                ps.close();
                rs.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        try {

            Connection conn = getConnection();

            PreparedStatement ps
                    = conn.prepareStatement("select id,name,amount,receipid,receivedby from income where idate=? and (name='Student' or name='Tutor Advance Pay' or name='Tutor First Pay' or name='Tutor Second Pay')");
            ps.setString(1, currentdate);
            rs = ps.executeQuery();
            bank_table.setModel(DbUtils.resultSetToTableModel(rs));

            DefaultTableModel model = (DefaultTableModel) bank_table.getModel();
            int total = 0;
            // TableModel model

            for (int i = 0; i < bank_table.getRowCount(); i++) {
                int amount = Integer.parseInt(bank_table.getValueAt(i, 2).toString());
                total = total + amount;
            }
            Object[] row = {"", "Total:", total};
            model.addRow(row);

                conn.close();
                 ps.close();
                 rs.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            String srchRoll = rolltoupdate.getText();
            int roll = Integer.parseInt(srchRoll);
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO  subgroup (ROLL,SUBJECT,BATCH)" + "VALUES(?,?,?)");
            ps.setInt(1, roll);
            ps.setString(2, rmvsubj.getSelectedItem().toString());
            ps.setString(3, rmvbatchcmbo.getSelectedItem().toString());
            ps.executeUpdate();
            PreparedStatement ps3 = conn.prepareStatement("select distinct subject,batch from subgroup where roll=?");
            ps3.setString(1, rolltoupdate.getText());
            rs = ps3.executeQuery();
            grpbtchtable.setModel(DbUtils.resultSetToTableModel(rs));

            JOptionPane.showMessageDialog(null, "New Batch Added!");
            conn.close();
            rs.close();
            ps.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void rmvsubjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rmvsubjActionPerformed

           Connection conn = getConnection();
           ArrayList<String> lst=new ArrayList<>();
         // String[] lst=new String[];
        try{
            
            PreparedStatement ps = conn.prepareStatement("select batch FROM batchlist where subject=?");
            ps.setString(1, rmvsubj.getSelectedItem().toString());
             rs = ps.executeQuery();
 while (rs.next()) {
     
            lst.add(rs.getString("batch"));
               }
 

        ps.close();
        rs.close();
        }
        catch(Exception e){
e.printStackTrace();
// JOptionPane.showMessageDialog(null, e.getMessage());
        }
        DefaultComboBoxModel model;
        model = new DefaultComboBoxModel(lst.toArray());
                    rmvbatchcmbo.setModel( model );
        
        
        
    }//GEN-LAST:event_rmvsubjActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        try {
            Connection conn = getConnection();
            String srchRoll = rolltoupdate.getText();
            int roll = Integer.parseInt(srchRoll);

            PreparedStatement ps = conn.prepareStatement("DELETE FROM subgroup  WHERE ROLL=? and subject=? and batch=?");

            ps.setInt(1, roll);
            ps.setString(2, rmvsubj.getSelectedItem().toString());
            ps.setString(3, rmvbatchcmbo.getSelectedItem().toString());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Batch: " + rmvsubj.getSelectedItem().toString() + " Subject: " + rmvbatchcmbo.getSelectedItem().toString() + " Deleted!");
            PreparedStatement ps3 = conn.prepareStatement("select distinct subject,batch from subgroup where roll=?");
            ps3.setString(1, rolltoupdate.getText());
            rs = ps3.executeQuery();
            grpbtchtable.setModel(DbUtils.resultSetToTableModel(rs));

            conn.close();
            rs.close();
            ps.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void delrecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delrecordActionPerformed
        // TODO add your handling code here:

        try {
            Connection conn = getConnection();
            String srchRoll = rolltoupdate.getText();
            int roll = Integer.parseInt(srchRoll);

            PreparedStatement ps = conn.prepareStatement("DELETE FROM T2017  WHERE ROLL=?");
            ps.setInt(1, roll);
            ps.executeUpdate();


            PreparedStatement ps11 = conn.prepareStatement("select distinct subject,batch from subgroup where roll=?");
            ps11.setString(1, rolltoupdate.getText());
            rs = ps11.executeQuery();
            grpbtchtable.setModel(DbUtils.resultSetToTableModel(rs));

            //                sinfotxtarea.setText("Successfull!\nRoll: "+txt_sRoll.getText()+"\nName: "+txt_sName.getText()+"\nSchool Name: "+txt_schlname.getText()+"\nClass: "+txt_class.getText()+"\nContact No.: "+txt_smbl.getText());

            up_name.setText("");
            up_schl.setText("");
            up_class.setText("");
            up_mblno.setText("");
            JOptionPane.showMessageDialog(null, "Record Deleted!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }//GEN-LAST:event_delrecordActionPerformed

    private void updbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updbActionPerformed
        int crntyear = Calendar.getInstance().get(Calendar.YEAR);

        try {
            Connection conn = getConnection();
            String srchRoll = rolltoupdate.getText();
            int roll = Integer.parseInt(srchRoll);
            String cls = up_class.getText();
            //int clss = Integer.parseInt(cls);
            String mblstring = up_mblno.getText();
            int mblno = Integer.parseInt(mblstring);
            
            PreparedStatement ps = conn.prepareStatement("UPDATE  T2017 set NAME=?,SCHOOLNAME=?,CLASS=?,CONTACT=? WHERE ROLL=?");

            ps.setString(1, up_name.getText());
            ps.setString(2, up_schl.getText());
            ps.setString(3, up_class.getText());
            //ps.setInt(3, clss);
            ps.setInt(4, mblno);
            ps.setInt(5, roll);
            ps.executeUpdate();
            
            //                sinfotxtarea.setText("Successfull!\nRoll: "+txt_sRoll.getText()+"\nName: "+txt_sName.getText()+"\nSchool Name: "+txt_schlname.getText()+"\nClass: "+txt_class.getText()+"\nContact No.: "+txt_smbl.getText());

            up_name.setText("");
            up_schl.setText("");
            up_class.setText("");
            up_mblno.setText("");
            JOptionPane.showMessageDialog(null, "Database Updated!");
            conn.close();
            ps.close();
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }//GEN-LAST:event_updbActionPerformed

    private void up_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_up_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_up_nameActionPerformed

    private void rolltoupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rolltoupdateActionPerformed
        // TODO add your handling code here:
        Connection conn = getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        //String srchRoll= rolltoupdate.getText();
        try {
            String sql = "SELECT ROLL,NAME,SCHOOLNAME,CLASS,CONTACT FROM T2017 WHERE ROLL =?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, rolltoupdate.getText());

            rs = pst.executeQuery();
            if (rs.next()) {
                String ID = rs.getString("ROLL");

                String FN = rs.getString("Name");
                up_name.setText(FN);
                String LN = rs.getString("SCHOOLNAME");
                up_schl.setText(LN);
                String Des = rs.getString("CLASS");
                up_class.setText(Des);
                String BS = rs.getString("CONTACT");
                up_mblno.setText(BS);
            }

            PreparedStatement ps3 = conn.prepareStatement("select distinct subject,batch from subgroup where roll=?");
            ps3.setString(1, rolltoupdate.getText());
            rs = ps3.executeQuery();
            grpbtchtable.setModel(DbUtils.resultSetToTableModel(rs));

            conn.close();
            rs.close();
            pst.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }//GEN-LAST:event_rolltoupdateActionPerformed

    private void del_tchr_infoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_del_tchr_infoActionPerformed
        // TODO add your handling code here:
                    int row= tchr_info.getSelectedRow();
         DefaultTableModel model =   (DefaultTableModel) tchr_info.getModel();

            String id= model.getValueAt(row, 0).toString();
            int roll = Integer.parseInt(id);
           
        if(row>=0)
            {
            model.removeRow(row);
            try {

            Connection conn = getConnection();

             PreparedStatement ps1
                    = conn.prepareStatement("delete from  ACADEMICTEACHER where roll=? ");
      ps1.setString(1,id);
           ps1.executeUpdate();
            
             PreparedStatement ps2 = conn.prepareStatement("DELETE FROM bank2017  WHERE ROLL=?");
            ps2.setInt(1, roll);
            ps2.executeUpdate();
             PreparedStatement ps3 = conn.prepareStatement("DELETE FROM bank2018  WHERE ROLL=?");
            ps3.setInt(1, roll);
            ps3.executeUpdate();
             PreparedStatement ps4 = conn.prepareStatement("DELETE FROM bank2019  WHERE ROLL=?");
            ps4.setInt(1, roll);
            ps4.executeUpdate();
             PreparedStatement ps5 = conn.prepareStatement("DELETE FROM bank2020  WHERE ROLL=?");
            ps5.setInt(1, roll);
            ps5.executeUpdate();
             PreparedStatement ps6 = conn.prepareStatement("DELETE FROM bank2021  WHERE ROLL=?");
            ps6.setInt(1, roll);
            ps6.executeUpdate();
             PreparedStatement ps7 = conn.prepareStatement("DELETE FROM bank2022  WHERE ROLL=?");
            ps7.setInt(1, roll);
            ps7.executeUpdate();
             PreparedStatement ps8 = conn.prepareStatement("DELETE FROM bank2023  WHERE ROLL=?");
            ps8.setInt(1, roll);
            ps8.executeUpdate();
          
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

            
            }
       
        
        
    }//GEN-LAST:event_del_tchr_infoActionPerformed

    private void del_tutor_infoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_del_tutor_infoActionPerformed
                int row= tchr_info.getSelectedRow();
         DefaultTableModel model =   (DefaultTableModel) tchr_info.getModel();

            String id= model.getValueAt(row, 0).toString();
            int roll = Integer.parseInt(id);
           
        if(row>=0)
            {
            model.removeRow(row);
            try {

            Connection conn = getConnection();

             PreparedStatement ps1
                    = conn.prepareStatement("delete from  tutor where id=? ");
      ps1.setString(1,id);
           ps1.executeUpdate();
            
           
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

            
            }
       
        
            // TODO add your handling code here:
    }//GEN-LAST:event_del_tutor_infoActionPerformed

    private void passinbox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passinbox2ActionPerformed
        String chkpass = passinbox2.getText().toString();
        System.out.println(pass);
        if (pass.equals(chkpass)) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new calculation().setVisible(true);
                }
            });
        } else if (chkpass.equals("HASINA")) {
            JOptionPane.showMessageDialog(null, "Password is " + pass);

        } else {
            JOptionPane.showMessageDialog(null, " Wrong Password! Try Again");

        }

    }//GEN-LAST:event_passinbox2ActionPerformed

    private void due_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_due_printActionPerformed

        String month= duecombo.getSelectedItem().toString();
        
        MessageFormat header = new MessageFormat("Due Table of "+month);
                MessageFormat footer = new MessageFormat("");
        
        
        try
        {
        bank_table.print(JTable.PrintMode.NORMAL, header, footer);
       // incometxt.print(getGraphics());
        }
        catch(PrinterException e)
           {
               JOptionPane.showMessageDialog(null, e.getMessage());
                }
        
    }//GEN-LAST:event_due_printActionPerformed

    private void tutor_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tutor_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tutor_idActionPerformed

    private void tutor_show_infoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tutor_show_infoActionPerformed
 Connection conn = getConnection();
     //   PreparedStatement pst = null;
        ResultSet rs = null;
     String   month=tutor_month.getSelectedItem().toString();
              int year = Calendar.getInstance().get(Calendar.YEAR);
            try {            
            PreparedStatement ps3 = conn.prepareStatement("SELECT tutor.id,tutor.NAME,tutor.CONTACT,tutorlist.description,tutor.institute,tutor.advance,tutor.firstpay,tutor.secondpay FROM tutor join tutorlist on tutor.id=tutorlist.id WHERE tutorlist.tyear="+year+" and "+month+" =true");
           
            rs = ps3.executeQuery();
            tchr_info.setModel(DbUtils.resultSetToTableModel(rs));

            conn.close();
            rs.close();
            ps3.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }

        
        
        
    }//GEN-LAST:event_tutor_show_infoActionPerformed

    private void tutor_descriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tutor_descriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tutor_descriptionActionPerformed

    private void tutor_save_infoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tutor_save_infoActionPerformed
 String month= tutor_month.getSelectedItem().toString();
        int year = Calendar.getInstance().get(Calendar.YEAR);
        try {
                Connection conn = getConnection();
                if (month.equals("January")) {
                    PreparedStatement ps = conn.prepareStatement("Insert into tutorlist(id,description,tyear,january) values (?,?,?,?)");
                    ps.setString(1, tutor_id.getText().toString());
                    ps.setString(2, tutor_description.getText().toString());
                    ps.setInt(3,year);
                    ps.setBoolean(4, true);
                    ps.executeUpdate();
                    ps.close();
                    
                }
                if (month.equals("February")) {
                    PreparedStatement ps = conn.prepareStatement("Insert into tutorlist(id,description,tyear,february) values (?,?,?,?)");
                    ps.setString(1, tutor_id.getText().toString());
                    ps.setString(2, tutor_description.getText().toString());
                    ps.setInt(3,year);
                    ps.setBoolean(4, true);
                    ps.executeUpdate();
                    ps.close();
                    
                }
                if (month.equals("March")) {
                  PreparedStatement ps = conn.prepareStatement("Insert into tutorlist(id,description,tyear,march) values (?,?,?,?)");
                    ps.setString(1, tutor_id.getText().toString());
                    ps.setString(2, tutor_description.getText().toString());
                    ps.setInt(3,year);
                    ps.setBoolean(4, true);
                    ps.executeUpdate();
                    ps.close();
                    
                }
                if (month.equals("April")) {
                   PreparedStatement ps = conn.prepareStatement("Insert into tutorlist(id,description,tyear,april) values (?,?,?,?)");
                    ps.setString(1, tutor_id.getText().toString());
                    ps.setString(2, tutor_description.getText().toString());
                    ps.setInt(3,year);
                    ps.setBoolean(4, true);
                    ps.executeUpdate();
                    ps.close();
                    
                }
                if (month.equals("May")) {
                   PreparedStatement ps = conn.prepareStatement("Insert into tutorlist(id,description,tyear,may) values (?,?,?,?)");
                    ps.setString(1, tutor_id.getText().toString());
                    ps.setString(2, tutor_description.getText().toString());
                    ps.setInt(3,year);
                    ps.setBoolean(4, true);
                    ps.executeUpdate();
                    ps.close();
                    
                }
                if (month.equals("June")) {
                   PreparedStatement ps = conn.prepareStatement("Insert into tutorlist(id,description,tyear,june) values (?,?,?,?)");
                    ps.setString(1, tutor_id.getText().toString());
                    ps.setString(2, tutor_description.getText().toString());
                    ps.setInt(3,year);
                    ps.setBoolean(4, true);
                    ps.executeUpdate();
                    ps.close();
                    
                }
                if (month.equals("July")) {
                    PreparedStatement ps = conn.prepareStatement("Insert into tutorlist(id,description,tyear,july) values (?,?,?,?)");
                    ps.setString(1, tutor_id.getText().toString());
                    ps.setString(2, tutor_description.getText().toString());
                    ps.setInt(3,year);
                    ps.setBoolean(4, true);
                    ps.executeUpdate();
                    ps.close();
                    
                }
                if (month.equals("August")) {
                   PreparedStatement ps = conn.prepareStatement("Insert into tutorlist(id,description,tyear,august) values (?,?,?,?)");
                    ps.setString(1, tutor_id.getText().toString());
                    ps.setString(2, tutor_description.getText().toString());
                    ps.setInt(3,year);
                    ps.setBoolean(4, true);
                    ps.executeUpdate();
                    ps.close();
                    
                }
                if (month.equals("September")) {
                  PreparedStatement ps = conn.prepareStatement("Insert into tutorlist(id,description,tyear,september) values (?,?,?,?)");
                    ps.setString(1, tutor_id.getText().toString());
                    ps.setString(2, tutor_description.getText().toString());
                    ps.setInt(3,year);
                    ps.setBoolean(4, true);
                    ps.executeUpdate();
                    ps.close();
                    
                }
                if (month.equals("October")) {
                   PreparedStatement ps = conn.prepareStatement("Insert into tutorlist(id,description,tyear,october) values (?,?,?,?)");
                    ps.setString(1, tutor_id.getText().toString());
                    ps.setString(2, tutor_description.getText().toString());
                    ps.setInt(3,year);
                    ps.setBoolean(4, true);
                    ps.executeUpdate();
                    ps.close();
                    
                }
                if (month.equals("November")) {
                   PreparedStatement ps = conn.prepareStatement("Insert into tutorlist(id,description,tyear,november) values (?,?,?,?)");
                    ps.setString(1, tutor_id.getText().toString());
                    ps.setString(2, tutor_description.getText().toString());
                    ps.setInt(3,year);
                    ps.setBoolean(4, true);
                    ps.executeUpdate();
                    ps.close();
                    
                }
                if (month.equals("December")) {
                 PreparedStatement ps = conn.prepareStatement("Insert into tutorlist(id,description,tyear,december) values (?,?,?,?)");
                    ps.setString(1, tutor_id.getText().toString());
                    ps.setString(2, tutor_description.getText().toString());
                    ps.setInt(3,year);
                    ps.setBoolean(4, true);
                    ps.executeUpdate();
                    ps.close();
                    
                }
               

                conn.close();
               
                rs.close();
        }
         catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        
         JOptionPane.showMessageDialog(null, "Saved");
         tutor_id.setText("");
         tutor_description.setText("");

    }//GEN-LAST:event_tutor_save_infoActionPerformed

    private void combosubjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combosubjActionPerformed

           Connection conn = getConnection();
           ArrayList<String> lst=new ArrayList<>();
         // String[] lst=new String[];
        try{
            
            PreparedStatement ps = conn.prepareStatement("select batch FROM batchlist where subject=?");
            ps.setString(1, combosubj.getSelectedItem().toString());
             rs = ps.executeQuery();
 while (rs.next()) {
     
            lst.add(rs.getString("batch"));
               }
 

        ps.close();
        rs.close();
        }
        catch(Exception e){
e.printStackTrace();
// JOptionPane.showMessageDialog(null, e.getMessage());
        }
        DefaultComboBoxModel model;
        model = new DefaultComboBoxModel(lst.toArray());
                    btchcombo.setModel( model );
        
        
        
    }//GEN-LAST:event_combosubjActionPerformed

    private void batchsubcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batchsubcomboActionPerformed

           Connection conn = getConnection();
           ArrayList<String> lst=new ArrayList<>();
        
         lst.add("All");
        try{
            
            PreparedStatement ps = conn.prepareStatement("select batch FROM batchlist where subject=?");
            ps.setString(1, batchsubcombo.getSelectedItem().toString());
             rs = ps.executeQuery();
 while (rs.next()) {
     
            lst.add(rs.getString("batch"));
               }
 

        ps.close();
        rs.close();
        }
        catch(Exception e){
e.printStackTrace();
// JOptionPane.showMessageDialog(null, e.getMessage());
        }
        DefaultComboBoxModel model;
        model = new DefaultComboBoxModel(lst.toArray());
                    batchbatchcombo.setModel( model );
        
        

    }//GEN-LAST:event_batchsubcomboActionPerformed
    public void searchTableContents(String searchString) {
        originalTableModel = (Vector) ((DefaultTableModel) tchr_info.getModel()).getDataVector().clone();
        //add document listener to jtextfield to search contents as soon
        DefaultTableModel currtableModel = (DefaultTableModel) tchr_info.getModel();
        //To empty the table before search
        currtableModel.setRowCount(0);
        //To search for contents from original table content
        for (Object rows : originalTableModel) {
            Vector rowVector = (Vector) rows;
            for (Object column : rowVector) {
                if (column.toString().contains(searchString)) {
                    //content found so adding to table
                    currtableModel.addRow(rowVector);
                    break;
                }
            }

        }
    }

    
    public int getRecipID(){
        int recpID = 0;
         Connection conn = getConnection();
        try{
            
            PreparedStatement ps = conn.prepareStatement("select * FROM passwordtable where password='receipID'");
             rs = ps.executeQuery();
 if (rs.next()) {
                 recpID = rs.getInt("serial");
               }
        }
        catch(Exception e){
             JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        
        return recpID;
        
    }
    
    
    
    public void IncrementReceipID(int recpid){
        
          Connection conn = getConnection();
          
          recpid++;
          
        try{
            
            PreparedStatement ps = conn.prepareStatement("UPDATE  passwordtable set serial=? WHERE password='receipID'");
              ps.setInt(1, recpid);
              ps.executeUpdate();
        }
        catch(Exception e){
             JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        
    }
    
    public void income_amount(int roll, int amount) {

        int receipID= getRecipID();
        String broll= bank_roll.toString();
        try {

            Connection conn = getConnection();
           
            PreparedStatement ps
                    = conn.prepareStatement("insert into income(id,name,amount,idate,receipid,receivedby ) values(?,?,?,?,?,?)");

            ps.setInt(1, roll);
            ps.setString(2, banksttchrcombo.getSelectedItem().toString());
          
            ps.setInt(3, amount);
            //ps.setString(4, ((JTextField) dbtcrddatechoos.getDateEditor().getUiComponent()).getText());
            ps.setString(4,currentdate);
            ps.setInt(5, receipID);
           ps.setString(6,recevdBY_txt.getText().toString());
            ps.executeUpdate();
            
            String year = yrcombo.getSelectedItem().toString();

             PreparedStatement ps2
                        = conn.prepareStatement("SELECT * FROM BANK" + year + "  WHERE ROLL=?");
                ps2.setString(1, bank_roll.getText());
                rs = ps2.executeQuery();
                bank_table.setModel(DbUtils.resultSetToTableModel(rs));
                conn.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        
        IncrementReceipID(receipID);

    }

    public void expense_amount(int roll, int amount) {
 int receipID= getRecipID();
 
        try {

            Connection conn = getConnection();
            //int money=  Integer.parseInt(bank_money.getText().toString());
            PreparedStatement ps
                    = conn.prepareStatement("insert into expense(id,name,amount,edate,receipid) values(?,?,?,?,?)");

            ps.setInt(1, roll);
            ps.setString(2, banksttchrcombo.getSelectedItem().toString());
            ps.setInt(3, amount);
           ps.setString(4, currentdate);
           ps.setInt(5,receipID);
// ps.setString(4, ((JTextField) dbtcrddatechoos.getDateEditor().getUiComponent()).getText());
                       ps.executeUpdate();
           
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        
        
        IncrementReceipID(receipID);
    }

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
            java.util.logging.Logger.getLogger(workstation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(workstation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(workstation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(workstation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new workstation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable SUBGROUPTABLE;
    private javax.swing.JButton ac_tchr;
    private javax.swing.JTextField addbatch;
    private javax.swing.JButton addbatchbt;
    private javax.swing.JButton addgrpbtch;
    private javax.swing.JTextField addsubbox;
    private javax.swing.JTextField bank_money;
    private javax.swing.JComboBox<String> bank_monthcombo;
    private javax.swing.JTextArea bank_output;
    private javax.swing.JButton bank_print;
    private javax.swing.JTextField bank_roll;
    private javax.swing.JButton bank_save;
    private javax.swing.JTable bank_table;
    private javax.swing.JComboBox<String> banksttchrcombo;
    private javax.swing.JComboBox<String> batchbatchcombo;
    private javax.swing.JComboBox<String> batchsubcombo;
    private javax.swing.JComboBox<String> btchcombo;
    private javax.swing.JButton btn_insertsdata;
    private javax.swing.JButton chng_pass;
    private javax.swing.JComboBox<String> combosubj;
    private javax.swing.JButton del_tchr_info;
    private javax.swing.JButton del_tutor_info;
    private javax.swing.JButton delrecord;
    private javax.swing.JButton due_print;
    private javax.swing.JComboBox<String> duecombo;
    private com.toedter.calendar.JDateChooser exp_cal;
    private javax.swing.JTextField expense_ammou_txt1;
    private javax.swing.JTextField expense_name_txt1;
    private javax.swing.JTable grpbtchtable;
    private javax.swing.JTextField income_ammou_txt;
    private com.toedter.calendar.JDateChooser income_calender;
    private javax.swing.JTextField income_name_txt;
    private javax.swing.JComboBox<String> infocombo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField newpass;
    private javax.swing.JPasswordField passinbox2;
    private javax.swing.JTextField prvspass;
    private javax.swing.JTextField recevdBY_txt;
    private javax.swing.JTextField rmvbatch;
    private javax.swing.JButton rmvbatchbtn;
    private javax.swing.JComboBox<String> rmvbatchcmbo;
    private javax.swing.JComboBox<String> rmvsubj;
    private javax.swing.JTextField rmvsubject;
    private javax.swing.JTextField rolltoupdate;
    private javax.swing.JLabel rowcount;
    private javax.swing.JButton save_expense;
    private javax.swing.JButton save_income;
    private javax.swing.JButton searchbtchgrp;
    private javax.swing.JComboBox<String> settings_subject_combo;
    private javax.swing.JLabel sinfototal;
    private javax.swing.JTextArea sinfotxtarea;
    private javax.swing.JTable stdntinfotable;
    private javax.swing.JButton subaddbtn;
    private javax.swing.JTable tchr_info;
    private javax.swing.JLabel tchr_rowcount;
    private javax.swing.JTextField tchrrollbox;
    private javax.swing.JTextField tutor_description;
    private javax.swing.JTextField tutor_id;
    private javax.swing.JButton tutor_info;
    private javax.swing.JComboBox<String> tutor_month;
    private javax.swing.JButton tutor_save_info;
    private javax.swing.JButton tutor_show_info;
    private javax.swing.JTextField txt_class;
    private javax.swing.JTextField txt_sName;
    private javax.swing.JTextField txt_sRoll;
    private javax.swing.JTextField txt_schlname;
    private javax.swing.JTextField txt_smbl;
    private javax.swing.JTextField up_class;
    private javax.swing.JTextField up_mblno;
    private javax.swing.JTextField up_name;
    private javax.swing.JTextField up_schl;
    private javax.swing.JButton updb;
    private javax.swing.JComboBox<String> yrcombo;
    private javax.swing.JComboBox<String> yrcombo2;
    // End of variables declaration//GEN-END:variables
}

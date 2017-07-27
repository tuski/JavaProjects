package com.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.awt.event.ActionEvent;

public class AgeCalculator {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgeCalculator window = new AgeCalculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AgeCalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 590, 377);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString(" dd/MM/yyyy");
		dateChooser.setBounds(59, 30, 159, 32);
		frame.getContentPane().add(dateChooser);
		
		JLabel resulttxt = new JLabel("Your Age is: ");
		resulttxt.setBounds(10, 129, 554, 112);
		frame.getContentPane().add(resulttxt);
		
		JLabel lblEnterYourBirthday = new JLabel("Enter your Birthday");
		lblEnterYourBirthday.setBounds(61, 11, 146, 14);
		frame.getContentPane().add(lblEnterYourBirthday);
		
		
		JButton calculatebtn = new JButton("Calculate");
		calculatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
				
				String inputDate= sdf.format(dateChooser.getDate());
			String arr[]= inputDate.split("/");	
				
			int day= Integer.parseInt(arr[0]);
			int month= Integer.parseInt(arr[1]);
			int year= Integer.parseInt(arr[2]);
			
			LocalDate todayDate= LocalDate.now();
			LocalDate birthday= LocalDate.of(year, month, day);
			
		
			Period p= Period.between(birthday, todayDate);
			
			
			Date dob=null;
			try {
				 dob= sdf.parse(inputDate);
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
			
			long dob_ms= System.currentTimeMillis()- dob.getTime();
			long sec=(long) (dob_ms/1000);
			
			long min=(long) (sec/60);
			long hr= (long) (min/60);
			resulttxt.setText("Your Age is: "+p.getYears()+" Years "+p.getMonths()+" Months "+p.getDays()+" Days "+" Hours= "+hr+" Minute= "+min+" Second= "+sec);
			
			}
		});
		
		calculatebtn.setBounds(68, 90, 89, 23);
		frame.getContentPane().add(calculatebtn);
	}
}

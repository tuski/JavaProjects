package com.main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class MyAppWindow {

	private JFrame frame;
	private JTextField myTxtField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyAppWindow window = new MyAppWindow();
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
	public MyAppWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel myLebel = new JLabel("sample text");
		myLebel.setBounds(36, 0, 114, 43);
		frame.getContentPane().add(myLebel);
		
		myTxtField = new JTextField();
		myTxtField.setBounds(36, 49, 193, 20);
		frame.getContentPane().add(myTxtField);
		myTxtField.setColumns(10);
		
		JButton chngButton = new JButton("Change");
		chngButton.setBounds(36, 80, 89, 23);
		
		String str="10/2/2017";
		String txtarr[]= str.split("/");
		
		
		chngButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				String txt= myTxtField.getText();
				if(!txt.isEmpty()){
					myLebel.setText(txt);
					myTxtField.setText("");
				}
					
			}
		});
		frame.getContentPane().add(chngButton);
		
		
	}
}

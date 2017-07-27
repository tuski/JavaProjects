/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

import javax.swing.JOptionPane;

/**
 *
 * @author tuski-Revolve
 */
public class recevedByException extends Exception {
    
    	public recevedByException(String msg) {
		super(msg);
		          JOptionPane.showMessageDialog(null,"Please Enter Receved By name");
	
	}

    
}

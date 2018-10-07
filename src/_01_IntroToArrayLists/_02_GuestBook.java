package _01_IntroToArrayLists;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
	JPanel panel=new JPanel();
	JFrame frame=new JFrame();
	JButton button1=new JButton("Add Name");
	JButton button2=new JButton("View Names");
	ArrayList<String> names = new ArrayList<String>();
	public static void main(String[] args) {
		new _02_GuestBook();
	}
	public _02_GuestBook() {
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.add(panel);
		panel.add(button1);
		panel.add(button2);
		button1.addActionListener(this);
		button2.addActionListener(this);
		
	}
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button1) {
			String answer=JOptionPane.showInputDialog("Enter a name");
			names.add(answer);
		}
		if (e.getSource() == button2) {
			for (int i = 1; i < names.size(); i++) {
			JOptionPane.showMessageDialog(null, "Guest #" + i + ": " + names.get(i));
			}

		}
		
	}
	
	
	
}

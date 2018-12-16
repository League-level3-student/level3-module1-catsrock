package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener{
	HashMap<Integer, String> thing= new HashMap<Integer, String>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton but1 = new JButton();
	JButton but2 = new JButton();
	JButton but3 = new JButton();
	JButton but4 = new JButton();

	public static void main(String[] args) {
		new _02_LogSearch();
	}

	public _02_LogSearch() {
		frame.add(panel);
		panel.add(but1);
		but1.addActionListener(this);
		panel.add(but2);
		but2.addActionListener(this);
		panel.add(but3);
		but3.addActionListener(this);
		panel.add(but4);
		but4.addActionListener(this);
		frame.pack();
		frame.setVisible(true);
	}

	/*
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 *
	 * Create a GUI with three buttons. Button 1: Add Entry When this button is
	 * clicked, use an input dialog to ask the user to enter an ID number. After an
	 * ID is entered, use another input dialog to ask the user to enter a name. Add
	 * this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID When this button is clicked, use an input dialog to
	 * ask the user to enter an ID number. If that ID exists, display that name to
	 * the user. Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List When this button is clicked, display the entire list in a
	 * message dialog in the following format: ID: 123 Name: Harry Howard ID: 245
	 * Name: Polly Powers ID: 433 Name: Oliver Ortega etc...
	 * 
	 * When this is complete, add a fourth button to your window. Button 4: Remove
	 * Entry When this button is clicked, prompt the user to enter an ID using an
	 * input dialog. If this ID exists in the HashMap, remove it. Otherwise, notify
	 * the user that the ID is not in the list.
	 *
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(but1)) {
			String entry=JOptionPane.showInputDialog("Enter an ID number");
			int iD=Integer.parseInt(entry);
			String name=JOptionPane.showInputDialog("Enter a name");
			thing.put(iD, name);
		}
		else if (e.getSource().equals(but2)) {
			int search=Integer.parseInt(JOptionPane.showInputDialog("Enter an ID number"));
			System.out.println(thing.get(search));
		}
		else if (e.getSource().equals(but3)) {
			for (Integer i: thing.keySet()) {
				System.out.println("ID: "+i+" Name: "+thing.get(i));
			}
		}
		else if (e.getSource().equals(but4)) {
			int remove=Integer.parseInt(JOptionPane.showInputDialog("Enter an ID"));
			int origSize=thing.size();	
			thing.remove(remove);
			int afterSize=thing.size();
			if (origSize==afterSize) {
				JOptionPane.showMessageDialog(null, "Sorry, this ID does not exist");
			}
		}
	}

}

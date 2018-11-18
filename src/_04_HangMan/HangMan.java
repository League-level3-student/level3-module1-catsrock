package _04_HangMan;

import javax.swing.JOptionPane;

public class HangMan{
	public static void main(String[] args) {
		String answer=JOptionPane.showInputDialog("Give a number from 1-266 inclusive");
		int num1=Integer.parseInt(answer);
		Utilities.getTotalWordsInFile("dictionary.txt");
	}
	
	
}

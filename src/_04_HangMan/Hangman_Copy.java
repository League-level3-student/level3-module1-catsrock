package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman_Copy implements KeyListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	static Stack<String> words = new Stack<String>();
	int lives = 7;

	public static void main(String[] args) {
		new Hangman_Copy();
	}

	public Hangman_Copy() {
		String answer = JOptionPane.showInputDialog("Give a number from 1-266 inclusive");
		int d = Integer.parseInt(answer);
		for (int i = 0; i < d; i++) {
			String s = Utilities.readRandomLineFromFile("dictionary.txt");
			while (words.contains(s)) {
				s = Utilities.readRandomLineFromFile("dictionary.txt");
			}
			words.push(s);
		}
		System.out.println(words.peek());
		for (int i = 0; i < words.peek().length(); i++) {
			label.setText(label.getText() + "_");
		}
		frame.add(panel);
		panel.add(label);
		frame.setVisible(true);
		frame.pack();
		frame.addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		ArrayList<Integer> thing = new ArrayList<>();
		boolean deductLife = true;
		char c = e.getKeyChar();
		for (int i = 0; i < words.peek().length(); i++) {
			if (c == words.peek().charAt(i)) {
				thing.add(i);
			}
		}
		String oldString = label.getText();
		String newString = "";
		for (int i = 0; i < oldString.length(); i++) {
			if (thing.contains(i)) {
				newString += c;
				deductLife = false;
			} else {
				newString += oldString.charAt(i);
			}
		}
		label.setText(newString);
		System.out.println(lives);
		if (deductLife) {
			lives--;
			if (lives == 0) {
				JOptionPane.showMessageDialog(null, "GAME OVER ;P");
				System.exit(0);
			}
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
		}
		if (!newString.contains("_")) {
			words.pop();
			if (words.isEmpty()) {
				System.exit(0);
			}
			label.setText("");
			for (int i = 0; i < words.peek().length(); i++) {
				label.setText(label.getText() + "_");
			}
			lives = 7;
		}
	}

	public void keyPressed(KeyEvent e) {

	}

	public void keyReleased(KeyEvent e) {

	}
}

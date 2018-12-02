package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	Stack<String> words = new Stack<String>();
	String c;

	public static void main(String[] args) {
		new HangMan();
	}

	public HangMan() {

		String answer = JOptionPane.showInputDialog("Give a number from 1-266 inclusive");
		Utilities.getTotalWordsInFile("dictionary.txt");
		int num1 = Integer.parseInt(answer);
		for (int i = 0; i < num1; i++) {
			String s = Utilities.readRandomLineFromFile("dictionary.txt");
			while (words.contains(s)) {
				s = Utilities.readRandomLineFromFile("dictionary.txt");
			}
			words.push(s);
		}
		System.out.println(words.peek());
		words.pop();

		frame.add(panel);
		panel.add(label);
		for (int i = 0; i < words.peek().length(); i++) {
			label.setText(label.getText() + "_");
		}
		frame.addKeyListener(this);
		frame.setSize(100, 100);
		frame.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("TEST");
		c = "" + (char) e.getKeyCode();
		if (Character.isLetter(c.charAt(0))) {
			// label.setText(label.getText()+c);
			ArrayList<Integer> indicesFound = new ArrayList<Integer>();
			int previous = 0;
			for (int i = 0; i < words.peek().length(); i++) {
				int newIndex = words.peek().indexOf(c, previous);
				previous = newIndex;
				if (indicesFound.contains(newIndex) || newIndex == -1) {
					break;
				}
				indicesFound.add(newIndex);
			}
			System.out.println(indicesFound);
			String getText = label.getText();
			String newText = "";
			int start = 0;
			for (int i = 0; i < indicesFound.size(); i++) {
				newText += getText.substring(start, indicesFound.get(i));
				start = indicesFound.get(i);
				newText += c;
			}
			newText += getText.substring(indicesFound.get(indicesFound.size() - 1), getText.length());
			System.out.println(getText);
			System.out.println(newText);
			label.setText(newText);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}

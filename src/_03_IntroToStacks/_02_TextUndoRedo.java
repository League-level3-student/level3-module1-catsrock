package _03_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	public static void main(String[] args) {
		new _02_TextUndoRedo();
	}

	/*
	 * Create a JFrame with a JPanel and a JLabel.
	 *
	 * Every time a key is pressed, add that character to the JLabel. It should look
	 * like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character
	 * is erased from the JLabel. Save that deleted character onto a Stack of
	 * Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed,
	 * the top Character is popped off the Stack and added back to the JLabel.
	 * 
	 */
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	Stack<Character> text = new Stack<Character>();
	Stack<Character> characters = new Stack<Character>();
	boolean type = true;

	public _02_TextUndoRedo() {

		frame.add(panel);
		panel.add(label);
		frame.setSize(500, 500);
		frame.setVisible(true);
		label.addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("TEST");
		char c = (char) e.getKeyCode();
		if (Character.isLetter(c)) {
			// String temp = label.getText();
			label.setText(label.getText() + c);
			type = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			characters.push(label.getText().charAt(label.getText().length() - 1));
			String s = label.getText().substring(0, label.getText().length() - 1);
			label.setText(s);
			for (int i = 0; i < s.length(); i++) {
				text.push(s.charAt(i));
			}
			type = false;

		}
		if (e.getKeyCode() == KeyEvent.VK_Q) {
			if (type) {
				characters.push(label.getText().charAt(label.getText().length() - 1));
				String s = label.getText().substring(0, label.getText().length() - 1);
				label.setText(s);
				for (int i = 0; i < s.length(); i++) {
					text.push(s.charAt(i));
				}
				type = false;
			} else {
				label.setText(label.getText() + characters.pop());
				type = true;
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}

package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements ActionListener{
	ArrayList <Song> songs=new ArrayList<Song>();
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	JButton button=new JButton("Surprise Me!");
	Random r=new Random();
	
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.
				//Song song1=new Song("piano.mp3");
				//song1.play();
				frame.add(panel);
				panel.add(button);
				frame.setVisible(true);
				frame.setSize(500, 500);
				songs.add(new Song("piano.mp3"));
				songs.add(new Song("demo.mp3"));
				songs.add(new Song("yiruma.mp3"));
				songs.add(new Song("arabesque_debussy.mp3"));
				button.addActionListener(this);
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */
		
	}
	
	public static void main(String[] args) {
		new _06_IPodShuffle();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int order=r.nextInt(songs.size());
		if (e.getSource()==button) {
		
			for (Song song : songs) {
			song.stop();
			
		}
			songs.get(order).play();
				
			
		}
	}
}
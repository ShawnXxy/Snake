package game;

import java.awt.Color;

import javax.swing.JFrame;

public class Snake {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// create a game window
		JFrame window = new JFrame("Snake");
		window.setBounds(10, 10, 1900, 1075);
//		window.setSize(1980, 1080);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		window.setBackground(Color.black);
		// setting up canvas
		SnakePanel panel = new SnakePanel();
		window.add(panel);
		
		window.setVisible(true);
	}

}

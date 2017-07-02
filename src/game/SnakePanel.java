package game;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class SnakePanel extends JPanel {
	
	// setting up for inserted images
//	ImageIcon title = new ImageIcon("title.jpg");
	ImageIcon up = new ImageIcon("up.png");
	ImageIcon down = new ImageIcon("down.png");
	ImageIcon right = new ImageIcon("right.png");
	ImageIcon left = new ImageIcon("left.png");
	ImageIcon body = new ImageIcon("body.png");
	ImageIcon food = new ImageIcon("food.png");

	public SnakePanel() {
		this.setFocusable(true);
	}
	
	public void paint(Graphics pen) {
		this.setBackground(Color.BLACK);
//		title.paintIcon(this, pen, 25, 11);
//		pen.fillRect(25,  75,  850, 600);
	}
}

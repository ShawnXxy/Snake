package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SnakePanel extends JPanel implements KeyListener, ActionListener{
	
	// setting up for inserted images
//	ImageIcon title = new ImageIcon("title.jpg");
	ImageIcon up = new ImageIcon("up.png");
	ImageIcon down = new ImageIcon("down.png");
	ImageIcon right = new ImageIcon("right.png");
	ImageIcon left = new ImageIcon("left.png");
	ImageIcon body = new ImageIcon("body.png");
	ImageIcon food = new ImageIcon("food.png");
	
	// setting snake
	int[] snakex = new int[750]; // latitude
	int[] snakey = new int[750]; // longitude
	int length = 3; // initial length
	String direction = "right";
	// setting food randomly
	Random rand = new Random();
	int foodx = rand.nextInt(74) * 25 + 25;
	int foody = rand.nextInt(41) * 25 + 75;
	
	boolean isStarted = false;
	boolean gameOver = false;
	
	Timer timer = new Timer(100, this);

	public SnakePanel() {
		this.setFocusable(true);
		this.addKeyListener(this); // check if key is pressed
		init();
		timer.start();
	}
	
	public void paint(Graphics pen) {
		super.paint(pen);
//		this.paint(pen);
		this.setBackground(Color.BLACK);
//		title.paintIcon(this, pen, 25, 11);
//		pen.fillRect(25,  75,  850, 600);
		
		if (!isStarted	) {
//			super.paint(pen);
			pen.setColor(Color.white);
			pen.setFont(new Font("arial", Font.BOLD, 30));
			pen.drawString("Press Space to Start/pause game", 700, 700);
		}
		
		// draw snake head
		if (direction.equals("right")) {
			right.paintIcon(this, pen, snakex[0], snakey[0]);
		} else if  (direction.equals("left")) {
			left.paintIcon(this, pen, snakex[0], snakey[0]);
		} else if (direction.equals("up")) {
			up.paintIcon(this, pen, snakex[0], snakey[0]);
		} else if (direction.equals("down")) {
			down.paintIcon(this, pen, snakex[0], snakey[0]);
		}
		// draw snake body
		for (int i  = 1; i < length; i++) {
			body.paintIcon(this, pen, snakex[i], snakey[i]);
		}
		// draw food
		food.paintIcon(this, pen, foodx, foody);
		
		// game over
		if (gameOver) {
			pen.setColor(Color.WHITE);
			pen.setFont(new Font("arial", Font.BOLD, 30));
			pen.drawString("Game Over! Your snake is died! Press Space to restart.", 700, 700);
		}
	}
	
	// initializing snake
	public void init() {
		length = 3;
		direction = "right";
		snakex[0] = 100;
		snakey[0] = 100;
		snakex[1] = 75;
		snakey[1] = 100;
		snakex[2] = 50;
		snakey[2] = 100;
		
		isStarted = false;
		gameOver = false;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_SPACE) { // start/pause game
			if (gameOver) {
				init();
			}
			isStarted = ! isStarted;
//			repaint();
		} else if (keyCode == KeyEvent.VK_UP && direction != "down") { // change direction
			direction = "up";
		} else if (keyCode == KeyEvent.VK_DOWN && direction != "up") {
			direction = "down";
		} else if (keyCode == KeyEvent.VK_RIGHT && direction != "left") {
			direction = "right";
		} else if (keyCode == KeyEvent.VK_LEFT && direction != "right") {
			direction = "left";
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		timer.start();
		
		// move snake
		if (isStarted && gameOver == false) {
			// move body
			for (int i = length; i > 0; i--) {
				snakex[i] = snakex[i - 1];
				snakey[i] = snakey[i - 1];
			}
			// move head and check direction
			if (direction.equals("right")) {
				snakex[0] += 25;
				if (snakex[0] > 1850) {
//					snakex[0] = 25;
					gameOver = true;
				}
			} else if  (direction.equals("left")) {
				snakex[0] -= 25;
				if (snakex[0] < 25) {
//					snakex[0] = 1850;
					gameOver = true;
				}
			} else if (direction.equals("up")) {
				snakey[0] -= 25;
				if (snakey[0] < 75) {
//					snakey[0] = 1025;
					gameOver = true;
				}
			} else if (direction.equals("down")) {
				snakey[0] += 25;
				if (snakey[0] > 1025) {
//					snakey[0] = 75;
					gameOver = true;
				}
			}
			
			// eat
			if (snakex[0] == foodx && snakey[0] == foody) {
				length++;
				foodx = rand.nextInt(74) * 25 + 25;
				foody = rand.nextInt(41) * 25 + 75;
			}
			
			for (int i = 1; i < length; i++) {
				if (snakex[0] == snakex[i] && snakey[0] == snakey[i]) {
					gameOver = true;
				}
			}
		}
		repaint();
	}
}

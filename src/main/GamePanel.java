package main;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.KeyListener;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.desktop.ScreenSleepEvent;
import java.awt.Color;
import java.awt.Dimension;

public class GamePanel extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener {

	private static final String Thread = null;
	//SCREEN SETTINGS
	final int originalTileSize = 32; 			// 32x32 tiles
	final int originalScale = 2; 				// 2x scale

	final int tileSize = originalTileSize*originalScale;// 32*3 = 96 - 96x96 pixels
	final int maxScreenSize = 960;
	final int maxScreenCol = 32;
	final int maxScreenRow = 24;
	final int width = maxScreenCol * tileSize; 			// 32*96 = 3072 - 3072 pixels
	final int height = maxScreenRow * tileSize; 		// 24*96 = 2304 - 2304 pixels


	KeyHandler keyH = new KeyHandler();
	MouseHandler mouseH = new MouseHandler();

	// Set player's position
	int playerX = 0;
	int playerY = 0;
	int playerSpeed = 10;

	// GAME OBJECTS
	//public static Player player;
	//public static Map map;

	// GAME SETTINGS
	public GamePanel() {
		this.setPreferredSize(new Dimension(width, height));
		setFocusable(true);
		setBackground(Color.BLACK);
		requestFocus();
		addKeyListener(keyH);
		addMouseListener(mouseH);
		setFocusable(true);
	}
	// GAME THREAD
	private Thread thread;
	private boolean running;
	private final int FPS = 60;
	private final long targetTime = 1000 / FPS;

	// MAIN METHOD
	public void setupGame() {
		// TODO Auto-generated method stub
	}
	public void startGameThread() {
		// TODO Auto-generated method stub
		thread = new Thread(this);
		thread.start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		double drawInterval = 1000000000/FPS;
		double nextDrawTime = System.nanoTime()+drawInterval;

		while(thread != null) {
	//		long currentTime = System.nanoTime();
	//or	long currentTime2 = System.currentTimeMillis();

			update();
			repaint();


			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime/1000000;
				if(remainingTime<0) {
					remainingTime = 0;
				}

				thread.sleep((long) remainingTime);
				nextDrawTime += drawInterval;

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void update() {
		// TODO Auto-generated method stub
		if(keyH.up) {
			playerY -= playerSpeed;
		}
		else if(keyH.down) {
			playerY += playerSpeed;
		}
		else if(keyH.left) {
			playerX -= playerSpeed;
		}
		else if(keyH.right) {
			playerX += playerSpeed;
		}
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.WHITE);

		g2.fillRect(playerX, playerY, tileSize, tileSize);

		g2.dispose();

	}
	public static JFrame window;
	/*
	public static void main(String[] args) {
		window = new JFrame();
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Close (X) button
		window.setResizable(false); // User unable to resize the window
		window.setTitle("2D Adventure"); // Title of the Apps

		// Call GamePanel
		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);

		gamePanel.config.loadConfig();
		if (gamePanel.fullScreenOn == true) {
			window.setUndecorated(true);
		}

		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);

		gamePanel.setupGame();
		gamePanel.startGameThread();
	}
	*/

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

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

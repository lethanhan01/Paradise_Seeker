package main;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JPanel;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close (X) button
		window.setResizable(false); // User unable to resize the window
		window.setTitle("Pradise Seeker"); // Title of the Apps

		// Call GamePanel
		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		/*
		gamePanel.config.loadConfig();
		if (gamePanel.fullScreenOn == true) {
			window.setUndecorated(true);
		}
	*/
		gamePanel.setupGame();
		gamePanel.startGameThread();
	}

}

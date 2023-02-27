package main;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// CLOSES THE WINDOW WHEN PRESSING X
		window.setResizable(false);
		window.setTitle("<3");
		
		
		
		GamePannel gamePanel = new GamePannel();
		window.add(gamePanel);
		
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);

		
		gamePanel.setupGame();
		gamePanel.startGameThread();
	}

}

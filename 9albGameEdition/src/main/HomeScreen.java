package main;

import java.awt.EventQueue;
import java.awt.Graphics;

import java.awt.Image;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JPanel;







public class HomeScreen extends JFrame {

	
	ImageIcon imageIcon = new ImageIcon("res/home.png");
	 JButton playButton = new JButton();
	 JButton settingButton = new JButton();
	 JButton exitButton = new JButton();
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeScreen frame = new HomeScreen();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**   
	 * Create the frame.
	 */
	public HomeScreen() {
		
		 Image backgroundImage = Toolkit.getDefaultToolkit().getImage("res/home.png"); // load the background image
		 JPanel panel = new JPanel() {
	            @Override
	            protected void paintComponent(Graphics g) {
	                super.paintComponent(g);
	                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null); // draw the background image

	            }
	        };
	        playButton.setBounds(164, 220, 217, 51);
	        settingButton.setBounds(164, 318, 217, 51);
	        exitButton.setBounds(164, 414, 217, 51);
	        panel.add(playButton);
	        
	        playButton.setOpaque(false);
	        playButton.setContentAreaFilled(false);
	        playButton.setBorderPainted(false);
	        panel.add(settingButton);
	        
	        settingButton.setOpaque(false);
	        settingButton.setContentAreaFilled(false);
	        settingButton.setBorderPainted(false);
	        
	        exitButton.setOpaque(false);
	        exitButton.setContentAreaFilled(false);
	        exitButton.setBorderPainted(false);
	        panel.add(exitButton);
            
            panel.setLayout(null);
            add(panel);
	        setSize(768, 576); // set the size of the frame
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set the default close operation
	        setVisible(true); // show the frame
	        setResizable(false);
	        
	        
	        playButton.addActionListener((ActionListener) new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                System.out.println("hi");
	                playButton.setBorderPainted(true);
	              
	                Main.main(new String[]{});
	                dispose();
	                                
	            }
	        });
	        
	        
				
		
	
	}
	
}
	
	
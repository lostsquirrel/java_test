package demo.gui.swing;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class NotHelloWorld {

	public static void main(String[] args)  {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new JFrame() {
					
					private static final long serialVersionUID = 1L;

					{
						setTitle("NotHelloWorld");
						setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
						JPanel panel = new JPanel(){

							private static final long serialVersionUID = 1L;
							
							public void paintComponent(Graphics g) {
								g.drawString("Not a Hello, World program", MESSAGE_X, MESSAGE_Y);
							}
							
							public static final int MESSAGE_X = 75;
							
							public static final int MESSAGE_Y = 100;
						};
						add(panel);
					}
					public static final int DEFAULT_WIDTH = 300;
					
					public static final int DEFAULT_HEIGHT = 200;
				};
				
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
			
		});
	}
}

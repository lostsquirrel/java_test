package demo.gui.swing;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class TestListFonts {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            JFrame frame = new JFrame(){
	            	private static final long serialVersionUID = 1L;

					{
						setTitle("DrawTest");
						setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
						// add panel to frame
						JComponent component = new JComponent() {

							private static final long serialVersionUID = 1L;

							public void paintComponent(Graphics g) {
								Graphics2D g2 = (Graphics2D) g;
								String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
								int h = 10;
								for (String fontName : fontNames){
									Font xbold14 = new Font(fontName, Font.BOLD, 14);
									g2.setFont(xbold14);
									g2.drawString(fontName, 15, h);
									h += 20;
								}
							}
						};
						add(component);
					}
					public static final int DEFAULT_WIDTH = 400;
					
					public static final int DEFAULT_HEIGHT = 400;
	            };
	            frame.setVisible(true);
	        }
	    });
		
	}
}

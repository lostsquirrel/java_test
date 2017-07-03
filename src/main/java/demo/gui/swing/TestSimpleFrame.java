package demo.gui.swing;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class TestSimpleFrame {

	public static void main(String[] args) {
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		
		
		JFrame frame = new JFrame() {
			
			private static final long serialVersionUID = 1L;

			{
				super.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
			}
			public static final int DEFAULT_WIDTH = 300;
			
			public static final int DEFAULT_HEIGHT = 200;
		};
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("第一个窗口");
		Image img = kit.getImage("19802.png");
		frame.setIconImage(img);
		frame.setLocation(screenWidth/6, screenHeight/6);
		frame.setSize(screenWidth / 2, screenHeight / 2);
//		frame.setBounds(500, 300, 500, 300);
		frame.setResizable(false);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}
}

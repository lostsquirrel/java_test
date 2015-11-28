package test.gui.swing;

import javax.swing.JFrame;

public class TestSimpleFrame {

	public static void main(String[] args) {
		
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
//		Image image = new ;
//		frame.setIconImage(image);
//		frame.setLocation(500, 300);
//		frame.setBounds(500, 300, 500, 300);
		frame.setResizable(false);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}
}

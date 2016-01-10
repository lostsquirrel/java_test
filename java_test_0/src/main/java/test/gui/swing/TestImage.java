package test.gui.swing;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class TestImage {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				ImageFrame frame = new ImageFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}

/**
 * A frame with an image component
 */
class ImageFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public ImageFrame() {
		setTitle("ImageTest");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		// add component to frame

		ImageComponent component = new ImageComponent();
		add(component);
	}

	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200;

	/**
	 * A component that displays a tiled image
	 */
	class ImageComponent extends JComponent {

		private static final long serialVersionUID = 1L;

		public ImageComponent() {
			// acquire the image
			try {
				image = ImageIO.read(new File("/home/lisong/git-repos/java/java_test/java_test_0/src/main/java/test/gui/swing/baidu.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void paintComponent(Graphics g) {
			if (image == null)
				return;

			int imageWidth = image.getWidth(this);
			int imageHeight = image.getHeight(this);

			// draw the image in the top-left corner

			g.drawImage(image, 0, 0, null);
			// tile the image across the component

			for (int i = 0; i * imageWidth <= getWidth(); i++)
				for (int j = 0; j * imageHeight <= getHeight(); j++)
					if (i + j > 0)
						g.copyArea(0, 0, imageWidth, imageHeight, i * imageWidth, j * imageHeight);
		}

		private Image image;
	}
}
package demo.gui.gui.event.demo.car;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class ImagePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public static final int DEFAULT_WIDTH = 500;
	
	private Image image;
	
	public ImagePanel() {
		String urlName = "http://cdn4.iconfinder.com/data/icons/car-silhouettes/1000/sportcar-128.png";
		try {
			image = ImageIO.read(new URL(urlName));
			Dimension preferredSize = new Dimension();
			preferredSize.setSize(DEFAULT_WIDTH, image.getHeight(null));
			this.setPreferredSize(preferredSize);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Border border = new LineBorder(Color.RED);
		this.setBorder(border);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 14, 1, null);
	}
	
}

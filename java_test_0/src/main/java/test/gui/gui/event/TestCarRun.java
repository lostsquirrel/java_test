package test.gui.gui.event;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TestCarRun {

	private static final Log log = LogFactory.getLog(TestCarRun.class);

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				log.debug("test start...");
				System.out.println("test start...");
				CarFrame frame = new CarFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				LayoutManager manager = new FlowLayout();
				frame.setLayout(manager);
				frame.setVisible(true);
			}
		});
	}
}

class CarFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private static final Log log = LogFactory.getLog(CarFrame.class);

	public CarFrame() {
		log.debug("init CarFrame...");
		setTitle("Running Car");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
/*
		// 控制文本框
		JLabel label = new JLabel("car 1:", SwingConstants.RIGHT);
		JTextField textField = new JTextField(DEFAULT_SPEED, 20);

		JPanel cpanel = new JPanel();
		cpanel.add(label);
		cpanel.add(textField);
		cpanel.setBackground(Color.BLUE);
		JPanel rpanel1 = new JPanel();
//		rpanel1.setBackground(Color.GREEN);
//		rpanel1.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		String urlname = "http://cdn4.iconfinder.com/data/icons/car-silhouettes/1000/sportcar-128.png";
//		rpanel1.add(label);

		rpanel1.add(new JPanel() {

			private Image image;

			private static final long serialVersionUID = 1L;

			{
				log.debug("loading image start");
				System.out.println("loading image start");
				try {
//					image = ImageIO.read(new URL(urlname));
					image = ImageIO.read(new File("/home/lisong/git-repos/java/java_test/java_test_0/src/main/java/test/gui/swing/19802.png"));
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				log.debug(image);
				System.out.println(image);
			}

			public void paintComponent(Graphics g) {
//				super.paintComponent(g);
				Graphics2D g2 = (Graphics2D) g;
//				g2.drawLine(1, 1, 5000, 5000);
//				g2.draw(new Line2D.Double(0, 0, 500, 500));
				log.debug(image);
//				g.drawImage(image, 100, 100, null);
				System.out.println("paint finished...");
				
				double centerX = 500;
				double centerY = 500;
				double radius = 150;

				Ellipse2D circle = new Ellipse2D.Double();
				circle.setFrameFromCenter(centerX, centerY, centerX + radius, centerY + radius);
//				g2.draw(circle);
			}

		});
*/
		// add(cpanel);
//		 add(rpanel1);
		add(new ImagePanel());
		add(new JButton("xxoo"));
	}

	public static final String DEFAULT_SPEED = "20";

	public static final int DEFAULT_WIDTH = 500;
	public static final int DEFAULT_HEIGHT = 500;

}
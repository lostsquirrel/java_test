package test.gui.swing;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class TestDraw {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {

				JFrame frame = new JFrame() {

					private static final long serialVersionUID = 1L;

					{
						setTitle("DrawTest");
						setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
						// add panel to frame
						JComponent component = new JComponent() {

							private static final long serialVersionUID = 1L;

							public void paintComponent(Graphics g) {
								Graphics2D g2 = (Graphics2D) g;

								// draw a rectangle

								double leftX = 100;
								double topY = 100;
								double width = 200;
								double height = 150;

								Rectangle2D rect = new Rectangle2D.Double(leftX, topY, width, height);
								Point2D p1 = new Point2D.Double(1, 1);
								Point2D p2 = new Point2D.Double(111, 111);
								Rectangle2D rect2 = new Rectangle2D.Double();
								rect2.setFrameFromDiagonal(p1, p2);
								g2.draw(rect);
								g2.draw(rect2);
								// draw the enclosed ellipse
								Ellipse2D ellipse = new Ellipse2D.Double();
								ellipse.setFrame(rect);
								g2.draw(ellipse);

								// draw a diagonal line

								g2.draw(new Line2D.Double(leftX, topY, leftX + width, topY + height));

								
								// draw a circle with the same center

								double centerX = rect.getCenterX();
								double centerY = rect.getCenterY();
								double radius = 150;

								Ellipse2D circle = new Ellipse2D.Double();
								circle.setFrameFromCenter(centerX, centerY, centerX + radius, centerY + radius);
								g2.draw(circle);
								
							}
						};
						add(component);
					}

					public static final int DEFAULT_WIDTH = 400;

					public static final int DEFAULT_HEIGHT = 400;
				};

				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);

			}
		});
	}
}

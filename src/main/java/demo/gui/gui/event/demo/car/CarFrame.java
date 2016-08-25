package demo.gui.gui.event.demo.car;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CarFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public static final int DEFAULT_WIDTH = 500;
	
	public static final int DEFAULT_HEIGHT = 500;
	
	public CarFrame() {
		setTitle("Car Management");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		this.add(new ControlPanel(), BorderLayout.NORTH);
		this.add(new ImagePanel(), BorderLayout.AFTER_LAST_LINE);
		this.add(new JButton("oo"), BorderLayout.BEFORE_FIRST_LINE);
		this.add(new JButton("xx"), BorderLayout.AFTER_LINE_ENDS);
	}
}

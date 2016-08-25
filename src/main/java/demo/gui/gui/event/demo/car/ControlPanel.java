package demo.gui.gui.event.demo.car;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class ControlPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public static final int DEFAULT_WIDTH = 500;
	
	public static final int DEFAULT_HEIGHT = 50;
	
	public ControlPanel() {
		Dimension preferredSize = new Dimension();
		preferredSize.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		this.setPreferredSize(preferredSize);
		this.setBackground(Color.LIGHT_GRAY);
	}
}

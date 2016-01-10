package test.gui.gui.event.demo.car;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;

public class TestCar {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				System.out.println("test start...");
				CarFrame frame = new CarFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				LayoutManager manager = new BorderLayout();
				frame.setLayout(new FlowLayout());
				frame.setVisible(true);
			}
		});
	}
}

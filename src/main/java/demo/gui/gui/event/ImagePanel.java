package demo.gui.gui.event;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private ImageIcon image;

    public ImagePanel() {
       image = new ImageIcon("/home/lisong/git-repos/java/java_test/java_test_0/src/main/java/test/gui/swing/19802.png");
       this.setSize(500, 500);
       this.setVisible(true);
       this.setAlignmentX(20);
       this.setAlignmentY(20);
       this.setBackground(Color.RED);
       this.setVisible(true);
       this.setLayout(new BorderLayout());
       this.add(new JButton("ooxx"), BorderLayout.PAGE_END);
       JPanel p = new JPanel();
       p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
       JLabel label = new JLabel("", image, JLabel.CENTER);
       JPanel panel = new JPanel(new BorderLayout());
       this.add( label, BorderLayout.CENTER );
    }

   
    
}
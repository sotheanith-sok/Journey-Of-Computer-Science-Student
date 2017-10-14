package View;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class rightPanel extends JPanel{
	public rightPanel() {
		JButton card = new JButton();
		try {
			BufferedImage img = ImageIO.read(new File("src/Images/cardm00.png"));
			card.setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
			card.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		JTabbedPane tab= new JTabbedPane();
		tab.add("Card1", card);
		add(tab);
	}
}

package View;
import Model.Deck;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class rightPanel extends JTabbedPane{ //extends JPanel
	public rightPanel() {
		//JButton card = new JButton();
		//JTabbedPane tab= new JTabbedPane();
		ArrayList<JButton> cardList = new ArrayList<JButton>();
		Deck playerDeck = new Deck();
		for(int i = 0 ; i < playerDeck.size(); i++)
		{
			JButton card = new JButton();
			String cardImgNumber =playerDeck.getDeck().get(i).getName(); 
			String imgUrl = "src/Images/cardm" + cardImgNumber + ".png";
			try {
				BufferedImage img = ImageIO.read(new File(imgUrl));
				card.setPreferredSize(new Dimension(img.getWidth()-25, img.getHeight()));
				card.setIcon(new ImageIcon(img));
			} catch (Exception ex) {
				System.out.println(ex);
			}
			//card.setEnabled();
			
			add("Card " + (i+1), card);
			cardList.add(card);
			
		}
		
		//add(tab);
		
	}
	
	
	
	
}

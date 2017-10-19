package View;
import Model.Deck;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class rightPanel extends JPanel{ //extends JPanel
	public Deck deck;
	public ArrayList<JLabel> cardList;
	public JLabel cardDeck;
	public rightPanel(Deck deckP) {
		deck = deckP;
		cardList = new ArrayList<JLabel>();
		cardDeck = new JLabel();
		
		cardDeck.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				int deckSize = cardList.size();
				/*
				System.out.println(deck.size());
				cardDeck.setIcon(cardList.get(deck.getCardIndex()).getIcon());
				System.out.println("Index : " + deck.getCardIndex());
				deck.setCardIndex(deck.getCardIndex() + 1);
				if(deck.getCardIndex() >= deckSize)
				{
					deck.setCardIndex(0);
				}
				*/
				deck.setCardIndex(deck.getCardIndex() + 1);
				if(deck.getCardIndex() >= deckSize)
				{
					deck.setCardIndex(0);
				}
				if(deck.size() > 0)
				{
				cardDeck.setIcon(cardList.get(deck.getCardIndex()).getIcon());
				}
				else
				{
					cardDeck.setIcon(null);
				}
				System.out.println("Index : " + deck.getCardIndex());
				
				
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		/*
		for(int i = 0 ; i < deck.size(); i++)
		{
			JLabel card = new JLabel();
			String cardImgNumber =deck.getDeck().get(i).getName(); 
			
			card.setName(cardImgNumber);
			String imgUrl = "src/Images/cardm" + cardImgNumber + ".png";
			try {
				BufferedImage img = ImageIO.read(new File(imgUrl));
				card.setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
				cardDeck.setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
				card.setIcon(new ImageIcon(img));
			} catch (Exception ex) {
				System.out.println(ex);
		
			}
			cardList.add(card);
			
		}*/
		updateCards();
		cardDeck.setIcon(cardList.get(deck.getCardIndex()).getIcon());
	//	deck.setCardIndex(deck.getCardIndex() + 1);
		add(cardDeck);
		
		
		
	}
	
	public void updateCards()
	{
		
		cardList.removeAll(cardList);
		for(int i = 0 ; i < deck.size(); i++)
		{
			
			JLabel card = new JLabel();
			String cardImgNumber =deck.getDeck().get(i).getName(); 
			
			card.setName(cardImgNumber);
			String imgUrl = "src/Images/cardm" + cardImgNumber + ".png";
			try {
				BufferedImage img = ImageIO.read(new File(imgUrl));
				card.setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
				cardDeck.setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
				card.setIcon(new ImageIcon(img));
			} catch (Exception ex) {
				System.out.println(ex);
		
			}
			
			
			cardList.add(card);
			
		}
		if(deck.size() > 0)
		{
		cardDeck.setIcon(cardList.get(deck.getCardIndex()).getIcon());
		}
		else
		{
			cardDeck.setIcon(null);
		}
	}
	
	
}

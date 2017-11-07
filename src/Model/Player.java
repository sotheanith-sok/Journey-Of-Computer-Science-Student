package Model;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import View.GameView;

public class Player {

	
	int score, skillChips, qualityPoints, learning, craft, integrity;
	String name = "";
	String location = "South Hall";
	GameModel model;
	GameView view;
	Hand hand;
	JDialog dialog;

	public Player(GameModel model ) {
		name = "AI ";
		this.model = model;
		hand = new Hand(model);
		Random rand = new Random();
		learning = rand.nextInt(3) + 1;
		craft = rand.nextInt(3) + 1;
		integrity = rand.nextInt(3) + 1;
		System.out.println(name + " " + learning + " " + craft + " " + integrity);
	}
	
	public Player(GameModel model, String n) {
		name = n;
		this.model = model;
		hand = new Hand(model);
		Random rand = new Random();
		learning = rand.nextInt(3) + 1;
		craft = rand.nextInt(3) + 1;
		integrity = rand.nextInt(3) + 1;
		
		
		
		System.out.println(name + " " + learning + " " + craft + " " + integrity);
	}
	public void setView(GameView view)
	{
		this.view = view;
		
	}
	public int getScore() {
		return score;
	}

	public String getName() {
		return name;
	}

	public void setScore(int score) {
		if (score < 0) {
			this.score = 0;
		} else {
			this.score = score;
		}

	}

	public void addScore() {
		score += 1;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSkillChips() {
		return skillChips;
	}

	public void setSkillChips(int skillChips) {
		if (skillChips < 0) {
			this.skillChips = 0;
		} else {
			this.skillChips = skillChips;
		}
	}

	public int getQualityPoints() {
		return qualityPoints;
	}

	public void setQualityPoints(int qualityPoints) {
		if (qualityPoints < 0) {
			this.qualityPoints = 0;
		} else {
			this.qualityPoints = qualityPoints;
		}
	}

	public int getLearning() {
		return learning;
	}

	public void setLearning(int learning) {
		if (learning < 0) {
			this.learning = 0;
		} else {
			this.learning = learning;
		}
	}

	public int getCraft() {
		return craft;
	}

	public void setCraft(int craft) {
		if (craft < 0) {
			this.craft = 0;
		} else {
			this.craft = craft;
		}
	}

	public int getIntegrity() {
		return integrity;
	}

	public void setIntegrity(int integrity) {
		if (integrity < 0) {
			this.integrity = 0;
		} else {
			this.integrity = integrity;
		}
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
		view.updateAvailableLocation();
	}
	
	public Hand getHand()
	{
		return hand;
	}
	
	public void discardACard(Card card)
	{
		if(this == model.getPlayerList()[0])
		{
			ArrayList<String> currentHand = new ArrayList<String>();
			ArrayList<Card>currHand = new ArrayList<Card>();
			Object discardChip = null;
			for(Card c : getHand())
			{
				if(!c.getCName().equals(card.getCName()))
				{
					currHand.add(c);
					currentHand.add(c.getCName() + ", " + c.getCLocation() + " : " + c.getEffect());
				}
				
			}
			String cHand[] = new String[currentHand.size()];
			for(int i = 0 ; i < currentHand.size();i++)
			{
				cHand[i] = currentHand.get(i);
			}
			while(discardChip == null)
			{
			discardChip = JOptionPane.showInputDialog(null, "Select One Card To Discard",
			        "", JOptionPane.QUESTION_MESSAGE, null,  cHand, cHand[0]);
			}
			
			for(int i = 0 ; i < cHand.length ; i++)
			{
				if(discardChip.equals(cHand[i]))
				{
					getHand().remove(model.getDeck().getCardMap().get(currHand.get(i).getName()));
					if(getHand().getCardIndex() == 0)
					{
						getHand().setCardIndex(0);
					}
					else
					{
						getHand().setCardIndex(getHand().getCardIndex() - 1);
					}
				
				}
			}
			dialog.dispose();
		}//if the human player
		
		else 
		{
			
			ArrayList<Card>currHand = new ArrayList<Card>();
			
			for(Card c : getHand())
			{
				if(!c.getCName().equals(card.getCName()))
				{
					currHand.add(c);
					
				}
				
			}
			
			Random rand = new Random();
			int temp = rand.nextInt( (currHand.size()-1) + 1 - 0 ) + 0 ;
			getHand().remove(model.getDeck().getCardMap().get(currHand.get(temp).getName()));
			
				
			
			
		}// AI PLAYER
	}//discard Card
	
	/**
	 * The effect when another card's effect discards a card. It will exempt the card that has already been played from being in the list of cards to discard
	 */
	public void discardACard()
	{
		if(this == model.getPlayerList()[0])
		{
			ArrayList<String> currentHand = new ArrayList<String>();
			ArrayList<Card>currHand = new ArrayList<Card>();
			Object discardChip = null;
			for(Card c : getHand())
			{
				
					currHand.add(c);
					currentHand.add(c.getCName() + ", " + c.getCLocation() + " : " + c.getEffect());
				
				
			}
			String cHand[] = new String[currentHand.size()];
			for(int i = 0 ; i < currentHand.size();i++)
			{
				cHand[i] = currentHand.get(i);
			}
			while(discardChip == null)
			{
			discardChip = JOptionPane.showInputDialog(null, "Select One Card To Discard",
			        "", JOptionPane.QUESTION_MESSAGE, null,  cHand, cHand[0]);
			}
			
			for(int i = 0 ; i < cHand.length ; i++)
			{
				if(discardChip.equals(cHand[i]))
				{
					getHand().remove(model.getDeck().getCardMap().get(currHand.get(i).getName()));
					if(getHand().getCardIndex() == 0)
					{
						getHand().setCardIndex(0);
					}
					else
					{
						getHand().setCardIndex(getHand().getCardIndex() - 1);
					}
				
				}
			}
				dialog.dispose();
		}//if the human player
		
		else 
		{
			
			ArrayList<Card>currHand = new ArrayList<Card>();
			
			for(Card c : getHand())
			{
					currHand.add(c);
				
			}
			
			Random rand = new Random();
			int temp = rand.nextInt( (currHand.size()-1) + 1 - 0 ) + 0 ;
			getHand().remove(model.getDeck().getCardMap().get(currHand.get(temp).getName()));
			
				
			
			
		}// AI PLAYER
	}//discard Card
	
	
	public void drawCard()
	{
		Card drawn = model.getDeck().removeCard();
		getHand().add(drawn);
		if(this == model.getPlayerList()[0])
		{
			
			
			 dialog = new JDialog();     
			 dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			 dialog.setTitle("You drew " + drawn.getCName());
			 JLabel card = new JLabel();
			String cardImgNumber =drawn.getName(); 
			
			card.setName(cardImgNumber);
			String imgUrl = "src/Images/cardm" + cardImgNumber + ".png";
			try {
				BufferedImage img = ImageIO.read(new File(imgUrl));
				card.setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
				card.setIcon(new ImageIcon(img));
			} catch (Exception ex) {
				System.out.println(ex);
  		
			}
			
			 dialog.add(card);
			 dialog.requestFocus();
			 dialog.pack();
			 dialog.setLocationByPlatform(true);
			 dialog.setVisible(true);
			
			 
		}
		
		String message = "gained a card";
		if(getHand().size() > getHand().getMaxSize())
		{
			view.getInfoPanel().updateFeedback(this, message + " but their hand was full and had to discard a card");
			discardACard();
			view.getControlPanel().getRightPanel().updateCards();
		}
		else
		{
			
			view.getInfoPanel().updateFeedback(this, message);
			view.getControlPanel().getRightPanel().updateCards();
		}
		//String message = "gained " + drawn.getCName() + " , " + drawn.getCLocation() + " : " + drawn.getEffect();
		//String message = "gained a card";
		
	
		
		
		
	}
	
	
}

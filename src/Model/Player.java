package Model;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import View.GameView;

public class Player {

	
	int score, skillChips, qualityPoints, learning, craft, integrity;
	String name = "";
	String location = "South Hall";
	GameModel model;
	GameView view;
	Hand hand;

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
		ArrayList<String> currentHand = new ArrayList<String>();
		ArrayList<Card>currHand = new ArrayList<Card>();
		Object discardChip = null;
		for(Card c : getHand())
		{
			if(!c.getCName().equals(card.getCName()))
			{
				currHand.add(c);
				currentHand.add(c.getCName() + " : " + c.getEffect());
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
	}//discard Card
	
	
}

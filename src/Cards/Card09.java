package Cards;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Model.Card;
import Model.GameModel;
import Model.Player;
import View.GameView;
public class Card09 extends Card {

	public Card09(String name, String cName, String effect , GameModel model , GameView view) {
		super(name, cName ,effect, model, view);
		// TODO Auto-generated constructor stub
	}
	

	public Card09(GameModel model)
	{
		super(model);
		super.setName("09");
		super.setCName("Parking Violation");
		super.setEffect("gain 1 Learning chip or Discard 1 game card from your hand to get another learning chip");
	}
	@Override
	public Boolean requirement(Player player ,String location, int stat) {
		if(player.getLocation().equals("Forbidden Parking"))
		{
			return true;
		}
		return false;
		// TODO Auto-generated method stub
		
	}


	@Override
	public void effect(Player player) {
		// TODO Auto-generated method stub
		if(getModel().getPlayerList()[0].getHand().size()-1 > 0)
		{
			
		
			String[] options = {"Get 1 Learning Chip" , "Discard 1 game card from your hand to get another learning chip"};
			String[] cHand = null;
			ArrayList<Card> currHand = null;
			Object chip = null, discardChip = null;
			do {
				chip = JOptionPane.showInputDialog(null, "Select One",
				        "", JOptionPane.QUESTION_MESSAGE, null, options , options[0]);
					if(chip.equals(options[1]))
					{
						
						ArrayList<String> currentHand = new ArrayList<String>();
						currHand = new ArrayList<Card>();
						
						for(Card c : getModel().getPlayerList()[0].getHand())
						{
							if(!c.getCName().equals(getCName()))
							{
								currHand.add(c);
								currentHand.add(c.getCName() + " : " + c.getEffect());
							}
							
						}
						cHand = new String[currentHand.size()];
						for(int i = 0 ; i < currentHand.size();i++)
						{
							cHand[i] = currentHand.get(i);
						}
						while(discardChip == null)
						{
						discardChip = JOptionPane.showInputDialog(null, "Select One",
						        "", JOptionPane.QUESTION_MESSAGE, null,  cHand, cHand[0]);
						}
					}
				} //do
			while(chip == null);
			
			if(chip.equals(options[0]))
			{
				player.setLearning(player.getLearning() + 1);
				setEffect("gained 1 Learning Chip");
			}
			else if(chip.equals(options[1]))
			{
				
				
				for(int i = 0 ; i < cHand.length ; i++)
				{
					if(discardChip.equals(cHand[i]))
					{
						getModel().getPlayerList()[0].getHand().remove(getModel().getDeck().getCardMap().get(currHand.get(i).getName()));
						if(getModel().getPlayerList()[0].getHand().getCardIndex() == 0)
						{
							getModel().getPlayerList()[0].getHand().setCardIndex(0);
						}
						else
						{
							getModel().getPlayerList()[0].getHand().setCardIndex(getModel().getPlayerList()[0].getHand().getCardIndex() - 1);
						}
					
					}
				}
					player.setLearning(player.getLearning() + 2);
					setEffect("gained 2 Learning Chip");	
				
				
			}//else if 
		}//if the player has enough cards
		else
		{
			JOptionPane.showMessageDialog(null,
				    "Gained 1 Learning Chips. Not enough cards to discard.",
				    "",
				    JOptionPane.PLAIN_MESSAGE);
			player.setLearning(player.getLearning() + 1);
			setEffect("gained 1 Learning Chip");
		}
	}//effect()


	@Override
	public void fail(Player player) {
		// TODO Auto-generated method stub
		
	}

}

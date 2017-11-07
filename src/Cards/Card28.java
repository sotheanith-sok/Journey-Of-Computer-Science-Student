package Cards;

import javax.swing.JOptionPane;

import Model.Card;
import Model.GameModel;
import Model.Player;
import View.GameView;


public class Card28 extends Card{

	
	
	public Card28()
	{
		//super();
		super.setName("28");
		super.setCName("Professor Englert");
		super.setCLocation("Play in CECS Conference");
		super.setEffect("Prerequiste: 3 Integrity , Get 1 Chip of Your Choice; Fail : Discard 1 Game Card ");
	}


	@Override
	public Boolean requirement(Player player ,String location, int stat) {
		if(  player.getLocation().equals("CECS Conference Room") && player.getIntegrity() >= 3 )
		{
			return true;
		}
		return false;
		
	}

	@Override
	public void effect(Player player) {
		// TODO Auto-generated method stub
		
		String tempEffect = "";
		String[] options = {"Get 1 Learning Chip" , "Get 1 Craft Chip" , "Get 1 Integrity Chip" , "Get 1 Quality Point"};
		Object chip = null;
		while(chip == null)
		{
			chip = JOptionPane.showInputDialog(null, "Select One",
		        "", JOptionPane.QUESTION_MESSAGE, null, options , options[0]);
		}
		if(chip.equals(options[0]))
		{
			player.setLearning(player.getLearning() + 1);
			tempEffect += "1 Learning Chip";
		}
		else if(chip.equals(options[1]))
		{
			player.setCraft(player.getCraft() + 1);
			tempEffect += "1 Craft Chip";
		}
		else if(chip.equals(options[2]))
		{
			player.setIntegrity(player.getIntegrity() + 1);
			tempEffect += "1 Integrity Chip";
		}
		else if(chip.equals(options[3]))
		{
			player.setQualityPoints(player.getQualityPoints() + 1);
			tempEffect += "1 additional Quality Point";
		}
		setEffect(tempEffect);
		
		
	}

	@Override
	public void fail(Player player) {
		// TODO Auto-generated method stub
		
		if(player.getHand().size() -1 >= 0)
		{
			player.discardACard(this);
			setEffect("and discarded a card");
		}
		else
		{
			setEffect("but their hand was empty.");
		}
	}
	

	
	

}

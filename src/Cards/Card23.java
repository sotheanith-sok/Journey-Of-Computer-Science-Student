package Cards;

import javax.swing.JOptionPane;

import Model.Card;
import Model.GameModel;
import Model.Player;
import View.GameView;


public class Card23 extends Card{

	public Card23(String name, String cName, String effect , GameModel model , GameView view) {
		super(name, cName ,effect, model, view);
		// TODO Auto-generated constructor stub
	}
	
	public Card23()
	{
		//super();
		super.setName("23");
		super.setCName("A New Laptop, Play in the Computer Lab");
		super.setEffect("Prerequiste: 4 Integrity , Get 3 Quality Points and 1 Chip of Your Choice; Fail : Discard 1 Game Card ");
	}


	@Override
	public Boolean requirement(Player player ,String location, int stat) {
		if((player.getLocation().equals("Computer Lab") || player.getIntegrity() >= 4 ))
		{
			return true;
		}
		
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void effect(Player player) {
		// TODO Auto-generated method stub
		player.setQualityPoints(player.getQualityPoints()+ 3);
		String tempEffect = "gained 3 Quality Points and ";
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
			setEffect("did not meet the requirements and discarded a card");
		}
		else
		{
			setEffect("did not meet the requirements and but their hand was empty.");
		}
	}
	

	
	

}

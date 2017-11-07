package Cards;

import javax.swing.JOptionPane;

import Model.Card;
import Model.GameModel;
import Model.Player;
import View.GameView;


public class Card27 extends Card{

	
	
	public Card27()
	{
		//super();
		super.setName("27");
		super.setCName("Loud Buzzing");
		super.setCLocation("Play in EAT Room");
		super.setEffect("Prerequiste: 3 Craft , Get 1 Chip of Your Choice; Fail : Lose 2 Quality Points");
	}


	@Override
	public Boolean requirement(Player player ,String location, int stat) {
		if(  player.getLocation().equals("Eat Club") && player.getCraft() >= 3 )
		{
			return true;
		}
		return false;
		
	}

	@Override
	public void effect(Player player) {
		// TODO Auto-generated method stub
		String tempEffect = "gained ";
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
		
		
			player.setQualityPoints(player.getQualityPoints()-2);
			setEffect("and lost 2 Quality Points.");
		
	}
	

	
	

}

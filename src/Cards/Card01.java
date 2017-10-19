package Cards;
import javax.swing.JOptionPane;

import Model.Card;
import Model.Player;
public class Card01 extends Card {

	public Card01(String name, String effect) {
		super(name, effect);
		// TODO Auto-generated constructor stub
	}
	
	public Card01()
	{
		//super();
		super.setName("01");
		super.setEffect("Another Test");
	}

	@Override
	public Boolean requirement(Player player ,String location, int stat) {
		if(player.getLocation().equals("Library"))
		{
			return true;
		}
		return false;
		// TODO Auto-generated method stub
		
	}


	@Override
	public void effect(Player player) {
		// TODO Auto-generated method stub
		String[] options = {"Get 1 Learning Chip" , "Get 1 Integrity Chip"};
		Object chip = null;
		while(chip == null)
		{
			chip = JOptionPane.showInputDialog(null, "Select One",
		        "", JOptionPane.QUESTION_MESSAGE, null, options , options[0]);
		}
		if(chip.equals(options[0]))
		{
			player.setLearning(player.getLearning() + 1);
		}
		else if(chip.equals(options[1]))
		{
			player.setIntegrity(player.getIntegrity() + 1);
		}
		
	}

}

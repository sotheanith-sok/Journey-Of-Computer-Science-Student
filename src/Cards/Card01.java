package Cards;
import javax.swing.JOptionPane;

import Model.Card;
import Model.GameModel;
import Model.Player;
import View.GameView;
public class Card01 extends Card {

	public Card01(String name, String cName, String effect , GameModel model , GameView view) {
		super(name, cName ,effect, model, view);
		// TODO Auto-generated constructor stub
	}
	
	public Card01()
	{
		//super();
		super.setName("01");
		super.setCName("Math 122");
		super.setEffect("");
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
			setEffect("gained 1 Learning Chip");
		}
		else if(chip.equals(options[1]))
		{
			player.setIntegrity(player.getIntegrity() + 1);
			setEffect("gained 1 Integrity Chip");
		}
		
	}

}

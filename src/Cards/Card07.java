package Cards;
import Model.Card;
import Model.Player;
public class Card07 extends Card {

	
	
	public Card07()
	{
		super("Finding the Lab", 
				"src/Images/cardm07.png", 
				new String[] {"Elevators"});
	}
	@Override
	public String pass(Player p) {
		// TODO Auto-generated method stub
		p.setIntegrity(p.getIntegrity()+1);
		return " 1 Integrity Chip";
	}


}

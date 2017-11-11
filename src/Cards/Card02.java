package Cards;
import Model.Card;
import Model.Player;
public class Card02 extends Card {
	
	public Card02()
	{
		super("Lunch at Bratwurst Hall", "src/Images/cardm02.png", new String[] {"Bratwurst Hall"});
	}
	@Override
	public String pass(Player p) {
		// TODO Auto-generated method stub
		p.setCraft(p.getCraft()+1);
		return "1 Craft Chip";
	}



}

package Cards;

import Model.Card;
import Model.Player;


public class Card13 extends Card{

	
	public Card13() {
		super("The Big Game", "src/Images/cardm13.png", new String[] { "Pyramid"});
	}

	@Override
	public String pass(Player p) {
		// TODO Auto-generated method stub
		p.setCraft(p.getCraft()+1);
		p.setLocation("Lactation Lounge");
		return " 1 Craft Chip";
	}
	
	

	
	

}

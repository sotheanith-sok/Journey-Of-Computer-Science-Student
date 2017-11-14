package Cards;

import Model.Card;
import Model.Player;


public class Card12 extends Card{

	
	public Card12() {
		super("Late for Class", "src/Images/cardm12.png", new String[] { "West Walkway","Library","LA5","Bratwurst Hall","East Walkway","Rec Center","Student Parking","Pyramid","Japanese Garden","George Allen Field" });
	}

	@Override
	public String pass(Player p) {
		// TODO Auto-generated method stub
		p.setCraft(p.getCraft()+1);
		p.setLocation("Lactation Lounge");
		return " 1 Craft Chip";
	}


	
	

	
	

}

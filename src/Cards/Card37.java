package Cards;

import Model.Card;
import Model.Player;

public class Card37 extends Card {

	public Card37() {
		super("Enjoying Nature", "src/Images/cardm37.png",
				new String[] { "Forbidden Parking", "West Walkway", "Library", "LA5", "Bratwurst Hall", "East Walkway",
						"Rec Center", "Student Parking", "Pyramid", "Japanese Garden", "George Allen Field" });
	}

	@Override
	public String pass(Player p) {
		// TODO Auto-generated method stub
		p.setCraft(p.getCraft() + 1);
		p.setLocation("Lactation Lounge");
		return " 1 Craft Chips";
	}


}

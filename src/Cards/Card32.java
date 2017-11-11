package Cards;

import Model.Card;
import Model.Player;

public class Card32 extends Card {

	public Card32() {
		super("The Outpost", "src/Images/cardm32.png",
				new String[] { "West Walkway", "Library", "LA5", "Bratwurst Hall", "East Walkway", "Rec Center",
						"Student Parking", "Pyramid", "Japanese Garden", "George Allen Field" });
	}

	@Override
	public String pass(Player p) {
		// TODO Auto-generated method stub
		if (p.isHuman() == true) {
			this.dialogOption(true, true, true, p);
			return "";
		} else {
			int i = (int) Math.random() * 3;
			if (i == 0) {
				p.setLearning(p.getLearning() + 1);
				return " 1 Learning Chip ";
			} else if (i == 1) {
				p.setIntegrity(p.getIntegrity() + 1);
				return " 1 Integrity Chip ";
			} else {
				p.setCraft(p.getCraft() + 1);
				return " 1 Craft Chip ";
			}
		}
	}

}

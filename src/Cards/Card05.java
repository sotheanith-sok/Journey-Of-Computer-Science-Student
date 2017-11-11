package Cards;

import Model.Card;
import Model.Player;

public class Card05 extends Card {

	public Card05() {
		super("CECS 100", "src/Images/cardm05.png", new String[] { "ECS 308" });
	}

	@Override
	public String pass(Player p) {
		if (p.isHuman() == true) {
			// TODO Auto-generated method stub
			this.dialogOption(true, true, true, p);
			return "";

		} else {
			int i = (int) Math.random() * 3;
			if (i == 0) {
				p.setLearning(p.getLearning() + 1);
				return " 1 Learning Chip";
			} else if (i==1){
				p.setIntegrity(p.getIntegrity() + 1);
				return " 1 Integrity Chip";
			} else {
				p.setCraft(p.getCraft() + 1);
				return " 1 Craft Chip";
			}
		}
	}

}

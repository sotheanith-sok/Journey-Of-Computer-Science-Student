package Cards;

import Model.Card;
import Model.Player;

public class Card01 extends Card {

	public Card01() {
		super("Math 122", "src/Images/cardm01.png", new String[] { "Library" });
	}

	@Override
	public String pass(Player p) {
		if (p.isHuman() == true) {
			dialogOption(true, true, false, p);
			return "";
		} else {
			int i = (int) Math.random() * 2;
			if (i == 0) {
				p.setLearning(p.getLearning() + 1);
				return " 1 Learning Chip";
			} else {
				p.setIntegrity(p.getIntegrity() + 1);
				return " 1 Integrity Chip";
			}
		}

	}

}

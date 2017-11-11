package Cards;

import Model.Card;
import Model.Player;

public class Card08 extends Card {

	public Card08() {
		super("Enjoying the Peace", "src/Images/cardm08.png", new String[] { "Japanese Gardens" });
	}

	@Override
	public String pass(Player p) {
		if (p.isHuman() == true) {
			this.dialogOption(true, true, false, p);
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

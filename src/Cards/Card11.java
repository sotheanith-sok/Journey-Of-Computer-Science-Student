package Cards;

import Model.Card;
import Model.Player;

public class Card11 extends Card {

	public Card11() {
		super("Buddy Up: Joining EAT or Soccer Team", "src/Images/cardm11.png",
				new String[] { "Eat Club", "George Allen Field" });
	}

	@Override
	public String pass(Player p) {
		// TODO Auto-generated method stub
		if (p.isHuman() == true) {
			this.dialogOption(false, true, true, p);
			return "";
		} else {
			int i = (int) Math.random() * 2;
			if (i == 0) {
				p.setLearning(p.getLearning() + 1);
				return " 1 Learning Chip";
			} else {
				p.setCraft(p.getCraft() + 1);
				return " 1 Craft Chip";
			}
		}
	}

}

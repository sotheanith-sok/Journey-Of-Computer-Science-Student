package Cards;

import Model.Card;
import Model.Player;

public class Card28 extends Card {

	public Card28() {
		super("Professor Englert", "src/Images/cardm28.png", new String[] { "CECS Conference Room" });
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

	@Override
	public void fail(Player p) {
		p.setQualityPoints(p.getQualityPoints() - 2);
		p.remove(p.getAllCardName().get((int)(Math.random()*p.getAllCardName().size())));
	}

	@Override
	public boolean requirement(Player p) {
		return (p.getIntegrity() >= 3) && location.contains(p.getLocation());
	}

}

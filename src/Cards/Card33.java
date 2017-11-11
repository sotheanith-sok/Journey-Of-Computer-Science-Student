package Cards;

import Model.Card;
import Model.Player;

public class Card33 extends Card {

	public Card33() {
		super("Oral Communication", "src/Images/cardm33.png",
				new String[] { "Library", "LA5", "Bratwurst Hall", "Rec Center", "Pyramid" });
	}

	@Override
	public String pass(Player p) {
		// TODO Auto-generated method stub
		p.setQualityPoints(p.getQualityPoints() + 4);
		if (p.isHuman() == true) {
			this.dialogOption(true, true, true, p);
			return " and 4 Quality Points";
		} else {
			int i = (int) Math.random() * 3;
			if (i == 0) {
				p.setLearning(p.getLearning() + 1);
				return " 1 Learning Chip and 4 Quality Points  ";
			} else if (i == 1) {
				p.setIntegrity(p.getIntegrity() + 1);
				return " 1 Integrity Chip and 4 Quality Points";
			} else {
				p.setCraft(p.getCraft() + 1);
				return " 1 Craft Chip and 4 Quality Points ";
			}
		}
	}

	@Override
	public void fail(Player p) {
		p.setQualityPoints(p.getQualityPoints() - 2);
		if (p.getPlayerHand().size() > 0)
			p.remove(p.getAllCardName().get((int) (Math.random() * p.getAllCardName().size())));
	}

	@Override
	public boolean requirement(Player p) {
		return (p.getIntegrity() >= 4) && location.contains(p.getLocation());
	}

}

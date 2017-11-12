package Cards;

import Model.Card;
import Model.Player;

public class Card25 extends Card {

	public Card25() {
		super("Program Crashes", "src/Images/cardm25.png", new String[] { "Lactation Lounge" });
	}

	@Override
	public String pass(Player p) {
		// TODO Auto-generated method stub
		p.setQualityPoints(p.getQualityPoints() + 5);
		if (p.isHuman() == true) {
			this.dialogChipOption(true, true, true, p);
			return " and 5 Quality Points";
		} else {
			int i = (int) Math.random() * 3;
			if (i == 0) {
				p.setLearning(p.getLearning() + 1);
				return " 1 Learning Chip and 5 Quality Points";
			} else if (i == 1) {
				p.setIntegrity(p.getIntegrity() + 1);
				return " 1 Integrity Chip and 5 Quality Points";
			} else {
				p.setCraft(p.getCraft() + 1);
				return " 1 Craft Chip and 5 Quality Points";
			}
		}
	}

	@Override
	public void fail(Player p) {
		p.setQualityPoints(p.getQualityPoints() - 2);
		if (p.getPlayerHand().size() > 0)
			if (p.isHuman()) {
				this.dialogoRemoveCard(p);
			}else {
				p.remove(p.getAllCardName().get((int) (Math.random() * p.getAllCardName().size())));
			}
	}

	@Override
	public boolean requirement(Player p) {
		return (p.getLearning() >= 2) && location.contains(p.getLocation());
	}

}

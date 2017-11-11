package Cards;

import Model.Card;
import Model.Player;

public class Card24 extends Card {

	public Card24() {
		super("Meet the Dean", "src/Images/cardm24.png", new String[] { "North Hall", "South Hall" });
	}

	@Override
	public String pass(Player p) {
		// TODO Auto-generated method stub
		p.setQualityPoints(p.getQualityPoints() + 5);
		p.addOneMoreCard();
		return "5 Quality Points and 1 Game Card";
	}

	@Override
	public void fail(Player p) {
		p.setQualityPoints(p.getQualityPoints() - 2);
		if (p.getPlayerHand().size() > 0)
			p.remove(p.getAllCardName().get((int) (Math.random() * p.getAllCardName().size())));
	}

	@Override
	public boolean requirement(Player p) {
		return (p.getLearning() >= 3) && (p.getIntegrity() >= 3) && (p.getCraft() >= 3)
				&& location.contains(p.getLocation());
	}

}

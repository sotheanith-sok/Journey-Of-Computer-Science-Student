package Cards;

import Model.Card;
import Model.Player;

public class Card21 extends Card {

	public Card21() {
		super("Pass Soccer Class", "src/Images/cardm21.png", new String[] {"George Allen Field"});
	}

	@Override
	public String pass(Player p) {
		// TODO Auto-generated method stub
		p.setQualityPoints(p.getQualityPoints() + 5);
		return "5 Quality Points";
	}

	@Override
	public void fail(Player p) {
		p.setQualityPoints(p.getQualityPoints() - 5);
	}

	@Override
	public boolean requirement(Player p) {
		return (p.getCraft() >= 5) && location.contains(p.getLocation());
	}
}

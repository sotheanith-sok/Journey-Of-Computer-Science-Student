package Cards;

import Model.Card;
import Model.Player;

public class Card14 extends Card {

	public Card14() {
		super("Math 123", "src/Images/cardm14.png", new String[] { "ECS 302", "ECS 308" });
	}

	@Override
	public String pass(Player p) {
		// TODO Auto-generated method stub
		p.setQualityPoints(p.getQualityPoints() + 5);
		return "5 Quality Points";
	}

	@Override
	public void fail(Player p) {
		p.setQualityPoints(p.getQualityPoints() - 3);
		if (p.getPlayerHand().size() > 0) {
			if (p.isHuman()) {
				this.dialogoRemoveCard(p);
			}else {
				p.remove(p.getAllCardName().get((int) (Math.random() * p.getAllCardName().size())));
			}
		}
			
	}

	@Override
	public boolean requirement(Player p) {
		return (p.getLearning() >= 5) && location.contains(p.getLocation());
	}

}

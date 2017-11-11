package Cards;

import Model.Card;
import Model.Player;

public class Card31 extends Card {

	public Card31() {
		super("Professor Hoffman", "src/Images/cardm31.png",
				new String[] { "CECS Conference Room", "Eat Club", "ECS 302", "Computer Lab", "North Hall",
						"South Hall", "ECS 308", "Elevators", "Room of Retirement" });
	}

	@Override
	public String pass(Player p) {
		// TODO Auto-generated method stub
		p.setQualityPoints(p.getQualityPoints() + 5);
		p.addOneMoreCard();
		p.addOneMoreCard();
		return " 5 Quality Points and 2 Game Cards";
	}

	@Override
	public void fail(Player p) {
		p.setQualityPoints(p.getQualityPoints() - 7);
		p.setLocation("Lactation Lounge");
	}

	@Override
	public boolean requirement(Player p) {
		return (p.getLearning() >= 3) && location.contains(p.getLocation());
	}

}

package Cards;
import Model.Card;
import Model.Player;
public class Card26 extends Card {

	public Card26() {
		super("Press the Right Floor", "src/Images/cardm26.png", new String[] {"Elevators"});
	}

	@Override
	public String pass(Player p) {
		// TODO Auto-generated method stub
		p.setCraft(p.getCraft()+2);
		return " 2 Craft Chips";
	}

	@Override
	public void fail(Player p) {
		p.setQualityPoints(p.getQualityPoints() - 4);
	}

	@Override
	public boolean requirement(Player p) {
		return (p.getLearning() >= 4) && location.contains(p.getLocation());
	}

}

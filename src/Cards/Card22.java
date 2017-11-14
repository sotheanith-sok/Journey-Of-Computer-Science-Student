package Cards;
import Model.Card;
import Model.Player;
public class Card22 extends Card {

	
	
	public Card22() {
		super("Fall in the Pond", "src/Images/cardm22.png", new String[] {"Japanese Garden"});
	}

	@Override
	public String pass(Player p) {
		// TODO Auto-generated method stub
		p.setIntegrity(p.getIntegrity() + 1);
		p.setCraft(p.getCraft() + 1);
		return " 1 Integrity Point and 1 Craft Point";
	}

	@Override
	public void fail(Player p) {
		p.setQualityPoints(p.getQualityPoints() - 2);
		p.setLocation("Lactation Lounge");
	}

	@Override
	public boolean requirement(Player p) {
		return (p.getLearning() >= 3) && location.contains(p.getLocation());
	}

}

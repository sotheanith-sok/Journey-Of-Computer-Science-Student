package Cards;
import Model.Card;
import Model.Player;
public class Card29 extends Card {
	
	public Card29() {
		super("Soccer Goalie", "src/Images/cardm29.png", new String[] {"George Allen Field"});
	}

	@Override
	public String pass(Player p) {
		// TODO Auto-generated method stub
		p.setQualityPoints(p.getQualityPoints()+5);
		p.addOneMoreCard();
		return " 5 Quality Points and 1 Game Card";
	}

	@Override
	public void fail(Player p) {
		p.setQualityPoints(p.getQualityPoints() - 2);
		p.setLocation("Student Parking");
	}

	@Override
	public boolean requirement(Player p) {
		return (p.getIntegrity() >= 3) &&(p.getLearning() >= 3) && location.contains(p.getLocation());
	}
	
}

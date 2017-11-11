package Cards;
import Model.Card;
import Model.Player;
public class Card19 extends Card {

	
	public Card19() {
		super("Score a Goal!", "src/Images/cardm19.png", new String[] {"George Allen Field"});
	}

	@Override
	public String pass(Player p) {
		// TODO Auto-generated method stub
		p.setQualityPoints(p.getQualityPoints()+5);
		p.setIntegrity(p.getIntegrity()+1);
		return "5 Quality Points and 1 Integrity Point";
	}
	@Override
	public void fail(Player p) {
		p.setQualityPoints(p.getQualityPoints()-2);
		p.setLocation("Student Parking");
	}
	@Override
	public boolean requirement(Player p) {
		return (p.getCraft()>=3)&&location.contains(p.getLocation());
	}
}

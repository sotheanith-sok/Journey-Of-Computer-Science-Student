package Cards;
import Model.Card;
import Model.Player;
public class Card34 extends Card {
	
	public Card34() {
		super("CHEM 111", "src/Images/cardm34.png",
				new String[] { "Library", "LA5", "Bratwurst Hall", "Rec Center", "Pyramid" });
	}

	@Override
	public String pass(Player p) {
		// TODO Auto-generated method stub
		p.setQualityPoints(p.getQualityPoints() + 5);
		return " 5 Quality Points";
	}

	@Override
	public void fail(Player p) {
		p.setQualityPoints(p.getQualityPoints() - 2);
		p.setLocation("Student Parking");
	}

	@Override
	public boolean requirement(Player p) {
		return (p.getCraft() >= 6) && location.contains(p.getLocation());
	}
	
}

package Cards;
import Model.Card;
import Model.Player;
public class Card16 extends Card {

	
	public Card16() {
		super("KIN 253 Learning the Rules of Soccer", "src/Images/cardm16.png", new String[] { "George Allen Field"});
	}

	@Override
	public String pass(Player p) {
		// TODO Auto-generated method stub
		p.setCraft(p.getCraft()+2);
		return " 2 Craft Points";
	}
	@Override
	public void fail(Player p) {
		p.setQualityPoints(p.getQualityPoints()-2);
		p.setLocation("Room of Retirement");
	}
	@Override
	public boolean requirement(Player p) {
		return (p.getIntegrity()>=4)&&location.contains(p.getLocation());
	}

}

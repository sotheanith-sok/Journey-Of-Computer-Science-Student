package Cards;
import Model.Card;
import Model.Player;
public class Card20 extends Card {

	
	
	public Card20() {
		super("Make the Dean's List", "src/Images/cardm20.png", new String[] {"North Hall", "South Hall"});
	}

	@Override
	public String pass(Player p) {
		// TODO Auto-generated method stub
		p.setQualityPoints(p.getQualityPoints()+5);
		return " 5 Quality Points";
	}
	@Override
	public void fail(Player p) {
		p.setQualityPoints(p.getQualityPoints()-2);
		p.setLocation("Student Parking");
	}
	@Override
	public boolean requirement(Player p) {
		return (p.getLearning()>=6)&&location.contains(p.getLocation());
	}

}

package Cards;
import Model.Card;
import Model.Player;
public class Card15 extends Card {

	
	
	public Card15() {
		super("Physics 151", "src/Images/cardm15.png", new String[] {"ECS 308"});
	}

	@Override
	public String pass(Player p) {
		// TODO Auto-generated method stub
		p.setQualityPoints(p.getQualityPoints()+5);
		return " 5 Quality Points";
	}
	@Override
	public void fail(Player p) {
		p.setQualityPoints(p.getQualityPoints()-3);
	}
	@Override
	public boolean requirement(Player p) {
		return (p.getCraft()>=3)&&location.contains(p.getLocation());
	}

}

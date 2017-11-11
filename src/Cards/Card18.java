package Cards;
import Model.Card;
import Model.Player;
public class Card18 extends Card {

	
	public Card18() {
		super("Choosing a Major", "src/Images/cardm18.png", new String[] {"CECS Conference Room"});
	}

	@Override
	public String pass(Player p) {
		// TODO Auto-generated method stub
		p.setQualityPoints(p.getQualityPoints()+5);
		return "5 Quality Points";
	}
	@Override
	public void fail(Player p) {
		p.setQualityPoints(p.getQualityPoints()-5);
	}
	@Override
	public boolean requirement(Player p) {
		return (p.getIntegrity()>=3)&&location.contains(p.getLocation());
	}

}

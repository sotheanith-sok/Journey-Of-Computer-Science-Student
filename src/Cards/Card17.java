package Cards;
import Model.Card;
import Model.Player;
public class Card17 extends Card {

	
	
	public Card17() {
		super("Learning Netbeans", "src/Images/cardm17.png", new String[] { "Lactation Lounge"});
	}

	@Override
	public String pass(Player p) {
		// TODO Auto-generated method stub
		p.setLearning(p.getLearning()+3);
		return "3 Learning Points";
	}
	@Override
	public void fail(Player p) {
		p.setQualityPoints(p.getQualityPoints()-5);
	}
	@Override
	public boolean requirement(Player p) {
		return (p.getLearning()>=3)&&location.contains(p.getLocation());
	}

}

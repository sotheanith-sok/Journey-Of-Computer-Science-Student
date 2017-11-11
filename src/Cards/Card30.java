package Cards;
import Model.Card;
import Model.Player;
public class Card30 extends Card {
	
	public Card30() {
		super("Elective Class", "src/Images/cardm30.png", new String[] {"Library"});
	}

	@Override
	public String pass(Player p) {
		// TODO Auto-generated method stub
		p.setLearning(p.getLearning()+1);
		p.addOneMoreCard();
		return " 1 Learning Chip and 1 Game Card";
	}

	@Override
	public void fail(Player p) {
		p.setQualityPoints(p.getQualityPoints() - 4);
	}

	@Override
	public boolean requirement(Player p) {
		return (p.getLearning() >= 2) && location.contains(p.getLocation());
	}
	
}

package Cards;
import Model.Card;
import Model.Player;
public class Card03 extends Card {

	public Card03()
	{
		super("Research Compilers", "src/Images/cardm03.png", new String[] {"Library"});
	}
	@Override
	public String pass(Player p) {
		// TODO Auto-generated method stub
		p.setLearning(p.getLearning()+1);
		return "1 Learning Chip";
	}

}

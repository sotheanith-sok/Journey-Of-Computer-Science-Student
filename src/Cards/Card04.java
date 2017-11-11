package Cards;
import Model.Card;
import Model.Player;
public class Card04 extends Card {

	
	public Card04()
	{
		super("Professor Murgolo's CECS 174 Class", "src/Images/cardm04.png", new String[] {"ECS 302"});
	}
	@Override
	public String pass(Player p) {
		// TODO Auto-generated method stub
		p.setLearning(p.getLearning()+1);
		return "1 Learning Chip";
	}

}

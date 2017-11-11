package Cards;

import Model.Card;
import Model.Player;


public class Card10 extends Card{

	
	
	public Card10() {
		super("CECS 105", "src/Images/cardm10.png", new String[] { "ECS 302", "ECS 308" });
	}

	@Override
	public String pass(Player p) {
		// TODO Auto-generated method stub
		p.setLearning(p.getLearning()+1);
		return "1 Learning Chip";
	}



	
	

}

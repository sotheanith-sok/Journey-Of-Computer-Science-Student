package Cards;


import Model.Card;
import Model.Player;

public class Card00 extends Card{
	
	public Card00(){
		super("CECS 100", "src/Images/cardm00.png", new String[] {"ECS 302", "ECS 308"});
	}
	@Override
	public String pass(Player p) {
		p.setLearning(p.getLearning()+1);
		return "1 Learning Chip";
	}
	

}

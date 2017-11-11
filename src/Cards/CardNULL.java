package Cards;

import Model.Card;
import Model.Player;

public class CardNULL extends Card{

	public CardNULL() {
		super("Empty", "src/Images/cardmNULL.png",
				new String[] {});
	}

	@Override
	public String pass(Player p) {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public void fail(Player p) {
	}

	@Override
	public boolean requirement(Player p) {
		return true;
	}
	@Override
	public String effect(Player p) {
		return p.getName()+ "has no card to play!";
	}

}

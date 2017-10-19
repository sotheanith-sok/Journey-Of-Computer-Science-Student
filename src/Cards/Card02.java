package Cards;
import Model.Card;
import Model.Player;
public class Card02 extends Card {

	public Card02(String name, String effect) {
		super(name, effect);
		// TODO Auto-generated constructor stub
	}
	
	public Card02()
	{
		//super();
		super.setName("02");
		super.setEffect("");
	}
	
	
	@Override
	public Boolean requirement(Player player ,String location, int stat) {
		
		return false;
		// TODO Auto-generated method stub
		
	}


	@Override
	public void effect(Player player) {
		// TODO Auto-generated method stub
		
	}

}

package Cards;
import Source.*;
public class Card3 extends Card {

	public Card3(String name, String effect) {
		super(name, effect);
		// TODO Auto-generated constructor stub
	}
	
	public Card3()
	{
		//super();
		super.setName("");
		super.setEffect("");
	}
	
	@Override
	public void effect(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean requirement(String location, int stat) {
		return false;
		// TODO Auto-generated method stub
		
	}

}

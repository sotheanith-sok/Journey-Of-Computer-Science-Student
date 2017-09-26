package Cards;
import Source.*;
public class Card2 extends Card {

	public Card2(String name, String effect) {
		super(name, effect);
		// TODO Auto-generated constructor stub
	}
	
	public Card2()
	{
		//super();
		super.setName("Card #2");
		super.setEffect("Another Test");
	}

	@Override
	public void effect(Player player) {
		// TODO Auto-generated method stub
		
	}

}

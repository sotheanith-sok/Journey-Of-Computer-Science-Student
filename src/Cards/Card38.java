package Cards;
import Model.Card;
import Model.Player;
public class Card38 extends Card {
	
	public Card38() {
		super("Student Parking", "src/Images/cardm38.png",
				new String[] { "Student Parking" });
	}

	@Override
	public String pass(Player p) {
		// TODO Auto-generated method stub
		p.setCraft(p.getCraft() + 1);
		p.setLocation("Lactation Lounge");
		return " 1 Craft Chips";
	}
	
}

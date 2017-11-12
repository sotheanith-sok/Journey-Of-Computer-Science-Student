package Cards;

import javax.swing.JOptionPane;

import Model.Card;
import Model.Player;

public class Card09 extends Card {

	public Card09() {
		super("Parking Violation", "src/Images/cardm09.png", new String[] { "Forbidden Parking" });
	}

	@Override
	public String pass(Player p) {
		// TODO Auto-generated method stub
		p.setLearning(p.getLearning() + 2);
		if (p.isHuman()) {
			this.dialogoRemoveCard(p);
		}else {
			p.remove(p.getAllCardName().get((int) (Math.random() * p.getAllCardName().size())));
		}

		return "2 Learning Chip";
	}

}

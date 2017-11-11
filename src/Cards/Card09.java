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
		p.setLearning(p.getLearning() + 1);
		if (p.isHuman()) {
			Object[] playerCard = p.getAllCardName().toArray(new Object[p.getPlayerHand().size()]);
			String c = (String) JOptionPane.showInputDialog(null, "Pick a Card to remove:", "Card Effect",
					JOptionPane.PLAIN_MESSAGE, null, playerCard, null);
			p.remove(c);
		}else {
			p.remove();
		}

		return "2 Integrity Chip";
	}

}

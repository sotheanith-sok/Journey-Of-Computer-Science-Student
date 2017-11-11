package View;

import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.Card;

public class rightPanel extends JPanel {
	JLabel card;

	public rightPanel(Card c) {
		card = new JLabel();
		updateIcon(c);
		add(card);
	}

	public void addCardButtonListener(MouseListener cb) {
		card.addMouseListener(cb);
	}

	public void updateIcon(Card c) {
		card.setIcon(new ImageIcon(c.getPath()));
		card.repaint();
	}
}

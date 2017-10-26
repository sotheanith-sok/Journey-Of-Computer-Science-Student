package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Model.Card;
import Model.GameModel;
import Model.Player;
import View.GameView;

public class GameController {
	private GameModel model;
	private GameView view;

	public GameController(GameModel model, GameView view) {
		this.model = model;
		this.view = view;
		view.addMoveButtonListener(new MoveButtonListener());
		view.addPlayCardButtonListener(new PlayCardButtonListener());
	}

	class DrawCardButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

		}
	}

	class MoveButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (view.getSelectedValue() == null) {

			} else {
				model.getPlayerList()[0].setLocation(view.getSelectedValue());
				view.updateAvailableLocation();
				view.updateFeedback(model.getPlayerList()[0]);
				view.getMapPanel().repaint();
				model.AISequencing(model.getPlayerList()[1]);
				view.updateFeedback(model.getPlayerList()[1]);
				view.getMapPanel().repaint();
				model.AISequencing(model.getPlayerList()[2]);
				view.updateFeedback(model.getPlayerList()[2]);
				view.getMapPanel().repaint();

			}
		}
	}

	class PlayCardButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(model.getDeckSize() > 0)
			{
				Card temp =(Card) model.getDeck().getCardMap().get(model.getPlayerList()[0].getHand().get(model.getPlayerList()[0].getHand().getCardIndex()).getName());
				Player player = model.getPlayerList()[0];
				if(temp.requirement(player, player.getLocation(), 0))
				{
					temp.effect(player);
					System.out.println(temp.getName());
					System.out.println("Card is : " + temp.getName());
					String effectDescription = "played " + temp.getCName() + " and " + temp.getEffect();
					view.getInfoPanel().updateFeedback(player, effectDescription);
					model.getPlayerList()[0].getHand().remove(temp);
					if(model.getPlayerList()[0].getHand().getCardIndex() == 0)
					{
						model.getPlayerList()[0].getHand().setCardIndex(0);
					}
					else
					{
						model.getPlayerList()[0].getHand().setCardIndex(model.getPlayerList()[0].getHand().getCardIndex() - 1);
					}
					System.out.println("Deck Size : " + model.getDeckSize());
				}//if requirementment
				else
				{
					JOptionPane.showMessageDialog (null, "You need to meet the requirements to use this card", "Requirement not met", JOptionPane.INFORMATION_MESSAGE);
				}//tells user that they cant use the card yet
			}
			else
			{
				JButton button = (JButton)e.getSource();
				button.setEnabled(false);
				System.out.println("EMPTY");
			}
			view.getInfoPanel().updateScoreBoard();
			view.getControlPanel().getRightPanel().updateCards();
			
			
		}
	}

}

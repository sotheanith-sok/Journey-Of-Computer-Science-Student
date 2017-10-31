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
		model.getPlayerList()[0].setView(view);
	}

	class DrawCardButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(model.getDeckSize() > 0)
			{
				
			}//if
			else
			{
				//(JButton)e.getSource().setEnabled(false);
			}
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
			Player player = model.getPlayerList()[0];
			if(model.getPlayerList()[0].getHand().size() > 0)
			{
				Card currentCard =(Card) model.getDeck().getCardMap().get(model.getPlayerList()[0].getHand().get(model.getPlayerList()[0].getHand().getCardIndex()).getName());
				
				if(currentCard.requirement(player, player.getLocation(), 0))
				{
					currentCard.effect(player);
					System.out.println(currentCard.getName());
					System.out.println("Card is : " + currentCard.getName());
					String effectDescription = "played " + currentCard.getCName() + " and " + currentCard.getEffect();
					view.getInfoPanel().updateFeedback(player, effectDescription);
					
					System.out.println("Deck Size : " + model.getDeckSize());
				}//if requirementment
				else
				{
					JOptionPane.showMessageDialog (null, "You need to meet the requirements to use this card", "Requirement not met", JOptionPane.INFORMATION_MESSAGE);
					currentCard.fail(player);
				}//tells user that they cant use the card yet
				player.getHand().remove(currentCard);
				if(player.getHand().getCardIndex() == 0)
				{
					player.getHand().setCardIndex(0);
				}
				else
				{
					player.getHand().setCardIndex(model.getPlayerList()[0].getHand().getCardIndex() - 1);
				}
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

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
		view.addDrawCardButtListener(new DrawCardButtonListener());
		view.addMoveButtonListener(new MoveButtonListener());
		view.addPlayCardButtonListener(new PlayCardButtonListener());
		model.getPlayerList()[0].setView(view);
	}

	class DrawCardButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			model.getPlayerList()[0].drawCard();
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
			if(player.getHand().size() > 0)
			{
				Card currentCard =(Card) model.getDeck().getCardMap().get(player.getHand().get(player.getHand().getCardIndex()).getName());
				
				if(currentCard.requirement(player, player.getLocation(), 0))
				{
					currentCard.effect(player);
					System.out.println(currentCard.getName());
					System.out.println("Card is : " + currentCard.getName() + " " + currentCard.getCName());
					String effectDescription = "played " + currentCard.getCName() + " and " + currentCard.getEffect();
					view.getInfoPanel().updateFeedback(player, effectDescription);
					
					System.out.println("Deck Size : " + model.getDeckSize());
				}//if requirementment
				else 
				{
					JOptionPane.showMessageDialog (null, "You need to meet the requirements to use this card", "Requirement not met", JOptionPane.INFORMATION_MESSAGE);
					currentCard.fail(player);
					String failMessage = "tried to play " + currentCard.getCName() + ", but failed " + currentCard.getEffect(); 
					view.getInfoPanel().updateFeedback(player, failMessage);
				}//tells user that they cant use the card yet
				
				player.getHand().remove(currentCard);//removes the card regardless if the player meets the requirement or not
				
				if(player.getHand().getCardIndex() == 0)
				{
					player.getHand().setCardIndex(0);
				}
				else
				{
					player.getHand().setCardIndex(player.getHand().getCardIndex() - 1);
				}
			}
			else
			{
				JButton button = (JButton)e.getSource();
				button.setEnabled(false);
				String emptyHandMessage = "'s Hand is empty"; 
				view.getInfoPanel().updateFeedback(player, emptyHandMessage);
				System.out.println("EMPTY");
			}
			
			view.getInfoPanel().updateScoreBoard();
			view.getControlPanel().getRightPanel().updateCards();
			
			
		}
	}
	
	public void playCardAI(Player player)
	{
		
		if(player.getHand().size() > 0)
		{
			//Card currentCard =(Card) model.getDeck().getCardMap().get(model.getPlayerList()[0].getHand().get(model.getPlayerList()[0].getHand().getCardIndex()).getName());
			Card currentCard = player.getHand().get(0);
			//player.getHand().remove(0);
			
			
			if(currentCard.requirement(player, player.getLocation(), 0))
			{
				currentCard.effect(player);
				//System.out.println(currentCard.getName());
				System.out.println("Card is : " + currentCard.getName() + " " + currentCard.getCName());
				String effectDescription = "played " + currentCard.getCName() + " and " + currentCard.getEffect();
				view.getInfoPanel().updateFeedback(player, effectDescription);
				
				System.out.println("Deck Size : " + model.getDeckSize());
			}//if requirementment
			else //wont prompt the ai with a dialog
			{
				currentCard.fail(player);
				String failMessage = "tried to play " + currentCard.getCName() + ", but did not meet the requirements and failed."; 
				view.getInfoPanel().updateFeedback(player, failMessage);
			}
			player.getHand().remove(currentCard);//removes the card regardless if the player meets the requirement or not 
			
			
		}
		else
		{
			//JButton button = (JButton)e.getSource();
			//button.setEnabled(false);
			String emptyHandMessage = player.getName() + "'s Hand is empty"; 
			view.getInfoPanel().updateFeedback(player, emptyHandMessage);
			System.out.println("EMPTY");
		}
		
		view.getInfoPanel().updateScoreBoard();
		view.getControlPanel().getRightPanel().updateCards();
		
	}
	
	
}

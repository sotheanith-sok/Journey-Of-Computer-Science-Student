package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import Model.GameModel;
import View.GameView;

public class GameController {
	private GameModel model;
	private GameView view;
	private int clicked = 0;
	public GameController(GameModel model, GameView view) {
		this.model = model;
		this.view = view;
		view.addMoveButtonListener(new MoveButtonListener());
		view.addPlayCardButtonListener(new PlayCardButtonListener());
		view.addDrawCardButtListener(new DrawCardButtonListener());
		view.addCardButtonListener(new CardLabelListener());
		view.switchOffMoveButton();
		view.switchOffPlayButton();
	}

	class DrawCardButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			model.drawCard(model.getPlayerList().get(0));
			view.updateScoreBoard();
			view.switchOffDrawButton();
			view.switchOnMoveButton();
			view.switchOnPlayButton();
		}
	}

	class MoveButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (view.getSelectedValue() == null) {
				JOptionPane.showMessageDialog(null, "Please select a location.");
			} else {
				model.move(model.getPlayerList().get(0), view.getSelectedValue());
				view.updateAvailableLocation();
				view.getMapPanel().repaint();
				view.updateScoreBoard();
				clicked++;
				if (clicked == 3) {
					view.switchOffMoveButton();
				}
			}
		}
	}

	class PlayCardButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// Human
			view.updateFeedback(model.play(model.getPlayerList().get(0)));
			view.getMapPanel().repaint();
			// AI 1
			model.drawCard(model.getPlayerList().get(1));
			for (int i = 0; i < ((int) (Math.random() * 3) + 1); i++) {
				model.getPlayerList().get(1).setLocation(model.getAvailableLocation(model.getPlayerList().get(1))
						.get((int) Math.random() * model.getAvailableLocation(model.getPlayerList().get(1)).size()));
				model.getPlayerList().get(1).getNextCard();
				view.getMapPanel().repaint();
			}
			view.updateFeedback(model.play(model.getPlayerList().get(1)));
			// AI 2
			model.drawCard(model.getPlayerList().get(2));
			for (int i = 0; i < ((int) (Math.random() * 3) + 1); i++) {
				model.getPlayerList().get(2).setLocation(model.getAvailableLocation(model.getPlayerList().get(2))
						.get((int) Math.random() * model.getAvailableLocation(model.getPlayerList().get(2)).size()));
				model.getPlayerList().get(2).getNextCard();
				view.getMapPanel().repaint();
			}
			view.updateFeedback(model.play(model.getPlayerList().get(2)));
			view.updatePlayerSelectedCard();
			view.updateScoreBoard();
			view.switchOffMoveButton();
			view.switchOffPlayButton();
			view.switchOnDrawButton();
			clicked=0;
		}
	}

	class CardLabelListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			model.getPlayerList().get(0).getNextCard();
			view.updatePlayerSelectedCard();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

}

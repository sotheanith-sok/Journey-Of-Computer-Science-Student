package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.GameModel;
import View.GameView;

public class GameController {
	private GameModel model;
	private GameView view;

	public GameController(GameModel model, GameView view) {
		this.model = model;
		this.view = view;
		view.addMoveButtonListener(new MoveButtonListener());
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

		}
	}

}

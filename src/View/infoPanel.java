package View;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Model.GameModel;
import Model.Player;

public class infoPanel extends JPanel {
	private JTextArea scoreBoard;
	private JTextArea feedback;
	GameModel model;

	public infoPanel(GameModel model) {
		this.model = model;
		setLayout(new GridBagLayout());
		scoreBoard = new JTextArea(7, 20);
		scoreBoard.setFont(new Font("monospaced", Font.BOLD, 20));
		scoreBoard.setEditable(false);
		JScrollPane sb = new JScrollPane(scoreBoard);
		feedback = new JTextArea(2, 20);
		feedback.setFont(new Font("monospaced", Font.ITALIC, 15));
		feedback.setEditable(false);
		JScrollPane f = new JScrollPane(feedback);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.weighty = 0.50;
		add(sb, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.weighty = 0.50;
		gbc.ipady = 0;
		add(f, gbc);
		updateScoreBoard();
	}

	public void updateScoreBoard() {
		ArrayList<Player> playerList = model.getPlayerList();
		String out = String.format("%-20s%-20s%-20s%-20s%-20s\n", "", "Learning", "Craft", "Integrity",
				"Quality Point");
		out += String.format("%-20s%-20d%-20d%-20d%-20d\n", playerList.get(0).getName(),
				playerList.get(0).getLearning(), playerList.get(0).getCraft(), playerList.get(0).getIntegrity(),
				playerList.get(0).getQualityPoints());
		out += String.format("%-20s%-20d%-20d%-20d%-20d\n", playerList.get(1).getName(),
				playerList.get(1).getLearning(), playerList.get(1).getCraft(), playerList.get(1).getIntegrity(),
				playerList.get(1).getQualityPoints());
		out += String.format("%-20s%-20d%-20d%-20d%-20d\n\n", playerList.get(2).getName(),
				playerList.get(2).getLearning(), playerList.get(2).getCraft(), playerList.get(2).getIntegrity(),
				playerList.get(2).getQualityPoints());
		out += String.format("%-40s%-40s\n", "Card in deck: " + model.getInPlayCardDeckSize(),
				"Discards out of play: " + model.getDiscardCardDeckSize());
		out += "You are " + playerList.get(0).getName() + " and you are in " + playerList.get(0).getLocation();
		scoreBoard.setText(out);
	}

	public void updateFeedback(String p) {
		feedback.append(p + "\n");
	}

}

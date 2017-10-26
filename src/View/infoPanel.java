package View;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

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
		Player[] listOfPlayer = model.getPlayerList();
		String out = String.format("%-20s%-20s%-20s%-20s%-20s\n", "", "Learning", "Craft", "Integrity",
				"Quality Point");
		out += String.format("%-20s%-20d%-20d%-20d%-20d\n", listOfPlayer[0].getName(), listOfPlayer[0].getLearning(),
				listOfPlayer[0].getCraft(), listOfPlayer[0].getIntegrity(), listOfPlayer[0].getQualityPoints());
		out += String.format("%-20s%-20d%-20d%-20d%-20d\n", listOfPlayer[1].getName(), listOfPlayer[1].getLearning(),
				listOfPlayer[1].getCraft(), listOfPlayer[1].getIntegrity(), listOfPlayer[1].getQualityPoints());
		out += String.format("%-20s%-20d%-20d%-20d%-20d\n\n", listOfPlayer[2].getName(), listOfPlayer[2].getLearning(),
				listOfPlayer[2].getCraft(), listOfPlayer[2].getIntegrity(), listOfPlayer[2].getQualityPoints());
		out += String.format("%-40s%-40s\n", "Cards left in deck: " + model.getDeckSize(),
				"Discards out of play: " + model.getDiscardCardSize());
		out += "You are " + listOfPlayer[0].getName() + " and you are in " + listOfPlayer[0].getLocation();
		scoreBoard.setText(out);
	}
	public void updateFeedback(Player p) {
		feedback.append(p.getName()+" moves to "+p.getLocation()+"\n");
	}
	public void updateFeedback(Player p , String s)
	{
		feedback.append(p.getName() + " " + s);
	}

}

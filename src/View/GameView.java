package View;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Model.GameModel;
import Model.Player;

public class GameView extends JFrame {

	private GameModel model;
	private double width;
	private double height;
	private JPanel mapPanel;
	private JPanel controlPanel;
	private JPanel infoPanel;

	public GameView(GameModel model) {
		// Initialize Values
		this.model = model;
		width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();

		// Set JFrame setting
		setTitle("CECS 343: Journey of the CS Major");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize((int) width, (int) height);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		// Layout the main panel
		JPanel mainPanel = new JPanel(new GridBagLayout());

		// mapPanel
		mapPanel = new mapPanel(model);
		JScrollPane mapPanelS = new JScrollPane(mapPanel);
		mapPanelS.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		mapPanelS.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		mapPanelS.getVerticalScrollBar().setUnitIncrement(16);
		mapPanelS.getHorizontalScrollBar().setUnitIncrement(16);

		// controlPanel
		controlPanel = new controlPanel(model);
		JScrollPane controllPanelS = new JScrollPane(controlPanel);
		controllPanelS.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		controllPanelS.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		controllPanelS.getVerticalScrollBar().setUnitIncrement(16);
		controllPanelS.getHorizontalScrollBar().setUnitIncrement(16);

		infoPanel = new infoPanel(model);
		mainPanel.setPreferredSize(new Dimension((int) width, (int) height));
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		// Add mapPanel
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 2;
		gbc.weightx = 1;
		gbc.weighty = 0.76;
		mainPanel.add(mapPanelS, gbc);

		// Add controllPanel
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 0.3;
		gbc.weighty = 0.29;
		mainPanel.add(controllPanelS, gbc);

		// Add infoPanel
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.weightx = 0.7;
		gbc.weighty = 0.29;
		mainPanel.add(infoPanel, gbc);
		add(mainPanel);
	}

	public JPanel getControlPanel() {
		return controlPanel;
	}

	public JPanel getInfoPanel() {
		return infoPanel;
	}

	public JPanel getMapPanel() {
		return mapPanel;
	}

	public String getSelectedValue() {
		return ((controlPanel) controlPanel).getSelectValue();
	}

	public void addDrawCardButtListener(ActionListener dcb) {
		((controlPanel) controlPanel).addDrawCardButtListener(dcb);
	}

	public void addMoveButtonListener(ActionListener mb) {
		((controlPanel) controlPanel).addMoveButtonListener(mb);
	}

	public void addPlayCardButtonListener(ActionListener pbc) {
		((controlPanel) controlPanel).addPlayCardButtonListener(pbc);
	}

	public void addCardButtonListener(MouseListener bc) {
		((controlPanel) controlPanel).addCardButtonListener(bc);
	}

	public void updateAvailableLocation() {
		((controlPanel) controlPanel).upDateLocation();
	}

	public void updateFeedback(String p) {
		((infoPanel) infoPanel).updateFeedback(p);
	}

	public void updateScoreBoard() {
		((infoPanel) infoPanel).updateScoreBoard();
	}

	public void updatePlayerSelectedCard() {
		((controlPanel) controlPanel).updatePlayerSelectedCard();
	}

	public void switchOnDrawButton() {
		((controlPanel) controlPanel).switchOnDrawButton();
	}

	public void switchOffDrawButton() {
		((controlPanel) controlPanel).switchOffDrawButton();
	}

	public void switchOnPlayButton() {
		((controlPanel) controlPanel).switchOnPlayButton();
	}

	public void switchOffPlayButton() {
		((controlPanel) controlPanel).switchOffPlayButton();
	}

	public void switchOnMoveButton() {
		((controlPanel) controlPanel).switchOnMoveButton();
	}

	public void switchOffMoveButton() {
		((controlPanel) controlPanel).switchOffMoveButton();
	}
}

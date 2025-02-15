package View;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

import Model.Card;
import Model.GameModel;
import Model.Player;

public class controlPanel extends JPanel {
	private JList<String> list;
	private DefaultListModel<String> availableLocation;
	JPanel leftPanel;
	JPanel rightPanel;
	GameModel model;

	public controlPanel(GameModel model) {
		this.model = model;
		setLayout(new GridBagLayout());
		availableLocation = new DefaultListModel<String>();
		upDateLocation();
		// Left Panel
		list = new JList<String>(availableLocation);
		leftPanel = new leftPanel(list);

		// Right Panel
		rightPanel = new rightPanel(model.getPlayerList().get(0).getSelectedCard());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 10, 0, 0);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 10;
		gbc.gridheight = 40;
		gbc.weightx = 0.7;
		gbc.weighty = 1;
		add(leftPanel, gbc);
		gbc.gridx = 10;
		gbc.gridy = 0;
		gbc.gridwidth = 10;
		gbc.gridheight = 40;
		gbc.weightx = 0.3;
		gbc.weighty = 1;
		add(rightPanel, gbc);
		upDateLocation();

	}

	public void addDrawCardButtListener(ActionListener dcb) {
		((leftPanel) leftPanel).addDrawCardButtListener(dcb);
	}

	public void addMoveButtonListener(ActionListener mb) {
		((leftPanel) leftPanel).addMoveButtonListener(mb);
	}

	public void addPlayCardButtonListener(ActionListener pbc) {

		((leftPanel) leftPanel).addPlayCardButtonListener(pbc);
	}

	public void addCardButtonListener(MouseListener cb) {
		((rightPanel) rightPanel).addCardButtonListener(cb);
	}

	public void upDateLocation() {
		ArrayList<String> s = new ArrayList<String>(model.getAvailableLocation(model.getPlayerList().get(0)));
		availableLocation.clear();
		for (String val : s)
			availableLocation.addElement(val);
	}

	public String getSelectValue() {
		return list.getSelectedValue();
	}

	public void updatePlayerSelectedCard() {
		((rightPanel) rightPanel).updateIcon(model.getPlayerList().get(0).getSelectedCard());
	}

	public void switchOnDrawButton() {
		((leftPanel) leftPanel).switchOnDrawButton();
	}

	public void switchOffDrawButton() {
		((leftPanel) leftPanel).switchOffDrawButton();
	}

	public void switchOnPlayButton() {
		((leftPanel) leftPanel).switchOnPlayButton();
	}

	public void switchOffPlayButton() {
		((leftPanel) leftPanel).switchOffPlayButton();
	}

	public void switchOnMoveButton() {
		((leftPanel) leftPanel).switchOnMoveButton();
	}

	public void switchOffMoveButton() {
		((leftPanel) leftPanel).switchOffMoveButton();
	}

}

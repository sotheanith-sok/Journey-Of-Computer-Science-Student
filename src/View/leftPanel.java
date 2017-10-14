package View;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class leftPanel extends JPanel {
	private JButton drawCardButton;
	private JButton moveButton;
	private JButton playCardButton;
	public leftPanel(JList<String> list) {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		drawCardButton = new JButton("Draw Card");
		moveButton = new JButton("Move");
		playCardButton = new JButton("Play Card");
		gbc.fill=GridBagConstraints.VERTICAL;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 20;
		gbc.gridheight = 10;
		gbc.weightx = 1;
		gbc.weighty = 0.3;	
		gbc.ipadx=10;
		
		add(drawCardButton,gbc);
		
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 10;
		gbc.gridwidth = 20;
		gbc.gridheight = 10;
		gbc.weightx = 1;
		gbc.weighty = 0.3;	
		gbc.ipadx=40;
		
		add(moveButton,gbc);
		
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 20;
		gbc.gridwidth = 20;
		gbc.gridheight = 10;
		gbc.weightx =1;
		gbc.weighty = 0.3;	
		gbc.ipadx=17;
		add(playCardButton,gbc);
		

		JScrollPane listScrollable = new JScrollPane(list);
		listScrollable.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		listScrollable.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 30;
		gbc.gridwidth = 40;
		gbc.gridheight = 10;
		gbc.weightx = 1;
		gbc.weighty = 0.7;	
		gbc.ipadx=100;
		add(listScrollable,gbc);
	}
	public void addDrawCardButtListener(ActionListener dcb) {
		drawCardButton.addActionListener(dcb);
	}

	public void addMoveButtonListener(ActionListener mb) {
		moveButton.addActionListener(mb);
	}

	public void addPlayCardButtonListener(ActionListener pbc) {
		playCardButton.addActionListener(pbc);
	}
}

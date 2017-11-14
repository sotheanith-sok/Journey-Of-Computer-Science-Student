package Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * 
 * This card class contains all informations associated with this object
 */
public abstract class Card {

	private String name;
	private String path;
	protected ArrayList<String> location;
	protected String output = "";
	protected int count = 0;

	public Card(String name, String path, String[] location) {
		this.name = name;
		this.path = path;
		this.location = new ArrayList<String>(Arrays.asList(location));
	}

	public Card() {
		this.name = "NULL";
		this.path = "NULL";
	}

	public String getName() {
		return name;
	}

	public String getPath() {
		return path;
	}

	public ArrayList<String> getPlayableLocation() {
		return location;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void fail(Player p) {
		p.setQualityPoints(p.getQualityPoints() - 2);
	}

	public String effect(Player p) {
		output = p.getName() + " played " + getName();
		if (requirement(p) == true) {
			String out = pass(p);
			if (count == 1) {
				output += " for 1 Integrity Chip" + out;
			} else if (count == 2) {
				output += " for 1 Learning Chip" + out;
			} else if (count == 3) {
				output += " for 1 Craft Chip" + out;
			} else {
				output += " for" + out;
			}
		} else {
			output += " failed.";
			fail(p);
		}
		return output;
	}

	public abstract String pass(Player p);

	public boolean requirement(Player p) {
		return location.contains(p.getLocation());
	}

	/**
	 * integrity, learning, craft
	 * 
	 * @param integrity
	 * @param learning
	 * @param craft
	 * @param p
	 */
	public void dialogChipOption(boolean integrity, boolean learning, boolean craft, Player p) {
		ArrayList<Object> buttonList = new ArrayList<Object>();
		JButton image1 = new JButton("Integrity", new ImageIcon("src/Images/IntegrityChip.png"));
		JButton image2 = new JButton("Learning", new ImageIcon("src/Images/LearningChip.png"));
		JButton image3 = new JButton("Craft", new ImageIcon("src/Images/CraftChip.png"));

		image1.setHorizontalTextPosition(JButton.CENTER);
		image1.setVerticalTextPosition(JButton.EAST);
		image2.setHorizontalTextPosition(JButton.CENTER);
		image2.setVerticalTextPosition(JButton.EAST);
		image3.setHorizontalTextPosition(JButton.CENTER);
		image3.setVerticalTextPosition(JButton.EAST);
		image1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p.setIntegrity(p.getIntegrity() + 1);
				count = 1;
				JOptionPane.getRootFrame().dispose();
			}
		});
		image2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p.setLearning(p.getLearning() + 1);
				count = 2;
				JOptionPane.getRootFrame().dispose();
			}
		});
		image3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p.setCraft(p.getCraft() + 1);
				count = 3;
				JOptionPane.getRootFrame().dispose();
			}
		});
		if (learning == true)
			buttonList.add(image2);
		if (craft == true)
			buttonList.add(image3);
		if (integrity == true)
			buttonList.add(image1);

		JOptionPane.showOptionDialog(null, "Pick the desire chip:", "Chip Options", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
				null, buttonList.toArray(new Object[buttonList.size()]), null);
	}

	public void dialogoRemoveCard(Player p) {
		ArrayList<Object> buttonList = new ArrayList<Object>();
		for (int i = 0; i < p.getPlayerHand().size(); i++) {
			JButton image = new JButton(p.getPlayerHand().get(i).getName(),
					new ImageIcon(p.getPlayerHand().get(i).getPath()));
			image.setHorizontalTextPosition(JButton.CENTER);
			image.setVerticalTextPosition(JButton.EAST);
			image.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					p.remove(image.getText());
					JOptionPane.getRootFrame().dispose();
				}
			});
			buttonList.add(image);

		}

		JOptionPane.showOptionDialog(null, "Select card to be remove: ", "Card Effect", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, buttonList.toArray(new Object[buttonList.size()]), null);
	}
}

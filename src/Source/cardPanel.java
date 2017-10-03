package Source;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import Cards.*;

public class cardPanel extends JTabbedPane{

	ArrayList<JButton> cardButton = new ArrayList<JButton>();
	ArrayList<Card> cards = new ArrayList<Card>();
	
	public cardPanel()
	{
		setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setForeground(Color.BLACK);
		setBackground(Color.WHITE);
		//cards.add(new Card("Test" , "Just a Test"));
		cards.add(new Card1());
		cards.add(new Card2());
		for(Card c : cards)
		{
			JButton temp = new JButton("<html>" + c.getName() + "<br />" + c.getDescription() + "</html>");
			temp.setName(c.getName());
			temp.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					Effect.changePlayer(c, Frame.players.get(0));
					Frame.playerScore.get(0).setText("Skill Chips: " + Frame.players.get(0).getSkillChips() + "     Quality Points: " + Frame.players.get(0).getQualityPoints() +"     Learning: " + Frame.players.get(0).getLearning() + "     Craft: " + Frame.players.get(0).getCraft() + "     Integrity: " + Frame.players.get(0).getIntegrity() );
					temp.setEnabled(false);
					//removeTabAt(index);
				}});
			cardButton.add(temp);
			addTab(cardButton.get(cardButton.size()-1).getName(), null, cardButton.get(cardButton.size()-1), null);
		}
		
	}
	
	
}

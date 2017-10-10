package Source;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class controlPanel extends JPanel {

	public controlPanel()
	{
		setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setForeground(Color.BLACK);
		setBackground(Color.WHITE);
		setLayout(new GridLayout(4, 0, 0, 0));
		
		JButton drawCardButton = new JButton("Draw Card");
		add(drawCardButton);
		
		JButton moveButton = new JButton("Move");
		add(moveButton);
		
		JTextPane controlTextPanel = new JTextPane();
		controlTextPanel.setEditable(false);
		add(controlTextPanel);
	}
}

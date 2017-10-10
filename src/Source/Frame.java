package Source;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JTextPane;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JScrollBar;

public class Frame extends JFrame {

	private JPanel contentPane;
	
	public int totalPlayers = 3;
	private int defaultWidth = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() , defaultHeight = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	public static ArrayList<Player> players = new ArrayList<Player>();
	public static ArrayList<JLabel> playerName = new ArrayList<JLabel>();
	public static ArrayList<JLabel> playerScore = new ArrayList<JLabel>();
	public BufferedImage map;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
		});
		
	}

	
	class mapPanelBackground extends JPanel
	{
		
		 @Override
		  protected void paintComponent(Graphics g) {
		    super.paintComponent(g);
		    Graphics2D g2 = (Graphics2D) g;
		   
		    //g2.scale(1.58, 1);
		    
		    g2.scale(1, 1);
		    g2.drawImage(map,0,0,null); // paints the image of the map onto the background 
		  }
		 	
	}
	
	//updates all variables in the game
	public void update()
	{
		for(int i = 0 ; i < totalPlayers ; i++)
		{
			playerScore.get(i).setText("Skill Chips: " + players.get(i).getSkillChips() + "     Quality Points: " + players.get(i).getQualityPoints() +"     Learning: " + players.get(i).getLearning() + "     Craft: " + players.get(i).getCraft() + "     Integrity: " + players.get(i).getIntegrity());
		}
		
	}
	
	/**
	 * Create the frame.
	 */
	public Frame() {
	
		try {													// Loads the image of the CSULB map
		    map = ImageIO.read(new File("src\\csulbMap.png"));
		} catch (IOException e) {
			System.err.println("Image not found");		//If the image file isnt found
		}
		
		setTitle("CECS 343 CECSBS Project");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(defaultWidth,defaultHeight);
		setBounds(0, 0, getWidth(), getHeight());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		contentPane.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		

		
///////////////////JSCROLLPANE////////////////////////////		
		JPanel mapCanvas = new mapPanelBackground();
		JScrollPane mapPanel = new JScrollPane();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		gbc.gridheight = 2;
		gbc.weightx = 1;
		gbc.weighty = 0.80;
		contentPane.add(mapPanel,gbc);
		contentPane.updateUI();
		mapPanel.setHorizontalScrollBarPolicy(
				   JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		mapPanel.setVerticalScrollBarPolicy(
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//mapPanel.setPreferredSize(new Dimension(defaultWidth , defaultHeight));
		JPanel locationPanel = new mapPanelBackground();
		locationPanel.setPreferredSize(new Dimension(map.getWidth() * 4 , map.getHeight() * 4));
		locationPanel.setLayout(null);
		
		
		mapPanel.setViewportView(locationPanel);
		mapPanel.getVerticalScrollBar().setUnitIncrement(15);
		mapPanel.getHorizontalScrollBar().setUnitIncrement(15);
		//JScrollBar verticalBar = mapPanel.getVerticalScrollBar();
		//verticalBar.setValue(mapPanel.getVerticalScrollBar().getMaximum());
		//verticalBar.setValue(mapPanel.getVerticalScrollBar().getMaximum());
		mapPanel.getViewport().setViewPosition(new Point(2000,1810));
/////////////////////JSCROLLPANE///////////////////////////////////////		
		
		
////////////////////UI BUTTONS/////////////////////////
		JPanel playerPanel = new JPanel();
		playerPanel.setBackground(Color.DARK_GRAY);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 3;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.weighty = 0.2;
		contentPane.add(playerPanel,gbc);
		playerPanel.setBounds(getX(), getY(), getWidth(), getHeight()/2);
		playerPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JTabbedPane cardPanel = new cardPanel();
		
		playerPanel.add(cardPanel);

		JPanel infoPanel = new JPanel();
		playerPanel.add(infoPanel);
		infoPanel.setLayout(new GridLayout(0, 1, 0, 0));
///////////////////UI BUTTONS/////////////////////////////////////////////		
		

		
/////////////////SCORE///////////////////////
		JPanel namePanel = new JPanel();
		infoPanel.add(namePanel);
		namePanel.setLayout(new GridLayout(0, 1, 0, 0));
		JPanel scorePanel = new JPanel();
		namePanel.add(scorePanel);
		scorePanel.setBackground(Color.GRAY);
		scorePanel.setLayout(new GridLayout(totalPlayers, 2, 0, 0));

		for(int i = 0 ; i < totalPlayers ; i++)
		{
			
			players.add(new Player());
			if(i == 0)			// Prompts User for name before the program continues
			{
				players.get(i).setName(players.get(i).promptName());
				playerName.add(new JLabel(players.get(i).getName()));
			
			}
			else //else the rest of the names are AI by default
			{
				playerName.add(new JLabel(players.get(i).getName() + (i)));
			}
			
	
			playerScore.add(new JLabel("Skill Chips: " + players.get(i).getSkillChips() + "     Quality Points: " + players.get(i).getQualityPoints() +"     Learning: " + players.get(i).getLearning() + "     Craft: " + players.get(i).getCraft() + "     Integrity: " + players.get(i).getIntegrity()));
			playerScore.get(i).setVerticalAlignment(SwingConstants.CENTER);
			playerScore.get(i).setFont(new Font("Tahoma", Font.BOLD, 13));
			playerScore.get(i).setHorizontalAlignment(SwingConstants.LEFT);
			playerName.get(i).setVerticalAlignment(SwingConstants.CENTER);
			playerName.get(i).setFont(new Font("Tahoma", Font.BOLD, 21));
			scorePanel.add(playerName.get(i));
			scorePanel.add(playerScore.get(i));
		}
////////////////////SCORE//////////////////////////////////	
		
///////////////////////////TEXT FIELD////////////////////
			JTextPane resultsPanel = new JTextPane();
			resultsPanel.setBackground(Color.WHITE);
			resultsPanel.setEditable(false);
			infoPanel.add(resultsPanel);
///////////////////////////////////////////////////////////
	}

}

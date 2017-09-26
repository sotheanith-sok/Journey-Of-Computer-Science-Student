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
import javax.swing.JScrollBar;

public class Frame extends JFrame {

	private JPanel contentPane;
	
	public int totalPlayers = 3;
	private int defaultWidth = 1200 , defaultHeight = 800;
	public ArrayList<Player> players = new ArrayList<Player>();
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
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	class mapPanelBackground extends JPanel
	{
		
		 @Override
		  protected void paintComponent(Graphics g) {
		    super.paintComponent(g);
		    g.drawImage(map,0,0,null); // paints the image of the map onto the background 
		  }
		 	
	}
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
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		JPanel mapCanvas = new mapPanelBackground();
		mapCanvas.setPreferredSize(new Dimension(map.getWidth(), map.getHeight()));
		JScrollPane mapPanel = new JScrollPane(mapCanvas);
		mapPanel.setHorizontalScrollBarPolicy(
				   JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		mapPanel.setVerticalScrollBarPolicy(
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		
		
		contentPane.add(mapPanel);
		
		JPanel playerPanel = new JPanel();
		playerPanel.setBackground(Color.DARK_GRAY);
		contentPane.add(playerPanel);
		playerPanel.setBounds(getX(), getY(), getWidth(), getHeight()/2);
		playerPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JTabbedPane cardPanel = new JTabbedPane(JTabbedPane.TOP);
		cardPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		cardPanel.setForeground(Color.BLACK);
		cardPanel.setBackground(Color.WHITE);
		playerPanel.add(cardPanel);
		
		JButton card1 = new JButton("");
		cardPanel.addTab("Cards", null, card1, null);
		
		JPanel infoPanel = new JPanel();
		playerPanel.add(infoPanel);
		infoPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel namePanel = new JPanel();
		infoPanel.add(namePanel);
		
		JPanel scorePanel = new JPanel();
		namePanel.add(scorePanel);
		scorePanel.setBackground(Color.GRAY);
		scorePanel.setLayout(new GridLayout(totalPlayers, 2, 0, 0));
		
		JPanel scoreInfoPanel = new JPanel();
		namePanel.add(scoreInfoPanel);
		scoreInfoPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		ArrayList<JLabel> playerName = new ArrayList<JLabel>();
		ArrayList<JLabel> playerScore = new ArrayList<JLabel>();

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
			
	
			playerScore.add(new JLabel("Learning: " + players.get(i).getLearning() + "     Craft: " + players.get(i).getCraft() + "     Integrity: " + players.get(i).getIntegrity()));
			playerScore.get(i).setVerticalAlignment(SwingConstants.CENTER);
			playerScore.get(i).setFont(new Font("Tahoma", Font.BOLD, 13));
			playerScore.get(i).setHorizontalAlignment(SwingConstants.LEFT);
			playerName.get(i).setVerticalAlignment(SwingConstants.CENTER);
			playerName.get(i).setFont(new Font("Tahoma", Font.BOLD, 21));
			scorePanel.add(playerName.get(i));
			scorePanel.add(playerScore.get(i));
		}
		
			JTextPane resultsPanel = new JTextPane();
			resultsPanel.setBackground(Color.WHITE);
			resultsPanel.setEditable(false);
			infoPanel.add(resultsPanel);
	}

}

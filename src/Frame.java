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
	
	public int totalPlayers = 4;
	private int defaultWidth = 1200 , defaultHeight = 800;
	
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
		    g.drawImage(map,0,0,null);
		  }
		 	
	}
	public Frame() {
		try {
		    map = ImageIO.read(new File("src\\csulbMap.png"));
		} catch (IOException e) {
			System.err.println("Image not found");
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
		
		//mapPanel.add(map);
		contentPane.add(mapPanel);
		
		JPanel userPanel = new JPanel();
		userPanel.setBackground(Color.DARK_GRAY);
		contentPane.add(userPanel);
		userPanel.setBounds(getX(), getY(), getWidth(), getHeight()/2);
		userPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JTabbedPane tabbedPanel = new JTabbedPane(JTabbedPane.TOP);
		tabbedPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		tabbedPanel.setForeground(Color.BLACK);
		tabbedPanel.setBackground(Color.WHITE);
		userPanel.add(tabbedPanel);
		
		JButton card1 = new JButton("");
		tabbedPanel.addTab("Cards", null, card1, null);
		
		JPanel infoPanel = new JPanel();
		userPanel.add(infoPanel);
		infoPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel scorePanel = new JPanel();
		scorePanel.setBackground(Color.GRAY);
		infoPanel.add(scorePanel);
		scorePanel.setLayout(new GridLayout(totalPlayers, 2, 0, 0));
		
		ArrayList<JLabel> playerName = new ArrayList<JLabel>();
		ArrayList<JLabel> playerScore = new ArrayList<JLabel>();
		ArrayList<Integer> playerScoreVal = new ArrayList<Integer>();
		for(int i = 0 ; i < totalPlayers ; i++)
		{
			playerName.add(new JLabel("Player #" + (i+1)));
			playerScoreVal.add(0);
			playerScore.add(new JLabel("Score : " + playerScoreVal.get(i)));
			playerScore.get(i).setVerticalAlignment(SwingConstants.CENTER);
			playerScore.get(i).setFont(new Font("Tahoma", Font.BOLD, 21));
			playerName.get(i).setVerticalAlignment(SwingConstants.CENTER);
			playerName.get(i).setFont(new Font("Tahoma", Font.BOLD, 21));
			scorePanel.add(playerName.get(i));
			scorePanel.add(playerScore.get(i));
		}
		/*
		JLabel user1 = new JLabel("User #1");
		user1.setFont(new Font("Tahoma", Font.BOLD, 21));
		user1.setVerticalAlignment(SwingConstants.TOP);
		scorePanel.add(user1);
		
		JLabel user2 = new JLabel("User #2");
		user2.setVerticalAlignment(SwingConstants.TOP);
		scorePanel.add(user2);
		
		JLabel user3 = new JLabel("User #3");
		user3.setVerticalAlignment(SwingConstants.TOP);
		scorePanel.add(user3);
		
		JLabel user4 = new JLabel("User #4");
		user4.setVerticalAlignment(SwingConstants.TOP);
		scorePanel.add(user4);//*/
		
		JTextPane resultsPanel = new JTextPane();
		resultsPanel.setBackground(Color.WHITE);
		resultsPanel.setEditable(false);
		infoPanel.add(resultsPanel);
	}

}

package Model;

import java.util.Random;

import javax.swing.JOptionPane;

import View.GameView;

public abstract class Card {

	private String name ,cName , cLocation , effect;
	private GameModel model;
	private GameView view;
	private String ECS[] = {"Computer Lab" , "ECS 302" , "Eat Club" , "CECS Conference Room" ,"North Hall" ,"South Hall" ,"Room of Retirement" ,"Elevators" ,"ECS 308" ,"Lactation Lounge"};
	/*public Card(String name , String cName , String cLocation ,  String effect, GameModel model , GameView view)
	{
		this.name = name;
		this.cName = cName;
		this.cLocation = cLocation;
		this.effect = effect;
		this.model = model;
		this.view = view;
	}*/
	public Card(GameModel model)
	{
		this.model = model;
	}
	
	public Card()
	{
		
	}
	public String getCName()
	{
		return cName;
	}
	public String getCLocation()
	{
		return cLocation;
	}
	public String getName() {
		return name;
	}
	
	public String[] getECS()
	{
		return ECS;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void setCName(String cName) {
		this.cName = cName;
	}
	
	public void setCLocation(String cLocation)
	{
		this.cLocation = cLocation;
	}
	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}
	public GameModel getModel()
	{
		return model;
	}
	public GameView getView()
	{
		return view;
	}
	
	public void chooseOne(Player player , String firstMessage)
	{
		
		String tempEffect = firstMessage + " ";
		
		
		if(player == model.listOfPlayer[0])
		{
			String[] options = {"Get 1 Learning Chip" , "Get 1 Craft Chip" , "Get 1 Integrity Chip" , "Get 1 Quality Point"};
			Object chip = null;
			while(chip == null)
			{
				chip = JOptionPane.showInputDialog(null, "Select One",
			        "", JOptionPane.QUESTION_MESSAGE, null, options , options[0]);
			}
			if(chip.equals(options[0]))
			{
				player.setLearning(player.getLearning() + 1);
				tempEffect += "1 Learning Chip";
			}
			else if(chip.equals(options[1]))
			{
				player.setCraft(player.getCraft() + 1);
				tempEffect += "1 Craft Chip";
			}
			else if(chip.equals(options[2]))
			{
				player.setIntegrity(player.getIntegrity() + 1);
				tempEffect += "1 Integrity Chip";
			}
			else if(chip.equals(options[3]))
			{
				player.setQualityPoints(player.getQualityPoints() + 1);
				tempEffect += "1 additional Quality Point";
			}
		}
		else //AI
		{
			Random rand = new Random();
			int choice = rand.nextInt(4 + 1 - 1) + 1;
			switch(choice)
			{
				case 1: 
					player.setLearning(player.getLearning() + 1);
					tempEffect += "1 Learning Chip";
					break;
				case 2 : 
					player.setCraft(player.getCraft() + 1);
					tempEffect += "1 Craft Chip";
					break; 
				case 3 : 
					player.setIntegrity(player.getIntegrity() + 1);
					tempEffect += "1 Integrity Chip";
					break;
				case 4 :
					player.setQualityPoints(player.getQualityPoints() + 1);
					tempEffect += "1 additional Quality Point";
					break;
			}
			
		}
		
		setEffect(tempEffect);
		
	}
	

	
	public abstract void effect(Player player);
	public void fail(Player player)
	{
		
		setEffect("");
		
		
	}
	
	public abstract Boolean requirement(Player player, String location , int stat);
	
}

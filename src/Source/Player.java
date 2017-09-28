package Source;
import java.util.Random;

import javax.swing.JOptionPane;

public class Player {

	int score, skillChips , qualityPoints , learning, craft , integrity;
	String name = "";
	String location = "";
	
	public Player()
	{
		name = "AI ";
		Random rand = new Random();
		learning = rand.nextInt(3) + 1;
		craft = rand.nextInt(3) + 1;
		integrity = rand.nextInt(3) + 1;
		System.out.println(name + " " + learning + " " + craft + " " + integrity);
	}
	
	public Player(String n)
	{
	name = n;
	}
	
	public int getScore(){
		return score;
	}
	
	public String getName(){
		return name;
	}
	
	public void setScore(int score){
		this.score = score;
	}
	
	public void addScore()
	{
		score += 1;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public int getSkillChips() {
		return skillChips;
	}

	public void setSkillChips(int skillChips) {
		this.skillChips = skillChips;
	}

	public int getQualityPoints() {
		return qualityPoints;
	}

	public void setQualityPoints(int qualityPoints) {
		this.qualityPoints = qualityPoints;
	}

	public int getLearning() {
		return learning;
	}

	public void setLearning(int learning) {
		this.learning = learning;
	}

	public int getCraft() {
		return craft;
	}

	public void setCraft(int craft) {
		this.craft = craft;
	}

	public int getIntegrity() {
		return integrity;
	}

	public void setIntegrity(int integrity) {
		this.integrity = integrity;
	}
	
	public String getLocation()
	{
		return location;
	}
	
	public void setLocation(String location)
	{
		this.location = location;
	}
	
	public String promptName()
	{
		boolean valid = false;
		String userName = null;
		while(!valid)
		{
			userName = (String)JOptionPane.showInputDialog("Please Enter Your Name");
			if(userName != null && userName.length() > 0)
			{
				valid = true;
			}
			else
			{
				JOptionPane.showMessageDialog(null ,"Your name must be at least 1 character, please try again!");
			}
		
		}
		return userName;
	}
	
	
}


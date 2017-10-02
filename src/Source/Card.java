package Source;

public abstract class Card {

	private String name;
	private String description;
	private String location;
	private int learning=0; 
	private int crafting=0;
	private int integrity=0;
	public Card(String name , String description, String location, int learning, int crafting, int integrity)
	{
		this.name = name;
		this.description= description;
		this.location=location;
		this.learning=learning;
		this.crafting=crafting;
		this.integrity=integrity;
	}
	
	public Card()
	{
		this.name="NULL";
		this.description="NULL";
		this.location="NULL";
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}
	
	public abstract void effect(Player player);
	
	public abstract Boolean requirement(String location , int stat);
	
}

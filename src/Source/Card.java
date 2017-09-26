package Source;

public abstract class Card {

	private String name , effect;
	
	public Card(String name , String effect)
	{
		this.name = name;
		this.effect = effect;
	}
	
	public Card()
	{}
	
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
}

package Model;

import View.GameView;

public abstract class Card {

	private String name ,cName , effect;
	private GameModel model;
	private GameView view;
	
	public Card(String name , String cName ,  String effect, GameModel model , GameView view)
	{
		this.name = name;
		this.cName = cName;
		this.effect = effect;
		this.model = model;
		this.view = view;
	}
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
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCName(String cName) {
		this.cName = cName;
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
	
	public abstract void effect(Player player);
	
	
	public abstract Boolean requirement(Player player, String location , int stat);
	
}

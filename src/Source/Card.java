package Source;

/**
 * 
 * This card class contains all informations associated with this object
 */
public class Card {

	private String name;
	private String description;
	
	/**
	 * Location is parsed by "," 
	 */
	private String location;
	private int learning = 0;
	private int craft = 0;
	private int integrity = 0;
	
	/**
	 * Year 1 is freshman.
	 */
	private int year = 1;
	
	/**
	 * For all the effectIndex, look at effect class. 
	 */
	private int effectIndex = -1;
	
	/**
	 * effectModifider: amount of changes occurred.
	 */
	private int effectModifier = -1;

	public Card(String name, String description, String location, int learning, int craft, int integrity, int year,
			int effectIndex, int effectModifier) {
		this.name = name;
		this.description = description;
		this.location = location;
		this.learning = learning;
		this.craft = craft;
		this.integrity = integrity;
		this.year = year;
		this.effectIndex = effectIndex;
		this.effectModifier = effectModifier;
	}

	public Card() {
		this.name = "NULL";
		this.description = "NULL";
		this.location = "NULL";
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getLocation() {
		return location;
	}

	public int getRequiredLearning() {
		return learning;
	}

	public int getRequiredCraft() {
		return craft;
	}

	public int getRequiredIntegrity() {
		return integrity;
	}

	public int getRequiredYear() {
		return year;
	}

	public int getEffectIndex() {
		return effectIndex;
	}

	public int getEffectModifier() {
		return effectModifier;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String s) {
		this.description = s;
	}

	public void setLocation(String s) {
		this.location = s;
	}

	public void setRequiredLearning(int i) {
		this.learning = i;
	}

	public void setRequiredCraft(int i) {
		this.craft = i;
	}

	public void setRequiredIntegrity(int i) {
		this.integrity = i;
	}

	public void setRequiredYear(int i) {
		this.year = i;
	}

	public void setEffectIndex(int i) {
		this.effectIndex = i;
	}

	public void setEffectModifier(int i) {
		this.effectModifier = i;
	}

}

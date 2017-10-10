package Source;

public class Location {
	//public String[] locations = {"ECS 308","ECS 309","ECS 310"};
	public String[][] location = new String[][] 
	{	// LOCATION NAME , LOCATION X , LOCATION Y
		{"ECS 308" , "2000" , "1810"}, //ROW 1
		//{}, //ROW 2
		//{}, // ROW 3
		
		
		
	}; 
	
	public Location()
	{
		
	}
	public int getLocationX(String name)
	{
		
		return 0;
	}
	public String getLocation(String locationName)
	{
		locationName = locationName.toUpperCase();
		for(int i = 0 ; i < location.length ; i++)
		{
			if(locationName.equals(location[i][0]))
			{
				return location[i][0];
			}
		}
		System.err.println("Not a valid location");
		//return locations[0];
		return "";
	}
}

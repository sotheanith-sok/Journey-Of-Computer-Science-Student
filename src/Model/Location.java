package Model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Location {
	private HashMap<String, Point> locationCordinate;
	private HashMap<String, ArrayList<String>> availableLocatioon;

	public Location() {
		locationCordinate = new HashMap<String, Point>();
		availableLocatioon = new HashMap<String, ArrayList<String>>();
		addLocationCoordinateData();
		addLocationMapData();
		addLocationMapData();

	}

	private void addLocationCoordinateData() {
		locationCordinate.put("Room of Retirement", new Point(121, 1103));
		locationCordinate.put("Elevators", new Point(425, 1141));
		locationCordinate.put("ECS 308", new Point(580, 1141));
		locationCordinate.put("Lactation Lounge", new Point(868, 1137));
		locationCordinate.put("South Hall", new Point(602, 930));
		locationCordinate.put("North Hall", new Point(131, 903));
		locationCordinate.put("Computer Lab", new Point(132, 772));
		locationCordinate.put("ECS 302", new Point(435, 793));
		locationCordinate.put("Eat Club", new Point(736, 805));
		locationCordinate.put("CECS Conference Room", new Point(898, 802));
		locationCordinate.put("West Walkway", new Point(4, 966));
		locationCordinate.put("Library", new Point(14, 1424));
		locationCordinate.put("LA5", new Point(343, 1425));
		locationCordinate.put("Bratwurst Hall", new Point(830, 1396));
		locationCordinate.put("East Walkway", new Point(1068, 1002));
		locationCordinate.put("Forbidden Parking", new Point(743, 592));
		locationCordinate.put("Rec Center", new Point(322, 586));
		locationCordinate.put("Student Parking", new Point(736, 291));
		locationCordinate.put("Pyramid", new Point(303, 329));
		locationCordinate.put("Japanese Garden", new Point(320, 148));
		locationCordinate.put("George Allen Field", new Point(24, 391));
	}

	private void addLocationMapData() {
		availableLocatioon.put("Room of Retirement", new ArrayList<String>(Arrays.asList("North Hall")));
		availableLocatioon.put("Elevators", new ArrayList<String>(Arrays.asList("LA5","North Hall")));
		availableLocatioon.put("ECS 308", new ArrayList<String>(Arrays.asList("South Hall")));
		availableLocatioon.put("Lactation Lounge", new ArrayList<String>(Arrays.asList("South Hall")));
		availableLocatioon.put("South Hall", new ArrayList<String>(Arrays.asList("ECS 302","Eat Club","CECS Conference Room","Lactation Lounge","ECS 308","East Walkway","North Hall")));
		availableLocatioon.put("North Hall", new ArrayList<String>(Arrays.asList("West Walkway","Computer Lab","Room of Retirement","Elevators","ECS 302","South Hall")));
		availableLocatioon.put("Computer Lab", new ArrayList<String>(Arrays.asList("North Hall")));
		availableLocatioon.put("ECS 302", new ArrayList<String>(Arrays.asList("North Hall","South Hall")));
		availableLocatioon.put("Eat Club", new ArrayList<String>(Arrays.asList("South Hall")));
		availableLocatioon.put("CECS Conference Room", new ArrayList<String>(Arrays.asList("South Hall")));
		availableLocatioon.put("West Walkway", new ArrayList<String>(Arrays.asList("Rec Center","Library","North Hall")));
		availableLocatioon.put("Library", new ArrayList<String>(Arrays.asList("West Walkway","LA5")));
		availableLocatioon.put("LA5", new ArrayList<String>(Arrays.asList("Elevators","Library","Bratwurst Hall")));
		availableLocatioon.put("Bratwurst Hall", new ArrayList<String>(Arrays.asList("East Walkway","LA5")));
		availableLocatioon.put("East Walkway", new ArrayList<String>(Arrays.asList("Bratwurst Hall","South Hall","Forbidden Parking")));
		availableLocatioon.put("Forbidden Parking", new ArrayList<String>(Arrays.asList("Rec Center","East Walkway")));
		availableLocatioon.put("Rec Center", new ArrayList<String>(Arrays.asList("Pyramid","West Walkway","Forbidden Parking","Student Parking")));
		availableLocatioon.put("Student Parking", new ArrayList<String>(Arrays.asList("Japanese Garden","Pyramid","Rec Center","Forbidden Parking")));
		availableLocatioon.put("Pyramid", new ArrayList<String>(Arrays.asList("Japanese Garden","Rec Center","Student Parking","George Allen Field")));
		availableLocatioon.put("Japanese Garden", new ArrayList<String>(Arrays.asList("Pyramid","Student Parking")));
		availableLocatioon.put("George Allen Field", new ArrayList<String>(Arrays.asList("Pyramid")));
	}

	public ArrayList<String> getAvailableLocation(Player p) {
		return availableLocatioon.get(p.getLocation());
	}

	public Point getPlayerCurrentLocationCoordinate(Player p) {
		if (locationCordinate.containsKey(p.getLocation())) {
			return locationCordinate.get(p.getLocation());
		} else {
			return new Point(-1, -1);
		}
	}

}

package Model;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Location {
	private HashMap<String, Point> locationCordinate;
	private HashMap<String, ArrayList<String>> availableLocatioon;

	public Location() {
		locationCordinate = new HashMap<String, Point>();
		Scanner in = null;
		availableLocatioon = new HashMap<String, ArrayList<String>>();
		try {
			in = new Scanner(new File("src/Images/LocationData.txt"));
			while (in.hasNextLine()) {
				String[] locationData = in.nextLine().split("\\|");
				locationCordinate.put(locationData[0], new Point(Integer.parseInt(locationData[1]),Integer.parseInt(locationData[2])));

				availableLocatioon.put(locationData[0],
						new ArrayList<String>(Arrays.asList(locationData[3].split("\\,"))));
			}

		} catch (FileNotFoundException fnoe) {
			fnoe.printStackTrace();
		} finally {
			in.close();
		}
	}

	public ArrayList<String> getAvailableLocation(Player p) {
		return availableLocatioon.get(p.getLocation());
	}

	public Point getPlayerCurrentLocationCoordinate(Player p) {
		if(locationCordinate.containsKey(p.getLocation())) {
			return locationCordinate.get(p.getLocation());
		}else {
			return new Point(-1,-1);
		}
	}

}

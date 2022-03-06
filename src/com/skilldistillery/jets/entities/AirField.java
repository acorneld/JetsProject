package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirField {

	private List<Jet> fleet;
	List<Jet> jets = new ArrayList<>();

	public AirField() {
		populateAirField();
	}

	public AirField(List<Jet> fleet) {
		this.jets = fleet;
	}

	public void populateAirField() {
		File initialPopulate = new File("Jets.txt");
		/*
		 * try { FileReader fr = new FileReader(initialPopulate); BufferedReader br =
		 * new BufferedReader(fr); String onLine;
		 * 
		 * for(int i = 0; i < 5; i++) { onLine = br.readLine(); if(onLine!= null) {
		 * for(int x = 0; x < iPlanes.length; x++) { String[] iPlanes =
		 * onLine.split(", "); // Plane style sorter needed String model = iPlanes[0];
		 */
		try {
			FileReader fr = new FileReader("jets.txt");
			BufferedReader br = new BufferedReader(fr);
			String onLine;
			while ((onLine = br.readLine()) != null) {
				String[] iPlanes = onLine.split(", ");
				String planeType;
				if (iPlanes[0].equals("FighterJet")) {
					FighterJet f1 = new FighterJet();
					f1.setModel(iPlanes[1]);
					f1.setSpeed(Double.parseDouble(iPlanes[2]));
					f1.setRange(Integer.parseInt(iPlanes[3]));
					f1.setPrice(Long.parseLong(iPlanes[4]));
					jets.add(f1);
					// Troubleshoot test sysout
				} else if (iPlanes[0].equals("CargoPlane")) {
					CargoPlane c1 = new CargoPlane();
					c1.setModel(iPlanes[1]);
					c1.setSpeed(Double.parseDouble(iPlanes[2]));
					c1.setRange(Integer.parseInt(iPlanes[3]));
					c1.setPrice(Long.parseLong(iPlanes[4]));
					jets.add(c1);
					// Starting to Copy Paste More, use in README Lessons Learned
				} else {
					JetBase jb1 = new JetBase();
					jb1.setStyle(iPlanes[0]);
					jb1.setModel(iPlanes[1]);
					jb1.setSpeed(Double.parseDouble(iPlanes[2]));
					jb1.setRange(Integer.parseInt(iPlanes[3]));
					jb1.setPrice(Long.parseLong(iPlanes[4]));
					jets.add(jb1);

				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println("Invalid filename: " + e.getMessage());
			return;
		} catch (IOException e) {
			System.err.println("Problem while reading " + "jets.txt" + ": " + e.getMessage());
			return;
		}
	}

	public List<Jet> getFleet() {
		return fleet;
	}

	public void setFleet(List<Jet> fleet) {
		this.fleet = fleet;
	}

	public List<Jet> getJets() {
		return jets;
	}

	public void setJets(List<Jet> jets) {
		this.jets = jets;
	}

	public void listFleet() {
		for (int i = 0; i < jets.size(); i++) {
			System.out.println(i + 1 + " " + jets.get(i));
		}
	}

	public void flyAll() {
		for (Jet jet : jets) {
			jet.fly();
		}
	}

	public Jet viewFastestJet() {
		Jet fastestJet = jets.get(0);
		for (Jet jet : jets) {
			if (jet.getSpeed() > fastestJet.getSpeed()) {
				fastestJet = jet;
			}
		}
		System.out.println(fastestJet);
		return fastestJet;
	}

	public Jet viewLongestRange() {
		Jet longestRange = jets.get(0);
		for (Jet jet : jets) {
			if (jet.getRange() > longestRange.getRange()) {
				longestRange = jet;
			}
		}
		System.out.println(longestRange);
		return longestRange;
	}

	public void loadAllCargo() {
		for (Jet jet : jets) {
			if (jet instanceof CargoPlane) {
				((CargoPlane) jet).load();
				System.out.println("Cargo Plane Loaded");
			}
		}
	}

	public void dogFight() {
		for (Jet jet : jets) {
			if (jet instanceof FighterJet) {
				((FighterJet) jet).fight();
			}
		}
	}

	public void addUserJet() {
		Scanner kb = new Scanner(System.in);

		System.out.println("You would like to add a Jet.");
		System.out.println("Please Enter FighterJet, CargoPlane, or the new Style of your model");
		System.out.println("New Style Example: \"Sesna\" ");
		String style = kb.nextLine();
		System.out.println("What is the Jet's Model?");
		String model = kb.nextLine();
		System.out.println("What is the Jet's Speed?");
		double speed = kb.nextDouble();
		System.out.println("What is the Jet's Range?");
		int range = kb.nextInt();
		System.out.println("What is the Jet's Price?");
		long price = kb.nextLong();
		// Don't need to String and then parseback
		Jet userJet;
		if (style.equalsIgnoreCase("FighterJet")) {
			userJet = new FighterJet(model, speed, range, price);
		} else if (style.equalsIgnoreCase("CargoPlane")) {
			userJet = new CargoPlane(model, speed, range, price);
		} else {
			userJet = new JetBase(style, model, speed, range, price);
		}
		jets.add(userJet);
		kb.close();
	}

	// TODO First stretch to try, use same lines 162-168
	public void removeJet() {
		int removeChoice;
		Scanner kb = new Scanner(System.in);
		System.out.println("You would like to remove a Jet.");
		System.out.println("Please enter the number of the Jet you would like to remove.");
		listFleet();
		removeChoice = kb.nextInt();
		fleet.remove(removeChoice);
		kb.close();
	}
		
	@Override
	public String toString() {
		return "AirField [fleet=" + fleet + ", jets=" + jets + "]";
	}

}

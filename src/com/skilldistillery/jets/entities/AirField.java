package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AirField {

	List<Jet> jets = new ArrayList<>();

	public AirField() {
		populateAirField();

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
				}
				else if(iPlanes[0].equals("CargoPlane")) {
					CargoPlane c1 = new CargoPlane();
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

}

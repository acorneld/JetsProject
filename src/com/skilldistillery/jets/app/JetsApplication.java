package com.skilldistillery.jets.app;

import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;

public class JetsApplication {

	AirField af = new AirField();

	public static void main(String[] args) {
		JetsApplication jetsApp = new JetsApplication();
		jetsApp.menu();
	}

	public void menu() {

		Scanner kb = new Scanner(System.in);
		int menuChoice = 0;
		while (menuChoice != 9) {
			System.out.println("\t MENU \t");
			System.out.println("1. List Fleet");
			System.out.println("2. Fly all Jets");
			System.out.println("3. View Fastest Jet");
			System.out.println("4. View Jet with Longest Range");
			System.out.println("5. Load all Cargo Jets");
			System.out.println("6. Dogfight!");
			System.out.println("7. Add a Jet to Fleet");
			System.out.println("8. Remove a Jet from Fleet");
			System.out.println("9. -xxQUITxx-");
			System.out.println(" ");
			menuChoice = kb.nextInt();

			if (menuChoice == 1) {

				af.listFleet();// Reader/Writer DOES NOT like my use of "_"
				// TODO stop repeating from occuring. (Fixed by moving while loop)
			} else if (menuChoice == 2) {
				af.flyAll();
			} else if (menuChoice == 3) {
				af.viewFastestJet();
			} else if (menuChoice == 4) {
				af.viewLongestRange();
			} else if (menuChoice == 5) {
				af.loadAllCargo();
			} else if (menuChoice == 6) {
				af.dogFight();
			} else if (menuChoice == 7) {
				af.addUserJet();
			} else if (menuChoice == 8) {
				af.removeUserJet();
			} else if (menuChoice == 9) {
				continue;
			}

			
			
		}

	}

}

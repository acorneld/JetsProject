package com.skilldistillery.jets.entities;

public interface CombatReady {

	public default void loadWeapons() {
		System.out.println("Weapons Systems Ready");
	}
}

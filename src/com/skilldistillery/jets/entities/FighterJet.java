package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements CombatReady{
	
	private String weapons;
	public FighterJet() {
		
	}
	
	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	
	FighterJet f1 = new FighterJet(getModel(), getSpeed(), getRange(), getPrice());
	f1.loadWeapons();
	public void fight() {
		System.out.println("Brrrrrtt");
	}

	public String getWeapons() {
		return weapons;
	}

	public void setWeapons(String weapons) {
		this.weapons = weapons;
	}

	public FighterJet getF1() {
		return f1;
	}

	public void setF1(FighterJet f1) {
		this.f1 = f1;
	}
	
	
	
}

package com.skilldistillery.jets.entities;

public class CargoPlane extends Jet implements LoadCargo {

	public CargoPlane() {

	}

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	public void load() {
		System.out.println("Cargo onboard, good to go");
	}

}

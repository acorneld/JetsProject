package com.skilldistillery.jets.entities;

public class Jet {
	
	private String model;
	private double speed;
	private int range;
	private long price;
	private double speedInMach;

	
	public Jet(){
	
	}
	
	public Jet(String model, double speed, int range, long price) {
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}
	
	public void fly() {
	double flightTime = this.range / this.speed;
		System.out.println(this.getModel() + " can floor for " + flightTime + " Taking Off....sshhhhwoo");
	}
	
	
	
	public double convertSpeedInMach(double speed) {
		return speedInMach;
		//Logic for speed in Mach conversion
	}


	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public int getRange() {
		return range;
	}
	
	public void setRange(int range) {
		this.range = range;
	}
	
	public long getPrice() {
		return price;
	}
	
	public void setPrice(long price) {
		this.price = price;
	}
	
	public double getSpeedInMach() {
		return speedInMach;
	}
	public void setSpeedInMach(double speedInMach) {
		this.speedInMach = speedInMach;
	}

	@Override
	public String toString() {
		return "Jet [model=" + model + ", speed=" + speed + ", range=" + range + ", price=" + price + ", speedInMach="
				+ speedInMach + "]";
	}

	






}
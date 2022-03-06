package com.skilldistillery.jets.entities;

public class JetBase extends Jet {
	private String style;

	public JetBase() {
		// IDE added, why different than Cargo/Fighter
	}

	public JetBase(String style, String model, double speed, int range, long price) {
		super(model, speed, range, price);
		setStyle(style);
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

}

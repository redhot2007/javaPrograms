package com.java.design.patterns.visitor;

class Liquor implements IVisitable {
	
	private double price;

	Liquor(double item) {
		price = item;
	}

	public double accept(IVisitor visitor) {
		return visitor.visit(this);
	}

	public double getPrice() {
		return price;
	}
	
}
package de.unistuttgart.interfaces;

public class Beer implements Drinkable {

	@Override
	public void print() {
		System.out.println("Drinking beer because the weather is nice");
	}
}

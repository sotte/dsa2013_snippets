package de.unistuttgart.interfaces2;

import de.unistuttgart.interfaces2.Drinkable;

public class Beer implements Drinkable {

	
	public void lall() {
		System.out.println("loaallll");
	}

	@Override
	public void drink() {
		System.out.println("Beer");
	}
}

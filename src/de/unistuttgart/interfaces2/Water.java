package de.unistuttgart.interfaces2;

import de.unistuttgart.interfaces2.Drinkable;

public class Water implements Drinkable {

	@Override
	public void drink() {
		System.out.println("wasser, frisch");
	}

}

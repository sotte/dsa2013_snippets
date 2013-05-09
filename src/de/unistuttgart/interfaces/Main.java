package de.unistuttgart.interfaces;

import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		LinkedList<Drinkable> minibar = new LinkedList<Drinkable>();
		
		minibar.add(new Beer());
		minibar.add(new Mate());
		minibar.add(new Beer());
		
		for (Drinkable drink : minibar) {
			drink.print();
		}
	}

}

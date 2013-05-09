package de.unistuttgart.interfaces3;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hallo Welt");
		
		Flasche caesarsFlasche = new Flasche(100, "Apfel", new FarbeRGB(255, 0, 0));
		try {
			caesarsFlasche.trinken(200);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Flasche meineFlasche = new Flasche(100, "Apfel", new FarbeRGB(255, 0, 0));

		System.out.println("Anzahl Flaschen:" + Flasche.anzahl);
		/*
		System.out.println("davor" + caesarsFlasche.volumen);
		caesarsFlasche.trinken(10);
		System.out.println("Nach dem trinken:" + caesarsFlasche.volumen);
		*/
	}
}

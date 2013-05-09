package de.unistuttgart.interfaces3;

public class Flasche {

	private int volumen;
	private String inhalt;
	private FarbeRGB farbe;
	static int anzahl = 0;

	public void trinken(int menge) throws Exception {
		if (menge < 0) {
			throw new IllegalArgumentException("haha :)");
		}
		volumen -= menge;
		// volumen = volumen - menge;
		if (volumen < 0) {
			volumen = 0;
			throw new LangweiligeException("leer");
		}
	}

	static public void pfand() {
		System.out.println("keine pfandflasche :(");
	}

	public Flasche(int v, String in, FarbeRGB f) {
		volumen = v;
		inhalt = in;
		farbe = f;

		anzahl++;
	}
}
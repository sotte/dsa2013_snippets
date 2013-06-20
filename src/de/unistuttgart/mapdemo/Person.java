package de.unistuttgart.mapdemo;

public class Person {
	// global counter of the nuber of ppl
	static int personCounter = 0;
	
	String name;
	String tel = "moms phone";
	int matrikelNr;
	
	public Person(String name) {
		// increment static person counter
		personCounter++;
		
		this.name = name;
		this.matrikelNr = personCounter;
	}
	
	public String toString() {
		return name + " -- matrikel: " + matrikelNr;
	}
}

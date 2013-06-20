package de.unistuttgart.mapdemo;

import java.util.Map;
import java.util.TreeMap;

public class MapDemo {

	public static void main(String[] args) {
		// add some ppl
		Map<Integer, Person> ppl = new TreeMap<Integer, Person>();
		for (int i = 0; i < 10; i++) {
			Person p = new Person("person" + i);
			ppl.put(p.matrikelNr, p);
		}

		// now we can lookup ppl really easily!
		Person tmpPerson;
		tmpPerson = ppl.get(1);
		System.out.println(tmpPerson);
		tmpPerson = ppl.get(5);
		System.out.println(tmpPerson);
	}
}

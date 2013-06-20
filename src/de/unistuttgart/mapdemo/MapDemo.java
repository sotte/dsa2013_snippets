package de.unistuttgart.mapdemo;

import java.util.Hashtable;
import java.util.Map;

public class MapDemo {

	public static void main(String[] args) {
		// add some ppl
		Map<Integer, Person> ppl = new Hashtable<Integer, Person>();
		// Alternatively we could also use a tree map
		// see http://docs.oracle.com/javase/6/docs/api/java/util/TreeMap.html
		// Map<Integer, Person> ppl = new TreeMap<Integer, Person>();
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

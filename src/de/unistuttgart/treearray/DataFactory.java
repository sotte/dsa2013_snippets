package de.unistuttgart.treearray;

import java.util.ArrayList;

public class DataFactory {

	/**
	 * | d1 | d2| .. | dn | null | .. | null |
	 * 
	 * @return return array which is partially filled with data.
	 */
	public static ArrayList<Integer> createData() {
		int max_fill = 128;
		ArrayList<Integer> data = new ArrayList<Integer>();
		for (int i = 0; i < max_fill; i++) {
			data.add(null);
		}
		int fill_to = 64;
		for (int i = 0; i < fill_to; i++) {
			data.set(i, i);
		}
		return data;
	}
}

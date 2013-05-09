package de.unistuttgart.ex0;
public class FindText {
	
	public static ProductFact findText(Product product, String text) throws IllegalArgumentException {
		// guards
		if (text == null) {
			throw new IllegalArgumentException("text is null");
		}
		if (product == null) {
			throw new IllegalArgumentException("product null");
		}
		
		
		if (product.getName().equals(text)) {
			return ProductFact.NAME;
		} else if (product.getDescription().equals(text)) {
			// ...
		}
		else {
			throw new IllegalArgumentException("not found");
		}
		return null;
	}
}

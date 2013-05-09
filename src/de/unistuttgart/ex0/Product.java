package de.unistuttgart.ex0;
public class Product {
	private String description;
	private String name;
	private int price;
	private Manufacturer manufacturer;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Product(String name, int price, Manufacturer manufacturer) {
		this.name = name;
		this.price = price;
		this.manufacturer = manufacturer;
	}
}

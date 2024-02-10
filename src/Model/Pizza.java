package Model;

// This is the class which stores the information about the pizza!
public class Pizza {

	// Here are the data related to the pizza which would be stored!
	private String pizzaSize, crustType;
	private String[] toppings;
	
	// This is the constructor which can be used to build a new pizza object!
	public Pizza(String _pizzaSize, String _crustType, String[] _toppings) {
		this.pizzaSize = _pizzaSize;
		this.crustType = _crustType;
		this.toppings = _toppings;
	}
	
	// This function returns the size of the pizza!
	public String getPizzaSize() {
		return this.pizzaSize;
	}
	
	// This function returns the crust type of the pizza!
	public String getCrustType() {
		return this.crustType;
	}
	
	// This function returns the list of the toppings on the pizza!
	public String[] getToppings() {
		return this.toppings;
	}
	
}

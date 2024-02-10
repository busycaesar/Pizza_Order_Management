package Model;

// This class stores all the information about the order!
public class Order {

	// All the data related to the order would be stored here!
	private Pizza pizza;
	private Customer customer;
	private int quantity;
	
	// The Order object can be created by passing these data!
	public Order(Pizza _pizza, Customer _customer, int _quantity) {
		this.pizza = _pizza;
		this.customer = _customer;
		this.quantity = _quantity;
	}
	
	// This function returns the pizza object for this specific order!
	public Pizza getPizza() {
		return this.pizza;
	}
	
	// This function returns the customer information for this order!
	public Customer getCustomer() {
		return this.customer;
	}
	
	// This function returns the quantity of the pizza ordered by the customer!
	public int getQuantity() {
		return this.quantity;
	}
	
}

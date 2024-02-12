package Controller;

import Model.Order;
import Model.Customer;
import Model.Pizza;

// This class controls all the orders!
public class OrderController {

	// The order controller controllers this order object!
	private Order order;
	
	// This constructor accepts all the data and created the order object!
	public OrderController(String _pizzaSize, String _crustType, String[] _toppings, String _customerName, long _customerNumber, int _quantity) {
		
		Pizza pizza = new Pizza(_pizzaSize, _crustType, _toppings);
		Customer customer = new Customer(_customerName, _customerNumber);
		
		this.order = new Order(pizza, customer, _quantity);
		
	}
	
	// This function returns the details of the customer!
	public String getCustomerDetails() {
		return this.order.getCustomer().getCustomerName() + "(" + this.order.getCustomer().getCustomerNumber() + ")";
	}
	
	// This function returns the pizza information!
	public String getPizzaDetails() {
		String pizzaSize = this.order.getPizza().getPizzaSize(),
			   crustType = this.order.getPizza().getCrustType(),
			   // If there are no toppings selected by the user, the system displays no toppings!
			   _toppings = "no toppings";
		String[] toppings = this.order.getPizza().getToppings();
		
		// If there are toppings selected, it will be in .csv form!
		if(toppings.length > 0) _toppings = String.join(", ", this.order.getPizza().getToppings());
		
		// Returning the detail of pizza!
		return pizzaSize + " size, " + crustType + " crust pizza with " + _toppings;
	}
	
	// This function returns the total quantity of pizza ordered!
	public int getPizzaQuantity() {
		return this.order.getQuantity();
	}
	
}

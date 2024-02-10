package Controller;

import Model.Order;
import Model.Customer;
import Model.Pizza;

// This class controls all the orders!
public class OrderController {

	// The order controller controllers this order object!
	private Order order;
	
	// This constructor accepts all the data and created the order object!
	public OrderController(String _pizzaSize, String _crustType, String[] _toppings, String _customerName, int _customerNumber, int _quantity) {
		
		Pizza pizza = new Pizza(_pizzaSize, _crustType, _toppings);
		Customer customer = new Customer(_customerName, _customerNumber);
		
		this.order = new Order(pizza, customer, _quantity);
		
	}
	
	// This function returns the name of the customer!
	public String getCustomerDetails() {
		return this.order.getCustomer().getCustomerName() + "(" + this.order.getCustomer().getCustomerNumber() + ")";
	}
	
	// This function returns the pizza information!
	public String getPizzaDetails() {
		String pizzaSize = this.order.getPizza().getPizzaSize(),
			   crustType = this.order.getPizza().getCrustType(),
			   toppings = String.join(", ", this.order.getPizza().getToppings());
		
		return pizzaSize + " size, " + crustType + " crust pizza with " + toppings;
	}
	
	// This function returns the total quantity of pizza ordered!
	public int getPizzaQuantity() {
		return this.order.getQuantity();
	}
	
}

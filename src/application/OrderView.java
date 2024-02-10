package application;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

import Controller.OrderController;
import UtilityFunctions.Utility;

public class OrderView {

	@FXML
	private Button placeOrderButton;
	@FXML
	private Text orderSummary;
	@FXML
	private TextField customerName, customerNumber, pizzaQuantity;
	@FXML
	private ChoiceBox<String> pizzaSizeList, crustTypeList;
	@FXML
	private VBox toppingsList;
	@FXML
	private CheckBox topPineapple, topExtraCheese, topDriedShrimps, topMushroom, topAnchovies, topSunDriedTomatoes, topDacon, topSpinach, topRostedGarlic, topJalapeno, topGroundBeef, topShreddedChicken, topGrilledChicken, topPepperoni, topHam, topBacon;
	@FXML
	private CheckBox[] toppings, meatToppings;
	
	// This is the object which controls the order of the customer!
	private OrderController orderController;
	private double totalAmount = 0;
	private final double TAX = 0.13;
	
	// This function initializes all the data required by the fxml file for front-end!
	@FXML
	public void initialize() {
		
		this.initiateToppings();
		this.addChoices();
		this.setDefaults();
		
	}
	
	private void initiateToppings() {

		this.toppings = new CheckBox[]{ 
				topPineapple, topExtraCheese, topDriedShrimps, topMushroom, topAnchovies, topSunDriedTomatoes, topDacon, topSpinach, topRostedGarlic, topJalapeno
		};
		this.meatToppings = new CheckBox[] {
				topGroundBeef, topShreddedChicken, topGrilledChicken, topPepperoni, topHam, topBacon
		};
		
	}
	
	@FXML
	// This function sets the default values of all the fields!
	public void setDefaults() {

		this.customerName.clear();
		this.customerNumber.clear();
		this.pizzaQuantity.setText("1");;
		this.pizzaSizeList.setValue("Medium");
		this.crustTypeList.setValue("Normal");
		this.orderSummary.setText("");
		
		for(CheckBox topping: this.toppings) {			
			if(topping.isSelected()) topping.setSelected(false);
		}
		
		for(CheckBox topping: this.meatToppings) {			
			if(topping.isSelected()) topping.setSelected(false);
		}
		
	}
	
	// This function adds the choice to all the drop-down menus!
	private void addChoices() {

		this.pizzaSizeList.getItems().addAll("Small", "Medium", "Large", "X-Large");
		this.crustTypeList.getItems().addAll("Normal", "Thin", "Deep Dish");
		
	}
	
	// This function implements when the place order button is clicked!
	@FXML
	public void handlePlaceOrder() {
		
		// Storing all the data provided!
		String   _pizzaSize = this.pizzaSizeList.getValue(),
				 _crustType = this.crustTypeList.getValue(),
				 _customerName = this.customerName.getText();
		String[] _toppings = this.getSelectedToppings(this.toppings),
				 _meatToppings = this.getSelectedToppings(this.meatToppings);
		int		 _customerNumber = Integer.parseInt(this.customerNumber.getText()),
				 _quantiy = Integer.parseInt(this.pizzaQuantity.getText());
		
		calculatePizzaBasePrice(_pizzaSize, _crustType, _toppings.length, _meatToppings.length, _quantiy);
		
		this.orderController = new OrderController(_pizzaSize, _crustType, Utility.mergeArrays(_toppings, _meatToppings), _customerName, _customerNumber, _quantiy);
		
		// Setting the fields again to default values!
		this.setDefaults();
		
		// Printing the order summary!
		this.printOrderSummary();
		
	}
	
	// This function calculates the price of the pizza according to the size, crust and toppings!
	private void calculatePizzaBasePrice(String _pizzeSize, String _crustType, int _toppings, int _meatToppings, int _quantity) {
		
		switch(_pizzeSize) {
		case "Small":
			this.totalAmount += 8;
			break;
		case "Medium":
			this.totalAmount += 10;
			break;
		case "Large":
			this.totalAmount += 12;
			break;
		default:
			this.totalAmount += 13.75;
			break;
		}
		
		if(_crustType == "Deep Dish") this.totalAmount += 3;
		
		if(_toppings > 0) {
			if(_toppings == 1) this.totalAmount += 1.5;
			else if(_toppings <= 3) this.totalAmount += 2;
			else this.totalAmount += 5;
		}
		
		if(_meatToppings > 0) this.totalAmount += (2.15 * _meatToppings);
		
		this.totalAmount *= _quantity;
		
	}
	
	// This functions returns all the toppings selected in csv or 'no toppings if nothing is selected!'
	private String[] getSelectedToppings(CheckBox [] _toppings) {
		
		List<String> toppingsSelected = new ArrayList<>();
		
		for(CheckBox topping: _toppings) {			
			if(topping.isSelected()) toppingsSelected.add(topping.getText());
		}
		
		return toppingsSelected.toArray(new String[0]);
		
	}
	
	// This function prints the order summary on the dashboard!
	private void printOrderSummary() {
		
		// 1 Medium size, normal crust, pizza with this, this, this toppings for Dev Shah(6470000000).
		String _orderSummary = this.orderController.getPizzaQuantity() + " " + this.orderController.getPizzaDetails() + " for " + this.orderController.getCustomerDetails() + ".",
				_price = "Total Amount: $" + this.totalAmount + ", With Tax: $" + this.totalAmount * (1 + this.TAX);
		
		this.orderSummary.setText(_orderSummary + "\n" + _price);
		
	}
	
}

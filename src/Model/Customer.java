package Model;

// This function stores the information about the customer!
public class Customer {
	
		// Here are the data related to the customer which would be stored!
		private String customerName;
		private int customerNumber;
		
		// This is the constructor which can be used to build a new customer object!
		public Customer(String _customerName, int _customerNumber) {
			this.customerName = _customerName;
			this.customerNumber = _customerNumber;
		}
		
		// This function returns the name of the customer!
		public String getCustomerName() {
			return this.customerName;
		}

		// This function returns the number of the customer!
		public int getCustomerNumber() {
			return this.customerNumber;
		}
		
}

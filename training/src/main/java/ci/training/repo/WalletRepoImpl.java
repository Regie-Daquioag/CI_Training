package ci.training.repo;
import java.util.Map;

import ci.training.beans.Customer;

public class WalletRepoImpl implements WalletRepo {
	private Map<String, Customer> customers;
	
	public WalletRepoImpl(Map<String, Customer> customers) {
		super();
		this.customers = customers;
	}
	public boolean save(Customer c) {
		customers.put(c.getPhoneNumber(), c);
		return true;
	}
	public Customer find(String phoneNumber) {
		return customers.get(phoneNumber);
	}
}

package ci.training;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.HashMap;

import ci.training.beans.Customer;
import ci.training.repo.WalletRepoImpl;
import ci.training.service.WalletServiceImpl;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WalletStepDef {
	private WalletServiceImpl service;
	private WalletRepoImpl repo;
	
	private Customer cust;
	private Customer res;
	
	@Given("I want to create an account") 
	public void createAccountSetUp() {
		repo = new WalletRepoImpl(new HashMap<String, Customer>());
		service = new WalletServiceImpl(repo);
		cust = new Customer();
	}

	@When("I give {string} {string} and {int}") 
	public void createAccountPassingParameters(String name, String phoneNumber, Integer balance) {
	    cust = service.createWallet(name, phoneNumber, new BigDecimal(balance));
	    res = cust;
	}

	@Then("I should get an account with {string} {string} and {int}")
	public void createAccountCheckingIfTestPassed(String name, String phoneNumber, Integer balance) {
		assertThat(res.getName()).isEqualTo(name);
		assertThat(res.getPhoneNumber()).isEqualTo(phoneNumber);
		assertThat(res.getWallet().getBalance()).isEqualTo(new BigDecimal(balance));
	}
}

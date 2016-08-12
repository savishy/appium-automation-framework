package com.vish.appium.atdd.stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AdbStepDefs {

	@Given("^(\\d+) android device with id \"([^\"]*)\" is connected$")
	public void android_device_with_id_is_connected(int arg1, String arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^I check for available android devices$")
	public void i_check_for_available_android_devices() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^the output should contain \"([^\"]*)\"$")
	public void the_output_should_contain(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Given("^(\\d+) android devices are connected$")
	public void android_devices_are_connected(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^no output should be returned$")
	public void no_output_should_be_returned() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}


}

package com.vish.appium.atdd.stepdefs;

import java.util.List;

import org.junit.Assert;
import org.junit.runner.notification.Failure;

import com.vish.appium.Adb;
import com.vish.appium.Device;
import com.vish.appium.atdd.support.Common;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AdbStepDefs {

	public List<Device> devices;
	@Given("^(\\d+) android device with id \"([^\"]*)\" is connected$")
	public void android_device_with_id_is_connected(int arg1, String arg2) throws Throwable {
		String op = Common.exec("adb devices", true, false);
		Assert.assertTrue("device with id " + arg2 + " not connected", op.contains(arg2));
	}

	@When("^I check for available android devices$")
	public void i_check_for_available_android_devices() throws Throwable {
		Adb adb = new Adb();
		devices = adb.getConnectedAndroidDevices();
	}

	@Then("^the output should contain \"([^\"]*)\"$")
	public void the_output_should_contain(String arg1) throws Throwable {
		Assert.assertTrue("output size is zero", devices.size() > 0);
		for (Device d : devices) {
			if (d.getName().equals(arg1)) return;
		}
		Assert.fail("the output does not contain " + arg1);
	}

	@Given("^(\\d+) android devices are connected$")
	public void android_devices_are_connected(int arg1) throws Throwable {
		String op = Common.exec("adb devices", true, false);
		String[] splits = op.split("\\n");
		int deviceConnectedCount = 0;
		for (String line : splits) {
			if (line.toLowerCase().trim().equals("list of devices attached")) continue;
			else if (line.toLowerCase().trim().contains("device")) deviceConnectedCount++;
		}
		Assert.assertEquals("expected "  + arg1 + " connected devices!", arg1, deviceConnectedCount);
	}

	@Then("^no output should be returned$")
	public void no_output_should_be_returned() throws Throwable {
		Assert.assertTrue("output size is not zero", devices.size() == 0);
	}


}

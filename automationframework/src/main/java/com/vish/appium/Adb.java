package com.vish.appium;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.exec.ExecuteException;

import com.vish.appium.atdd.support.Common;

/**
 * This class wraps Adb commands and provides easy access to managing device details.
 *
 */
public class Adb 
{
	
	public Adb() {
		
	}
	
	private String execAdbCommandOnDevice(String suffix, String deviceId) throws ExecuteException, IOException, InterruptedException {
		String prefix = "adb -s " + deviceId + " ";
		return Common.exec(prefix + suffix, true, false);
	}

	private Device createDeviceFromId(String id) throws Exception {
		String name = execAdbCommandOnDevice("shell getprop ro.product.model", id).trim().toLowerCase().replace(" ", "");
		String os = execAdbCommandOnDevice("shell getprop ro.build.version.release", id).trim();
		boolean rooted  = execAdbCommandOnDevice("shell getprop ro.build.tags", id).trim().toLowerCase().contains("test-keys");
		return new Device(name, os, id, rooted);
	}
	
	public List<Device> getConnectedAndroidDevices() throws Exception {
		List<Device> retVal = new ArrayList<Device>();
		String op = Common.exec("adb devices -l",true,false);
		for (String l: op.split("\\n")) {
			String line = l.toLowerCase().trim();
			if (line.equals("list of devices attached")) continue;
			else if (line.contains("device")) {
				String[] lineParsed = line.split("\\s+");
				retVal.add(createDeviceFromId(lineParsed[0]));
			}
		}
		return retVal;
	}
	
}

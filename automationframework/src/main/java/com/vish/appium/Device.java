package com.vish.appium;

public class Device {
	private String id, os, name;
	private boolean rooted;
	public String getId() {
		return this.id;
	}
	public String getOS() {
		return this.os;
	}
	
	public boolean isRooted() {
		return rooted;
	}
	
	public String getName() {
		return this.name;
	}

	public Device(String name, String os, String id, boolean rooted) {
		this.os = os;
		this.id = id;
		this.name = name;
		this.rooted = rooted;
	}

}

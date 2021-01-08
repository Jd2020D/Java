package com.axsos.phone;

public abstract class Phone {
    private String versionNumber="";
    private int batteryPercentage=0;
    private String carrier="";
    private String ringTone="";
    public Phone(String versionNumber, int batteryPercentage, String carrier, String ringTone){
        this.versionNumber = versionNumber;
        this.batteryPercentage = batteryPercentage;
        this.carrier = carrier;
        this.ringTone = ringTone;
    }
    // abstract method. This method will be implemented by the subclasses
    public abstract void displayInfo();
    // getters and setters removed for brevity. Please implement them yourself
	public String getRingTone() {
		return ringTone;
	}
	public String getCarrier() {
		return carrier;
	}
	public int getBatteryPercentage() {
		return batteryPercentage;
	}
	public String getVersionNumber() {
		return versionNumber;
	}
}

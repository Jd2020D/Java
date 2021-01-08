package com.axsos.gold;

public class Form {
	private String name="";
	Form(String name, String amount, String value) {
		super();
		this.name = name;
		this.amount = amount;
		this.value = value;
	}
	public String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	public String getAmount() {
		return amount;
	}
	void setAmount(String amount) {
		this.amount = amount;
	}
	public String getValue() {
		return value;
	}
	void setValue(String value) {
		this.value = value;
	}
	private String amount="";
	private String value="";
}

package com.axsos.gold;

public class Message {
	private String color="green";
	private String text="";

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Message(String text, String color) {
		this.color = color;
		this.text = text;
	}
}

package com.axsos.calculator;

public class Calculator {
	private char operation=' ';
	private double operandOne=0;
	private double operandTwo=0;
	private double result=0;
	public Calculator() {}
	public Calculator(char operator,double num1,double num2) {
		this.operation=operator;
		this.operandOne=num1;
		this.operandTwo=num2;
	}
	public void performOperation() {
		switch(this.operation) {
		case '+':
			this.result=this.operandOne+this.operandTwo;
			break;
		case '-':
			this.result=this.operandOne-this.operandTwo;
			break;
		case '*':
			this.result=this.operandOne*this.operandTwo;
			break;
		case '/':
			this.result=this.operandOne/this.operandTwo;
			break;
		}
	}
	public double getOperandOne() {
		return operandOne;
	}
	public void setOperandOne(double num1) {
		this.operandOne = num1;
	}
	public double getOperandTwo() {
		return operandTwo;
	}
	public void setOperandTwo(double num2) {
		this.operandTwo = num2;
	}
	public char getOperation() {
		return operation;
	}
	public void setOperation(char operator) {
		this.operation = operator;
	}
	public double getResult() {
		return result;
	}
	
	
}

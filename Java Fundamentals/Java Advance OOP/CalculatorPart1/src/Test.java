import com.axsos.calculator.Calculator;

public class Test {
	public static void main(String[] args) {
		Calculator a= new Calculator();
		a.setOperandOne(10.5);
		a.setOperandTwo(20.5);
		a.setOperation('+');
		a.performOperation();
		System.out.println(a.getResult());
		a.setOperation('-');
		a.performOperation();
		System.out.println(a.getResult());
		a.setOperation('*');
		a.performOperation();
		System.out.println(a.getResult());
		a.setOperation('/');
		a.performOperation();
		System.out.println(a.getResult());
	}
}

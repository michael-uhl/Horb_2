package x_Sol;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;
import de.congrace.exp4j.UnknownFunctionException;
import de.congrace.exp4j.UnparsableExpressionException;

public class Exp4JInterpreter {
	public static void main(String[] args) throws UnknownFunctionException,
			UnparsableExpressionException {
		Calculable calc = new ExpressionBuilder("5+4*(7-15)").build();
		System.out.println(calc.calculate());
	}
}

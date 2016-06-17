package x_Sol;

import bsh.EvalError;
import bsh.Interpreter;

public class BshInterpreter {
	public static void main(String [] args) throws EvalError {
		Interpreter interpreter = new Interpreter();
		interpreter.eval("result = 5+4*(7-15)");
		System.out.println(interpreter.get("result"));
	}
}

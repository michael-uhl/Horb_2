package x_Sol;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;

public class JsInerpreter {
  public static void main(String[] args) throws Exception{
    ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine engine = mgr.getEngineByName("JavaScript");
    String foo = " 5+4*(7-15)";
    System.out.println(engine.eval(foo));
    } 
}
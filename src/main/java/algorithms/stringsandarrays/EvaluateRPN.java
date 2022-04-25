package algorithms.stringsandarrays;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
 *
 * Note that division between two integers should truncate toward zero.
 *
 * It is guaranteed that the given RPN expression is always valid. That means the expression
 * would always evaluate to a result, and there will not be any division by zero operation.
 */
public class EvaluateRPN {

  public int evalRPN(String[] tokens) {
    Stack<Integer> values = new Stack<>();

    for(String str : tokens) {
      if(Character.isDigit(str.charAt(str.length() - 1))) {
        values.push(Integer.valueOf(str));
      } else {
        int y = values.pop();
        int x = values.pop();
        int res = calculate(str, x, y);
        values.push(res);
      }
    }
    return values.pop();
  }

  private int calculate(String op, int val1, int val2) {
    if("+".equals(op)) {
      return val1 + val2;
    } else if("-".equals(op)) {
      return val1 - val2;
    } else if("*".equals(op)) {
      return val1 * val2;
    } else if("/".equals(op)) {
      return val1 / val2;
    }
    return 0;
  }
}

package PDA;

import java.util.Stack;

public class Result {

    private final Stack<String> stack;
    private final String input;
    private final boolean valid;

    public Result(Stack<String> stack, String input, boolean valid) {
        this.stack = new Stack<String>();
        this.stack.addAll(stack);
        this.input = input;
        this.valid = valid;
    }

    public Stack<String> getStack() {
        return stack;
    }

    public String getInput() {
        return input;
    }

    public boolean isValid() {
        return valid;
    }
}

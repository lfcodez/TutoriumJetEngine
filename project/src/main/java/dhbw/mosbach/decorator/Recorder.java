package dhbw.mosbach.decorator;

import java.util.Stack;

public enum Recorder {
    INSTANCE;

    public Stack<String> getStack() {
        return stack;
    }

    private Stack<String> stack = new Stack<>();

    public void store(String s){
        this.stack.push(s);
    }
}

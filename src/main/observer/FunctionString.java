package observer;

public class FunctionString extends AbstractObserver {

    public FunctionString(String s) {
        super(s);
    }

    @Override
    public void update() {
        System.out.print("[function: " + answer + "]");
    }

}

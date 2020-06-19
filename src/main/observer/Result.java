package observer;

public class Result extends AbstractObserver {

    public Result(double i) {
        super(Double.toString(i));
    }


    @Override
    public void update() {
        System.out.print("[" + answer + "]");
    }
}

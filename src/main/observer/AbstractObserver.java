package observer;

public abstract class AbstractObserver {
    protected String answer;

    AbstractObserver(String s) {
        answer = s;
    }

    public String getAnswer() {
        return answer;
    }

    public abstract void update();

    public void print() {
        System.out.println(answer);
    }

}

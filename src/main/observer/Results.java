package observer;

import java.util.ArrayList;

public class Results {
    private ArrayList<AbstractObserver> results;

    public Results() {
        results = new ArrayList<>();
    }


    public void add(AbstractObserver r) {
        results.add(r);
    }

    public void notifyall() {
        for (AbstractObserver r: results) {
            r.update();
        }
    }

    public int size() {
        return results.size();
    }
}

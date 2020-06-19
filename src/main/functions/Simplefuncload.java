package functions;

import java.io.IOException;

public class Simplefuncload extends Simplefunc {

    public Simplefuncload() throws IOException {
        find();
    }

    private void find() throws IOException {
        setfirstnum(load());
    }
}

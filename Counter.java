public class Counter implements AutoCloseable {
    private int count;

    public void add() {
        count++;
    }

    @Override
    public void close() throws Exception {
        if (count > 0) {
            throw new IllegalStateException("Resource not closed properly");
        }
    }

    public void start() {
    }
}

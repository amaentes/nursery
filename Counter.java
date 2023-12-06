public class Counter implements AutoCloseable {
    private int count;
    private boolean closed;

    public Counter() {
        this.count = 0;
        this.closed = false;
    }

    public void add() {
        if (!closed) {
            this.count++;
        } else {
            throw new IllegalStateException("Ресурс уже закрыт");
        }
    }

    public int getCount() {
        return this.count;
    }

    @Override
    public void close() {
        this.closed = true;
        System.out.println("Ресурс закрыт");
    }

    public boolean isClosed() {
        return this.closed;
    }
}
package Exercise24;

public class Middle {
    private volatile int buffer;


    public Middle(int buffer) {
        this.buffer = buffer;
    }

    @Override
    public String toString() {
        return buffer + " In The Middle ";

    }
}

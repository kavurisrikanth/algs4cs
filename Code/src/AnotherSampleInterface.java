public interface AnotherSampleInterface {
    int x = 100;

    default int getX() {
        return x;
    }
}

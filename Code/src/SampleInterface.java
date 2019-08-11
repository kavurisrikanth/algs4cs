public interface SampleInterface {
    int x = 250;

    default int getX() {
        return x;
    }
}

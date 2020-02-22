package helpers;

public class GenericHelper<T> {
    public static <T> String arrayToString(T[] array) {
        StringBuilder sb = new StringBuilder();
        for (T elem: array)
            sb.append(elem).append(" ");
        return sb.toString();
    }
}

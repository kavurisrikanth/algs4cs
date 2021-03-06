package helpers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResizableArrayTest {
    private ResizableArray<Integer> arr;

    @BeforeEach
    public void setup() {
        arr = new ResizableArray<>();
    }

    @Test
    public void testInsertAt() {
        arr.insertAt(0, 1);
        assertEquals(arr.length(), 1);
        arr.insertAt(0, 2);
        assertEquals(arr.length(), 2);
    }

    @Test
    public void testInsertionOrder() {
        for (int i = 0; i < 10; i++)
            arr.insertAt(0, i);
        assertEquals(20, arr.size());
        System.out.println(arr);
        for (int i = 0; i < 10; i++)
            assertEquals(i, arr.pop());

        assertEquals(0, arr.length());

        for (int i = 0; i < 10; i++)
            arr.push(i);
        System.out.println(arr);
        for (int i = 9; i >= 0; i--)
            assertEquals(i, arr.pop());

        assertEquals(0, arr.length());

        for (int i = 0; i < 10; i++)
            arr.push(i);
        System.out.println(arr);
        for (int i = 0; i < 10; i++)
            assertEquals(i, arr.removeFrom(0));

        for (int i = 9; i >= 0; i--)
            arr.push(i);
        System.out.println(arr);
        for (int i = 9; i >= 0; i--)
            assertEquals(i, arr.removeFrom(0));
    }

    @Test
    public void testExchange() {
        for (int i = 0; i < 10; i++)
            arr.push(i);
        System.out.println(arr);

        arr.exch(0, 1);
        assertEquals(1, arr.viewItemAt(0));
        assertEquals(0, arr.viewItemAt(1));
        for (int i = 2; i < arr.length(); i++) {
            assertEquals(i, arr.viewItemAt(i));
        }
    }

    @AfterEach
    public void tearDown() {
        arr = null;
    }
}
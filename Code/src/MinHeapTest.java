import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinHeapTest {

    MinHeap<Integer> mh;

    @BeforeEach
    void setUp() {
        mh = new MinHeap<>();
    }

    @Test
    void testMinValues() {
        for (int i = 0; i < 10; i++) {
            mh.insert(i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(mh);
            assertEquals(i, mh.delMin());
        }
    }

    @AfterEach
    void tearDown() {
        mh = null;
    }
}
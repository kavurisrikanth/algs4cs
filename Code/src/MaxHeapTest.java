import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxHeapTest {

    MaxHeap<Integer> mh;

    @BeforeEach
    void setUp() {
        mh = new MaxHeap<>();
    }

    @Test
    void testMaxValues() {
        for (int i = 0; i < 5; i++) {
            mh.insert(i);
        }

        System.out.println(mh);

        for (int i = 4; i >= 0; i--) {
            assertEquals(i, mh.delMax());
            System.out.println(mh);
        }
    }

    @AfterEach
    void tearDown() {
        mh = null;
    }
}
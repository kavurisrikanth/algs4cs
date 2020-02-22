package trees;

import helpers.GenericHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTTest {
    private BST<Integer> intBST;

    @BeforeEach
    public void setup() {
        intBST = new BST<>();
    }

    @Test
    public void testInsert() {
        int[] nums = {7, 3, 1, 9, 2, 8, 6, 4, 10, 5};
        Integer[] order = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int x: nums) {
            intBST.insert(x);
        }

        Integer[] receivedOrder = intBST.getPreOrder().toArray(new Integer[0]);
        System.out.println(GenericHelper.arrayToString(receivedOrder));
        assertArrayEquals(order, receivedOrder);
    }

}
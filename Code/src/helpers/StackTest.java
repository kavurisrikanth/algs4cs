package helpers;/*
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;
*/

public class StackTest {
    /*
    @Test
    public void pushAndPopOneIntegerAtATime() {
        helpers.Stack<Integer> stack = new helpers.Stack<>();
        helpers.ResizableArrayStack<Integer> resizableArrayStack = new helpers.ResizableArrayStack<>();
        Random rand = new Random();
        int num = 100000, x = 0;

        for (int i = 0; i < num; i++) {
            x = rand.nextInt();

            stack.push(x);
            resizableArrayStack.push(x);

            Assert.assertEquals((long)stack.peek(), x);
            Assert.assertEquals((long)stack.pop(), x);
            Assert.assertTrue(stack.empty());

            Assert.assertEquals((long)resizableArrayStack.peek(), x);
            Assert.assertEquals((long)resizableArrayStack.pop(), x);
            Assert.assertTrue(resizableArrayStack.empty());
        }

    }

    @Test
    public void pushMultipleIntegersThenPopAll() {
        helpers.Stack<Integer> stack = new helpers.Stack<>();
        helpers.ResizableArrayStack<Integer> resizableArrayStack = new helpers.ResizableArrayStack<>();
        Random rand = new Random();
        int num = 100000,
            x = 0,
            arr[] = new int[num];

        for (int i = 0; i < num; i++) {
            arr[i] = rand.nextInt();
            stack.push(arr[i]);
            resizableArrayStack.push(arr[i]);
        }

        Assert.assertFalse(stack.empty());
        Assert.assertFalse(resizableArrayStack.empty());

        for (int i = num - 1; i >= 0; i--) {
            Assert.assertEquals((long)stack.pop(), arr[i]);
            Assert.assertEquals((long)resizableArrayStack.pop(), arr[i]);
        }

        Assert.assertTrue(stack.empty());
        Assert.assertTrue(resizableArrayStack.empty());
    }

    @Test
    public void pushMultipleIntegersThenPopSome() {
        helpers.Stack<Integer> stack = new helpers.Stack<>();
        helpers.ResizableArrayStack<Integer> resizableArrayStack = new helpers.ResizableArrayStack<>();
        Random rand = new Random();
        int num = 100000,
                x = 0,
                arr[] = new int[num];

        for (int i = 0; i < num; i++) {
            arr[i] = rand.nextInt();
            stack.push(arr[i]);
            resizableArrayStack.push(arr[i]);
        }

        Assert.assertFalse(stack.empty());
        Assert.assertFalse(resizableArrayStack.empty());

        int popUntilNum = rand.nextInt(num);
        for (int i = num - 1; i >= popUntilNum; i--) {
            Assert.assertEquals((long)stack.pop(), arr[i]);
            Assert.assertEquals((long)resizableArrayStack.pop(), arr[i]);
        }

        if (popUntilNum == 0) {
            Assert.assertTrue(stack.empty());
            Assert.assertTrue(resizableArrayStack.empty());
        } else {
            Assert.assertFalse(stack.empty());
            Assert.assertEquals((long)stack.peek(), arr[popUntilNum - 1]);

            Assert.assertFalse(resizableArrayStack.empty());
            Assert.assertEquals((long)resizableArrayStack.peek(), arr[popUntilNum - 1]);
        }
    }

    @Test
    public void oneIntegerPushAndTestIterator() {
        helpers.Stack<Integer> stack = new helpers.Stack<>();
        helpers.ResizableArrayStack<Integer> resizableArrayStack = new helpers.ResizableArrayStack<>();
        Random rand = new Random();
        int num = 100000, x = 0;

        for (int i = 0; i < num; i++) {
            x = rand.nextInt();

            stack.push(x);
            resizableArrayStack.push(x);

            for (Integer one: stack) {
                Assert.assertEquals((long)one, x);
            }

            for (Integer one: resizableArrayStack) {
                Assert.assertEquals((long)one, x);
            }

            Assert.assertEquals((long)stack.peek(), x);
            Assert.assertEquals((long)stack.pop(), x);
            Assert.assertTrue(stack.empty());

            Assert.assertEquals((long)resizableArrayStack.peek(), x);
            Assert.assertEquals((long)resizableArrayStack.pop(), x);
            Assert.assertTrue(resizableArrayStack.empty());
        }
    }

    @Test
    public void multipleIntegersPushAndTestIterator() {
        helpers.Stack<Integer> stack = new helpers.Stack<>();
        helpers.ResizableArrayStack<Integer> resizableArrayStack = new helpers.ResizableArrayStack<>();
        Random rand = new Random();
        int num = 100000, x = 0, arr[] = new int[num];

        for (int i = 0; i < num; i++) {
            arr[i] = rand.nextInt();
            stack.push(arr[i]);
            resizableArrayStack.push(arr[i]);
        }

        int i = num;
        for (Integer one: stack) {
            Assert.assertEquals((long)one, arr[--i]);
        }

        for (Integer one: resizableArrayStack) {
            Assert.assertEquals((long)one, arr[i]);
        }
    }
    */

}

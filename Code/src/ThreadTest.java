public class ThreadTest {
    public static void main(String[] args) {
        (new Thread(new HelloRunnable())).start();
        (new HelloThread()).start();
    }
}

class HelloRunnable implements Runnable {
    @Override
    public void run() {
        String[] msgs = {
            "HelloRunnable One",
            "HelloRunnable Two",
            "HelloRunnable Three",
            "HelloRunnable Four"
        };

        for (String s: msgs) {
            try {
                System.out.println(s);
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class HelloThread extends Thread {
    public void run() {
        String[] msgs = {
            "HelloThread One",
            "HelloThread Two",
            "HelloThread Three",
            "HelloThread Four"
        };

        for (String s: msgs) {
            try {
                System.out.println(s);
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
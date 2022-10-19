package background;

/**
 * 描述：     第二章线程安全问题，演示死锁。
 */
public class MultiThreadError implements Runnable {

    int flag = 1;
    static Object lock1 = new Object();
    static Object lock2 = new Object();

    public static void main(String[] args) {
        MultiThreadError r1 = new MultiThreadError();
        MultiThreadError r2 = new MultiThreadError();
        r1.flag = 1;
        r2.flag = 0;
        new Thread(r1).start();
        new Thread(r2).start();
    }

    @Override
    public void run() {
        System.out.println("flag = " + flag);
        if (flag == 1) {
            synchronized (lock1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("这是flag1");
                }
            }
        }
        if (flag == 0) {
            synchronized (lock2) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("这是flag0");
                }
            }
        }
    }
}

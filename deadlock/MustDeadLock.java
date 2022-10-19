package deadlock;

/**
 * 描述：     必定发生死锁的情况
 */
public class MustDeadLock implements Runnable {

    int flag = 1;

    static Object lock = new Object();
    static Object lock2 = new Object();

    public static void main(String[] args) {
        MustDeadLock r1 = new MustDeadLock();
        MustDeadLock r2 = new MustDeadLock();
        r1.flag = 1;
        r2.flag = 0;
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        System.out.println("flag = " + flag);
        if (flag == 1) {
            synchronized (lock) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("线程1成功拿到两把锁!");
                }
            }
        }
        if (flag == 0) {
            synchronized (lock2) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock) {
                    System.out.println("线程2成功拿到两把锁!");
                }
            }
        }
    }
}

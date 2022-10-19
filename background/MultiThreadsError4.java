package background;

/**
 * 描述：     初始化未完毕，就this赋值
 * 代码参考自Java Concurrency In Practice的在对象完全构造之前发布对象会危及线程安全部分
 */
public class MultiThreadsError4 {

    static MyXY myXY;

    public static void main(String[] args) throws InterruptedException {
        new MyXYMaker().start();
//        Thread.sleep(10);
        Thread.sleep(105);
        if (myXY != null) {
            System.out.println(myXY);
        }
    }
}

class MyXY {

    private final int x, y;

    public MyXY(int x, int y) throws InterruptedException {
        this.x = x;
        MultiThreadsError4.myXY = this;
        Thread.sleep(1000);
        this.y = y;
    }

    @Override
    public String toString() {
        return x + "," + y;
    }
}

class MyXYMaker extends Thread {

    @Override
    public void run() {
        try {
            new MyXY(1, 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
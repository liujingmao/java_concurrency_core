package singleton;

/**
 * 描述：     饿汉式（静态常量）（可用）
 * 单例相关课程内容参考程序猿001《单例模式的八种写法比较》：https://www.cnblogs.com/zhaoyan001/p/6365064.html
 * 小宝马的爸爸 - 梦想的家园《单例模式（Singleton）》：https://www.cnblogs.com/BoyXiao/archive/2010/05/07/1729376.html
 * Jark's Blog《如何正确地写出单例模式》：http://wuchong.me/blog/2014/08/28/how-to-correctly-write-singleton-pattern/
 * Hollis Chuang《为什么我墙裂建议大家使用枚举来实现单例》：https://www.hollischuang.com/archives/2498
 * Hollis Chuang《深度分析Java的枚举类型—-枚举的线程安全性及序列化问题》：https://www.hollischuang.com/archives/197
 */
public class Singleton1 {

    private final static Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {

    }

    public static Singleton1 getInstance() {
        return INSTANCE;
    }

}

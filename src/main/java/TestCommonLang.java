
import concurrent.MyReentrantLock;
import concurrent.TestReentrantLock;
import event.CatEvent;
import event.CatListener;
import event.Listener;
import org.apache.commons.lang3.*;
import org.apache.commons.lang3.event.EventUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.commons.lang3.tuple.Triple;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * 测试 common-lang 包
 *
 * Created by shixiaotian on 16/3/23.
 *
 */
public class TestCommonLang {

    /**
     * 主入口
     *
     * @param arg
     */
    public static void main(String arg[]) throws InterruptedException {

        // 序列化
//        TestCommonLang.serialization();

        // 元祖比对
//        TestCommonLang.triple();

        // 计时器
//        TestCommonLang.stopWatch();

        // 事件工具
//        TestCommonLang.eventUtils();

        // concurrent 线程锁 ReentrantLock
        ExecutorService service= Executors.newCachedThreadPool();
        TestReentrantLock lock=new TestReentrantLock();
        for(int i=0;i<10;i++){
            service.submit(new MyReentrantLock(i,lock));
        }
        service.shutdown();
    }

    // 序列化
    private static void serialization () {

        String s = "123";

        byte[] result = SerializationUtils.serialize(s);

        System.out.println(result);

    }

    // 元祖
    private static void triple() {

        // 元组 1
        Triple<String, String, String> t = new Triple<String, String, String>() {

            String a = "a";
            String b = "b";
            String c = "c";

            @Override
            public String getLeft() {
                return a;
            }

            @Override
            public String getMiddle() {
                return b;
            }

            @Override
            public String getRight() {
                return c;
            }
        };

        // 元组 1
        Triple<String, String, String> tb = new Triple<String, String, String>() {

            String a = "a1";
            String b = "b2";
            String c = "c3";

            @Override
            public String getLeft() {
                return a;
            }

            @Override
            public String getMiddle() {
                return b;
            }

            @Override
            public String getRight() {
                return c;
            }
        };

        // 比较
        int result = tb.compareTo(t);

        // 输出结果
        System.out.println(result);

    }

    // 计时器
    private static synchronized void stopWatch() throws InterruptedException {

        // 构建计时器实体
        StopWatch stopWatch  = new StopWatch();

        // 启动计时器
        stopWatch.start();

        // 间隔20秒取一次
        for(int i=0;i<1000;i++) {

            // 启动分段计时器
            stopWatch.split();

            // 线程休眠
            Thread.sleep(20);
            // 输出分段时间
            System.out.println(stopWatch.getSplitTime());

            // 关闭分段计时器
            stopWatch.unsplit();
        }

        //关闭计时器
        stopWatch.stop();

        // 输出开始时间
        System.out.println(stopWatch.getStartTime());

    }

    // 时间工具
    private static void eventUtils() {

        Listener catListener = new CatListener();

        CatEvent catEvent = new CatEvent(Listener.class);


        EventUtils.addEventListener(catEvent, Listener.class, catListener);
    }

}

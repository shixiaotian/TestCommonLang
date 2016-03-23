package concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by shixiaotian on 16/3/23.
 */
public class TestReentrantLock {
    private ReentrantLock lock=new ReentrantLock();
    public void print(int str){
        try{
            lock.lock();
            System.out.println(str+"获得");
            Thread.sleep((int)(Math.random()*1000));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            System.out.println(str+"释放");
            lock.unlock();
        }
    }
}

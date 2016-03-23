package concurrent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
public class MyReentrantLock extends Thread{
    TestReentrantLock lock;
    private int id;
    public MyReentrantLock(int i,TestReentrantLock test){
        this.id=i;
        this.lock=test;
    }
    public void run(){
        lock.print(id);
    }
    public static void main(String args[]){

    }
}

package 多线程.s07;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MLock implements Lock {
    private Sync sync = new Sync();

    @Override
    public void lock() {
        // 调用的是AQS的acquire
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        synchronized (this){
            sync.release(1);
        }
    }

    // 在文档中建议用内部类
    private class Sync extends AbstractQueuedSynchronizer {


        // 需要自己实现的方法
        @Override
        protected boolean tryAcquire(int arg) {
            if ((compareAndSetState(0, 1))){ // 如果将当前state设置为了1说明持有这把锁了
                // 设置互斥锁/还可以是共享锁[对读共享]
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            assert arg == 1; // 保证为1才能往下执行
            if (! isHeldExclusively()) throw new IllegalMonitorStateException();
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        // 当前线程是否独有的持有锁
        @Override
        protected boolean isHeldExclusively() {
            // 独占线程是否与当前线程一样
            return getExclusiveOwnerThread() == Thread.currentThread();
        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}

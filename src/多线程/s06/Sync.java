package 多线程.s06;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class Sync extends AbstractQueuedSynchronizer {


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
        setExclusiveOwnerThread(null);
        setState(0);
        return true;
    }

    @Override
    protected int tryAcquireShared(int arg) {
        return super.tryAcquireShared(arg);
    }

    @Override
    protected boolean tryReleaseShared(int arg) {
        return super.tryReleaseShared(arg);
    }

    // 当前线程是否排他设置这个锁
    @Override
    protected boolean isHeldExclusively() {
        return getState() == 1;
    }
}

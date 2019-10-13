# JUC 之 AQS
+ ArrayList -> CopyOnWriteArrayList
+ HashSet -> CopyOnWriteArraySet 
+ TreeSet -> ConcurrentSkipListSet
> CopyOnWriteArraySet 底层是一个 CopyOnWriteArrayList

> ConcurrentSkipListSet 基于 Map 集合，它的 add/remove/contains 方法都是原子的，线程安全的，对于addALL/removeALL/containsALL不能保证以原子的方式执行，因为它只能保证单个操作的原子操作，使用批量操作时要手动加锁

+ HashMap -> ConcurrentHashMap

+ TreeMap -> ConcurrentSkipListMap

## AbstractQueuedSynchronizer - AQS
+ 使用 Node 实现 FIFO 队列，可以用于构建锁或者其他同步装置的基础框架
+ 利用了一个 int 类型表示状态
+ 使用方法是继承
+ 子类通过继承并使它的方法管理其状态{acquire 和 release} 的方法操纵状态
+ 可以同时实现排它锁和共享锁模式

## AQS 组件
+ CountDownLatch 闭锁 通过一个计数来保证线程是否要一直阻塞
![Snipaste_2019-10-13_11-37-01.jpg](https://i.loli.net/2019/10/13/HKa5iuxkofrmGVt.jpg)
使用场景
    + 主要用来解决一个线程等待多个线程的场景
    + 在程序等待某些条件完成后，才能执行后续的操作，如并行计算
+ CyclicBarrier
![Snipaste_2019-10-13_12-21-07.jpg](https://i.loli.net/2019/10/13/CFnj4IlpTmYstbP.jpg)
+ Semaphore 控制同一时间并发线程的数目
使用场景：有限访问的资源
+ ReentrantLock 
+ Condition
+ FutureTask
# Concurrency
并发学习

## 原子性-Atomic包
 AtomicXXX：CAS、Unsafe.compareAndSwapInt

AtomicLong、LongAdder

AtomicBoolean
+ 可以用来让某个操作只执行一次

AtomicIntegerFieldUpdater
+ 核心作用：更新指定的类的某一个字段的值，这个字段必须是由**volatile**关键字修饰的，同时还是非静态（static）的字段。

AtomicStampReference:解决 CAS 的 ABA 问题

AtomicLongArray

## 原子性 - 锁 - 线程切换
sychronized：依赖JVM
+ 修饰方法：整个方法，作用于调用的对象
+ 修饰静态方法：整个静态方法，作用于所有对象
+ 修饰代码块：用大括号括起来的代码，作用于调用的对象
    + `synchronized (this){}`
+ 修饰类：括号括起来的部分，作用于所有对象
    +`synchronized (SynchronizedExample2.class){}`

**synchronized不属于方法声明的一部分（不会被继承）**，子类继承父类时，如果父类中的方法由synchronized关键字修饰，在子类中继承的方法是不带Synchronized关键字的。

Lock：依赖特殊的 CPU 指令，代码实现，ReentrantLock

**原子性-对比**
+ synchronized：不可中断锁，适合竞争不激烈，可读性好。
+ Lock：可中断锁，多样化同步，竞争激烈时能维持常态。
+ Atomic：竞争激烈时能维持常态，比 Lock 性能好；只能同步一个值。

## 可见性 - CPU 的缓存机制
导致共享变量在线程间不可见的原因
+ 线程交叉执行
+ 从排序结合线程交叉执行
+ 共享变量更新后的值没有在工作内存与主内存间及时更新。

**可见性 - synchronized**

JMM 关于 synchronized的两条规定
+ 线程解锁前，必须把共享变量的最新值刷新到主存中
+ 线程加锁时，将清空工作内存中共享变量的值，从而使用共享变量时需要从主存中重新读取最新的值（注意，加锁与解锁是通一把锁）

**可见性 - volatile **

通过加入**内存屏障**和**禁止重排序**优化来实现
+ 对 volatile 变量写操作时，会在写操作后加入一条 store 屏障指令，将本地内存中的共享变量值刷新到主存中
+ 对 volatile 变量读操作时，会在读操作前加入一条 load 屏障指令，从主内存中读取共享变量。

使用 **volatile** 的两个条件
+ 

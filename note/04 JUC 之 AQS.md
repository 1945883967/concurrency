# JUC 之 AQS
+ ArrayList -> CopyOnWriteArrayList
+ HashSet -> CopyOnWriteArraySet 
+ TreeSet -> ConcurrentSkipListSet
> CopyOnWriteArraySet 底层是一个 CopyOnWriteArrayList

> ConcurrentSkipListSet 基于 Map 集合，它的 add/remove/contains 方法都是原子的，线程安全的，对于addALL/removeALL/containsALL不能保证以原子的方式执行，因为它只能保证单个操作的原子操作，使用批量操作时要手动加锁

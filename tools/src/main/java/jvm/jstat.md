## jvm tools 

监视虚拟机的各种运行状态：类装载、内存、垃圾收集等运行数据。


### jps
jps –v # 找到java 进程 pid

### jstat(JVM Statistics Monitoring Tool)
jstat [option] PID [interval] [count]
jstat -gcutil <pid> 2000 10 # 2秒打印一次，打印10次

参数：
option：
-class 查看类装载的信息
-gc 查看java堆的状况
-gccapacity 查看堆中各个区域的最小容量和最大容量
-gcutil 查看堆中各个区域已使用空间占其总空间的百分比
-gccause 与-gcutil相同，另外还输出了：导致上一次GC的原因和当前GC的原因
-gcnew 查看堆中新生代的状况
-gcnewcapacity 查看堆中新生代的最小容量和最大容量
-gcold 查看堆中老年代的状况
-gcoldcapacity 查看堆中老年代的最小容量和最大容量
-gcpermcapacity 查看堆中永久代的最小容量和最大容量
-gcmetacapacity 查看元数据空间的当前大小、最大容量和最小容量(jdk1.8)

查询结果标识：
通用：
Minor GC(Young GC)：
YGC： 进程从启动以来Minor GC的次数
YGCT：进程从启动以来Minor GC所花费的时间
Full GC：FGC表示次数，FGCT表示时间
FGC： 进程从启动以来Full GC的次数
FGCT：进程从启动以来Full GC所花费的时间
GCT： Minor GC和Full GC总共花费的时间
注：查看 JVM 是否回收垃圾频繁，主要根据 FGC 和 FGCT 来分析。上面的命令

jstat -gc
jstat -gcutil
jstat -gccause

新生代(Young)中的Eden区：E
E： Eden区已使用的空间占其总空间的百分比
EC：Eden区的容量(Eden Capacity)
EU：Eden区已使用的空间(Eden Use)
新生代(Young)中的Survivor区：S0 S1
老年代(Old)：O
永久代(Permanent)：P

jdk8中：
元数据空间(Metaspace)：M
元数据空间中的压缩类空间(Compressed Class Space)：CCS

说明：
1>jdk8中已经没有永久代了，取而代之的是元空间，元空间占用的是本地内存，不占用虚拟机的内存。
2>Metaspace由Klass Metaspace和NoKlass Metaspace两部分组成。
3>M表示Metaspace已使用的百分比，CCS表示Klass Metaspace已使用的百分比(CCS=CCSU/CCSC)。
4>M的值达到了90%以上，不一定能说明metaspace已经用了很多了，因为内存是慢慢commit的，所以我们的分母是慢慢变大的，不过当我们commit到一定量的时候就不会再增长了。
5>根据MC，MU，CCSC，CCSU来判断metaspace的状态更靠谱。(注：可以在jstat -gc 中看到MU)

注：S0/S0C/S0U、S1/S1C/S1U、O/OC/OU、P/PC/PU、M/MC/MU、CCS/CCSC/CCSU 与 E/EC/EU类似
LGCC：最后一次GC发生的原因
GCC： 当前GC发生的原因

jstat -gcnew
TT： 老年化阈值。被移动到老年代之前，在新生代空存活的次数
MTT：最大老年化阈值。
DSS：幸存者区所需空间大小

注意：单位是都是KB


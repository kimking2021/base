package jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.RunnerException;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * @author kim
 * @date 2021/1/18
 */

/**
 * 冷启动测试
 */
@BenchmarkMode( Mode.SingleShotTime )
@OutputTimeUnit( TimeUnit.SECONDS )
@Fork(1)
// 测试次数
@Measurement(iterations = 1)
@State(Scope.Thread)
public class JmhSingleTest {

    public static void main(String[] args) throws RunnerException {
        org.openjdk.jmh.runner.options.Options options = new org.openjdk.jmh.runner.options.OptionsBuilder()
                .include( JmhSingleTest.class.getName() )
                // 可通过output将测试结果写入到文件中
                //.output("D:/JmhDemo.log")
                .build();

        new org.openjdk.jmh.runner.Runner(options).run();
    }

    @Param({"2","7"})
    private Integer num;

    // 每个待测方法测试前执行的方法
    @Setup
    public void init() {
        System.out.println("----------- <init: "+ num +" >  -----------");
    }

    // 每个待测方法测试后执行的方法
    @TearDown
    public void shutdown() {
        System.out.println("----------- <shutdown: "+ num +" >  -----------");
    }

    // 待测方法1
    @Benchmark
    public void test1() throws Exception {
        System.out.println("<test1> : " + num);
    }

    // 待测方法2
    @Benchmark
    public void test2() throws Exception {
        System.out.println("<test2> : " + num);
    }


}

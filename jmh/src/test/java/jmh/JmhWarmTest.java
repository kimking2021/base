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
 * 指定基准测试的模式。具体地有
 * AverageTime：方法调用的平均时间
 * Throughput：吞吐量模式，即每秒调用的次数
 * SampleTime：采样模式，即方法调用的耗时分布
 * SingleShotTime：上述模式在一次Iteration的时间内会调用方法。而在该模式中一次Iteration仅会调用一次方法。与此同时也会将Warmup预热次数设为0，用于测试方法冷启动时的耗时
 * All：其会分别使用上述四种模式进行测试
 */
@BenchmarkMode( Mode.AverageTime )
@OutputTimeUnit( TimeUnit.SECONDS )
@Fork(1)
// 预热次数、时长/次
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
// 测试次数、时长/次
@Measurement(iterations = 6,time = 2, timeUnit = TimeUnit.SECONDS)
public class JmhWarmTest {

    public static void main(String[] args) throws RunnerException {
        org.openjdk.jmh.runner.options.Options options = new org.openjdk.jmh.runner.options.OptionsBuilder()
                .include( JmhWarmTest.class.getName() )
                .build();

        new org.openjdk.jmh.runner.Runner(options).run();
    }

    // 标识这是一个需要测试的方法
    @Benchmark
    public void helloWorld() throws Exception {
        Thread.sleep(700);
    }

}

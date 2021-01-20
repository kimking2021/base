package jmh;

/**
 * <p>
 *
 * @author kim
 * @date 2021/1/18
 */

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.RunnerException;

import java.util.concurrent.TimeUnit;

/**
 * 死码消除
 */
@BenchmarkMode( Mode.AverageTime )
@OutputTimeUnit( TimeUnit.NANOSECONDS )
@Fork(1)
// 预热次数、时长/次
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
// 测试次数、时长/次
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@State(Scope.Thread)
public class JmhDECTest {

    public static void main(String[] args) throws RunnerException {
        org.openjdk.jmh.runner.options.Options options = new org.openjdk.jmh.runner.options.OptionsBuilder()
                .include( JmhDECTest.class.getName() )
                .build();
        new org.openjdk.jmh.runner.Runner(options).run();
    }

    private double x = Math.PI;

    @Benchmark
    public void base() {
    }

    @Benchmark
    public void test1() {
        Math.log(x);
    }

    @Benchmark
    public double test2() {
        return Math.log(x);
    }

    @Benchmark
    public void test3(Blackhole blackhole) {
        blackhole.consume( Math.log(x) );
    }

}

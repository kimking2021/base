package jmh;

/**
 * <p>
 *
 * @author kim
 * @date 2021/1/18
 */

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.RunnerException;

import java.util.concurrent.TimeUnit;

/**
 * 常量折叠测试
 */
@BenchmarkMode( Mode.AverageTime )
@OutputTimeUnit( TimeUnit.NANOSECONDS )
@Fork(1)
// 预热次数、时长/次
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
// 测试次数、时长/次
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@State(Scope.Thread)
public class ConstantTest {

    public static void main(String[] args) throws RunnerException {
        org.openjdk.jmh.runner.options.Options options = new org.openjdk.jmh.runner.options.OptionsBuilder()
                .include( ConstantTest.class.getName() )
                .build();
        new org.openjdk.jmh.runner.Runner(options).run();
    }

    private double x = Math.PI;

    private final double x_final = Math.PI;

    @Benchmark
    public double base() {
        return Math.PI;
    }

    // Math.PI是final变量，会发生常量折叠
    @Benchmark
    public double test1() {
        return Math.log( Math.PI );
    }

    // x_final是final变量，会发生常量折叠
    @Benchmark
    public double test2() {
        return Math.log( x_final );
    }

    @Benchmark
    public double test3() {
        return Math.log( x );
    }

}

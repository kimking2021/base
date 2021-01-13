package priv.kimking.base.jmh.runner;

import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import priv.kimking.base.jmh.str.StringConnectBenchmark;

/**
 * <p>
 *
 * @author kim
 * @date 2020/11/11
 */
public class StringBuilderRunner {

    public static void main( String[] args ) throws RunnerException {
        Options opt = new OptionsBuilder()
                // 导入要测试的类
                .include(StringConnectBenchmark.class.getSimpleName())
                // 预热5轮
                .warmupIterations(5)
                // 度量10轮
                .measurementIterations(10)
                .mode(Mode.Throughput)
                .forks(3)
                .build();

        new Runner(opt).run();


    }

}

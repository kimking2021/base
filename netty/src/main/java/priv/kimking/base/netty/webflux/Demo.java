package priv.kimking.base.netty.webflux;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * <p>
 *
 * @link https://developer.ibm.com/zh/articles/j-cn-with-reactor-response-encode/
 * @author kim
 * @date 2020/9/30
 */
public class Demo {

    public static void main(String... args) {
//        Flux.just("hello", "world").subscribe(System.out::println);
//        Flux.fromArray(new Integer[] {1, 2, 3}).subscribe(System.out::println);
//        Flux.empty().subscribe(System.out::println);
//        Flux.range(1, 10).subscribe(System.out::println);
//        Flux.interval(Duration.ofSeconds(1)).toStream().forEach(System.out::println);


//        Flux.generate(sink -> {
//            sink.next("hello");
//            sink.complete();
//        }).subscribe(System.out::println);


//        Flux.range(1, 100).buffer(20).subscribe(System.out::println);
//        Flux.intervalMillis(100).bufferMillis(1001).take(2).toStream().forEach(System.out::println);
//        Flux.range(1, 10).bufferUntil(i -> i % 2 == 0).subscribe(System.out::println);
//        Flux.range(1, 10).bufferWhile(i -> i % 2 == 0).subscribe(System.out::println);


//        Flux.range(1, 10).filter(i -> i % 2 == 0).subscribe(System.out::println);

//        Flux.range(1, 100).window(20).subscribe(System.out::println);

//        Flux.just("a", "b")
//                .zipWith(Flux.just("c", "d"))
//                .subscribe(System.out::println);
//        Flux.just("a", "b")
//                .zipWith(Flux.just("c", "d"), (s1, s2) -> String.format("%s-%s", s1, s2))
//                .subscribe(System.out::println);

//        Flux.range(1, 1000).take(10).subscribe(System.out::println);
//        Flux.range(1, 1000).takeLast(10).subscribe(System.out::println);
//        Flux.range(1, 10).takeWhile(i -> i % 2 == 1).subscribe(System.out::println);
//        Flux.range(1, 1000).takeUntil(i -> i == 10).subscribe(System.out::println);

//        Flux.range(1, 100).reduce((x, y) -> x + y).subscribe(System.out::println);
//        Flux.range(1, 100).reduceWith(() -> 100, (x, y) -> x + y).subscribe(System.out::println);

//        Flux.merge(Flux.interval(Duration.ofMillis(0), Duration.ofMillis(100)).take(5), Flux.interval(Duration.ofMillis(0), Duration.ofMillis(100)).take(5))
//                .toStream()
//                .forEach(System.out::println);
//        Flux.mergeSequential(Flux.interval(Duration.ofMillis(0), Duration.ofMillis(100)).take(5), Flux.interval(Duration.ofMillis(50), Duration.ofMillis(100)).take(5))
//                .toStream()
//                .forEach(System.out::println);

//        Flux.just(5, 10)
//                .flatMap(x -> Flux.interval(Duration.ofMillis(x * 10), Duration.ofMillis(100)).take(x))
//                .toStream()
//                .forEach(System.out::println);

//        Flux.just(5, 10)
//                .concatMap(x -> Flux.interval(Duration.ofMillis(x * 10), Duration.ofMillis(100)).take(x))
//                .toStream()
//                .forEach(System.out::println);


//        Flux.just(1, 2)
//                .concatWith(Mono.error(new IllegalStateException()))
//                .subscribe(System.out::println, System.err::println);

//        Flux.just(1, 2)
//                .concatWith(Mono.error(new IllegalStateException()))
//                .onErrorReturn(0)
//                .subscribe(System.out::println);

//        Flux.just(1, 2)
//                .concatWith(Mono.error(new IllegalArgumentException()))
//                .onErrorResume(e -> {
//                    if (e instanceof IllegalStateException) {
//                        return Mono.just(0);
//                    } else if (e instanceof IllegalArgumentException) {
//                        return Mono.just(-1);
//                    }
//                    return Mono.empty();
//                })
//                .subscribe(System.out::println);

//        Flux.just(1, 2)
//                .concatWith(Mono.error(new IllegalStateException()))
//                .retry(1)
//                .subscribe(System.out::println);

        Flux.create(sink -> {
            sink.next(Thread.currentThread().getName());
            sink.complete();
        })
                .publishOn(Schedulers.single())
                .map(x -> String.format("[%s] %s", Thread.currentThread().getName(), x))
                .publishOn(Schedulers.elastic())
                .map(x -> String.format("[%s] %s", Thread.currentThread().getName(), x))
                .subscribeOn(Schedulers.parallel())
                .toStream()
                .forEach(System.out::println);



    }
}

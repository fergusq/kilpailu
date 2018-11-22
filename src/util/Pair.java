package util;

import java.util.function.BiFunction;
import java.util.stream.Stream;

import static java.util.stream.IntStream.rangeClosed;

public class Pair<A, B> {
    public final A first;
    public final B second;

    private Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public<C> C feed(BiFunction<A, B, C> f) {
        return f.apply(first, second);
    }

    public static<A, B> Pair<A, B> of(A first, B second) {
        return new Pair<>(first, second);
    }

    public static Stream<Pair<Integer, Integer>> range(Pair<Integer, Integer> fromInclusive, Pair<Integer, Integer> toInclusive) {
        return
            rangeClosed(fromInclusive.first, toInclusive.first)
            .mapToObj(Integer::valueOf)
            .flatMap(dx ->
                rangeClosed(fromInclusive.second, toInclusive.second)
                .mapToObj(dy -> Pair.of(dx, dy)));
    }
}
package hello.hello.spring.test;


import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class test {

    @Test
    void test() {
        List<String> list = Arrays.asList("a1", "a2", "b1", "b2", "c2", "c1", "c3");
        Stream<String> stream1 = list.stream();
        Stream<String> filtered = stream1.filter(s -> s.startsWith("c"));
        filtered.forEach(System.out::println);
    }

}
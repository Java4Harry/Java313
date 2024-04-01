package lessons.src.Homework;

import java.util.stream.Stream;

public class Homework_35 {
    public static void main(String[] args) {
        Stream<Integer> numbersStream = Stream.of(3, 4, 2, 5, 1);
        numbersStream.skip(1).limit(3).forEach(s -> System.out.println(s * 2));
    }
}

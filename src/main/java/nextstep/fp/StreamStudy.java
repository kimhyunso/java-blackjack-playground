package nextstep.fp;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class StreamStudy {

    public static long countWords() throws IOException {
        String contents = new String(Files.readAllBytes(Paths
                .get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        long count = 0;
        for (String w : words) {
            if (w.length() > 12) count++;
        }
        return count;
    }

    public static long countWordsFilter(WordStrategy wordStrategy) throws IOException {
        String contents = new String(Files.readAllBytes(Paths
                .get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        return words.stream()
                .mapToLong(String::length)
                .filter(wordStrategy::confidence)
                .count();
    }


    /**
     * 1. 단어의 길이가 12자를 초과하는 단어를 추출한다.
     * 2. 12자가 넘는 단어 중 길이가 긴 순서로 100개의 단어를 추출한다.
     * 3. 단어 중복을 허용하지 않는다. 즉, 서로 다른 단어 100개를 추출해야 한다.
     * 4. 추출한 100개의 단어를 출력한다. 모든 단어는 소문자로 출력해야 한다.
     */
    public static void printLongestWordTop100(WordTop100Strategy wordTop100Strategy) throws IOException {
        String contents = new String(Files.readAllBytes(Paths
                .get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        // TODO 이 부분에 구현한다.
        AtomicInteger count = new AtomicInteger(1);

        words.stream()
                .distinct()
                .filter(wordTop100Strategy::confidence)
                .sorted()
                .map(String::toLowerCase)
                .limit(100)
                .forEach(item -> {
                    System.out.println(count.getAndIncrement() + " : " + item);
                });
    }

    public static List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream().map(x -> 2 * x).collect(Collectors.toList());
    }

    public static List<Integer> doubleNumbersRefactor(List<Integer> numbers) {
        return numbers.stream().map(StreamStudy::multipleNumber).collect(Collectors.toList());
    }

    public static long sumAll(List<Integer> numbers) {
        return numbers.stream().reduce(0, (x, y) -> x + y);
    }

    public static long sumAllRefactor(List<Integer> numbers) {
        // reduce의 첫번째 요소 identify: 0부터 누적하겠다는 의미
        return numbers.stream().reduce(0, Integer::sum);
    }

    public static long sumOverThreeAndDouble(List<Integer> numbers, SumStrategy sumStrategy) {
        return numbers.stream()
                .filter(sumStrategy::isCondition)
                .mapToInt(StreamStudy::multipleNumber)
                .reduce(0, Integer::sum);
    }

    private static int multipleNumber(int x) {
        return x * 2;
    }

}
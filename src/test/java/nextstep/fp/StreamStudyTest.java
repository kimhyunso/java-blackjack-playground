package nextstep.fp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StreamStudyTest {
    private List<Integer> numbers;

    @BeforeEach
    public void setup() {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void countWords() throws Exception {
        long result = StreamStudy.countWords();
        System.out.println("result : " + result);
    }

    @DisplayName("stream, filter를 사용하여 글자의 개수를 새는 기능")
    @Test
    void countWordStreamFilter() throws Exception {
        long result = StreamStudy.countWordsFilter((length) -> length > 12);
        System.out.println("result : " + result);
    }

    @Test
    public void printLongestWordTop100() throws Exception {
        StreamStudy.printLongestWordTop100();
    }

    @Test
    public void map() throws Exception {
        List<Integer> doubleNumbers = StreamStudy.doubleNumbers(numbers);
        doubleNumbers.forEach(System.out::println);
    }

    @DisplayName("numbers 배열 안에 있는 요소들을 2배로 만드는 기능")
    @Test
    public void mapStrategy() throws Exception {
        List<Integer> doubleNumbers = StreamStudy.doubleNumbersRefactor(numbers);
        List<Integer> compareNumbers = Arrays.asList(2, 4, 6, 8, 10, 12);
        assertThat(doubleNumbers).isEqualTo(compareNumbers);
        System.out.println(doubleNumbers);
    }


    @Test
    public void sumAll() throws Exception {
        long sum = StreamStudy.sumAll(numbers);
        assertThat(sum).isEqualTo(21);
    }

    @Test
    @DisplayName("numbers 요소들의 sum을 구하는 기능 Strategy")
    void sumAllStrategy() {
        long sum = StreamStudy.sumAllRefactor(numbers);
        assertThat(sum).isEqualTo(21);
    }

    @Test
    @DisplayName("numbers 요소들의 sum을 구하는 기능 reduce 테스트")
    void sumAllReduce() {
        long sum = numbers.stream()
                .peek(System.out::println)
                .reduce(10, (x, y) -> x + y);

        assertThat(sum).isEqualTo(31);
    }

    @Test
    @DisplayName("List에 담긴 모든 숫자 중 3보다 큰 숫자를 2배 한 후 모든 값의 합을 구하는 기능")
    public void sumOverThreeAndDouble() throws Exception {
        numbers = Arrays.asList(3, 1, 6, 2, 4, 8);
        long sum = StreamStudy.sumOverThreeAndDouble(numbers, (x) -> x > 3);
        assertThat(sum).isEqualTo(36);
    }


}

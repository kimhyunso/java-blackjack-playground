package nextstep.fp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class LambdaTest {
    private List<Integer> numbers;

    @BeforeEach
    public void setup() {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void printAllOld() throws Exception {
        Lambda.printAllOld(numbers);
    }

    @Test
    public void printAllLambda() throws Exception {
        Lambda.printAllLambda(numbers);
    }

    @Test
    public void runThread() throws Exception {
        Lambda.runThread();
    }

    @Test
    public void sumAll() throws Exception {
        int sum = Lambda.sumAll(numbers);
        assertThat(sum).isEqualTo(21);
    }

    @Test
    public void sumAllEven() throws Exception {
        int sum = Lambda.sumAllEven(numbers);
        assertThat(sum).isEqualTo(12);
    }

    @Test
    public void sumAllOverThree() throws Exception {
        int sum = Lambda.sumAllOverThree(numbers);
        assertThat(sum).isEqualTo(15);
    }


    @DisplayName("모두 더하기 Lamdba")
    @Test
    void sumAllLamdba() {
        int sum = Lambda.sumAllLamdba(numbers);
        assertThat(sum).isEqualTo(21);
    }

    @DisplayName("짝수만 모두 더하기 Lamdba")
    @Test
    void sumEvenLamdba() {
        int sum = Lambda.sumLamdba((confidence) -> confidence % 2 == 0, numbers);
        assertThat(sum).isEqualTo(12);
    }

    @DisplayName("3이상의 수만 모두 더하기 Lamdba")
    @Test
    void sumAllOverThreeLamdba() {
        int sum = Lambda.sumLamdba((confidence) -> confidence > 3, numbers);
        assertThat(sum).isEqualTo(15);
    }


}

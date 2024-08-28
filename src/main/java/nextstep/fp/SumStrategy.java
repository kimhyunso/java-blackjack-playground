package nextstep.fp;

@FunctionalInterface
public interface SumStrategy {
    boolean isCondition(int confidence);
}

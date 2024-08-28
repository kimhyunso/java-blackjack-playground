package nextstep.fp;

@FunctionalInterface
public interface WordStrategy {
    boolean confidence(long length);
}

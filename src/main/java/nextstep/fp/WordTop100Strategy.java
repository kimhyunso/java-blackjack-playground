package nextstep.fp;


@FunctionalInterface
public interface WordTop100Strategy {
    boolean confidence(String word);
}

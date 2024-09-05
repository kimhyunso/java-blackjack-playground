package nextstep.blackjac.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Utils {
    private static final String REGEX = ",";
    public static List<String> splitName(String names) {
        names = (String) notNullable(names);
        return Arrays.stream(names.split(REGEX))
                .filter(Utils::isEmpty)
                .collect(Collectors.toList());
    }

    public static Object notNullable(Object object) {

        return Optional.ofNullable(object)
                .orElseThrow(() -> new IllegalArgumentException("잘 못된 값입니다."));
    }

    private static boolean isEmpty(String name) {
        return !name.isEmpty();
    }




}

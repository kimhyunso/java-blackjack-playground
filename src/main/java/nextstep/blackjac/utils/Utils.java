package nextstep.blackjac.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Utils {
    private static final String REGEX = ",";
    public static List<String> splitName(String names) {
        String optName = Optional.ofNullable(names)
                .orElseThrow(() -> new NullPointerException("이름이 정의되지않았습니다."));

        return Arrays.stream(optName.split(REGEX))
                .filter(Utils::isEmpty)
                .collect(Collectors.toList());
    }


    private static boolean isEmpty(String name) {
        return !name.isEmpty();
    }




}
